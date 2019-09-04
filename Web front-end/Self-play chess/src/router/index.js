import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home.vue'
import Prepare from '@/components/Prepare.vue'
import Menu from '@/components/Menu.vue'
import Player from '@/components/Player.vue'
import Waiting from '@/components/Waiting.vue'
import Sceeing from '@/components/Sceeing.vue'
 import Meenu from '@/components/Meenu.vue'
//  import Login from '@/components/Login.vue'

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
          path: 'Menu',
          component: Menu
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
      path: '/',
      name: 'Meenu',
      component: Meenu,
      
     },
    // {
    //   path: '/',
    //   name: 'Login',
    //   component: Login,
      
    // },
    
  ]
})
