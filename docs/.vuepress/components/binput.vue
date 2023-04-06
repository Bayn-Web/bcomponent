<template>
    <div class="inpbox">
        <input id="comInp" class="shake" :type="inptype" required :value="props.value" :pattern="props.inppattern" /><label>
            <slot></slot>
        </label>
    </div>
</template>

<script setup>
import {
    reactive,
    ref,
    onMounted
} from 'vue';
const props = defineProps({
    value: {
        type: String,
        default:""
    },
    inppattern: {
        type: String,
        default:null
    },
    isPassword: {
        type: Boolean,
        default:false
    },
    needAnimation: {
        type: Boolean,
        default:false
    }
})
const inptype = ref("text")
onMounted(() => {
    if (props.isPassword) {
        inptype.value = "password"
    }    
    if (props.inppattern!=null) {
        let inp = document.getElementById("comInp")
        inp.classList.remove("shake")
    }
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
    top: -33px;
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

.shake:invalid {
    color: red;
    caret-color: rgb(0, 0, 0);
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