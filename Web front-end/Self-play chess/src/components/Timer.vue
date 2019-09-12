<template>

  <div>
    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <span>游戏结束</span>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="handleClose">确 定</el-button>
      </span>
    </el-dialog>
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
            <div :style="statusBar">{{sec}}</div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>
<script type="text/ecmascript-6">
import img from "@/assets/imgs/ling.jpg";
export default {
  name: "Timer",
  props: ["glod", "number", "playerId", "gameId","state"],
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
      statusBar: "",
      play: {},
      descTimerRunFlg: false,
      dialogVisible: false
    };
  },

  created() {
    
    this.totalDuration= setInterval(this.startTimer, 1000);
    this.initRound();
    
  },

  destroyed() {
    clearInterval(this.totalDuration);
  },

  methods: {
    handleClose(done) {
        this.dialogVisible = false;
        this.$router.push({
            name: "Menu",
            query: {
              id: this.playerId
            }
        })
    },

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
    initRound(){
      //初始化战场定时器
      let timer = setInterval(() => {
        //如果是战斗结束，则轮询
        if(this.state == 1)
        {
        console.log("上一轮战斗结束，status为战斗结束，开始初始化战场 initRounds");

        this.axios.get("serveApi/game/initRounds?playerId=" +this.playerId)
          .then(resp => {
            var retState = resp.data.state;

            //判断state PREPARE, BATTLE, FINISHED
            //如果返回的如果是FINISHED,则游戏结束
            //如果是PREPARE，程序往下进行
            //如果是BATTLE则继续轮询
            if(retState == "FINISHED")
            {
              window.clearInterval(timer);
              this.$message({
              type: "success",
              message: `游戏结束！`
              });

              return;
            }else if(retState == "PREPARE")
            {
              //设置状态为准备中
              this.$emit("setState",3),
              this.statusBar = "color:white"
              this.ready = "准备中"
              this.preparatoryRound = "准备回合"
              this.sec = resp.data.prepareTime
              this.$emit("resetTime", this.sec);
              if (resp.data.playerOneData.id == this.playerId) {
                this.play = resp.data.playerOneData;
              } else {
                this.play = resp.data.playerTwoData;
              }
              this.$emit("setRound",resp.data.rounds)
              console.log("当前回合为：" + resp.data.rounds);
              this.$emit("cover",this.play);  
              this.descTimer();
              }             
          }).catch(err => {
              window.clearInterval(timer);
          })}
      }, 500);
    },
    /**
     * 准备倒计时
     */
    descTimer() {
      console.log("enter descTimer");

      let descTimer = setInterval(() => {
        this.$emit("resetTime",this.sec);
         this.sec -= 1;
         console.log("准备中，开始倒计时，剩余时间：" + this.sec);
         if (this.sec <= 0) {
            //状态设置为战斗中
            this.$emit("setState",4),
            this.statusBar = "color:red"
            this.ready = "战斗中"
            this.preparatoryRound = "战斗回合"
            window.clearInterval(descTimer);
       }
      }, 1000);
    },
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