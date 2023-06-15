## 效果图

<ClientOnly><parallax></parallax></ClientOnly>

## 代码

<<< @/docs/.vuepress/components/parallax.vue

## 步骤

`第一步` npm i parallax-js

`第二步`

```js
var scene = document.getElementById("scene");
var parallaxInstance = new Parallax(scene, {
  relativeInput: true,
});
```

为了获取到这个标签，注意要当 dom 加载完成后再调用！

## 配置属性

配置属性表示实例化 Parallax 这个实例的第二个参数中的属性：

| 属性名              |                                                                                               描述                                                                                               |         类型          | 默认  |
| ------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :-------------------: | :---: |
| selector            |                                                                 选择器，指定动画产生在什么子元素上,如果 null 则直接指定所有元素                                                                  |      string/null      | null  |
| hoverOnly           |                                                                                      仅在绑定元素上产生效果                                                                                      |        boolean        | false |
| frictionX/frictionY |                                                                                    移动摩擦力，类似于动画速度                                                                                    | float between 0 and 1 |  0.1  |
| invertX/invertY     |                                                                                 移动和鼠标位置或陀螺仪移动的方向                                                                                 |        boolean        | true  |
| scalarX/scalarY     |                                                                                  移动速度，这个值会和移动量相乘                                                                                  |         float         | 10.0  |
| limitX/limitY       |                                                       移动量，这个值会为 false 意味着移动不会受限制，如果有数值则到达这个数值后不会再移动                                                        |   false or integer    | false |
| originX/originY     | 鼠标默认位置，这个值意味着当值为图片不会继续往一侧继续移动，例如 originX 为 1 则图层在默认配置下不会再往左移动（实测后感觉有些类似 clipRelativeInput，作用和描述不一样，开启后往往限制移动幅度） |   false or integer    | false |
| onReady             |                                                                                 Parallax 对象实例化完成时的回调                                                                                  |   null or Function    | null  |

除了配置外很多配置还提供了方法，可以在必要时使用例如 invert，这些则最好前往[官网](https://github.com/wagerfield/parallax)查询。以及其他的方法类似开启关闭销毁以及版本则不一一写出。

## BUG

如果发现 bug 或者其他需求可以联系作者
也十分欢迎 pr
[前往 github](https://github.com/Bayn-Web/bcomponent)
