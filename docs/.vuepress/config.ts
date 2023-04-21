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
    sidebar: [
      {
        title: 'Part1. realComponent',   // 必要的
        path: '/b_Components/',      // 可选的, 标题的跳转链接，应为绝对路径且必须存在
        collapsable: false, // 可选的, 默认值是 true,
        sidebarDepth: 1,    // 可选的, 默认值是 1
        children: [
          ['/b_Components/b_input', "登录输入框"],
          ['/b_Components/doLastORFirstAction', "触发第一次&&最后一次"],
        ]
      },
      {
        title: 'Part2. anmazing layout',   // 必要的
        path: '/b_layout/',      // 可选的, 标题的跳转链接，应为绝对路径且必须存在
        children: [
          '/b_layout/parallax',
          '/b_layout/chapter2',
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