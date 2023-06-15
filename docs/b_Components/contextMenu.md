## 效果图

<ClientOnly><contextMenu></contextMenu></ClientOnly>

## 代码

<<< @/docs/.vuepress/components/contextMenu.vue

## 说明

通过绑定就可以阻止用户点击右键，类似的方式可以让用户更专注于页面，减少错误操作带来的影响。

```js
window.addEventListener("keydown", (e) => {
  if (e.code == "F12") {
    e.preventDefault();
  }
});
```

这个例子就是用于屏蔽 f12 带来的困扰，在低代码开发中这类操作应该是十分必要的。

## BUG

如果发现 bug 或者其他需求可以联系作者
也十分欢迎 pr
[前往 github](https://github.com/Bayn-Web/bcomponent)
