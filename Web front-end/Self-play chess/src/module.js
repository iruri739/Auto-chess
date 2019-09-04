import Vue from 'vue'
import axios from 'axios'
const RESQUEST_ARTICLES = 'RESQUEST_ARTICLES'

export default {
  state: {
    game:[],
    player1:[],
    player2:[]
  },

  getters: {
    getGame: state => state.game
  },

  actions: {
    fetchGameData (context) {
      context.commit(RESQUEST_ARTICLES)
    }
  },

  mutations: {
    [RESQUEST_ARTICLES] (state) {
      axios.get('/game').then(
        response => {
         
          let data = response.data
          state.game = data.game
        }
      )
    }
  }
}