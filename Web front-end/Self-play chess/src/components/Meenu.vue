<template>
  <div id="Meenu">

  <el-carousel indicator-position="outside">
    <el-carousel-item v-for="item in img" :key="item.index">
      <div class="limg" :style="{backgroundImage:'url('+item+')'}"></div>
      <div class="img1"></div>
    </el-carousel-item>
  </el-carousel> 
    <el-container>

      <div class="detail" style="margin:0 auto"></div>
      
    </el-container>
    <div>
      <span style="display:block"></span>
      <el-divider></el-divider>
    </div>

    <div class = "gonggao">
      <p style="color:white">自走棋活动公告</P>
      <hr>
      <span style="color:white">
        自走棋是一个回合制游戏，每回合会刷新一次棋子，每次会出现5个可供购买的棋子，当然在金币多的情况下也可以花2金币手动刷新一次。而棋子总共有五个品质，品质越高购买花费的金币就越多，而是否能刷新到高品质且是自己想要的棋子除了和自己的信使角色等级有关，运气也是必不可少的一部分。三个相同的棋子可以升星，升星后属性和能力都有大幅提升，最高不超过三星。
        信使等级
      </span>
    </div>

    <el-container>
      <el-container>
        <el-button @click="startGames" style="display:block;margin:0 auto;margin-top:10px" round>
          <font color="#000000">开始游戏</font>
        </el-button>
      </el-container>
      <el-container>
        <el-button @click="quitGame" style="display:block;margin:0 auto;margin-top:10px" round>
          <font color="#000000">退出游戏</font>
        </el-button>
      </el-container>


    </el-container>
  </div>
</template>

<script>
import img1 from "@/assets/imgs/1.jpg";
import img2 from "@/assets/imgs/2.jpg";
import img3 from "@/assets/imgs/3.jpg";
import img4 from "@/assets/imgs/4.jpg";
import img5 from "@/assets/imgs/5.jpg";
// import Carousel from "./Carousel.vue";
import img6 from '@/assets/imgs/logo.jpg';
import img9 from '@/assets/imgs/background1.jpg';
export default {
  name: "Meenu",
  // components: {
  //   Carousel
  // },
   data: function() {
    return {
      img: [img1, img2, img3,  img4, img5]
    };
  },
  methods: {
    startGames: function() {
        this.$router.push({ path: "/Waiting"});
    },
    quitGame: function() {
        this.$confirm('即将退出游戏！是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          window.location.href = "https://www.baidu.com"
        })
    }
  }
};
</script>

<style>
.detail {
  width: 300px;
  height: 300px;
   opacity: 4;
  background-color: transparent;
  background-image: url('../assets/imgs/logo.jpg');
  
}
.gonggao
{
  background-color: black;
  margin-top: 68px;
  opacity: 0.6;
  text-align: center;

}
body {
  width: 100%;
  background: url('../assets/imgs/background1.jpg');
  background-size: cover;
}

span {
  height: 30px;
  zoom: 1;
  opacity: 5;
  color: rgb(0, 0, 0);
}
#Meenu {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
   margin-top: 30px; 
}
.el-carousel--horizontal {
  width: 800px;
  float: left;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
  height: 500px;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.limg {
   background-repeat: no-repeat;
   background-size:100% 100%; 
 
  height: 300px;
}

.el-row {
  margin-bottom: 20px;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}

</style>