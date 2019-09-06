var Mock = require('mockjs')
 
 const produceData = function () {
 let articles = []
 let newArticleObject = {
 
 userId:1,
 userName:"222"
 }
 for(var i=0;i<15;i++){
 newArticleObject.userId=i;
 newArticleObject.userName="userName"+i;
 articles.push(newArticleObject)
 }
 
 
 
 return { userlist: articles}
 }
// 第三个参数可以是对象也可以是返回对象的函数
Mock.mock('http://localhost:8888/user/onlineUserList', 'get', produceData)