<template>
  <div class="contain">
    <div>
      <el-row :gutter="10">
        <el-col :xs="5" :sm="5" :md="5" :lg="5">
          <div>
            <el-menu @select="handleSelect" active-text-color="#ffd04b">
              <img src="../assets/images/bage.jpg" width="200px" alt />
                <el-menu-item index="1"><i class="el-icon-menu"></i><span slot="title">卡牌管理</span></el-menu-item>
                <el-submenu index="2">
                  <template slot="title">
                    <i class="el-icon-menu"></i><span>用户管理</span>
                  </template>
                  <el-menu-item index="2-1">用户在线玩家列表</el-menu-item>
                </el-submenu>
                <el-submenu index="3">
                  <template slot="title">
                    <i class="el-icon-menu"></i><span>棋子管理</span>
                  </template>
                  <el-menu-item index="3-1">选项1</el-menu-item>
                  <el-menu-item index="3-2">选项2</el-menu-item>
                </el-submenu>
            </el-menu>
          </div>
        </el-col>
        <el-col :xs="19" :sm="19" :md="19" :lg="19">
          <div style="margin-top:10px">
            <router-view></router-view>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<style scoped>
.contain {
  background-color: rgb(255, 255, 255);
  height: 100%;
}
</style>
<script type="text/ecmascript-6">
  export default {
    data(){
      return {
        searchCriteria: '',
      }
    },
    methods:{
      handleSelect(key, keyPath){
        switch(key){
          case '1':
            this.$router.push('/UserMaster');
            break;
          case '2-1':
            this.$router.push('')
            break;
          case '2-2':
            this.$router.push('')
            break;
        }
      },
 
    },
  }
</script> 