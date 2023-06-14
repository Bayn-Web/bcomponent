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

<<< @/docs/.vuepress/components/binput.vue

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
