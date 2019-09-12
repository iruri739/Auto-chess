<template>
  <div id="Waiting">
    <el-container>
      <div class="block">
        <span class="demonstration"></span>
      </div>

      <div class="block">
        <span class="demonstration"></span>
      </div>

      <div class="d1">
        <div>
          <img src="../assets/timg.jpg" width="100%" height="720px" />
        </div>
        <!-- <video id="video" autoplay loop muted="true">
          <source src="../assets/background.mp4" type="video/mp4">
        </video>-->

        <div class="divcss5">
          <div class="divcss5-a">
            <img src="../assets/touxiang2.jpg" width="140px" height="140px" />
          </div>
          <div class="divcss5-b">
            <img src="../assets/touxiang.jpg" width="140px" height="140px" />
          </div>

          <link rel="stylesheet" href="bootstrap.min.css" />
          <div class="container">
            <div class="row">
              <div class="col-md-12">
                <div class="preloader">
                  <div class="loader loader-inner-1">
                    <div class="loader loader-inner-2">
                      <div class="loader loader-inner-3"></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="text-effect">
            <span>匹</span>
            <span>配</span>
            <span>中</span>
            <span>.</span>
            <span>.</span>
            <span>.</span>
          </div>
          <div class="button">
            <el-button type="button" @click="open">取消匹配</el-button>
          </div>
          <div class="divcss5-e"></div>
          <div class="divcss5-f"></div>
          <div class="divcss5-d">
            <el-button type="primary" :loading="true">寻找势均力敌的玩家</el-button>
          </div>

          <div>
            <div class="textBox">
              <transition name="slide">
                <p class="text" :key="text.id">{{text.val}}</p>
              </transition>
            </div>
          </div>

          <div class="pic">
            <img :src="now" />
          </div>
        </div>
      </div>
    </el-container>
  </div>
</template>
<script>
import { clearTimeout, clearInterval } from "timers";
import { watch } from "fs";
export default {
  name: "Waiting",
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
      bool: false,
      playerId: 0
    };
  },

  computed: {
   
    text() {
      return {
        id: this.number,
        val: this.textArr[this.number]
      };
    },
    
  },
  created() {
    this.getRouterData();
  },
  mounted() {
    this.startMove();
    this.getTimer();
    
  },
  methods: {
    
    getRouterData() {
      this.playerId = this.$route.query.id;
      console.log("id", this.playerId);
    },
    //轮询发送匹配请求
    getTimer() {
      time = setInterval(() => {
        this.$http
          .get("http://localhost:8888/game/matchGame?playerId=" + this.playerId)
          .then(resp => {
            this.bool = resp.data;
          });
        if (this.bool == true) {
          //this.$router.push({ path: "/Sceeing" });
          this.$router.push({
            name: "Sceeing",
            query: {
              id: this.playerId
            }
          });

          window.clearInterval(time);
        }
      }, 1000);
      function stop() {
        window.clearInterval(time);
      }
    },

    //文字轮播
    startMove() {
      setTimeout(() => {
        if (this.number === 7) {
          this.number = 0;
        } else {
          this.number += 1;
        }
        this.startMove();
      }, 3000); // 滚动不需要停顿则将2000改成动画持续时间
    },

    open() {
      this.$confirm("是否退出游戏?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
        center: true
      })
        .then(() => {
          this.$router.push({ path: "/Meenu" });
          window.clearInterval(time);
          this.$message({
            type: "success",
            message: "退出成功!"
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消退出"
          });
        });
    }
  }
};

var time;
</script>

<style scoped>
#Waiting {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 5px;
}
.video {
  position: absolute;
  left: 0px;
  top: -30px;
  width: 100%;
  height: 100%;
  z-index: -1;
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
.divcss5-a {
  position: absolute;
  margin-left: 50px;
  top: 130px;
}
.divcss5-a img {
  cursor: pointer;
  transition: all 0.6s;
}
.divcss5-a img:hover {
  transform: scale(1.4);
}
/* 使用绝对定位position:absolute样式 并且使用left top进行定位位置 */
.divcss5-b {
  position: absolute;
  margin-left: 560px;
  top: 130px;
}
.divcss5-b img {
  cursor: pointer;
  transition: all 0.6s;
}
.divcss5-b img:hover {
  transform: scale(1.4);
}

.divcss5-d {
  position: absolute;
  top: 10%;
  left: 32%;
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
.text-effect {
  color: #fff;
  font-size: 50px;
  font-weight: 700;
  position: relative;
  left: 30px;
  top: 160px;
}
.text-effect span {
  animation: animate linear 2000ms infinite;
}
.text-effect span:nth-child(1n) {
  animation-delay: 0s;
}
.text-effect span:nth-child(2n) {
  animation-delay: 100ms;
}
.text-effect span:nth-child(3n) {
  animation-delay: 200ms;
}
.text-effect span:nth-child(4n) {
  animation-delay: 300ms;
}
.text-effect span:nth-child(5n) {
  animation-delay: 400ms;
}
.text-effect span:nth-child(6n) {
  animation-delay: 500ms;
}
.text-effect span:nth-child(7n) {
  animation-delay: 600ms;
}
.text-effect span:nth-child(8n) {
  animation-delay: 700ms;
}
.text-effect span:nth-child(9n) {
  animation-delay: 800ms;
}
.text-effect span:nth-child(10n) {
  animation-delay: 900ms;
}
@keyframes animate {
  0% {
    opacity: 0.3;
  }
  100% {
    opacity: 1;
    text-shadow: 0 0 80px Red, 0 0 30px orange, 0 0 6px DarkRed;
  }
}
@media only screen and (max-width: 990px) {
  .text-effect {
    font-size: 65px;
  }
}
@media only screen and (max-width: 767px) {
  .text-effect {
    font-size: 50px;
  }
}
@media only screen and (max-width: 479px) {
  .text-effect {
    font-size: 36px;
  }
}
@media only screen and (max-width: 359px) {
  .text-effect {
    font-size: 27px;
  }
}

.button {
  position: relative;
  border: 0px;
  top: 250px;
  width: 800px;
  left: -32px;
}

.textBox {
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
/* 加载动画 */
.preloader {
  position: absolute;
  top: 2%;
  left: 10%;
  padding: 10px 0 10px;
  display: flex;
  flex-flow: column wrap;
  justify-content: center;
  align-content: center;
  align-items: center;
  perspective: 500;
}
.loader {
  text-align: center;
  margin: 5px;
  border-radius: 50%;
  border: 3px solid rgb(83, 62, 62);
  display: flex;
  flex-flow: column wrap;
  justify-content: center;
  align-content: center;
  align-items: center;
  transform-style: preserve-3d;
  position: relative;
}
.loader-inner-1 {
  animation-delay: 0.2s;
  animation: change_first_circle 2s ease-in-out infinite;
}
.loader-inner-2 {
  animation-delay: 0.2s;
  animation: change_second_circle 2s ease-in-out infinite;
}
.loader-inner-3 {
  animation-delay: 0.2s;
  width: 50px;
  height: 50px;
  animation: change_last_circle 3s linear infinite;
}
@keyframes change_first_circle {
  50% {
    transform: rotateX(360deg) scale(0.8);
  }
}
@keyframes change_second_circle {
  50% {
    transform: rotateY(360deg) scale(0.8);
  }
}
@keyframes change_last_circle {
  50% {
    transform: rotateX(360deg) scale(0.8);
  }
}
</style>
