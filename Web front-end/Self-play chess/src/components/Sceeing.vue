<template>
  <div id="Sceeing">
      <div class="whole">
        <div>
          <img src="../assets/timg.jpg" width="100%" height="700px" />
        </div>

        <div class="divcss">
          <div class="divcss-a">
            <img src="../assets/touxiang2.jpg" width="140px" height="140px" />
          </div>

          <div class="divcss-b">
            <img src="../assets/touxiang4.jpg" width="140px" height="140px" />
          </div>

          <div class="divcss-c">
            <el-button type="primary" :loading="true">正在进入战场</el-button>
          </div>

          <div class="divcss-d">
            <font size="7">匹配成功</font>
          </div>
        
          <div class="divcss-e">{{myName}}</div>
          <div class="divcss-f">{{name}}</div>

          <div>
            <div class="textBox">
              <transition name="slide">
                <p class="text" :key="text.id">{{text.val}}</p>
              </transition>
            </div>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
import { clearTimeout } from 'timers';
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
      set: 4,
      playerId: 0,
      name: "",
      myName:"",
      player:{}
    };
  },
  computed: {
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
      }
    },
    beforeDestroy(){
    clearInterval(this.timer);
},
  getPlayer() {
      this.axios
        .get(`/serveApi/game/initRounds?playerId=${this.playerId}`)
        .then(resp => {
          if (resp.data.playerOneData.id == this.playerId) {
            this.myName = resp.data.playerOneData.name;
            this.name = resp.data.playerTwoData.name;
          } else {
            this.myName = resp.data.playerTwoData.name;
            this.name = resp.data.playerOneData.name;
          }
          this.player = resp.data;
        });
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
        window.clearInterval(carsel);
      }, 2000); // 滚动不需要停顿则将2000改成动画持续时间
    }
  }
};
var carsel;
</script>

<style scoped>
#Sceeing {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 5px;
}
.whole {
  position: absolute;
  left: 0px;
  top: -30px;
  width: 100%;
  height: 100%;
  z-index: -1;
}
.divcss {
  position: relative;
  left: 330px;
  top: -480px;
  width: 750px;
  height: 400px;
  border: 0px;
  background: #bdbdbd;
}.divcss-a {
  position: absolute;
  margin-left: 50px;
  top: 130px;
}
.divcss-a img {
  cursor: pointer;
  transition: all 0.6s;
}
.divcss-a img:hover {
  transform: scale(1.4);
}
/* 使用绝对定位position:absolute样式 并且使用left top进行定位位置 */
.divcss-b {
  position: absolute;
  margin-left: 560px;
  top: 130px;
}
.divcss-b img {
  cursor: pointer;
  transition: all 0.6s;
}
.divcss-b img:hover {
  transform: scale(1.4);
}.divcss-c {
  position: absolute;
  top: 10%;
  left: 40%;
}
.divcss-d {
  position: absolute;
  width: 250px;
  height: 80px;
  left: 260px;
  top: 160px;
  font-weight: bold;
}
.divcss-e {
  position: absolute;
  width: 250px;
  height: 80px;
  left: 1px;
  top: 280px;
  font-weight: bold;
}
.divcss-f {
  position: absolute;
  width: 250px;
  height: 80px;
  left: 500px;
  top: 280px;
  font-weight: bold;
}.textBox {
  position: absolute;
  left: -10px;
  top: 90%;
  width: 800px;
  height: 30px;
  border: 0px;
}
.text {
  width: 100%;
  size: 5px;
  position: absolute;
  color: rgb(16, 16, 17);
  bottom: 0;
}
.slide-enter-active,
.slide-leave-active {
  transition: all 1s linear;
}
.slide-enter {
  transform: translateY(20px) scale(1);
  opacity: 1;
}
.slide-leave-to {
  transform: translateY(-20px) scale(0.8);
  opacity: 0;
}
/* 使用绝对定位position:absolute样式 并且使用right bottom进行定位位置 */
</style>