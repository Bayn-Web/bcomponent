<template>
    <div style="position: relative;">
        <div class="but" @click="convertedFunc">
            {{ count }} click and i will do the first time
        </div>
        <div ref="shader" class="shader"></div>
    </div>
</template>

<script setup>
import {
    ref,
    onMounted
} from 'vue';
const count = ref(0);
const shader = ref(null);
let deg = ref(0);
const doFirstTimeFunc = (func, time = 2000) => {
    let t = true;
    let n = null;
    return () => {
        clearTimeout(n)
        if (t == true) {
            func();
            t = false
        }
        n = setTimeout(() => {
            t = true;
        }, time)
    }
}
const doClick = () => {
    count.value++;
}
let convertedFunc = doFirstTimeFunc(doClick)
onMounted(() => {
    doNextFrame(animation, 2)
})
</script>

<style scoped>
.but {
    display: flex;
    justify-content: center;
    position: relative;
    width: 280px;
    height: 30px;
    font-weight: bolder;
    background-color: black;
    color: white;
    border-radius: 1em;
    cursor: pointer;
    z-index: 1;
}

.but:hover {
    background-color: white;
    color: black;
}

@property
--deg {
    syntax: "<angle>";
    initial-value: 0deg;
    inherits: false;
}

.shader {
    position: absolute;
    top: -2px;
    left: -2px;
    height: 34px;
    width: 284px;
    border-radius: 1em;
    animation: rotate 5s infinite;
    background: conic-gradient(from var(--deg), #7460ba, #fff 5deg 340deg, #7857ed);
}

@keyframes rotate {
    to {
        --deg: 360deg;
    }
}
</style>