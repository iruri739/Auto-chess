<template>
  <div id="Meenu">
<el-container>
<el-carousel :interval="4000" type="card" height="350px">
    <el-carousel-item v-for="item in img" :key="item.index">
      <div class="limg" :style="{backgroundImage:'url('+item+')'}"></div>
      <div class="img1"></div>
    </el-carousel-item>
</el-carousel> 
 </el-container>
  <UserView></UserView>
    <el-container>
      <div>
      <el-container>
        <el-button id="campus-home-btn-group" @click="startGames"  plain>
          <div class="btn-group-inner">
                            <div class="start">
                                <i class="el-icon-check">开始游戏</i>
                                <em class="em_1"></em>
                                <em class="em_2"></em>
                            </div>
                        </div>     
        </el-button>
      </el-container>
      </div>
      <div>
      <el-container>
        <el-button id="campus-home-btn-group1" @click="quitGame" plain>
           <div class="btn-group-inner">
                            <div class="over">
                                <i class="el-icon-close">退出游戏</i>
                                <em class="em_1"></em>
                                <em class="em_2"></em>
                            </div>
                        </div>
        </el-button>
      </el-container>
      </div>
    </el-container>
  </div>
</template>

<script>
import img1 from "@/assets/imgs/1.jpg";
import img2 from "@/assets/imgs/2.jpg";
import img3 from "@/assets/imgs/3.jpg";
import img4 from "@/assets/imgs/4.jpg";
import img5 from "@/assets/imgs/5.jpg";
import UserView from './UserView'
import img9 from '@/assets/imgs/background4.jpg';
export default {
  name: "Meenu",
  components: {
    UserView
  },

   data: function() {
    return {
      img: [img1, img2, img3,  img4, img5],
      id:0
    };
  },
   created() {
    this.getRouterData()
  },
  methods: {
     getRouterData() {
      this.id = this.$route.query.id
      
    },
    startGames: function() {
         this.$router.push({ 
                   name: "Waiting" ,
                   query:{
                     id:this.id
                   }
                   });
     
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
#campus-home-btn-group{
  display:block;
  margin:0 auto;
  top:-177px;
  position:relative;
  left:1123px;
  background:#686d9c;
  font-size:20px;
  width:155px; 
}
#campus-home-btn-group1{
  display:block;
  margin:0 auto;
  top:-85px;
  position:relative;
  left:969px;
  background:#686d9c;
  font-size:20px;
  width:155px; 
}
#campus-home-btn-group .start {
        color: wheat;
        display: inline-block;
        width: 100%;
        position: relative;
    }
#campus-home-btn-group1 .over {
        color: wheat;
        display: inline-block;
        width: 100%;
        position: relative;
    }
    #campus-home-btn-group .start em {
        position: absolute;
        top: -12.5px;
        left: -20px;
        display: block;
        width: 7.5em;
        height: 2em;
        border: 2px solid rgb(238, 241, 243);
       
    }
    #campus-home-btn-group1 .over em {
        position: absolute;
        top: -12px;
        left: -20px;
        display: block;
        width: 7.5em;
        height: 2em;
        border: 2px solid rgb(238, 241, 243);
       
    }
    #campus-home-btn-group .start:hover em {
        opacity: .2;
    }

    #campus-home-btn-group .start:hover em.em_1 {
        -webkit-animation: 'cbtnem1'.5s linear;
    }

    #campus-home-btn-group .start:hover em.em_2 {
        -webkit-animation: 'cbtnem2'.75s linear;
    }

    #campus-home-btn-group .start:hover em.em_3 {
        -webkit-animation: 'cbtnem3'1s linear;
    }

    #campus-home-btn-group .start:hover em.em_4 {
        -webkit-animation: 'cbtnem4'1.25s linear;
    }

    #campus-home-btn-group1 .over:hover em {
        opacity: .2;
    }

    #campus-home-btn-group1 .over:hover em.em_1 {
        -webkit-animation: 'cbtnem1'.5s linear;
    }

    #campus-home-btn-group1 .over:hover em.em_2 {
        -webkit-animation: 'cbtnem2'.75s linear;
    }

    #campus-home-btn-group1 .over:hover em.em_3 {
        -webkit-animation: 'cbtnem3'1s linear;
    }

    #campus-home-btn-group1 .over:hover em.em_4 {
        -webkit-animation: 'cbtnem4'1.25s linear;
    }


    @-webkit-keyframes cbtnem1 {
        0% {
            -webkit-transform: scale(1, 1);
            -webkit-transform-origin: 40% 40%
        }

        50% {
            -webkit-transform: scale(1.12, 1.4);
            -webkit-transform-origin: 40% 40%
        }

        100% {
            -webkit-transform: scale(1, 1);
            -webkit-transform-origin: 40% 40%
        }
    }

    @-webkit-keyframes cbtnem2 {
        0% {
            -webkit-transform: scale(1, 1);
            -webkit-transform-origin: 40% 60%
        }

        50% {
            -webkit-transform: scale(1.12, 1.4);
            -webkit-transform-origin: 40% 60%
        }

        100% {
            -webkit-transform: scale(1, 1);
            -webkit-transform-origin: 40% 60%
        }
    }

    @-webkit-keyframes cbtnem3 {
        0% {
            -webkit-transform: scale(1, 1);
            -webkit-transform-origin: 60% 60%
        }

        50% {
            -webkit-transform: scale(1.12, 1.4);
            -webkit-transform-origin: 60% 60%
        }

        100% {
            -webkit-transform: scale(1, 1);
            -webkit-transform-origin: 60% 60%
        }
    }

    @-webkit-keyframes cbtnem4 {
        0% {
            -webkit-transform: scale(1, 1);
            -webkit-transform-origin: 60% 40%
        }

        50% {
            -webkit-transform: scale(1.12, 1.4);
            -webkit-transform-origin: 60% 40%
        }

        100% {
            -webkit-transform: scale(1, 1);
            -webkit-transform-origin: 60% 40%
        }
    }

body{
  width: 100%;
  background: url('../assets/imgs/background4.jpg');
  background-size: cover;
  /* margin-left: 600px; */
}

 #Meenu{
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
   margin-top: 10px; 
} 
.el-carousel--horizontal {
  width: 1349px;
  
 
}


.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.limg{
   background-repeat: no-repeat;
   background-size:100% 100%; 
 
   height: 350px; 
}




</style>