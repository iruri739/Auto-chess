<template>
    <div  v-if="state1">
        <div class="box">
            <div class="top">
                <ul>
                    <li>{{li1}}</li>
                    <li>{{li1}}</li>
                    <li>{{li1}}</li>
                    <li>{{li1}}</li>
                    <li>{{li1}}</li>
                   
                </ul>
                
                <button class="but11" @click="start()">开始</button>
            </div>
            <div class="center">
                
                <div :style="aa"></div>
                <div :style="aa"></div>
                <div :style="aa"></div>
                <div :style="aa"></div>
                <div :style="aa"></div>
                <div :style="bb"></div>
                <div :style="bb"></div>
                <div :style="bb"></div>
                <div :style="bb"></div>
                <div :style="bb"></div>
                
            
            </div>
            <div class="down">
                <ul>
                    <li>{{li6}}</li>
                    <li>{{li6}}</li>
                    <li>{{li6}}</li>
                    <li>{{li6}}</li>
                    <li>{{li6}}</li>
                </ul>
            </div>
        </div>
    </div>
</template>
<script>
import img1 from '@/assets/images/hema.jpg'
import img2 from '@/assets/images/gezi.jpg'
export default {
    
    name: 'Battle',
    props:["state1"],
    data(){
        return{
           
        
        li1:'1',
        li6:'6',
        // img1,
        center1:'',
        center6:'',
        aa:''
        }
    },
methods:{
    start(){
    
    //  this.center1=this.img1;
    //  this.center6=this.li6;
    this.aa="background-image:url('"+img1+"');background-size: cover"
    this.bb="background-image:url('"+img2+"');background-size: cover"
    }
}
}
</script>
<style scoped>
    ul li{
       
        list-style:none;
    }
    .box{
        width:70%;
        height:350px;   
        margin:50px auto;
    }
    .top{
        width:900px;
        height:100px;
        background:#232611;
        opacity: 0.6;
        margin:15px auto;
    }
    .top ul li{
        
        text-align: center;
        color: red;
        list-style:none;
        width:80px;
        height:80px;
        border-radius:50%;
        background-size: cover;
        background-image:url('../assets/images/hema.jpg');
        margin:10px 30px;
        float:left;
        position:relative;
    }
   
    .center{
        width:360px;
        height:150px;
        background: #232611;
        margin-left: 280px;
    }
    .center div{
        position: relative;
        width:70px;
        height:70px;
       border-radius:50%;
        background: #232611;
        opacity: 0.6;
        float:left;
        /* border:1px solid gray; */
        /* margin:3px 5px; */
        animation-name: shake;
        animation-duration: 1.5s;
        animation-iteration-count: infinite;
    }
     @keyframes shake {
        from {

            transform: scale(1, 1) rotate(0deg);
        }

        to {
            transform: scale(.8, .5) rotate(360deg);

            box-shadow: 0px 0px 200px blue;

        }
    }
    .top ul{
        margin-left:100px;
        top:0;
    }
    .down ul{
        margin-left:100px;
        top:0;
    }
    .down ul li{
        text-align: center;
        color: blue;
        list-style:none;
        width:80px;
        height:80px;
        border-radius:50%;  
        background-size: cover;  
       background-image:url('../assets/images/gezi.jpg');
        margin:10px 30px;
        float:left;
        position:relative;
    }
     .down{
        width:900px;
        height:100px;
        background:#232611;
        opacity:0.6;
        margin:15px auto; 
        } 
   /* #center,
    #horizontal,
    #vertical {
        position: absolute;
        left: 0px;
        top: 0px;

    } */

    /* #horizontal {
        animation: horizontal 0.8s linear 0s infinite alternate;
    }

    #vertical {
        animation: vertical 0.55s ease-in 0s infinite alternate;
    } */

    @keyframes horizontal {
        0% {
            left: 0px;
        }

        100% {
            left: 150px;
        }
    }

    @keyframes vertical {
        0% {
            top: 0px;
        }

        100% {
            top: 200px;
        }
    }
   
</style>