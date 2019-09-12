<template>
  <div v-if="state1">
    <div class="box">
      <div class="top">
        <ul>
          <li>{{li1}}</li>
          <li>{{li1}}</li>
          <li>{{li1}}</li>
          <li>{{li1}}</li>
          <li>{{li1}}</li>
        </ul>

        <button class="but11" @click="start()">开始</button>
      </div>
      <div class="center">
        <div :style="aa" class="dui"></div>
        <div :style="aa" class="dui"></div>
        <div :style="aa" class="dui"></div>
        <div :style="aa" class="dui"></div>
        <div :style="aa" class="dui"></div>

        <div :style="bb" class="my"></div>
        <div :style="bb" class="my"></div>
        <div :style="bb" class="my"></div>
        <div :style="bb" class="my"></div>
        <div :style="bb" class="my"></div>
      </div>
      <div class="down">
        <ul>
          <li>{{li6}}</li>
          <li>{{li6}}</li>
          <li>{{li6}}</li>
          <li>{{li6}}</li>
          <li>{{li6}}</li>
        </ul>
      </div>
    </div>
  </div>
</template>
<script>
import img1 from "../assets/images/hema.jpg";
import img2 from "../assets/images/wugui.jpg";
export default {
  name: "Battle",
  props: ["state1"],
  data() {
    return {
      li1: "1",
      li6: "6",
      // img1,
      center1: "",
      center6: "",
      aa: ""
    };
  },
  methods: {
    start() {
      //  this.center1=this.img1;
      //  this.center6=this.li6;
      this.aa = "background-image:url('" + img1 + "');background-size: cover";
      this.bb = "background-image:url('" + img2 + "');background-size: cover";
    }
  }
};
</script>
<style scoped>
ul li {
  list-style: none;
}
.box {
  width: 70%;
  height: 350px;
  margin: 50px auto;
}
.top {
  width: 900px;
  height: 100px;
  background: #232611;
  opacity: 0.6;
  margin: 15px auto;
}
.top ul li {
  text-align: center;
  color: red;
  list-style: none;
  width: 80px;
  height: 80px;
  border-radius: 50%;
  background-size: cover;
  background-image: url("../assets/images/hema.jpg");
  margin: 10px 30px;
  float: left;
  position: relative;
}

.center {
  width: 360px;
  height: 150px;
  background: #232611;
  margin-left: 280px;
}
.center div {
  margin-left: 18px;
  position: relative;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  background: #232611;
  opacity: 0.6;
  float: left;
  /* border:1px solid gray; */
  /* margin:3px 5px; */
}

.my {
  animation-name: shake;
  animation-duration: 0.7s;
  animation-iteration-count: infinite;
}

.dui {
  animation-name: sha;
  animation-duration: 0.7s;
  animation-iteration-count: infinite;
}

@keyframes shake {
  from {
    bottom: -50px;
  }

  to {
    bottom: -10px;
  }
  
}
@keyframes sha {
  from {
    top: 0px;
  }

  to {
    top: 30px;
  }
}
.top ul {
  margin-left: 100px;
  top: 0;
}
.down ul {
  margin-left: 100px;
  top: 0;
}
.down ul li {

  text-align: center;
  color: blue;
  list-style: none;
  width: 80px;
  height: 80px;
  border-radius: 50%;
  background-size: cover;
  background-image: url("../assets/images/wugui.jpg");
  margin: 10px 30px;
  float: left;
  position: relative;
}
.down {
  width: 900px;
  height: 100px;
  background: #232611;
  opacity: 0.6;
  margin: 15px auto;
}
</style>