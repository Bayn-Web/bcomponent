import { defineConfig } from "vuepress/config";
import path from "path"

export default defineConfig({
  head: [
  ],
  themeConfig: {
    sidebar: [
      {
        title: 'input',   // 必要的
        path: '/b_input/',      // 可选的, 标题的跳转链接，应为绝对路径且必须存在
        collapsable: false, // 可选的, 默认值是 true,
        sidebarDepth: 1,    // 可选的, 默认值是 1
        children: [
          ['/b_input/chapter1', "登录输入框"],
          ['/b_input/chapter2', "输入框"],
        ]
      },
      {
        title: 'part2',   // 必要的
        children: [
          '/part2/',
          '/part2/chapter1',
          '/part2/chapter2',
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