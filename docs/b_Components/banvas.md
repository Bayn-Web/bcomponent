## 效果图

<ClientOnly><banvas></banvas></ClientOnly>

## 代码

<<< @/docs/.vuepress/components/banvas.vue

## 说明

1.  注意 canvas 保留一个默认的高宽为 **heigth:150** **width:300**,这个比例指的是 canvas 画布大小，而不是实际大小，这个属性可以直接在标签上修改,例如:

```html
<canvas height="300" width="300"></canvas>
```

此时这个默认高宽的画布被设置成了 300 的正方形画布,这 300 个单位只在 js 调用 canvas 函数时产生效果。 2. **切记** 当使用一个事件绑定时，最好将绑定事件单独写到外部，否则在给这个事件解绑时匿名函数是无法做到的。 3. 当事件解绑，或对应数据较多时，硬编码的方式可以替换成**makeCanvasCannotDraw**方法里的写法，让数组对应完成大量操作，比人为填写要更方便优雅。

## BUG

如果发现 bug 或者其他需求可以联系作者
也十分欢迎 pr
[前往 github](https://github.com/Bayn-Web/bcomponent)
