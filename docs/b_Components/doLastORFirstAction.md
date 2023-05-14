
 ## 效果图 ##
<doLastTimeButton></doLastTimeButton>

<doFirstTime></doFirstTime>

## 代码 ##
```html
<template>    
    <label>{{ count }}
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
import {
    reactive,
    ref,
    onMounted,
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
setInterval(() => {
    if (deg.value < 360) {
        deg.value += 1;
        shader.value.style.background = `conic-gradient(from ${deg.value}deg, #7460ba, #fff 5deg 340deg, #7857ed)`;
    }
    else deg.value = 0;
}, 10)
```

```javascript
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
const convertedFunc = doFirstTimeFunc(doClick)
setInterval(() => {
    if (deg.value < 360) {
        deg.value += 1;
        shader.value.style.background = `conic-gradient(from ${deg.value}deg, #7460ba, #fff 5deg 340deg, #7857ed)`;
    }
    else deg.value = 0;
}, 10)
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

## 学习点 ##
当学习了闭包后，我们可以封装一个独立的变量到函数中重复使用，例如在```函数中return函数```并使用外部函数的内部变量，此时返回出的函数同一个函数实例会拥有一个独立的外部变量，可以理解为形参，当触发这个返回方法实例总是会修改同一个函数变量，类似于这个变量永远为一个函数实例服务，也叫```内存泄漏```。

## BUG ##
如果发现bug或者其他需求可以联系作者
也十分欢迎pr
[前往github](https://github.com/Bayn-Web/bcomponent)