<template>
    <label>{{ count }}
        <button @click="convertedFunc">click and i will do the last time</button>
    </label>
</template>

<script setup>
import {
    reactive,
    ref
} from 'vue';
const count = ref(0);
const doLastTimeFunc = (func, time = 2000) => {
    let n = null
    return () => {
        clearTimeout(n)
        n = setTimeout(() => {
            func();
        }, time)
    }
}
const doClick = () => {
    count.value++;
}
const convertedFunc = doLastTimeFunc(doClick)
</script>

<style scoped></style>