## 效果图

<ClientOnly><sideMenu></sideMenu></ClientOnly>

## 代码

<<< @/docs/.vuepress/components/sideMenu.vue

## 未完待续

后期再做组件化相关工作

## 记 23-6-12 的 bug

~~本地代码无误，打包后在页面刷新时报节点无法增加子节点错误，排除后是 querySelectorAll 找错了节点，在 vuepress 打包后页面渲染时也有相同的节点。~~
错误在于 ssr 服务端渲染特性，client 端与 server 端渲染的 html 不一致，导致在`hydrate`时出错。
目前的解决办法是增加ClientOnly标签。  

## BUG

如果发现 bug 或者其他需求可以联系作者
也十分欢迎 pr
[前往 github](https://github.com/Bayn-Web/bcomponent)
