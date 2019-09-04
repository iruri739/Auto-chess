import Vue from 'vue'
import Vuex from 'vuex'
import App from './App.vue'
import router from './router'
Vue.config.productionTip = false
import './mock.js'
import axios from 'axios'
import VueAxios from 'vue-axios'
import game from './module.js'
import './plugins/element.js'

import VueRouter from 'vue-router'

Vue.use(VueRouter)
Vue.use(VueAxios, axios)
Vue.use(Vuex)
// 创建Vuex的store
const store = new Vuex.Store({
  modules: {
    game
  }
})

/* eslint-disable no-new */
// new Vue({
//   el: '#app',
//   router,
//   store,
//   components: { App },
//   template: '<App/>'
// })
new Vue({
  render: h => h(App),
  store,
  router,
}).$mount('#app')
