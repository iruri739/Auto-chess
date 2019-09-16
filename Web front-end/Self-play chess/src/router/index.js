import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home.vue'
import Prepare from '@/components/Prepare.vue'
import Timer from '@/components/Timer.vue'
import Player from '@/components/Player.vue'
import Waiting from '@/components/Waiting.vue'
import Sceeing from '@/components/Sceeing.vue'
import Menu from '@/components/Menu.vue'
import Login from '@/components/Login.vue'
import UserMaster from '@/components/UserMaster.vue'
import Manage from '@/components/Manage.vue'
import adminLogin from '@/components/adminLogin.vue'
import UserView from '@/components/UserView.vue'

Vue.use(Router)

export default new Router({
  routes: [
     {
      path: '/Home',
      name: 'Home',
      component: Home,
      children:[
        {
          path: 'Prepare',
          component: Prepare
        },
        {
          path: 'Timer', 
          component: Timer
        },
        {
          path: 'Player',
          component: Player
        }
      ]
      
    },
    {
      path: '/Waiting',
      name: 'Waiting',
      component: Waiting
    },
    {
      path: '/Sceeing',
      name: 'Sceeing',
      component: Sceeing
    },
    {
      path: '/Menu',
      name: 'Menu',
      component: Menu,
      
     },
     {
      path: '/',
      name: 'Login',
      component: Login,
      
     },
     {
      path: '/adminLogin',
      name: 'adminLogin',
      component: adminLogin,
      
     },
     {
      path: '/Manage',
      name: 'Manage',
      component: Manage,
      children:[
        {
          path: '/UserMaster',
          name: UserMaster,
          component: UserMaster
        },
        {
          path: '/UserView',
          name: UserView,
          component: UserView
        }
      ]
     }
  ]
})
