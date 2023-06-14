<template>
    <label style="position: relative;">
        <div class="lbut" @click="convertedFunc">
            {{ count }} click and i will do the last time</div>
        <div ref="shader" class="lshader"></div>
    </label>
</template>

<script setup>
import {
    ref,
} from 'vue';
const count = ref(0);
const shader = ref(null);
const doLastTimeFunc = (func, time = 2000) => {
    let n = null
    return () => {
        clearTimeout(n)
        n = setTimeout(() => {
            func();
        }, time)
    }
}
const doClick = () => {
    count.value++;
}
const convertedFunc = doLastTimeFunc(doClick)
</script>

<style scoped>
label {
    overflow: hidden;
    display: block;
    height: 34px;
    width: 284px;
    border-radius: 1em;
}

.lbut {
    display: flex;
    justify-content: center;
    position: relative;
    width: 280px;
    height: 30px;
    margin-left: 2px;
    margin-top: 2px;
    font-weight: bolder;
    background-color: black;
    color: white;
    border-radius: 1em;
    cursor: pointer;
    z-index: 1;
}

.lbut:hover {
    background-color: white;
    color: black;
}

.lshader {
    position: absolute;
    top: -142px;
    left: -2px;
    height: 300px;
    width: 300px;
    border-radius: 1em;
    background: conic-gradient(from 180deg at 50% 50%, #00D1FF 0deg, #EE27FF 106.88deg, #205EFF 206.25deg, #00F0FF 286.87deg, #00D1FF 360deg);
    animation: rotate 3s linear infinite;
}

@keyframes rotate {
    from {
        transform: rotate(0deg);
    }

    to {
        transform: rotate(360deg);
    }
}
</style>