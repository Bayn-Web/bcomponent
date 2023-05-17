import { defineConfig } from "vuepress/config";
import path from "path"

export default defineConfig({
  head: [
  ],
  configureWebpack: {
    resolve: {
      alias: {
        '@': "./public"
      },
    }
  },
  themeConfig: {
    // sidebarDepth: 1,    // 可选的, 默认值是 1
    sidebar: [
      {
        title: 'Part1. realComponent',   // 必要的
        path: '/b_Components/',      // 可选的, 标题的跳转链接，应为绝对路径且必须存在
        collapsable: true, // 是否可以折叠。默认为true。
        children: [
          ['/b_Components/b_input', "登录输入框"],
          ['/b_Components/doLastORFirstAction', "触发第一次&&最后一次"],
          ['/b_Components/sideMenu', "侧边菜单"],
          ['/b_Components/contextMenu', "自定义右键菜单"],
        ]
      },
      {
        title: 'Part2. anmazing layout',   // 必要的
        path: '/b_layout/',      // 可选的, 标题的跳转链接，应为绝对路径且必须存在
        children: [
          ['/b_layout/parallax', "parallax库应用"],
          ['/b_layout/scroll', "滑动至底部"],
        ]
      },
    ]
  },
  plugins: [
    [
      '@vuepress/plugin-register-components',
      {
        componentsDir: path.resolve(__dirname, './components')
      }
    ]
  ]
})