## 效果图

1. 默认插入
   <binput :needAnimation="false">默认插槽内容</binput>
2. 默认内容
   <binput :inpvalue="'默认内容'">默认插槽内容</binput>
3. 密码输入
   <binput :isPassword="true">默认插槽内容</binput>
4. 输入校验(校验 0 到三位数字)
   <binput :inppattern="'[0-9]{0,3}'">默认插槽内容</binput>

## 代码

```html
<template>
  <div class="inpbox">
    <input
      class="focus"
      ref="inp"
      @input="onInput"
      :type="inptype"
      required
      :value="props.inpvalue"
      :pattern="props.inppattern"
    /><label>
      <slot></slot>
    </label>
  </div>
</template>
```

```typescript
import { reactive, ref, onMounted } from "vue";
let f = defineEmits(["update:inpvalue"]);
const inp = ref(null);
const onInput = function (e) {
  f("update:inpvalue", e.target.value);
};
const props = defineProps({
  inpvalue: {
    type: String,
    default: "",
  },
  inppattern: {
    type: String,
    default: null,
  },
  isPassword: {
    type: Boolean,
    default: false,
  },
});
const inptype = ref("text");
onMounted(() => {
  if (props.isPassword) {
    inptype.value = "password";
  }
  inp.value.classList.remove("focus");
  inp.value.addEventListener("input", () => {
    if (inp.value.value != "") {
      inp.value.classList.add("focus");
      console.log(1);
    } else {
      inp.value.classList.remove("focus");
      console.log(1);
    }
  });
});
```

```css
.inpbox {
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
  top: -36px;
  color: #3d3d3d;
  font-weight: bolder;
  pointer-events: none;
  transition: all 0.5s;
}

input:focus + label,
input:valid + label {
  top: -53px;
  color: #a29bf6;
  font-size: 12px;
}

.focus:invalid ~ label {
  top: -53px;
  color: #a29bf6;
  font-size: 12px;
}

.focus:invalid {
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

## 属性以及插槽

| props      |                                         描述                                         |    类型     | 默认  |
| ---------- | :----------------------------------------------------------------------------------: | :---------: | :---: |
| inpvalue   |                             给 input 的值，注意双向绑定                              |   String    |  ""   |
| inppattern | 如果有内容格式限制（input:invalid 不能限制输入,仅是抖动提示）,可以传递一个正则字符串 | String/null | null  |
| isPassword |                            如果是密码（输入内容星号代替）                            |   Boolean   | false |

| slot    |   描述   |  类型  | 默认 |
| ------- | :------: | :----: | :--: |
| default | 提示内容 | String |  ""  |

## BUG

如果发现 bug 或者其他需求可以联系作者
也十分欢迎 pr
[前往 github](https://github.com/Bayn-Web/bcomponent)
