<template>
  <div class="Setting" :style="zIndex">
    <span class="icon iconfont icon-menu" @click="open"></span>
    <span class="icon iconfont icon-setting" @click="handleClick"></span>
    <el-container class="opp" v-if="show">
      <el-header border>系统设置</el-header>
      <el-main>
        <el-tabs v-model="activeName" tabPosition="left" style="height: 400px;" type="boder-card">
          <el-tab-pane label="系统设置" name="first">系统设置</el-tab-pane>
          <el-tab-pane label="操作设置" name="second">操作设置</el-tab-pane>
          <el-tab-pane label="画面设置" name="third">画面设置</el-tab-pane>
          <el-tab-pane label="声音设置" name="fourth" class="voiceSetting">
            声音设置
            <div id="voice">
              <el-checkbox v-model="checked1">总音量</el-checkbox>
              <br />
              <div class="block">
                <span class="demonstration">音量</span>
                <el-slider v-model="value1"></el-slider>
              </div>
              <br />
              <el-checkbox v-model="checked2">音效</el-checkbox>
              <br />
              <div class="block">
                <span class="demonstration">音量</span>
                <el-slider v-model="valuef1"></el-slider>
              </div>
              <br />
              <el-checkbox v-model="checked3" @change="handleClick1">背景音乐</el-checkbox>
              <div class="block">
                <span class="demonstration">音量</span>
                <el-slider  v-model="slider" @change="changeVolume"></el-slider>
              </div>
              <br />
            </div>
          </el-tab-pane>
        </el-tabs>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "GameSetting",
  data() {
    return {
      checked1: true,
      checked2: true,
      checked3: true,
      value1: 100,
      valuef1: 100,
      slider: 100,
      show: false,
      activeName: "first",
      count: 0,
      zIndex: ""
    };
  },
  methods: {
    changeVolume(index) {
       this.$emit("setVolume",index)
      },
      handleClick1(value){
        this.$emit("setSwitch",value)
      },
    open() {
      this.$confirm("是否退出游戏?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
        center: true
      })
        .then(() => {
          this.$router.push({ path: "/" });
          this.$message({
            type: "success",

            message: "退出成功!"
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消退出"
          });
        });
    },
    
    handleClick: function() {
      this.show = !this.show;
      this.count++;
      if (this.count % 2 == 1) {
        this.zIndex = "z-index: 100";
      } else {
        this.zIndex = "z-index: 0";
      }
    }
  }
};
</script>
<style scoped>
.Setting {
  width: 700px;
  height: 300px;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 0;
}

.left {
  width: 100px;
  height: 50px;
  float: left;
}
.opp {
  width: 800px;
  margin-left: 300px;
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
.el-header {
  padding: 20px;
  font-size: 20px;
  color: rgb(248, 248, 248);
  background: rgb(110, 110, 110);
}
.el-main {
  background: rgb(175, 159, 159);
}
.voiceSetting {
  margin-left: 10px;
}
</style>

