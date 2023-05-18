## 效果图 ##

  <banvas></banvas>

## 代码 ##
```html
<template> 
    <div>
        <canvas height="500" width="500" ref="canvasDom" id="canvas"></canvas>
        <input type="number" ref="inp1" v-model="height">
        <input type="number" ref="inp2" v-model="width">
        <input type="color" ref="inp3" v-model="color">
        <label for="checkbox">🖊<input id="checkbox" type="checkbox" v-model="drawable"></label>
    </div>
</template>
```

```js
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
```

```css
#canvas {
    position: relative;
    width: 500px;
    height: 500px;
    display: block;
}
```
## 说明 ##

1.  注意canvas保留一个默认的高宽为 **heigth:150** **width:300**,这个比例指的是canvas画布大小，而不是实际大小，这个属性可以直接在标签上修改,例如:

```html
<canvas height="300" width="300"></canvas>
```
此时这个默认高宽的画布被设置成了300的正方形画布,这300个单位只在js调用canvas函数时产生效果。
2. **切记** 当使用一个事件绑定时，最好将绑定事件单独写到外部，否则在给这个事件解绑时匿名函数是无法做到的。
3. 当事件解绑，或对应数据较多时，硬编码的方式可以替换成**makeCanvasCannotDraw**方法里的写法，让数组对应完成大量操作，比人为填写要更方便优雅。
## BUG ##
如果发现bug或者其他需求可以联系作者
也十分欢迎pr
[前往github](https://github.com/Bayn-Web/bcomponent)