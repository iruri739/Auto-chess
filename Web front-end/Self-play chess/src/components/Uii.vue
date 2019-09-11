
<template>
    <div class="wrap">
      <div class="cube">
        <div class="front">
          <h2>自走棋-冲冲冲</h2></div>
        <div class="back">
          <h2>自走棋-gogogo</h2></div>
        <div class="top">
          <h2>自走棋-哈哈哈</h2></div>
        <div class="bottom">
          <h2>自走棋-嘿嘿嘿</h2></div>
        <div class="left">
          <h2>自走棋-啦啦啦</h2></div>
        <div class="right">
          <h2>自走棋-略略略</h2></div>
      </div>
    </div>
    </template>
<script>
export default {
  name: "Uii",
  
  }
</script>
<style scoped>
	.wrap {
  		margin-top: 150px;
  		perspective: 1000px;
  		perspective-origin: 50% 50%;
	     }
            .cube {
                margin: auto;
                position: relative;
                height: 200px;
                width: 200px;
                transform-style: preserve-3d;
             }
                .cube div {
                    position: absolute;
                    padding: 10px;
                    box-sizing: border-box;
                    height: 100%;
                    width: 100%;
                    opacity: 0.9;
                    background-color: #000;
                    border: solid 1px #eee;
                    color: #fff;
                    font: 10px arial;
                    transition: transform 0.2s ease-in;
                }
            .front {
                background: url("../assets/imgs/7.jpg");
                transform: translateZ(100px);
            }

            .back {
                background: url("../assets/imgs/8.jpg");
                transform: translateZ(-100px) rotateY(180deg);
            }

            .right {
                background: url("../assets/imgs/9.jpg");
                transform: rotateY(-270deg) translateX(100px);
                transform-origin: top right;
            }

            .left {
                background: url('../assets/imgs/11.jpg');
                transform: rotateY(270deg) translateX(-100px);
                transform-origin: center left;
            }
            .top {
                background: url('../assets/imgs/12.jpg');
                transform: rotateX(-270deg) translateY(-100px);
                transform-origin: top center;
            }
            .bottom {
                background: url('../assets/imgs/13.jpg');
                transform: rotateX(270deg) translateY(100px);
                transform-origin: bottom center;
            }
            @keyframes rotate {
                from {
                    transform: rotateX(0deg) rotateY(0deg);
                }
                to {
                    transform: rotateX(360deg) rotateY(360deg);
                }
            }
            .cube {
                animation: rotate 20s infinite linear;
            }

            .wrap:hover .front {
                transform: translateZ(200px);
            }
            .wrap:hover .back {
                transform: translateZ(-200px) rotateY(180deg);
            }
            .wrap:hover .right {
                transform: rotateY(-270deg) translateZ(100px) translateX(100px);
            }
            .wrap:hover .left {
                transform: rotateY(270deg) translateZ(100px) translateX(-100px);
            }
            .wrap:hover .top {
                transform: rotateX(-270deg) translateZ(100px) translateY(-100px);
            }
            .wrap:hover .bottom {
                transform: rotateX(270deg) translateZ(100px) translateY(100px);
            }
        </style>