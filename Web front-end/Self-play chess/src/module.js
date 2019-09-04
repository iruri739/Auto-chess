import Vue from 'vue'
import axios from 'axios'
const RESQUEST_ARTICLES = 'RESQUEST_ARTICLES'

export default {
  state: {
    articles: []
    
  },

  getters: {
    getArticles: state => state.articles
  },

  actions: {
    fetchArticlesData (context) {
      context.commit(RESQUEST_ARTICLES)
    }
  },

  mutations: {
    [RESQUEST_ARTICLES] (state) {
      axios.get('/article').then(
        response => {
         
          let data = response.data
          state.articles = data.articles
        }
      )
    }
  }
}