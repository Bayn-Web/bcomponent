<template>
    <label style="position: relative;">
        <div class="but" @click="convertedFunc">
            {{ count }} click and i will do the last time</div>
        <div ref="shader" class="shader"></div>
    </label>
</template>

<script setup>
import {
    reactive,
    ref,
    onMounted
} from 'vue';
const count = ref(0);
const shader = ref(null);
let deg = ref(0);
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
onMounted(() => {
    animation()
})
const animation = () => {
    if (deg.value < 360) {
        deg.value += 1;
        shader.value.style.background = `conic-gradient(from ${deg.value}deg, #7460ba, #fff 5deg 340deg, #7857ed)`;
    }
    else deg.value = 0;
    requestAnimationFrame(animation)
}
</script>

<style scoped>
.theme-default-content {
    position: absolute;
    z-index: -2;
}

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
}

.but:hover {
    background-color: white;
    color: black;
}

.shader {
    position: absolute;
    top: -2px;
    left: -2px;
    height: 34px;
    width: 284px;
    border-radius: 1em;
    z-index: -1;
}
</style>