var Mock = require('mockjs')


 const produceData = function () {
     let articles = []
     let newArticleObject  = {
       id:1
     }
    articles.push(newArticleObject)
   return { game: articles}
 }
// 第三个参数可以是对象也可以是返回对象的函数
Mock.mock('/game', 'get', produceData)