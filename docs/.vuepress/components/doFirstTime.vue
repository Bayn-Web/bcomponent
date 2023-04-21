<template>
    <label>{{ count }}
        <button @click="convertedFunc">click and i will do the first time</button>
    </label>
</template>

<script setup>
import {
    reactive,
    ref
} from 'vue';
const count = ref(0);
const doFirstTimeFunc = (func, time = 2000) => {
    let t = true;
    let n = null;
    return () => {
        clearTimeout(n)
        if (t == true) {
            func();
            t = false
        }
        n = setTimeout(() => {
            t = true;
        }, time)
    }
}
const doClick = () => {
    count.value++;
}
const convertedFunc = doFirstTimeFunc(doClick)
</script>

<style scoped></style>