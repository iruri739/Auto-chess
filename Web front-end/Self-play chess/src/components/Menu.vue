<template>
  <div>
    <!-- <p>这是menu</p> -->
    <div>
      <div class="box">
        <ul class="top">
          <li></li>
          <li>回合{{number}}</li>
          <li>
            <div class="timer">
              <div ref="startTimer"></div>
            </div>
          </li>
          <li>对战</li>
          <li>金币</li>
        </ul>
        <ul class="center">
          <li>
            <img :src="img" />
          </li>
          <li :style="statusBar">{{ready}}</li>
          <li :style="statusBar">{{preparatoryRound}}</li>
          <li>1vs1</li>
          <li>{{glod}}</li>
        </ul>

        <div class="bottom">
          <div>
            <div :style="statusBar" ref="descTimer"></div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>
<script type="text/ecmascript-6">
import img from "@/assets/imgs/ling.jpg";
export default {
  name: "Menu",
  props: ["glod", "number", "id", "game"],
  data: function() {
    return {
      ready: "准备中",
      preparatoryRound: "准备回合",
      img,
      readyTime: "",
      totalDuration: "",
      //timer: "",
      content: "",
      hour: 0,
      minutes: 0,
      seconds: 0,
      min: 0,
      sec: 30,
      flg: true,
      Bstate: true,
      Pstate: false,
      statusBar: "",
      play: {},
    };
  },
  created() {
    this.totalDuration= setInterval(this.startTimer, 1000);
    this.readyTime= setInterval(this.descTimer, 1000);
  },
  destroyed() {
    clearInterval(this.totalDuration);
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
      this.$emit("getSec", this.sec);
      this.sec -= 1;
      if (this.sec == -1) {
        if (this.flg) {
          this.$emit("stateChange", this.Bstate, this.Pstate),
            (this.statusBar = "color:red"),
            (this.ready = "战斗中"),
            (this.preparatoryRound = "战斗回合"),
            (this.sec = 5);
          this.$emit("getSec", this.sec);
          this.flg = !this.flg;
        } else {
          var time1 = setInterval(() => {
            this.$http
              .get(
                "http://localhost:8888/game/gamePrepareCheck?gameId=" +
                  this.game +
                  "&playerId=" +
                  this.id
              )
              .then(resp => {
                if (resp.data == true) {
                  (this.Bstate = true), (this.Pstate = false);
                  this.$emit("stateChange", this.Pstate, this.Bstate),
                    (this.statusBar = "color:white"),
                    (this.ready = "准备中"),
                    (this.preparatoryRound = "准备回合"),
                    (this.sec = 30);
                  this.$emit("getSec", this.sec);
                  this.flg = !this.flg;
                  this.$http
                    .get(
                      "http://localhost:8888/game/defaultDataModel?playerId=" +
                        this.id
                    )
                    .then(resp => {
                      if (resp.data.playerOneData.id == this.playerId) {
                        this.play = resp.data.playerOneData;
                      } else {
                        this.play = resp.data.playerTwoData;
                      }
                      this.$emit("cover", this.play);
                    });

                  window.clearInterval(time1);
                } else if (resp.data == "win") {
                  alert("你赢了");
                } else if (resp.data == "lose") {
                  alert("你输了");
                }
              });
          }, 1000);
        }
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