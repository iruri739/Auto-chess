import Vue from 'vue'
import axios from 'axios'
const RESQUEST_GAME = 'RESQUEST_GAME'
const RESQUEST_PLAYER1 = 'RESQUEST_PLAYER1'
const RESQUEST_PLAYER2 = 'RESQUEST_PLAYER2'

export default {
  state: {
    game: [],
    player1: [],
    player2: []
  },

  getters: {
    getGame: state => state.game,
    getPlayer1: state => state.Player1,
    getPlayer2: state => state.Player1
  },

  actions: {
    fetchGameData(context,game) {
      context.commit(RESQUEST_GAME)
    },
    fetchPlayer1Data(context,Player1) {
      context.commit(RESQUEST_PLAYER1)
    },
    fetchPlayer2Data(context,Player2) {
      context.commit(RESQUEST_PLAYER2)
    },

  },

  mutations: {
    [RESQUEST_GAME](state, game) {

      state.game = game
    },
    [RESQUEST_PLAYER1](state, Player1) {

      state.player1 = player1
    },
    [RESQUEST_PLAYER2](state, Player2) {
      state.player2 = player2
    }

  }
}