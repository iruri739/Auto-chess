<template>
<el-container  id="View">
    
      <div  id="w4">	
        <div>
           <div>
           <br/><br/><br/><br/><br/><h1 style="text-align:center">在线玩家</h1>
            </div>
            <br/><br/><br/><br/>
            <div>
                <el-scrollbar style="height:280px;">
                    <ol id="a4">
                        <li v-for="(user,index) in UserList" :key="index">
                            {{user}}
                        </li>
                    </ol>
                </el-scrollbar>
            </div>
        </div>
        <!-- <MagicSquare class="MagicSquare"></MagicSquare> -->
        </div>

       <div id="viem">
      <uii class="uii"></uii>
      </div>

    <Announcement class="yuan"> </Announcement>
</el-container>
</template>
<script>
import Announcement from './Announcement'
import Uii from './Uii'
export default {
  name: "UserView",
  components: {
    Announcement,
    Uii
    // MagicSquare
    },
  data: function() {
    return {
      UserList:[],
    };
  },

  mounted() {
    
    this.getOnlineUserList();
  },

  methods: {
    getOnlineUserList() {
      this.axios.get("/serveApi/user/getOnlineList").then(resp => {   
          this.UserList = resp.data;
      });
    }
  }
};
</script>

<style scoped>

    body{
        margin: 0%;
        padding: 0%;
    }
    /* #View{
      height: 450px;
        
    } */
    #w4{
     width: 248px;
     height: 500px;
     margin-left: 50px;
     margin-right: 50px;
     background-image: url("../assets/images/playerlist.jpg");
     margin-top:-50px; 
      
    }
    
    #a4{
    display: table;
     margin:0% auto;
     padding: 10px;
     text-align: left;
    }
    h1{
        font-family: "黑体";color:white;
    }
    li{
        color:white;
        line-height:2em;
    }
    .MagicSquare{

      margin:auto;
    }
    .yuan{
    width: 30%;
    background: black;
    height: 40%;
    float: top;
    left: 70%;
    opacity: 0.5;
    position: absolute;
    }
    h3{
        color:white;
    }

 .el-scrollbar__bar.is-horizontal{
    display: none

}
.el-scrollbar__wrap{
  overflow-x: hidden;
  margin:0%;
}
</style>
<style>
 .el-scrollbar__wrap{
  overflow-x: hidden !important;
  margin:0%;
} 
#w4{
     width: 248px;
     height: 500px;
     margin-left: 50px;
     margin-right: 50px;
     background-image: url("../assets/images/playerlist.jpg");
     margin-top:-50px;     
    }
#viem {
    width: 650px;
    margin-top: -30px;
  }
.Uii {
    margin: auto;
    }

</style>