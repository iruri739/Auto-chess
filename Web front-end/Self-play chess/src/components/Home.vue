<template>
  <div class="container">
    <GameSetting @setVolume="setVolume" @setSwitch="setSwitch"></GameSetting>
    <Timer
      @resetTime="resetTime"
      @setState="setState"
      @cover="cover"
      @setRound="setRound"
      :glod="play.gold"
      :number="round"
      :playerId="playerId"
      :gameId="gameId"
      :state="state"
    ></Timer>
    <Prepare
      :sec="sec"
      :id="playerId"
      :state="state"
      :animal="play.cardInventory"
      :gameID="gameId"
      :glod="play.gold"
      @buy="buy"
      @shopping="getGlod"
    ></Prepare>
    <Battle :round="round" @setState="setState" :state="state" :sec="sec" :playerId="playerId"></Battle>
    <Player
      :sec="sec"
      @setState="setState"
      :state="state"
      :animals="Animals"
      :id="playerId"
      :gameId="gameId"
      :val="(play.hp*5)"
    ></Player>
    <audio ref="audio" autoplay loop>
      <source src="@/assets/music.mp3" />
    </audio>
  </div>
</template>

<script>
import GameSetting from "./GameSetting";
import Prepare from "./Prepare";
import Timer from "./Timer";
import Battle from "./Battle";
import Player from "./Player";
import img from "@/assets/imgs/save.jpg";
export default {
  name: "Home",
  props: {
    msg: String
  },
  components: {
    Prepare,
    Timer,
    Battle,
    Player,
    GameSetting
  },
  data: function() {
    return {
      Animals: {},
      img,
      playerId: 0,
      sec: 25,
      play: {},
      gameId: "",
      round: 1,
      //1:战斗结束，2：战斗中， 3：准备中，4：即将战斗
      state: 1
    };
  },
  created() {
    this.getRouterData();
    this.getPlayer();
  },
  methods: {
    setVolume(index) {
      this.$refs.audio.volume = index / 100;
      this.volume = index;
    },
    setSwitch(val) {
      if (val == true) {
        this.$refs.audio.play();
      } else {
        this.$refs.audio.pause();
      }
    },
    cover(value) {
      this.play = value;
    },
    resetTime(value) {
      this.sec = value;
    },
    getRouterData() {
      this.playerId = this.$route.query.id;
    },
    getPlayer() {
      this.$http
        .get("serveApi/game/initRounds?playerId=" + this.playerId)
        .then(resp => {
          if (resp.data.playerOneData.id == this.playerId) {
            this.play = resp.data.playerOneData;
          } else {
            this.play = resp.data.playerTwoData;
          }
          this.gameId = resp.data.gameId;
          this.round = resp.data.rounds;
          // this.sec = resp.data.prepareTime;
        });
    },
    getGlod(value) {
      this.play.gold -= value;
    },

    setState(value) {
      this.state = value;
    },
    buy(value) {
      value.fixed = false;
      this.Animals = value;
    },
    setRound(round) {
      this.round = round;
    }
  }
};
</script>
<style scoped>
.container {
  width: 100%;
  height: 900px;
  background-image: url("../assets/imgs/saei.jpg");
  background-size: cover;
}
.box {
  width: 100%;
  height: 50px;
  position: fixed;
}
.left {
  width: 100px;
  height: 50px;
  float: left;
}
.icon {
  width: 50px;
  height: 50px;
  display: inline-block;
  font-size: 24px;
  color: white;
  line-height: 50px;
  text-align: center;
}
</style>