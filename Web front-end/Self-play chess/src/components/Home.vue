<template>
  <div class="container">
     <!-- <div class="box">
      <div class="left">
        <span class="icon iconfont icon-menu"></span>
        <span class="icon iconfont icon-setting"></span>
      </div>
    </div> -->
     <Draglo></Draglo> 
    <Menu @aaa='aaa'></Menu>
    <Prepare :state2='Pstate'></Prepare>
    <Battle :state1='Bstate'></Battle>
    <Player></Player>
    
  </div>
</template>

<script>
import Draglo from './Draglo'
import Prepare from './Prepare'
import Menu from './Menu'
import Battle from './Battle'
import Player from './Player'
import img from '@/assets/imgs/save.jpg';
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
  data:function(){
    return {
      img,
      Pstate:true,
      Bstate:false
    }
  },
   methods:{
    aaa(value1,value2){
      debugger
      this.Bstate=value1,
      this.Pstate=value2
    }
  }

};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.container{
  width: 100%;
  height: 900px;
  background-image: url('../assets/imgs/save.jpg');
}
.box{
  width:100%;
  height:50px;
  position: fixed;
}
.left{
  width:100px;
  height:50px;
  float:left;
}
.icon{
  width:50px;
  height:50px;
  display:inline-block;
  font-size:24px;
  color:white;
  line-height:50px;
  text-align:center;
}
</style>
