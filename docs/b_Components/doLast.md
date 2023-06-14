## 效果图

<ClientOnly><doLastTimeButton></doLastTimeButton></ClientOnly>

## 代码

<<< @/docs/.vuepress/components/doLastTimeButton.vue

## 学习点

当学习了闭包后，我们可以封装一个独立的变量到函数中重复使用，例如在`函数中return函数`并使用外部函数的内部变量，此时返回出的函数同一个函数实例会拥有一个独立的外部变量，可以理解为形参，当触发这个返回方法实例总是会修改同一个函数变量，类似于这个变量永远为一个函数实例服务，也叫`内存泄漏`。

- 一个小知识：如果使用`setTimeout或Interval`在设置的时间间隔过小时会产生 js 来不及找到 dom 的 bug，这个 bug 大致原因是操作 dom 时下一个操作又要进入，因此最好使用`requestAnimationFrame`这个新的 api，这个 api 会自动寻找下一次渲染时机，因此所有由数值控制的移动，例如鼠标动画，或循环动画应该都由这个 api 接管，这样可以保证动画的流畅。注意这个 api 大致每秒执行 60 次，因此不必担心流畅程度，只需要控制好数值来让动画尽量以合适速度进行。

## BUG

如果发现 bug 或者其他需求可以联系作者
也十分欢迎 pr
[前往 github](https://github.com/Bayn-Web/bcomponent)
