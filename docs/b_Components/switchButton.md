## 效果图

<ClientOnly><switchBut></switchBut></ClientOnly>

## 代码

<<< @/docs/.vuepress/components/switchBut.vue

## 简述

简单编写了获取用户摄像头和音频，以及一个相当不错的主题切换按钮！

## 属性

| props    |                               描述                               |  类型   | 默认  |
| -------- | :--------------------------------------------------------------: | :-----: | :---: |
| isDay    |                       设置初始切换按钮状态                       | Boolean | null  |
| liveTime | 是否以当前时间作为初始按钮状态，同时与 isDay 存在时以 isDay 优先 | Boolean | false |

## 未来计划

- 根据当前时间默认 switch 值。 √
- 更改部分元素为范围内随机位置。 √
- 接入公共气象 api 对样式添加雨天阴天效果。

## BUG

如果发现 bug 或者其他需求可以联系作者
也十分欢迎 pr
[前往 github](https://github.com/Bayn-Web/bcomponent)
