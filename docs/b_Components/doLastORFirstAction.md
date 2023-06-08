## 效果图

<doLastTimeButton></doLastTimeButton>

<doFirstTime></doFirstTime>

## 代码

```html
<template>
  <label
    >{{ count }}
    <button @click="convertedFunc">click and i will do the last time</button>
  </label>

  <label style="position: relative;">
    <div class="but" @click="convertedFunc">
      {{ count }} click and i will do the first time
    </div>
    <div ref="shader" class="shader"></div>
  </label>
</template>
```

```javascript
import { reactive, ref, onMounted } from "vue";
const count = ref(0);
const shader = ref(null);
let deg = ref(0);
const doLastTimeFunc = (func, time = 2000) => {
  let n = null;
  return () => {
    clearTimeout(n);
    n = setTimeout(() => {
      func();
    }, time);
  };
};
const doClick = () => {
  count.value++;
};
const convertedFunc = doLastTimeFunc(doClick);
onMounted(() => {
  animation();
});
const animation = () => {
  if (deg.value < 360) {
    deg.value += 1;
    shader.value.style.background = `conic-gradient(from ${deg.value}deg, #7460ba, #fff 5deg 340deg, #7857ed)`;
  } else deg.value = 0;
  requestAnimationFrame(animation);
};
```

```javascript
import { ref, onMounted } from "vue";
const count = ref(0);
const shader = ref(null);
let deg = ref(0);
const doFirstTimeFunc = (func, time = 2000) => {
  let t = true;
  let n = null;
  return () => {
    clearTimeout(n);
    if (t == true) {
      func();
      t = false;
    }
    n = setTimeout(() => {
      t = true;
    }, time);
  };
};
const doClick = () => {
  count.value++;
};
const convertedFunc = doFirstTimeFunc(doClick);
onMounted(() => {
  animation();
});
const animation = () => {
  if (deg.value < 360) {
    deg.value += 1;
    shader.value.style.background = `conic-gradient(from ${deg.value}deg, #7460ba, #fff 5deg 340deg, #7857ed)`;
  } else deg.value = 0;
  requestAnimationFrame(animation);
};
```

```css
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
```

## 学习点

当学习了闭包后，我们可以封装一个独立的变量到函数中重复使用，例如在`函数中return函数`并使用外部函数的内部变量，此时返回出的函数同一个函数实例会拥有一个独立的外部变量，可以理解为形参，当触发这个返回方法实例总是会修改同一个函数变量，类似于这个变量永远为一个函数实例服务，也叫`内存泄漏`。

- 一个小知识：如果使用`setTimeout或Interval`在设置的时间间隔过小时会产生 js 来不及找到 dom 的 bug，这个 bug 大致原因是操作 dom 时下一个操作又要进入，因此最好使用`requestAnimationFrame`这个新的 api，这个 api 会自动寻找下一次渲染时机，因此所有由数值控制的移动，例如鼠标动画，或循环动画应该都由这个 api 接管，这样可以保证动画的流畅。注意这个 api 大致每秒执行 60 次，因此不必担心流畅程度，只需要控制好数值来让动画尽量以合适速度进行。

## BUG

如果发现 bug 或者其他需求可以联系作者
也十分欢迎 pr
[前往 github](https://github.com/Bayn-Web/bcomponent)
