<template>
  <div>
    <!-- <p>这是menu</p> -->
    <div>
      <div class="box">
        <ul class="top">
          <li></li>
          <li>round1</li>
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
          <li>6</li>
        </ul>

        <div class="bottom">
        
          <div>
            <div :style="aa" ref="descTimer"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script type="text/ecmascript-6">
import img from "@/assets/imgs/ling.jpg"

export default {
  
  name: "Menu",
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
      sec: 30,
      flg: true,
      Bstate: true,
      Pstate: false,
    };
  },
  created() {
    this.timer = setInterval(this.startTimer, 1000);
    this.timer = setInterval(this.descTimer, 1000);
  },
  mounted() {
    this.add();
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
            debugger
            this.$emit("aaa",this.Bstate,this.Pstate),
            (this.aa = "color:red"),
            (this.li1 = "战斗中"),
            (this.li2 = "战斗回合"),
            (this.sec = 60)
          } else {
            debugger
            this.Bstate=true,this.Pstate=false
            this.$emit("aaa",this.Pstate,this.Bstate),
            (this.aa = "color:white"),
              (this.li1 = "准备中"),
              (this.li2 = "准备回合"),
              (this.sec = 30);
          }
          this.flg = !this.flg;
          
      }

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