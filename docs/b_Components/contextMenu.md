## 效果图 ##

  <contextMenu></contextMenu>

## 代码 ##
```html
<template> 
    <div ref="area">
        <span ref="line1" @click="undo" id="line1" class="warning-line">WARN &nbsp; WARN &nbsp; WARN &nbsp; WARN &nbsp; WARN
            &nbsp; WARN
            &nbsp;
        </span>
        <span ref="line2" @click="undo" id="line2" class="warning-line">WARN &nbsp; WARN &nbsp; WARN &nbsp; WARN &nbsp; WARN
            &nbsp; WARN
            &nbsp;
        </span>
    </div>
</template>
```

```js
import { onMounted, ref } from "vue"
const area = ref(null)
const line1 = ref(null)
const line2 = ref(null)
const lines = [line1, line2]
const stopDefaultBehavior = (e) => { e.preventDefault(); }
onMounted(() => { area.value.addEventListener("contextmenu", stopDefaultBehavior) })
const undo = () => {
    area.value.removeEventListener("contextmenu", stopDefaultBehavior)
    lines.forEach((v) => {
        console.log(v.value)
        v.value.innerText = "accessible".toUpperCase()
        v.value.style.background = "#7CFC00";
        v.value.style.color = "#fff";
        v.value.classList.add("anim")
    })
}
```

```css
div {
    box-sizing: border-box;
    height: 600px;
    width: 600px;
    position: relative;
    background: url(https://dummyimage.com/600x600/#40b78/fff);
    overflow: hidden;
}

#line1 {
    transform: rotate(30deg);
    margin-left: -50px;
}

#line2 {
    transform: rotate(-23deg);
    padding-left: -20px;
}

.anim {
    animation: dropdown 3s ease-in forwards;
}

.warning-line {
    position: relative;
    border: 2px dashed black;
    border-color: black;
    color: red;
    display: block;
    width: 150%;
    text-align: center;
    font-size: 2em;
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    font-weight: bold;
    background-color: yellow;
    box-shadow: 3px 3px 3px grey;
    top: 200px;
    left: -100px;
    border-radius: 5px;
    cursor: pointer;
}

@keyframes dropdown {
    to {
        top: 700px;
        transform: rotate(0deg);
    }
}
```
## 说明 ##

通过绑定就可以阻止用户点击右键，类似的方式可以让用户更专注于页面，减少错误操作带来的影响。
```js
    window.addEventListener("keydown", (e) => {
        if (e.code == "F12") {
            e.preventDefault();
        }
    })
```
这个例子就是用于屏蔽f12带来的困扰，在低代码开发中这类操作应该是十分必要的。

## BUG ##
如果发现bug或者其他需求可以联系作者
也十分欢迎pr
[前往github](https://github.com/Bayn-Web/bcomponent)