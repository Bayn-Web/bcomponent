import { defineClientAppEnhance } from '@vuepress/client'
export default defineClientAppEnhance(({ app }) => {
    document.getElementById("page-nav")?.remove();
})