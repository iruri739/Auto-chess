import Vue from 'vue'
import Vuex from 'vuex'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import './plugins/element.js'
import VueRouter from 'vue-router'

Vue.config.productionTip = false
Vue.use(VueRouter)
Vue.use(VueAxios, axios)
Vue.use(Vuex)

// 创建Vuex的store
const store = new Vuex.Store({
  modules: {
     
  }
})

new Vue({
  render: h => h(App),
  store,
  router,
}).$mount('#app')
