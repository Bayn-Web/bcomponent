<template>
    <div class="container">
        <ul id="scene">
            <div class="layer" data-depth="0.2">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="-260.5 -143 1920 1080">
                    <path fill="#010F1C" d="M-4283.3-877.2h9976v2610h-9976z" />
                </svg>
            </div>
            <div class="layer" data-depth="0.9">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="-260.5 -143 1920 1080">
                    <path fill="#054B8C"
                        d="M-4283.3-877.2v2610h9976v-2610h-9976zM839.6 371c19.4 13.4 44.6 16.4 64.3 30.4 13.2 9.4 41.7 42.6 22.9 59.2 4.9-4.3 2.5-2.2 0 0l-.3.3c.1-.1.2-.2.3-.2-2.7 2.4-5.5 4.8-.3.2-18.9 16.1-39.5-6.5-54.1-16.9-23.1-16.5-48-26.3-75.2-33.6C740 395 680.7 397 622.1 396.2c-50.6-.7-112.8 9.6-152.1-30-10.9-11-25-30.5-12.6-45.5 19.8-24.3 47.3-4.6 68.5 3.8 20.9 8.3 39.7 5.4 63.4 7.2 9 .6 58.1-12.5 82.7-25 17.3-8.8 36.8-20.6 52.7-3.4 19.5 21 44.9 15.1 70.1 10.4 13.4-2.5 43-9.9 53.8 2.2 19.3 21.6-30.1 40.4-9 55.1zm-64.7 270.1c-7.3 19-69.3-26.7-78.6-31.7-20.4-10.9-42.1-18.6-63.9-26-5.3-1.8-64.9-20.4-47.5-32.9 31.6-22.6 97.2 8.7 127.3 21.3 23.8 10 77.7 30.4 62.7 69.3zm.6-1.5l-.1.2.1-.2zm-.2.5l-.3.7.3-.7zm325.3-485.7c-6.8 33.6-75.3 5.6-97.8 5.6-25 0-53.1 12-77.1-.3-16.5-8.4-27.7-48.4-.2-44.1 19 3 38.7 14.4 58.4 7.9 20.6-6.8 22.8-32.8 46.9-30.6 25.9 2.4 76.7 27.7 69.8 61.5z" />
                </svg>
            </div>
        </ul>
    </div>
</template>

<script lang="ts" setup>
import Parallax from "parallax-js"
import { onMounted } from "vue";
onMounted(() => {
    var scene = document.getElementById('scene');
    var inp = document.getElementById('inp');
    //@ts-ignore
    new Parallax(scene, {
        relativeInput: true,
        // clipRelativeInput:true, //到达极限边距不再移动
        // hoverOnly:true,  //仅在绑定dom上有移动效果
        // frictionX :1, //图层间摩擦力，即图层移动时的速度 这个值只能低于1，数值越小速度越慢
        // originX: 0,//鼠标原始位置,值为1时相当于鼠标初始位置定为绑定元素右侧,此时再往右自然移动的距离就少了
        // originY: 0,//鼠标原始位置,值为1时相当于鼠标初始位置定为绑定元素右侧,此时再往右自然移动的距离就少了
        // invertX:false//设置为false意味着移动跟随鼠标或者陀螺仪,用于手机用户使用false会比较有意思
        // limitX :10, //设置为false则完全自由移动,设置数字则可以限制移动距离,当需要限制移动可以使用
        // scalarX :1000//数字越大移动越多越快,默认10,当想移动更多时可以使用
        // selector:"li"//一个选择器 指定动画产生在什么子元素上,如果null则直接指定所有元素
        // onReady: () => { console.log("插件加载完毕") }//parallax实例加载完毕的回调
    });
})
</script>

<style scoped>
body {
    margin: 0;
    padding: 0;
}

.container {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100vh;
    overflow: hidden;
    background: url(https://dummyimage.com/600x600/#40b78/fff);
    background-attachment: fixed;
}

.layer {
    width: 200px;
    height: 200px;
}

.layer svg {
    width: 100%;
    height: 100%;
    filter: drop-shadow(5px 5px 5px rgba(0, 0, 0, 0.3));
}
</style>