
<template>
  <div id="Announcement">
    <div class="notice" style="margin-top:0px;clear:both">
      <el-tabs v-model="activeName">
        <el-tab-pane label="最新消息" name="first">
          <el-link
            :underline="false"
            href="https://www.zizouqi.com/comprehensiveInformation/detail/e4171e46465?lan=zh-cn&mobile=false"
            target="_blank"
          >《Superance自走棋》国际邀请赛中国区预选赛报名截止通知</el-link>
          <br />
          <el-link
            :underline="false"
            href="https://www.zizouqi.com/comprehensiveInformation/detail/e40fe8a93f6?lan=zh-cn&mobile=false"
            target="_blank"
          >《Superance自走棋》国际邀请赛中国区报名正式开启</el-link>
          <br />
          <el-link
            :underline="false"
            href="https://www.zizouqi.com/comprehensiveInformation/detail/e3f67fc85fd?lan=zh-cn&mobile=false"
            target="_blank"
          >关于体验服应用无法安装的解决办法</el-link>
        </el-tab-pane>

        <el-tab-pane label="公告" name="second">
          <el-link
            :underline="false"
            href="https://www.zizouqi.com/comprehensiveInformation/detail/e3f3ec04a63?lan=zh-cn&mobile=false"
            target="_blank"
          >《Superance自走棋》体验服8月23日维护公告</el-link>
          <br />
          <el-link
            :underline="false"
            href="https://www.zizouqi.com/comprehensiveInformation/detail/e40417751d1?lan=zh-cn&mobile=false"
            target="_blank"
          >关于结算排名异常的问题</el-link>
          <br />
          <el-link
            :underline="false"
            href="https://www.zizouqi.com/comprehensiveInformation/detail/e3f9a8d9c3d?lan=zh-cn&mobile=false"
            target="_blank"
          >《Superance自走棋》限时集结活动</el-link>
        </el-tab-pane>

        <el-tab-pane label="活动" name="third">
          <el-link :underline="false">无数据</el-link>
        </el-tab-pane>

        <el-tab-pane label="新闻" name="fourth">
          <el-link
            :underline="false"
            href="https://www.zizouqi.com/comprehensiveInformation/detail/16c6bec1f23?lan=zh-cn&mobile=false"
            target="_blank"
          >2019自走棋国际邀请赛八大赛区合作伙伴宣布！</el-link>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>
 
<script>
export default {
  name: "Announcement",
  data: function() {
    return {
      activeName: "second"
    };
  },
  methods: {
    quitGame: function() {
      this.$confirm("即将退出游戏！是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        window.location.href = "https://www.baidu.com";
      });
    }
  }
};
</script>
 
<style>
</style>

