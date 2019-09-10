<template>
  <div v-if="state1">
    <div class="box">
      <div class="top">
        <ul>
          <li
            v-for="(enemyChess,index) in enemyArmy"
            :key="index"
            :style="{backgroundImage:'url('+makeUrl(enemyChess.img)+')'}"
            :id="getEnemyChessId(index)"
          >{{enemyChess.hp}}</li>
        </ul>
      </div>
      <div class="center"></div>
      <div class="bottom">
        <ul>
          <li
            v-for="(selfChess,index) in selfArmy"
            :key="index"
            :style="{backgroundImage:'url('+makeUrl(selfChess.img)+')'}"
            :id="getSelfChessId(index)"
          >{{selfChess.hp}}</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import Anime from "animejs";
export default {
  name: "Battle",
  props: ["state1", "sec", "eid", "gameid"],
  data() {
    return {
      enemyArmy: [],
      selfArmy: []
    };
  },
  mounted() {
    this.getMockData();
  },

  methods: {
    getEnemyChessId(index) {
      return "enemyChess" + index;
    },
    getSelfChessId(index) {
      return "selfChess" + index;
    },
    makeUrl(url) {
      return require("../assets/images/" + url + ".jpg");
    },
    getMockData() {
      var time = setInterval(() => {
        if (this.sec == 5) {
          this.$http
            .get(`serveApi/game/defaultDataModel?playerId=${this.eid}`)
            .then(resp => {
              if (
                resp &&
                resp.data &&
                resp.data.playerOneData &&
                resp.data.playerOneData.id == this.eid
              ) {
                this.enemyArmy = resp.data.playerTwoData.battleCards;
                this.selfArmy = resp.data.playerOneData.battleCards;
              } else {
                this.enemyArmy = resp.data.playerOneData.battleCards;
                this.selfArmy = resp.data.playerTwoData.battleCards;
              }
            });
          this.start();
        }
      }, 1000);
    },
    start() {
      const animeTime = 200;
      var timeline = Anime.timeline({
        easing: "easeOutExpo",
        duration: animeTime
      });
      this.fight(timeline);
    },
    fight(t) {
      var timeline = t;
      var isOver = false;
      if (isOver) {
        return;
      }
      for (var position = 0; position < 5; position++) {
        var enemyPosition = position;
        var selfPosition = position;
        if (position > this.enemyArmy.length - 1) {
          enemyPosition = this.enemyArmy.length - 1;
        }
        if (position > this.selfArmy.length - 1) {
          selfPosition = this.selfArmy.length - 1;
        }
        var enemyIndex = this.findAnimalIndex(this.enemyArmy, enemyPosition);
        var selfIndex = this.findAnimalIndex(this.selfArmy, selfPosition);
        if (enemyIndex == -1 || selfIndex == -1) {
          isOver = true;
          break;
        }
        var enemyChess = this.enemyArmy[enemyIndex];
        var selfChess = this.selfArmy[selfIndex];

        var enemyChessHP = enemyChess.hp;
        var selfChessHP = selfChess.hp;
        
        var enemyOffset = this.getOffset(enemyIndex, selfIndex);
        var selfOffset = this.getOffset(selfIndex, enemyIndex);

        var elements1 = document.getElementById(this.getEnemyChessId(enemyIndex));
        var elements2 = document.getElementById(this.getSelfChessId(selfIndex));

        let enemyArmyAttack = this.enemyArmy[enemyIndex].attack;
        let selfArmyAttack = this.selfArmy[selfIndex].attack;

        while (this.enemyArmy[enemyIndex].hp > 0 && this.selfArmy[selfIndex].hp > 0) {
          this.enemyArmy[enemyIndex].hp -= selfArmyAttack;
          this.selfArmy[selfIndex].hp -= enemyArmyAttack;
        }

        if (this.enemyArmy[enemyIndex].hp <= 0) {
          this.enemyArmy[enemyIndex].hp = 0;
        }
        if (this.selfArmy[selfIndex].hp <= 0) {
          this.selfArmy[selfIndex].hp = 0;
        }
        var hp1 = JSON.parse(JSON.stringify(this.enemyArmy[enemyIndex].hp));
        var hp2 = JSON.parse(JSON.stringify(this.selfArmy[selfIndex].hp));

        timeline
          .add({
            targets: elements1,
            translateX: enemyOffset,
            translateY: 90
          })
          .add({
            targets: elements2,
            translateX: selfOffset,
            translateY: -90
          })
          .add({
            targets: elements1,
            translateX: 0,
            translateY: 0,
            innerHTML: [enemyChessHP, hp1],
            round: 1
          })
          .add({
            targets: elements2,
            translateX: 0,
            translateY: 0,
            innerHTML: [selfChessHP, hp2],
            round: 1
          });
      }
      if (!isOver) {
        this.fight(timeline);
      }
    },
    getOffset(selfIndex, enemyIndex) {
      var distance = 70;
      return (enemyIndex - selfIndex) * distance;
    },

    findAnimalIndex(army, position) {
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
  background: #232611;
  opacity: 0.6;
  margin: 15px auto;
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
.bottom ul {
  margin-left: 100px;
  top: 0;
}
.bottom ul li {
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
.bottom {
  width: 900px;
  height: 100px;
  background: #232611;
  opacity: 0.6;
  margin: 15px auto;
}
</style>