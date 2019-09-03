<template>
  <div id="Sceeing">
    <el-container>
      <div class="block">
        <span class="demonstration"></span>
        <!-- <el-carousel height="150px">
          <el-carousel-item v-for="item in 4" :key="item">
            <h3 class="small">{{ item }}</h3>
          </el-carousel-item>
        </el-carousel> -->
      </div>

      <div class="block">
        <span class="demonstration"></span>
        <!-- <el-carousel trigger="click" height="150px">
          <el-carousel-item v-for="item in 4" :key="item">
            <h3 class="small">{{ item }}</h3>
          </el-carousel-item>
        </el-carousel> -->
      </div>
      <div class="d1">
        <div>
          <img src="../assets/timg.jpg" width="100%" height="700px" />
        </div>

        <div class="divcss5">
          <div class="divcss5-a">
            <img src="../assets/touxiang2.jpg" width="140px" height="140px" />
          </div>
          <div class="divcss5-b">
            <img src="../assets/touxiang4.jpg" width="140px" height="140px" />
          </div>
          <div class="divcss5-c">
            <font size="7">匹配成功</font>
          </div>
          <div class="divcss5-e">凹凸凸凹</div>
          <div class="divcss5-f">霸覇壩灞</div>
          <div class="divcss5-d">
            <el-button type="primary" :loading="true">正在进入游戏</el-button>
          </div>
          <div class="button">
            <el-button type="button" @click="open">开始战斗</el-button>
          </div>
          <div>
            <div class="textBox">
              <transition name="slide">
                <p class="text"  :key="text.id">{{text.val}}</p>
              </transition>
            </div>
          </div>
        </div>
      </div>
    </el-container>
  </div>
</template>

<script>

export default {
  name: "Sceeing",
  data() {
    return {
      // visible: false,
      textArr: [
        " 游戏战斗每回合，系统都会随机刷新出五枚棋子。",
        " 每回合都可以花费一定金币购买系统刷新出的棋子。 ",
        " 每局游戏我们将所购买的棋子放置战场，进行战斗。",
        " 战斗开始后，双方棋子会自动进行对战。",
        " 当对方棋子全部死亡后，己方获胜。",
        " 棋子分为海、陆、空三种不同类型，相互之间有制约关系。",
        " 当一局游戏结束后，会开始下一轮，直至玩家生命值为0。"
      ],
      number: 0
    }
  },
  computed: {
    text() {
      return {
        id: this.number,
        val: this.textArr[this.number]
      }
    }
  },
  mounted() {
    this.startMove();
  },

  methods: {
    startMove() {
      // eslint-disable-next-line
      let timer = setTimeout(() => {
        if (this.number === 7) {
          this.number = 0;
        } else {
          this.number += 1;
        }
        this.startMove();
      }, 2000); // 滚动不需要停顿则将2000改成动画持续时间
    },
    open() {
      this.$router.push({ path: "/Home" });
      // this.$confirm("是否退出游戏?", "提示", {
      //   confirmButtonText: "确定",
      //   cancelButtonText: "取消",
      //   type: "warning",
      //   center: true
      // })
      //   .then(() => {
      //     this.$message({
      //       type: "success",

      //       message: "退出成功!"
      //     });
      //   })
      //   .catch(() => {
      //     this.$message({
      //       type: "info",
      //       message: "已取消退出"
      //     });
      //   });
    },
    //几秒后进入跳转页面
    clickJump() {
      const timejump = 1;
      if (!this.timer) {
        this.count = timejump;
        this.show = false;
        this.timer = setInterval(() => {
          if (this.count > 0 && this.count <= timejump) {
            this.count--;
          } else {
            this.show = true;
             this.timer = null;
            this.$router.push({ path: "/Home" });
            clearInterval(this.timer);
           
          }
        }, 3000);
      }
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
.divcss5-a {
  position: absolute;
  margin-left: 50px;
  top: 130px;
}
/* 使用绝对定位position:absolute样式 并且使用left top进行定位位置 */
.divcss5-b {
  position: absolute;
  margin-left: 560px;
  top: 130px;
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
.button {
  position: relative;
  top: 320px;
  width: 800px;
  left: -30px;
  border: 0px;
}
 /* .bottom {
  position: relative;
  left: 460px;
  top: 180px;
  width: 800px;
  height: 30px;
  border: 0px;
}   */
.textBox {
  position: relative;
  left: -10px;
  top: 320px;
  width: 800px;
  height: 30px;
  border: 0px;
  
}
.text {
  width: 100%;
  size: 5px;
  position: absolute;
  color:rgb(16, 16, 17);
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
