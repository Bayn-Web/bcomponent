<template>
    <div class="inpbox">
        <input class="focus" ref="inp" @input="onInput($event)" :type="inptype" required :value="props.inpvalue"
            :pattern="props.inppattern" /><label>
            <slot></slot>
        </label>
    </div>
</template>

<script setup>
import {
    ref,
    onMounted,
} from 'vue';
let f = defineEmits(["update:inpvalue"])
const inp = ref(null)
const onInput = function (e) {
    f("update:inpvalue", e.target.value);
}
const props = defineProps({
    inpvalue: {
        type: String,
        default: ""
    },
    inppattern: {
        type: String,
        default: null
    },
    isPassword: {
        type: Boolean,
        default: false
    }
})
const inptype = ref("text")
onMounted(() => {
    if (props.isPassword) {
        inptype.value = "password"
    }
    inp.value.classList.remove("focus")
    inp.value.addEventListener("input", () => {
        if (inp.value.value != "") {
            inp.value.classList.add("focus")
        } else {
            inp.value.classList.remove("focus")
        }
    })
})
</script>

<style scoped>
.inpbox {
    height: fit-content;
}

input {
    outline: none;
    border: none;
    width: 100%;
    margin-bottom: 10px;
    color: #a29bf6;
    font-size: 16px;
    border-bottom: 1px solid #a29bf6;
    background-color: transparent;
}

label {
    position: relative;
    left: 0;
    top: -36px;
    color: #3d3d3d;
    font-weight: bolder;
    pointer-events: none;
    transition: all 0.5s;
}

input:focus+label,
input:valid+label {
    top: -53px;
    color: #a29bf6;
    font-size: 12px;
}

.focus:invalid~label {
    top: -53px;
    color: #a29bf6;
    font-size: 12px;
}

.focus:invalid {
    color: #ff0059;
    animation: 0.3s ease-in shake;
}

@keyframes shake {
    0% {
        margin-left: 10px;
        margin-right: 0px;
    }

    25% {
        margin-left: 0px;
        margin-right: 10px;
    }

    75% {
        margin-left: 10px;
        margin-right: 0px;
    }

    100% {
        margin-left: 0px;
        margin-right: 10px;
    }
}
</style>