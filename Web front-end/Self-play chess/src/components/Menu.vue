<template>
  <div>
    <!-- <p>这是menu</p> -->
    <div>
      <div class="box">
        <ul class="top">
          <li></li>
          <li>round{{number}}</li>
          <li>
            <div class="timer">
              <div ref="startTimer"></div>
            </div>
          </li>
          <li>pieces</li>
          <li>Gold</li>
        </ul>
        <ul class="center">
          <li>
            <img :src="img" />
          </li>
          <li :style="aa">{{li1}}</li>
          <li :style="aa">{{li2}}</li>
          <li>1vs1</li>
          <li>{{glod}}</li>
        </ul>

        <div class="bottom">
          <div>
            <div :style="aa" ref="descTimer"></div>
          </div>
        </div>
      </div>
    </div>
    <!-- <el-dialog title="游戏结束" :visible.sync="gameVisible" width="30%" :before-close="handleClose">
      <span>{{result}}</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="gameVisible = false">取 消</el-button>
        <el-button type="primary" @click="gameVisible = false">确 定</el-button>
      </span>
    </el-dialog> -->
  </div>
</template>
<script type="text/ecmascript-6">
import img from "@/assets/imgs/ling.jpg";

export default {
  name: "Menu",
  props: ["glod", "number"],
  data: function() {
    return {
      li1: "准备中",
      li2: "准备回合",
      img,
      timer: "",
      content: "",
      hour: 0,
      minutes: 0,
      seconds: 0,
      min: 0,
      sec: 40,
      flg: true,
      Bstate: true,
      Pstate: false,
      aa: ""
    };
  },
  created() {
    this.timer = setInterval(this.startTimer, 1000);
    this.timer = setInterval(this.descTimer, 1000);
  },
  destroyed() {
    clearInterval(this.timer);
  },

  methods: {
    startTimer() {
      this.seconds += 1;
      if (this.seconds >= 60) {
        this.seconds = 0;
        this.minutes += 1;
      }
      this.$refs.startTimer.innerHTML =
        (this.minutes < 10 ? "0" + this.minutes : this.minutes) +
        ":" +
        (this.seconds < 10 ? "0" + this.seconds : this.seconds);
    },

    descTimer() {
      this.sec -= 1;
      if (this.sec == 0) {
        if (this.flg) {
          
          this.$emit("aaa", this.Bstate, this.Pstate),
            (this.aa = "color:red"),
            (this.li1 = "战斗中"),
            (this.li2 = "战斗回合"),
            (this.sec = 60);
        } else {
         
          (this.Bstate = true), (this.Pstate = false);
          this.$emit("aaa", this.Pstate, this.Bstate),
            (this.aa = "color:white"),
            (this.li1 = "准备中"),
            (this.li2 = "准备回合"),
            (this.sec = 30);
        }
        this.flg = !this.flg;
      }

      // descTimer() {
      // this.sec -= 1;
      // if (this.sec == 0) {
      //     if (this.flg) {
      //       debugger
      //       this.$emit("aaa",this.Bstate,this.Pstate),
      //       (this.aa = "color:red"),
      //       (this.li1 = "战斗中"),
      //       (this.li2 = "战斗回合"),
      //       (this.sec = 60)
      //     } else {
      //       debugger
      //   //     this.Bstate=true,this.Pstate=false
      //   //     this.$emit("aaa",this.Pstate,this.Bstate),
      //   //     (this.aa = "color:white"),
      //   //       (this.li1 = "准备中"),
      //   //       (this.li2 = "准备回合"),
      //   //       (this.sec = 30);
      //    this.$http
      //       .get("http://localhost:8888/game/checkGameResult/" + gameid + "/" + userid)
      //       .then(resp => {
      //         // alert(resp .data);
      //         {
      //           if (resp.data === "continue") {
      //             (this.Bstate = true), (this.Pstate = false);
      //             this.$emit("aaa", this.Pstate, this.Bstate),
      //               (this.aa = "color:white"),
      //               (this.li1 = "准备中"),
      //               (this.li2 = "准备回合"),
      //               (this.sec = 30);
      //           } else if (resp.data === "true") {
      //             this.gameVisible = true;
      //             this.result = "恭喜您赢得本局游戏";
      //             clearInterval(this.descTimer);
      //           } else {
      //             this.gameVisible = true;
      //             this.result = "很遗憾您输了";
      //             clearInterval(this.descTimer);
      //           }
      //         }
      //       });

      //    }
      //     this.flg = !this.flg;

      // }
      this.$refs.descTimer.innerHTML =
        this.sec < 10 ? "0" + this.sec : this.sec;
    },
    watch: {
      second: {
        handler(newVal) {
          this.num(newVal);
        }
      },
      minute: {
        handler(newVal) {
          this.num(newVal);
        },
        sec: {
          handler(newVal) {
            this.num(newVal);
          }
        },
        min: {
          handler(newVal) {
            this.num(newVal);
          }
        }
      }
    }
  }
};
</script>
<style scoped>
.top li {
  list-style: none;
  width: 20%;
  height: 30px;
  float: left;
  text-align: center;
  color: wheat;
  line-height: 30px;
  margin-top: 20px;
}
.center li {
  list-style: none;
  width: 20%;
  height: 30px;
  background: black;
  float: left;
  text-align: center;
  color: wheat;
  line-height: 30px;
}
/* .text {
  line-height: 50px;
  display: inline-block;
} */

.box {
  width: 40%;
  height: 100px;
  margin: 0 auto;
}
.bottom {
  width: 100%;
  height: 20px;
  text-align: center;
  color: white;
}
img {
  width: 100px;
  height: 30px;
}
</style>