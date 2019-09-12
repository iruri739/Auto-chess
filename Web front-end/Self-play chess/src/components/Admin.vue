<template>
  <div class="container">
      <h1>自走棋游戏后台管理系统</h1>
    <UserMaster></UserMaster>
    <Userview></Userview>
  </div>
</template>

<script>
import UserMaster from "./UserMaster";

export default {
     name: "Admin",
     components: {
     UserMaster,
    }
  }
</script>