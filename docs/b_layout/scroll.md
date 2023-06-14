## 效果图 ##

<ClientOnly><scroll></scroll></ClientOnly>

## 代码 ##
```html
<template>
    <div id="container">
        滑动至底部查看效果
        <div id="load" v-show="state">loading......</div>
        <div class="ani"></div>
    </div>
</template>
```
```typescript
import {
    nextTick,
    ref,
    onMounted
} from 'vue';
const state = ref(false)
onMounted(() => {
    window.addEventListener("scroll", onScroll)
})
let fistTime = true;
let time = 1;
let dosomething = () => {
    state.value = true
    //loading动画相关
    if (fistTime) {
        fistTime = !fistTime
        let loading = document.querySelector("#load");
        let letters = loading.textContent.split("");
        loading.textContent = "";
        letters.forEach((letter, i) => {
            let span = document.createElement("span");
            span.textContent = letter;
            span.style.animationDelay = `${i / 10}s`;
            span.classList += "ani"
            loading.append(span);
        });
    }
    setTimeout(() => {
        state.value = false
    }, 3000)
}
let doLess = doFirstTimeFunc(dosomething)
const onScroll = () => {
    let scrollHeight = document.documentElement.scrollHeight;
    let screenHeight = window.screen.height;
    let scrollTop = document.documentElement.scrollTop;
    if (scrollTop >= scrollHeight - screenHeight) {
        doLess()
    }
}
const doFirstTimeFunc = (func, time = 1000) => {
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
```
```css
#load {
    position: fixed;
    right: 10px;
    bottom: 10px;
}

#load /deep/ .ani {
    display: inline-block;
    font-size: 2em;
    animation: bounce 1.9s ease infinite alternate;
}

@keyframes bounce {
    to {
        transform: translateY(20px);
    }
}
```
## 步骤 ##
与信息加载类的组件进行搭配，目前仅作为一种监测滑动的demo。


## BUG ##
如果发现bug或者其他需求可以联系作者
也十分欢迎pr
[前往github](https://github.com/Bayn-Web/bcomponent)