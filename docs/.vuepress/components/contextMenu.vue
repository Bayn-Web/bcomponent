<template>
    <div ref="area">
        <span ref="line1" @click="undo" id="line1" class="warning-line">WARN &nbsp; WARN &nbsp; WARN &nbsp; WARN &nbsp; WARN
            &nbsp; WARN
            &nbsp;
        </span>
        <span ref="line2" @click="undo" id="line2" class="warning-line">WARN &nbsp; WARN &nbsp; WARN &nbsp; WARN &nbsp; WARN
            &nbsp; WARN
            &nbsp;
        </span>
    </div>
</template>

<script setup>
import { onMounted, ref, onBeforeUnmount } from "vue"
const area = ref(null)
const line1 = ref(null)
const line2 = ref(null)
const lines = [line1, line2]
const stopDefaultBehavior = (e) => { e.preventDefault(); }
onMounted(() => {
    area.value.addEventListener("contextmenu", stopDefaultBehavior)
})
onBeforeUnmount(() => {
    area.value.removeEventListener("contextmenu", stopDefaultBehavior)
})
const undo = () => {
    area.value.removeEventListener("contextmenu", stopDefaultBehavior)
    lines.forEach((v) => {
        v.value.innerText = "accessible".toUpperCase()
        v.value.style.background = "#7CFC00";
        v.value.style.color = "#fff";
        v.value.classList.add("anim")
    })
}
</script>

<style scoped>
div {
    box-sizing: border-box;
    height: 600px;
    width: 600px;
    position: relative;
    background: url(https://dummyimage.com/600x600/#40b78/fff);
    overflow: hidden;
}

#line1 {
    transform: rotate(30deg);
    margin-left: -50px;
}

#line2 {
    transform: rotate(-23deg);
    padding-left: -20px;
}

.anim {
    animation: dropdown 3s ease-in forwards;
}

.warning-line {
    position: relative;
    border: 2px dashed black;
    border-color: black;
    color: red;
    display: block;
    width: 150%;
    text-align: center;
    font-size: 2em;
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    font-weight: bold;
    background-color: yellow;
    box-shadow: 3px 3px 3px grey;
    top: 200px;
    left: -100px;
    border-radius: 5px;
    cursor: pointer;
}

@keyframes dropdown {
    to {
        top: 700px;
        transform: rotate(0deg);
    }
}
</style>