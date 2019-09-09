<template>
  <div id="Sceeing">
    <el-container>
      <div class="block">
        <span class="demonstration"></span>
      </div>

      <div class="block">
        <span class="demonstration"></span>
      </div>
      <div class="d1">
        <div>
          <img src="../assets/timg.jpg" width="100%" height="700px" />
        </div>

        <div class="divcss5">
          <div class="divcss5-g">
            <img src="../assets/touxiang2.jpg" width="140px" height="140px" />
          </div>

          <div class="divcss5-h">
            <img src="../assets/touxiang4.jpg" width="140px" height="140px" />
          </div>
          <div class="divcss5-c">
            <font size="7">匹配成功</font>
          </div>

          <div class="divcss5-e">{{myName}}</div>
          <div class="divcss5-f">{{name}}</div>
          <div class="divcss5-d">
            <el-button type="primary" :loading="true">正在进入游戏</el-button>
          </div>

          <div>
            <div class="textBox">
              <transition name="slide">
                <p class="text" :key="text.id">{{text.val}}</p>
              </transition>
            </div>
          </div>
        </div>
      </div>
    </el-container>
  </div>
</template>

<script>
import { clearTimeout } from 'timers';
// import { mapGetters, mapActions } from "vuex";
export default {
  name: "Sceeing",
  data() {
    return {
      textArr: [
        " 游戏战斗每回合，系统都会随机刷新出五枚棋子。",
        " 每回合都可以花费一定金币购买系统刷新出的棋子。 ",
        " 每局游戏我们将所购买的棋子放置战场，进行战斗。",
        " 战斗开始后，双方棋子会自动进行对战。",
        " 当对方棋子全部死亡后，己方获胜。",
        " 棋子分为海、陆、空三种不同类型，相互之间有制约关系。",
        " 当一局游戏结束后，会开始下一轮，直至玩家生命值为0。"
      ],
      number: 0,
      set: 3,
      playerId: 0,
      name: "",
      myName:"",
      player:{}
    };
  },
  computed: {
    //  ...mapGetters({
    //  game: "getGame"
    // }),
    // ...mapGetters({
    //  player1: "getPlayer1"
    // }),
    // ...mapGetters({
    //  player2: "getPlayer2"
    // }),
    text() {
      return {
        id: this.number,
        val: this.textArr[this.number]
      };
    }
  },
  mounted() {
    this.startMove();
    this.getPlayer();
    this.timer = setInterval(this.desTimer, 1000);
  },
 created() {
    this.getRouterData()
  },
  methods: {
    // ...mapActions({
    //   fetchGameData: "fetchGameData"
    // }),
    // ...mapActions({
    //   fetchPlayer1Data: "fetchPlayer1Data"
    // }),
    // ...mapActions({
    //   fetchPlayer2Data: "fetchPlayer2Data"
    // }),
     getRouterData() {
      this.playerId = this.$route.query.id
      console.log('id', this.playerId)
     },
    desTimer(){
      this.set -= 1;
      if(this.set == 0){
           this.$router.push({ 
                   name: "Home" ,
                   query:{
                     id:this.playerId
                   }
                   });
       // this.$router.push({ path: "/Home" });
      }
    },
    beforeDestroy() {
    clearInterval(this.timer);
},
    getPlayer() {
      this.$http
        .get("http://localhost:8888/game/defaultDataModel?playerId="+this.playerId)
        .then(resp => {
           if(resp.data.playerOneData.id==this.playerId){
             this.myName = resp.data.playerOneData.name;
             this.name = resp.data.playerTwoData.name;
           }else{
              this.myName = resp.data.playerTwoData.name;
             this.name = resp.data.playerOneData.name;
           }
          this.player=resp.data
          const _this = this;
          // timer=setTimeout(function() {
          //   _this.$router.push({ path: "/Home" });
          // }, 4000);
        },
        );
        // this.fetchGameData(this.player.game);
        // this.fetchPlayer1Data(this.player.player1);
        // this.fetchPlayer2Data(this.player.player2);
    },

    //文字轮播
    startMove() {
      let timer = setTimeout(() => {
        if (this.number === 7) {
          this.number = 0;
        } else {
          this.number += 1;
        }
        this.startMove();
      }, 2000); // 滚动不需要停顿则将2000改成动画持续时间
    }
  }
};
</script>

<style>
#Sceeing {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 5px;
}

.d1 {
  position: absolute;
  left: 0px;
  top: -30px;
  width: 100%;
  height: 100%;
  z-index: -1;
}
.divcss5 {
  position: relative;
  left: 330px;
  top: -480px;
  width: 750px;
  height: 400px;
  border: 0px;
  background: #bdbdbd;
}
/* 定义父级position:relative:绝对定位声明*/
.divcss5-g {
  position: absolute;
  margin-left: 50px;
  top: 130px;
}
.divcss5-g img {
  cursor: pointer;
  transition: all 0.6s;
}
.divcss5-g img:hover {
  transform: scale(1.4);
}
/* 使用绝对定位position:absolute样式 并且使用left top进行定位位置 */
.divcss5-h {
  position: absolute;
  margin-left: 560px;
  top: 130px;
}
.divcss5-h img {
  cursor: pointer;
  transition: all 0.6s;
}
.divcss5-h img:hover {
  transform: scale(1.4);
}
.divcss5-c {
  position: absolute;
  width: 250px;
  height: 80px;
  left: 260px;
  top: 160px;
  font-weight: bold;
}
.divcss5-d {
  position: absolute;
  top: 10%;
  left: 40%;
}
.divcss5-e {
  position: absolute;
  width: 250px;
  height: 80px;
  left: 1px;
  top: 280px;
  font-weight: bold;
}
.divcss5-f {
  position: absolute;
  width: 250px;
  height: 80px;
  left: 500px;
  top: 280px;
  font-weight: bold;
}

/* 使用绝对定位position:absolute样式 并且使用right bottom进行定位位置 */
</style>
