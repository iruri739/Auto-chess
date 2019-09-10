<template>
  <div class="container">
    <GameSetting></GameSetting>
    <Timer
      @getSec="gettime"
      @setState="setState"
      :glod="play.gold"
      :number="player.rounds"
      :playerId="playerId"
      :gameId="player.gameId"
      @cover="cover"
    ></Timer>
    <Prepare
      :sec="sec"
      :id="playerId"
      :state2="Pstate"
      :animal="play.cardInventory"
      :gameID="player.gameId"
      :glod="play.gold"
      @buy="buy"
      @shopping="getGlod"
    ></Prepare>
    <Battle :state1="Bstate" :sec="sec" :eid="playerId" :gameid="player.gameId"></Battle>
    <Player
      :sec="sec"
      :animals="Animals"
      :id="playerId"
      :games="player.gameId"
      :val="play.hp"
    ></Player>
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
      Pstate: true,
      Bstate: false,
      playerId: 0,
      player: {},
      sec: 0,
      play:{}
    };
  },
  mounted() {
    
  },
  created() {
    console.log("1")
    this.getPlayer();
    console.log("2")
    this.getRouterData();
  },
  methods: {
    cover(value){
       this.play=value
    },
    gettime(value) {
      this.sec = value;
    },
    getRouterData() {
      this.playerId = this.$route.query.id;
      
    },
    getPlayer() {
      this.$http
        .get(
          "http://localhost:8888/game/defaultDataModel?playerId=" +
            this.playerId
        )
        .then(resp => { 
          this.player = resp.data;
         
           if (resp.data.playerOneData.id == this.playerId) {
                this.play = resp.data.playerOneData; 
              } else {
                this.play=resp.data.playerTwoData;
              }
        });
    },
    getGlod(value) {
      this.play.gold -= value;
    },
    setState(value1, value2) {
      (this.Bstate = value1), (this.Pstate = value2);
    },
    buy(value) {
      value.fixed = false;
      this.Animals=value;
    }
  }
};
</script>
  
<!-- Add "scoped" attribute to limit CSS to this component only -->
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