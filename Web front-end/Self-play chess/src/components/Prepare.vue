<template>
  <div v-if="state2">
    <div class="box">
      <div class="top">
        <ul class="store">
          <li v-for="(item,index) in Animals" :key="index">
            <img :class="{'active':item.checked}" :src="getImage(item.img)" @click="buycards(item)" />
            <span class="iconfont icon-coinyen">{{item.price}}</span>
          </li>
        </ul>
        <div class="icon_l">
          <span @click="getShop()" class="iconfont icon-refresh"></span>
          <span class="iconfont icon-coinyen">{{gold}}</span>
        </div>
        <div class="icon_r">
          <span class="iconfont icon-close1"></span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  props: ["state2", "glod"],
  name: "Store",
  data: function() {
    return {
      Animals: [],
      bought: [],
      gold: 0
    };
  },
  watch: {
    state2() {
      debugger;
      this.state2;
    },
    glod: function(newVal, oldVal) {
      this.gold = newVal;
    }
  },
  mounted() {
    this.getMockData();
  },
  computed: {},
  methods: {
    getShop() {
      if (this.gold>= 2) {
        this.gold -= 2;
        this.getMockData();
      } else if (this.gold <= 1) {
        alert("金币不足");
      }
    },
    deletcard(bought, item) {
      for (let i = 0; i < bought.length; i++) {
        if (bought[i].id == item.id) {
          bought.splice(i, 1);
          return bought;
        }
      }
    },
    buycards(item) {
      if (typeof item.checked == "undefined" || item.checked == false) {
        if (this.gold >= item.price) {
          if (!this.bought) {
            this.bought = [];
          }
          this.$emit("buy", item);
          this.bought.push(item);
          this.gold -= item.price;
          this.$set(item, "checked", true);
        } else {
          alert("金币不足");
          this.bought = this.deletcard(this.bought, item);
        }
      } 
      // else {
      //   item.checked = !item.checked;
      //   this.gold += item.price;
      //   this.bought = this.deletcard(this.bought, item);
      // }
    },
    getImage(imgName) {
      var img = imgName;

      return require("../assets/images/" + img + ".jpg");
    },
    getMockData() {
      this.$http.get("http://localhost:8888/game/getChessData/").then(resp => {
        this.Animals = resp.data;
      });
    }
  }
};
</script>

<style scoped>
ul li {
  list-style: none;
}
.box {
  width: 80%;
  height: 240px;

  margin: 50px auto;
  position: relative;
}
.icon_l {
  position: absolute;
  left: 5px;
  top: 5px;
}
.icon_r {
  position: absolute;
  right: 5px;
  top: 5px;
}
.icon_l .iconfont {
  font-size: 24px;
  color: white;
  display: inline-block;
  margin-right: 20px;
}
.icon_r .iconfont {
  font-size: 24px;
  color: white;
}
.top {
  width: 100%;
  height: 240px;
  background: #232611;
  opacity: 0.6;
  margin: 20px auto;
  position: relative;
}
.top ul li {
  list-style: none;
  width: 100px;
  height: 100px;
  border-radius: 50%;
  background: #131508;
  margin: 50px 30px;
  float: left;
  position: relative;
}
.top ul li img {
  width: 100px;
  height: 100px;
  border-radius: 50%;
}
.active {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  opacity: 0.4;
}
ul.store {
  margin-left: 130px;
  top: 0;
}
img + span {
  width: 50px;
  height: 20px;
  text-align: center;
  background: yellow;
  display: inline-block;
  position: absolute;
  bottom: -30px;
  left: 25px;
}
.down {
  width: 675px;
  height: 130px;
  background: purple;
  margin: 50px auto;
}
.down ul li {
  list-style: none;
  width: 100px;
  height: 100px;
  border-radius: 50%;
  border: 1px solid #ccc;
  margin: 10px 40px 0 0;
  float: left;
  position: relative;
}
.down ul li:last-child {
  margin-right: 0;
}
</style>