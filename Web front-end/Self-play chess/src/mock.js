var Mock = require('mockjs')


 const produceData = function () {
     let articles = []
     let newArticleObject  = {
      id: 1,
      name: "bage",
      price: 3,
      level: 1,
      hp: 50,
      attack: 65,
      animalKind: "air",
      isAlive: true,
      img: "assets/images/bage.jpg"
     }
    articles.push(newArticleObject)
   return { articles: articles}
 }
// 第三个参数可以是对象也可以是返回对象的函数
Mock.mock('/article', 'get', produceData)