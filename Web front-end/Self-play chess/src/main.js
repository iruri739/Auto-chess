import Vue from 'vue'
import Vuex from 'vuex'
import App from './App.vue'
import router from './router'
Vue.config.productionTip = false
import axios from 'axios'
import VueAxios from 'vue-axios'
import game from './module.js'
import player1 from './module.js'
import player2 from './module.js'
import './plugins/element.js'
import VueRouter from 'vue-router'

Vue.use(VueRouter)
Vue.use(VueAxios, axios)
Vue.use(Vuex)

// 创建Vuex的store
const store = new Vuex.Store({
  modules: {
    game,
    player1,
    player2
  }
})

new Vue({
  render: h => h(App),
  store,
  router,
}).$mount('#app')
