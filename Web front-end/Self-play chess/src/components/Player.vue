<template>
  <div>
    <div>
      <div class="down" v-if="show">
        <ul>
          <draggable element="span" v-model="list2" v-bind="dragOptions" :move="onMove">
            <transition-group name="no" class="list-group" tag="ul">
              <li v-for="(element,index) in list2" :key="index">
                <i
                  :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'"
                  @click=" element.fixed=! element.fixed"
                  aria-hidden="true"
                ></i>
                <img :src="getImage(element.img)" class="img" />
                <span class="badge">{{element.hp}}+{{element.attack}}</span>
              </li>
            </transition-group>
          </draggable>
          <!-- <li v-for ="(item, index) in articles" :key="index">{{item.img}}</li> -->
        </ul>
      </div>
      <div class="box">
        <div class="left">
          <div class="title">
            <img src="../assets/touxiang2.jpg" alt />
          </div>
         
          <div class="blood">
            <meter
              min="0"
              max="100"
              :value="val"
              low="30"
              high="80"
              style="width: 200px;"
              optimum="50"
            ></meter>
          </div>
        </div>
        <!--已购买棋牌库-->
        <div class="right">
          <draggable
            class="list-group"
            tag="ul"
            v-model="list"
            v-bind="dragOptions"
            :move="onMove"
            @start="isDragging=true"
            @end="isDragging=false"
          >
            <transition-group type="transition" :name="'flip-list'">
              <div class="chess" v-for="(element,index) in list" :key="index">
                <i
                  :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'"
                  @click="element.fixed=! element.fixed"
                  aria-hidden="true"
                ></i>
                {{element.name}}
                <img
                  :src="getImage(element.img)"
                  width="50px"
                  height="50px"
                />
                <span class="badge">{{element.hp}}+{{element.attack}}</span>
              </div>
            </transition-group>
          </draggable>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import Prepare from "./Prepare";
import draggable from "vuedraggable";
import { mapGetters, mapActions } from "vuex";
export default {
  name: "Player",
  props: ["animals", "val", "sec", "games", "id"],
  components: {
    draggable,
    Prepare
  },
  data() {
    return {
      list2: [],
      list: [],
      editable: true,
      isDragging: false,
      delayedDragging: false,
      show:true
    };
  },
  mounted() {
    this.fetchData();
    this.getTimer();
  },
  methods: {
    ...mapActions({
      fetchData: "fetchGameData"
    }),
    getTimer() {
    var  time = setInterval(() => {
       
        if (this.sec==1){
          this.show=false
          this.axios
            .post("/serveApi/game/battleDataApi", {
              gameId: this.games,
              playerId: this.id,
              cards: this.list2
            })
            .then(response => {
              debugger
              console.log(response.data)
            });
        }else if(this.sec==30){
             this.show=true
        }
      }, 1000);
    },
    getImage(imgName) {
      var img = imgName;

      return require("../assets/images/" + img + ".jpg");
    },
    onMove({ relatedContext,draggedContext }) {
      const relatedElement = relatedContext.element;
      const draggedElement = draggedContext.element;
      return (
        (!relatedElement || !relatedElement.fixed) && !draggedElement.fixed
      );
    }
  },
  computed: {
    ...mapGetters({
      game: "getGame"
    }),
    dragOptions() {
      return {
        animation: 0,
        group: "description",
        disabled: !this.editable,
        ghostClass: "ghost"
      };
    },
    listString() {
      return JSON.stringify(this.list, null, 2);
    },
    list2String() {
      return JSON.stringify(this.list2, null, 2);
    }
  },

  watch: {
    animals: function(newVal, oldVal) {
      if(this.list.length<9){
        this.list.push(newVal)
      }else{
        console.log("牌库已满")
      }
      
    },
    isDragging(newValue) {
      if (newValue) {
        this.delayedDragging = true;
        return;
      }
      this.$nextTick(() => {
        this.delayedDragging = false;
      });
    }
  }
};
</script>
<style scoped>
.box {
  width: 40%;
  height: 240px;
  background: rgba(0, 0, 0, 0.5);
  margin: 0 auto;
}
.left {
  width: 328px;
  height: 210px;
  background: #232611;
  opacity: 0.6;
  float: left;
}
.right {
  width: 210px;
  height: 210px;
  background: #232611;
  opacity: 0.6;
  float: left;
}
.chess {
  width: 50px;
  height: 50px;
  background: #33342c;
  float: left;
  margin: 10px;
}
.title {
  width: 120px;
  height: 120px;
  border-radius: 50%;
  background: #131508;
  margin: 20px auto;
}
.title > img {
  width: 120px;
  height: 120px;
  border-radius: 50%;
}
.blood {
  width: 200px;
  height: 10px;
  border: 1px solid black;
  margin: 30px auto;
  border-radius: 10px;
}
.blood > meter {
  display: block;
  border-radius: 10px;
}
.down ul {
  margin-left: 50px;
}
.down ul li {
  list-style: none;
  width: 80px;
  height: 80px;
  border-radius: 50%;

  background: #131508;
  margin: 10px 30px;
  float: left;
  position: relative;
}
.img {
  width: 80px;
  height: 80px;
  border-radius: 50%;
  float: left;
}
.down {
  width: 900px;
  height: 100px;
  background: #232611;
  opacity: 0.6;
  margin: 15px auto;
}
.ghost {
  opacity: 0.5;
  background: #c8ebfb;
}
</style>