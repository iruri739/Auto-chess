<template>
  <div class="container">
    <Draglo></Draglo>
    <Menu
      @getSec="getTime"
      @aaa="aaa"
<<<<<<< HEAD
      :glod="play.gold"
      :number="player.rounds"
      :playerId="playerId"
      :gameId="player.gameId"
      @cover="cover"
=======
      :glod="player.playerOneData.gold"
      :number="player.playerOneData.winCount"
>>>>>>> dd0f31031b5ad09fb9274f1a9a69aac7657c0738
    ></Menu>
    <Prepare
      :id="playerId"
      :state2="Pstate"
      :game="player.gameId"
      :glod="player.playerOneData.gold"
      @buy="addFixesAttr"
      @shopping="getGlod"
    ></Prepare>
    <Battle :state1="Bstate"></Battle>
    <Player :sec="sec" :animals="Animals" :val="player.playerOneData.hp"></Player>
  </div>
</template>

<script>
import Draglo from "./Draglo";
import Prepare from "./Prepare";
import Menu from "./Menu";
import Battle from "./Battle";
import Player from "./Player";
import img from "@/assets/imgs/save.jpg";
export default {
  name: "Home",
  components: {
    Prepare,
    Menu,
    Battle,
    Player,
    Draglo
  },
  data: function() {
    return {
      Animals: [],
      img,
      Pstate: true,
      Bstate: false,
      playerId: 0,
      player: {},
      sec: 0
    };
  },
  mounted() {
    this.getPlayer();
  },
  created() {
    this.getRouterData();
  },
  methods: {
<<<<<<< HEAD
    cover(user){
       this.play=user
    },
    getTime(time) {
      this.sec = time;
    },
    getRouterData() {
      this.playerId = this.$route.query.id;
      
=======
    gettime(value) {
      this.sec = value;
    },
    getRouterData() {
      this.playerId = this.$route.query.id;
>>>>>>> dd0f31031b5ad09fb9274f1a9a69aac7657c0738
    },
    getPlayer() {
      this.$http
        .get(
          `http://localhost:8888/game/defaultDataModel?playerId=${this.playerId}`
        )
        .then(resp => {
          this.player = resp.data;
        });
    },
    getGlod(value) {
      this.player.playerOneData.gold -= value;
    },
    aaa(value1, value2) {
      (this.Bstate = value1), (this.Pstate = value2);
    },
    addFixesAttr(value) {
      value.fixed = false;
      this.Animals.push(value);
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
