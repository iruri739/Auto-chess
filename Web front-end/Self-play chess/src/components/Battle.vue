<template>
  <div v-if="state == 2 || state == 4">
    <div class="box">
      <div class="top">
        <ul id="qq_face faceout">
          <li
            v-for="(animalA,index) in armyA"
            :key="index"
            :style="{backgroundImage:'url('+makeUrl(animalA.img)+')'}"
            :id="getIdA(index)"
          >{{animalA.hp}}</li>
        </ul>
        <!-- <button @click="start()">开始战斗</button> -->
      </div>
      <div class="center"></div>
      <div class="down">
        <ul class="pp_face faceout">
          <li
            v-for="(animalB,index) in armyB"
            :key="index"
            :style="{backgroundImage:'url('+makeUrl(animalB.img)+')'}"
            :id="getIdB(index)"
          >{{animalB.hp}}</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import Anime from "animejs";
export default {
  name: "Battle",
  props: ["state", "sec", "playerId", "round"],
  data() {
    return {
      armyA: [],
      armyB: []
    };
  },
  mounted() {
    this.getMockData();
  },
  methods: {
    getIdA(index) {
      return "animalA" + index;
    },
    getIdB(index) {
      return "animalB" + index;
    },
    makeUrl(url) {
      return require("../assets/images/" + url + ".jpg");
    },
    getMockData() {
      var time = setInterval(() => {
        //如果状态为即将战斗
        if (this.state == 4) {
          console.log("战斗动画页面请求第" + this.round + "轮次双方战斗卡牌");
          this.$http
            .get(
              "serveApi/game/requestBattleData?playerId=" +
                this.playerId +
                "&round=" +
                this.round
            )
            .then(resp => {
              if (resp.data.cached) {
                if (resp.data.playerOneData.id == this.playerId) {
                  this.armyA = resp.data.playerTwoData.battleCards;
                  this.armyB = resp.data.playerOneData.battleCards;
                } else {
                  this.armyA = resp.data.playerOneData.battleCards;
                  this.armyB = resp.data.playerTwoData.battleCards;
                }
                console.log("状态设置为战斗中");
                this.$emit("setState",2);
                this.start();
                this.wait(6)
              }

            });
          //状态设置为战斗中
        }
      }, 500);
    },
    wait(second){
      let  time=0
       let descTimer = setInterval(() => {
            time++
            console.log("打斗动画倒计时" + (second - time));
           if(time==second){
            console.log("打斗画面结束，状态设置为战斗结束");

             this.$emit("setState",1)
             window.clearInterval(descTimer)
           }    
       },1000)
    },
    start() {
      //时间轴
      var timeline = Anime.timeline({
        easing: "easeOutExpo",
        duration: 200
      });
      console.log("开始播放动画");
      this.fight(timeline);

    },

    fight(t) {
      var timeline = t;
      var isOver = false;
      // var round = 1;
      if (isOver) {
        return;
      }
      // for(var j=0;j<this.armyA.length;j++){
      //   console.log("Army1 第" +j + "个动物血量："+ this.armyA[j].hp + "   vs    Army2 第" +j + "个动物血量："+ this.armyB[j].hp);
      // }
      // console.log("--------------------------------------------上面是打之前的血量-----------------------------");
      for (var pos = 0; pos < 5; pos++) {
        var posA = pos;
        var posB = pos;
        if (pos > this.armyA.length - 1) {
          posA = this.armyA.length - 1;
        }
        if (pos > this.armyB.length - 1) {
          posB = this.armyB.length - 1;
        }
        var index1 = this.findAnimalIndex(this.armyA, posA);
        var index2 = this.findAnimalIndex(this.armyB, posB);
        // console.log("---------------------第" +round +"轮--------------------------------");
        // console.log("Army1 第" +index1 + "个动物 打Army2 第" +index2 + "个动物");
        if (index1 == -1 || index2 == -1) {
          isOver = true;
          // this.$emit("setState",1);
          // console.log("打斗画面结束，状态设置为战斗结束");
          return;
        }
        var animalA = this.armyA[index1];
        var animalB = this.armyB[index2];
        var animalAHP = animalA.hp;
        var animalBHP = animalB.hp;
        var positionA = this.getSelfFightPosition(index1, index2);
        var positionB = this.getSelfFightPosition(index2, index1);
        var elements1 = document.getElementById(this.getIdA(index1));
        var elements2 = document.getElementById(this.getIdB(index2));
        let armyAAttack = this.armyA[index1].attack;
        let armyBAttack = this.armyB[index2].attack;
        while (this.armyA[index1].hp > 0 && this.armyB[index2].hp > 0) {
          this.armyA[index1].hp -= armyBAttack;
          this.armyB[index2].hp -= armyAAttack;
        }
        if (this.armyA[index1].hp <= 0) {
          this.armyA[index1].hp = 0;
        }
        if (this.armyB[index2].hp <= 0) {
          this.armyB[index2].hp = 0;
        }
        // var e1 = document.getElementById(this.getIdA(index1));
        // var e2 = document.getElementById(this.getIdB(index2));
        var hp1 = JSON.parse(JSON.stringify(this.armyA[index1].hp));
        var hp2 = JSON.parse(JSON.stringify(this.armyB[index2].hp));
        timeline
          .add({
            targets: elements1,
            translateX: positionA,
            translateY: 90
          })
          .add({
            targets: elements2,
            translateX: positionB,
            translateY: -90
          })
          .add({
            targets: elements1,
            translateX: 0,
            translateY: 0,
            innerHTML: [animalAHP, hp1],
            round: 1
          })
          .add({
            targets: elements2,
            translateX: 0,
            translateY: 0,
            innerHTML: [animalBHP, hp2],
            round: 1
          });
      }
      if (!isOver) {
        this.fight(timeline);
      }

    },
    getSelfFightPosition(selfIndex, enemyIndex) {
      var distance = 70;
      return (enemyIndex - selfIndex) * distance;
    },
    findAnimalIndex(army, position) {
      if (army.length == 0) {
        return -1;
      }
      var isAllDead = true;
      if (army[position] != null && army[position].hp > 0) {
        return position;
      } else {
        var x = position;
        for (; x >= 0; x--) {
          if (army[x].hp > 0) {
            isAllDead = false;
            return x;
          }
        }
        x = position;
        for (; x < army.length; x++) {
          if (army[x].hp > 0) {
            isAllDead = false;
            return x;
          }
        }
        if (isAllDead) {
          return -1;
        }
      }
    }
  }
};
</script>
<style scoped>
ul li {
  list-style: none;
}
.box {
  width: 70%;
  height: 350px;
  margin: 50px auto;
}
.top {
   width: 900px;
  height: 100px;
  background-image: url("../assets/dongtu.gif");
  background-position: 50%  10%;
  opacity:0.6;
  margin:15px auto; 
  border-radius:20%; 
}
.top ul li {
  text-align: center;
  color: red;
  font-size: 30px;
  list-style: none;
  width: 80px;
  height: 80px;
  border-radius: 50%;
  background-size: cover;
  margin: 10px 30px;
  float: left;
  position: relative;
}
.center {
  width: 360px;
  height: 150px;
  background: #232611;
  margin-left: 280px;
  opacity: 0;
}
.top ul {
  margin-left: 100px;
  top: 0;
}
.down ul {
  margin-left: 100px;
  top: 0;
}
.down ul li {
  text-align: center;
  color: blue;
  font-size: 30px;
  list-style: none;
  width: 80px;
  height: 80px;
  border-radius: 50%;
  background-size: cover;
  margin: 10px 30px;
  float: left;
  position: relative;
}
.down {
  width: 900px;
  height: 100px;
  background-image: url("../assets/dongtu.gif");
  background-position: 50%  10%;
  opacity:0.6;
  margin:15px auto; 
  border-radius:20%; 
}
</style>