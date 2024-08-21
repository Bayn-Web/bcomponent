## 效果图

<ClientOnly><doFirstTimeUseHoudini></doFirstTimeUseHoudini></ClientOnly>

## 代码

<<< @/docs/.vuepress/components/doFirstTimeUseHoudini.vue

## 介绍

**Houdini CSS**（[参考文档](https://developer.mozilla.org/zh-CN/docs/Web/API/Houdini_APIs)）是一组底层 API，旨在扩展 CSS 的功能，使其能够处理那些不符合默认 CSS 逻辑的场景。

其主要特点包括：

1. **更好的动画效果**：
   - 实现 CSS 动画无法完成的效果。
   - 减少 JavaScript 动画中所需的复杂逻辑控制，简化调优过程。

2. **更高的性能**：
   - 类似于原生 CSS，更容易利用浏览器的渲染引擎进行高效执行。

作为一个 CSSOM（CSS Object Model）的扩展，Houdini 能够在短期内提供更好的性能表现。然而，由于其强大的功能，是否在大型项目中采用 Houdini 需要仔细考虑。