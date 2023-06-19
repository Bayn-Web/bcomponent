<template>
    <div>
        <canvas height="500" width="500" ref="canvasDom" id="canvas"></canvas>
        <input type="number" ref="inp1" v-model="height">
        <input type="number" ref="inp2" v-model="width">
        <input type="color" ref="inp3" v-model="color">
        <label for="checkbox">🖊<input id="checkbox" type="checkbox" v-model="drawable"></label>
    </div>
</template>

<script setup>
import {
    ref,
    onMounted,
    watch
} from 'vue';
const ctx = ref(null)
const canvasDom = ref(null)
const height = ref(200)
const width = ref(200)
const color = ref('#cdcdcd')
const drawable = ref(true)
onMounted(() => {
    ctx.value = canvasDom.value.getContext('2d');
    ctx.scale(scale, scale);
    rePicCanvas(width.value, height.value, color.value)
    watch(drawable, (newV) => {
        console.log(newV)
        if (newV) { makeCanvasCanDraw() }
        else { makeCanvasCannotDraw(); }
    }, {
        immediate: true
    })
})
watch([height, width, color], ([preHeight, preWidth, preColor]) => {
    ctx.value.clearRect(0, 0, canvasDom.value.clientWidth, canvasDom.value.clientHeight);
    rePicCanvas(preWidth, preHeight, preColor)
})
const rePicCanvas = (width, height, color) => {
    ctx.value.fillStyle = color;
    ctx.value.fillRect(0, 0, parseInt(width), parseInt(height));
}
const makeCanvasCanDraw = () => {
    canvasDom.value.addEventListener('mousedown', downFunc);
    canvasDom.value.addEventListener('mousemove', moveFunc);
    canvasDom.value.addEventListener('mouseup', stopFunc)
    canvasDom.value.addEventListener('mouseleave', stopFunc)
}
let isDrawing = false;
let lastX = 0;
let lastY = 0;
const downFunc = (e) => {
    isDrawing = true;
    [lastX, lastY] = [e.offsetX, e.offsetY];
}
const moveFunc = (e) => {
    if (isDrawing) {
        ctx.value.beginPath();
        ctx.value.moveTo(lastX, lastY);
        ctx.value.lineTo(e.offsetX, e.offsetY);
        ctx.value.stroke();
        [lastX, lastY] = [e.offsetX, e.offsetY];
    }
}
const stopFunc = (e) => {
    isDrawing = false;
}
const makeCanvasCannotDraw = () => {
    const acts = ["mousedown", "mousemove", "mouseup", "mousemouseleavedown"]
    const events = [downFunc, moveFunc, stopFunc, stopFunc]
    acts.forEach((value, index) => {
        canvasDom.value.removeEventListener(value, events[index]);
    })
}
</script>

<style scoped>
#canvas {
    position: relative;
    width: 500px;
    height: 500px;
    display: block;
}
</style>