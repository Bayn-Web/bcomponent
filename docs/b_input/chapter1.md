## 效果图 ##
1. 默认插入

  <binput :needAnimation="false">默认插槽内容</binput>
2. 默认插入
  
  <binput :value="'绑定value'">默认插槽内容</binput>
3. 密码
  
  <binput :isPassword="true">默认插槽内容</binput>
4. 输入校验(校验0到三位数字)
  
  <binput :inppattern="'[0-9]{0,3}'">默认插槽内容</binput>
## 代码 ##
```html
<template>
    <div class="inpbox">
        <input id="comInp" :type="inptype" required :value="props.value" :pattern="props.inppattern" /><label>
            <slot></slot>
        </label>
    </div>
</template>
```
```typescript
import {
    reactive,
    ref,
    onMounted
} from 'vue';
const props = defineProps({
    value: {
        type: String
    },
    inppattern: {
        type: String
    },
    isPassword: {
        type: Boolean
    }
})
const inptype = ref("text")
onMounted(() => {
    if (props.isPassword) {
        inptype.value = "password"
    }
})
```
```css
.inpbox{
    height: fit-content;
}
input {
    outline: none;
    border: none;
    width: 100%;
    margin-bottom: 10px;
    color: #a29bf6;
    font-size: 16px;
    border-bottom: 1px solid #a29bf6;
    background-color: transparent;
}

label {
    position: relative;
    left: 0;
    top: -33px;
    color: #3d3d3d;
    font-weight: bolder;
    pointer-events: none;
    transition: all 0.5s;
}

input:focus+label,
input:valid+label {
    top: -53px;
    color: #a29bf6;
    font-size: 12px;
}

#comInp:invalid {
    top: -53px;
    color: #ff0059;
    animation: 0.3s ease-in shake;
}

@keyframes shake {
    0% {
        margin-left: 10px;
        margin-right: 0px;
    }

    25% {
        margin-left: 0px;
        margin-right: 10px;
    }

    75% {
        margin-left: 10px;
        margin-right: 0px;
    }

    100% {
        margin-left: 0px;
        margin-right: 10px;
    }
}
```
## 属性以及插槽 ##

|    props  |  描述 |类型    |默认|
|  -------  | :---------: | :---: |:---: |
|   value   |给input的值，注意双向绑定   |String|""    |
|inppattern |如果有内容格式限制（input:invalid 不能限制输入,仅是抖动提示）,可以传递一个正则字符串|String/null|null|
|isPassword |如果是密码（输入内容星号代替）| Boolean|false|

|    slot  |  描述 |类型    |默认|
|  -------  | :---------: | :---: |:---: |
|   default   |提示内容   |String |""|


## BUG ##
-- 这个bug只针对开启验证的输入框 --
-----
若当前设置了inppattern意味着会开启抖动动画，当内容为空时会触发，这是由于聚焦后label上移采用required，所以没有聚焦且内容为空则不会触发valid和focus，因此当最后一个内容被删除相当于required校验出错，触发invalid继而会产生抖动动画，此bug可以使用js调整，但由于考虑验证本身就常常有非空的限制因此在有更好的替代方式（不使用js强行调整）前不会更改此bug。  

-----
如果发现bug或者其他需求可以联系作者
也十分欢迎pr
[前往github](https://github.com/Bayn-Web/bcomponent)