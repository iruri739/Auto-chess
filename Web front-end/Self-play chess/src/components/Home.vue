<template>
  <div class="container">
    <Draglo></Draglo>
    <Menu @aaa="aaa" :glod="player.playerOneData.gold" :number="player.playerOneData.winCount"></Menu>
    <Prepare :state2="Pstate" :game="player.gameId" :glod="player.playerOneData.gold" @buy="buya" @shopping="getGlod"></Prepare>
    <Battle :state1="Bstate"></Battle>
    <Player :animals="Animals" :val="player.playerOneData.hp"></Player>
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
  props: {
    msg: String
  },
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
      playerId: 1,
      player: {}
    };
  },
  mounted() {
    this.getPlayer();
  },
  methods: {
    getPlayer() {
      this.$http
        .post("http://localhost:8888/game/defaultDataModel?playerId=10")
        .then(resp => {
          
          this.player =resp.data;
          console.log(this.player);
        });
    },
    getGlod(value) {
      this.player.playerOneData.gold -= value;
    },
    aaa(value1, value2) {
      (this.Bstate = value1), (this.Pstate = value2);
    },
    buya(value) {
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
