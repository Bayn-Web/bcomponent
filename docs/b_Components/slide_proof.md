## 效果图

<ClientOnly><slideProof></slideProof></ClientOnly>

## 代码

```html
<template>
  <div id="continer">
    <canvas ref="canvas1" width="300" height="200"></canvas>
    <canvas id="slideBlock" ref="canvas2" width="60" height="60"></canvas>
    <img ref="img" src="../public/bk.png" style="display: none" />
    <input v-model="process" type="range" id="range" ref="range" />
  </div>
</template>
```

```javascript
import { ref, onMounted } from "vue";
const canvas1 = ref(null);
const canvas2 = ref(null);
const range = ref(null);
const process = ref(0);
const startPathX = Math.round(Math.random() * 240);
const startPathY = Math.round(Math.random() * 140);
const img = ref(null);
let isAct = false;
onMounted(() => {
  canvas2.value.style.top = canvas1.value.offsetTop + startPathY + "px";
  const ctx1 = canvas1.value.getContext("2d");
  const ctx2 = canvas2.value.getContext("2d");
  img.value.onload = () => {
    ctx1.drawImage(img.value, 0, 0, 300, 200);
    ctx2.drawImage(img.value, startPathX * -1, startPathY * -1, 300, 200);
    draw(
      ctx1,
      () => {
        ctx1.fillStyle = "#63eae6";
        ctx1.fill();
      },
      startPathX,
      startPathY
    );
  };
  range.value.addEventListener("mouseup", () => {
    isAct = false;
    if (Math.abs(Number.parseInt(process.value) * 2.6 - 20 - startPathX) < 5) {
      process.value = 0;
      canvas2.value.style.transform = `translateX(0px)`;
    }
  });
  range.value.addEventListener("mousedown", () => {
    isAct = true;
  });
  range.value.addEventListener("mousemove", () => {
    if (isAct) {
      canvas2.value.style.transform = `translateX( ${
        Number.parseInt(process.value) * 2.6
      }px)`;
    }
  });
});

const draw = (ctx, act, startPathX, startPathY) => {
  ctx.beginPath();
  ctx.moveTo(startPathX, startPathY);
  ctx.lineTo(startPathX + 60, startPathY);
  ctx.lineTo(startPathX + 60, startPathY + 60);
  ctx.lineTo(startPathX + 40, startPathY + 60);
  ctx.lineTo(startPathX + 40, startPathY + 55);
  ctx.lineTo(startPathX + 30, startPathY + 55);
  ctx.lineTo(startPathX + 30, startPathY + 60);
  ctx.lineTo(startPathX, startPathY + 60);
  ctx.lineTo(startPathX, startPathY + 40);
  ctx.lineTo(startPathX + 10, startPathY + 40);
  ctx.lineTo(startPathX + 10, startPathY + 30);
  ctx.lineTo(startPathX, startPathY + 30);
  ctx.lineTo(startPathX, startPathY);
  act();
};
```

```css
canvas:first-child {
  height: 200px;
  width: 300px;
  box-shadow: 2px 2px 1px;
}

#slideBlock {
  position: absolute;
  margin-left: -20px;
  z-index: 999;
  height: 60px;
  width: 60px;
  box-shadow: 1px 2px 2px;
}

#range {
  position: relative;
  width: 100%;
}

#continer {
  width: 300px;
}
```

## 简述

简单实现了滑动验证，也是对 canvas 的再一次学习。

## BUG

如果发现 bug 或者其他需求可以联系作者
也十分欢迎 pr
[前往 github](https://github.com/Bayn-Web/bcomponent)
