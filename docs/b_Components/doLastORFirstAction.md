
 ## 效果图 ##
<doLastTimeButton></doLastTimeButton>

<doFirstTime></doFirstTime>

## 代码 ##
```html
<template>    
    <label>{{ count }}
        <button @click="convertedFunc">click and i will do the last time</button>
    </label>
    
    <label>{{ count }}
        <button @click="convertedFunc">click and i will do the first time</button>
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
```

```javascript
const count = ref(0);
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

```

```css
```

## 学习点 ##
当学习了闭包后，我们可以封装一个独立的变量到函数中重复使用，例如在```函数中return函数```并使用外部函数的内部变量，此时返回出的函数同一个函数实例会拥有一个独立的外部变量，可以理解为形参，当触发这个返回方法实例总是会修改同一个函数变量，类似于这个变量永远为一个函数实例服务，也叫```内存泄漏```。

## BUG ##
如果发现bug或者其他需求可以联系作者
也十分欢迎pr
[前往github](https://github.com/Bayn-Web/bcomponent)