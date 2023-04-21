## 效果图 ##

<parallax></parallax>

## 代码 ##
```html
<template>
    <div class="container">
        <ul data-relative-input="true" id="scene">
            <li class="layer" data-depth="0.9">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="-260.5 -143 1920 1080">
                    <path fill="#010F1C" d="M-4283.3-877.2h9976v2610h-9976z" />
                </svg>
            </li>
            <li class="layer" data-depth="0.2">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="-260.5 -143 1920 1080">
                    <path fill="#054B8C"
                        d="M-4283.3-877.2v2610h9976v-2610h-9976zM839.6 371c19.4 13.4 44.6 16.4 64.3 30.4 13.2 9.4 41.7 42.6 22.9 59.2 4.9-4.3 2.5-2.2 0 0l-.3.3c.1-.1.2-.2.3-.2-2.7 2.4-5.5 4.8-.3.2-18.9 16.1-39.5-6.5-54.1-16.9-23.1-16.5-48-26.3-75.2-33.6C740 395 680.7 397 622.1 396.2c-50.6-.7-112.8 9.6-152.1-30-10.9-11-25-30.5-12.6-45.5 19.8-24.3 47.3-4.6 68.5 3.8 20.9 8.3 39.7 5.4 63.4 7.2 9 .6 58.1-12.5 82.7-25 17.3-8.8 36.8-20.6 52.7-3.4 19.5 21 44.9 15.1 70.1 10.4 13.4-2.5 43-9.9 53.8 2.2 19.3 21.6-30.1 40.4-9 55.1zm-64.7 270.1c-7.3 19-69.3-26.7-78.6-31.7-20.4-10.9-42.1-18.6-63.9-26-5.3-1.8-64.9-20.4-47.5-32.9 31.6-22.6 97.2 8.7 127.3 21.3 23.8 10 77.7 30.4 62.7 69.3zm.6-1.5l-.1.2.1-.2zm-.2.5l-.3.7.3-.7zm325.3-485.7c-6.8 33.6-75.3 5.6-97.8 5.6-25 0-53.1 12-77.1-.3-16.5-8.4-27.7-48.4-.2-44.1 19 3 38.7 14.4 58.4 7.9 20.6-6.8 22.8-32.8 46.9-30.6 25.9 2.4 76.7 27.7 69.8 61.5z" />
                </svg>
            </li>
        </ul>
    </div>
</template>
```
```typescript
import Parallax from "parallax-js"
import { onMounted } from "vue";
onMounted(() => {
    var scene = document.getElementById('scene');
    //@ts-ignore
    var parallaxInstance = new Parallax(scene, {
        relativeInput: true
    });

})
```
```css
body {
    margin: 0;
    padding: 0;
}

.container {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100vh;
    overflow: hidden;
    background: url(https://dummyimage.com/600x600/#40b78/fff);
    background-attachment: fixed;
}

.layer {
    width: 200px;
    height: 200px;
}

.layer svg {
    width: 100%;
    height: 100%;
    filter: drop-shadow(5px 5px 5px rgba(0, 0, 0, 0.3));
}
```
## 步骤 ##

```第一步``` npm i parallax-js

```第二步``` 

```js
var scene = document.getElementById('scene');
var parallaxInstance = new Parallax(scene, {
    relativeInput: true
});
```
为了获取到这个标签，注意要当dom加载完成后再调用！

## 配置属性 ##

配置属性表示实例化Parallax这个实例的第二个参数中的属性：

|    slot  |  描述 |类型    |默认|
|  -------  | :---------: | :---: |:---: |
|   default   |提示内容   |String |""|


## BUG ##
如果发现bug或者其他需求可以联系作者
也十分欢迎pr
[前往github](https://github.com/Bayn-Web/bcomponent)