<template>
    <nav>
        <div class="brand">
            <img src="../public/profile.jpg">
            <p>
                Good day,
                <span>Hossein</span>
            </p>
        </div>
        <hr class="line">
        <ul class="list">
            <li @click="addClass($event)" ref="li" class="active">
                <i>🏠</i>
                <span>Dashboard</span>
            </li>
            <li @click="addClass($event)">
                <i>💰</i>
                <span>Accounts</span>
            </li>
            <li @click="addClass($event)">
                <i>🛒</i>
                <span>Orders</span>
            </li>
            <li @click="addClass($event)">
                <i>📊</i>
                <span>Charts</span>
            </li>
            <li @click="addClass($event)">
                <i>🎉</i>
                <span>Support</span>
            </li>
            <hr class="line">
            <li @click="addClass($event)">
                <i>🎈</i>
                <span>Logout</span>
            </li>
        </ul>
    </nav>
</template>

<script setup>
import { ref, onMounted } from 'vue';
const li = ref(null)
onMounted(() => {
    let delayTime = 3;
    let spans = document.querySelectorAll(".container>nav>.list>li>span");
    spans.forEach((e) => {
        e.style.animationDelay = `.${delayTime++}s`
    })
})
const addClass = (e) => {
    li.value && li.value.classList.remove("active")
    e.currentTarget.classList.add("active")
    li.value = e.currentTarget
}
</script>

<style scoped>
nav {
    width: 40px;
    height: fit-content;
    position: fixed;
    top: 60px;
    right: 0;
    display: flex;
    align-items: start;
    justify-content: end;
    flex-direction: column;
    z-index: 2;
    overflow-x: hidden;
    padding: 5px 16px;
    border-radius: 12px;
    backdrop-filter: blur(18px);
    background: rgba(230, 235, 240, .7);
    border: 2px solid rgba(230, 235, 240, .7);
    box-shadow: 0 0 30px rgba(0, 0, 0, .05);
    transition: .6s cubic-bezier(.8, .5, .5, .8);
}

nav:hover {
    width: 200px;
}

nav:hover ul li {
    width: 90%;
}

.brand {
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: start;
}

.brand img {
    width: 65px;
    border-radius: 50%;
    border: 4px solid rgba(230, 235, 240, .8);
}

.brand p {
    color: #505257;
    font-size: 10px;
    font-weight: 500;
    font-style: italic;
    text-align: left;
    line-height: 22px;
    margin-left: 4px;
    box-sizing: inherit;
    opacity: 0;
}

.brand p span {
    color: #3c3e43;
    display: block;
    font-size: 20px;
    font-style: normal;
}

nav .line {
    width: 100%;
    height: 2px;
    margin: 5px 0;
    border-radius: 30%;
    background: #87a3af;
}

nav .list {
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: start;
    margin-left: -20px;
}

nav .list li {
    display: flex;
    width: 60%;
    margin: 5px 0;
    padding: 5px 12px;
    cursor: pointer;
    border-radius: 8px;
    transition: .4s ease-in-out;
}

nav .list li:hover {
    background: rgba(230, 235, 240, .4);
}

nav .list li.active {
    background: #3681f6;
}

nav .list li.active span {
    color: #fff;
}

nav .list li.active i {
    background: none;
    -webkit-text-fill-color: unset;
    color: #e6ebf0;
}

nav .list i {
    font-size: 20px;
    background: linear-gradient(-135deg,
            #3c3e43,
            #838487);
    font-style: normal;
    background-clip: text;
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
}

nav .list span {
    color: #505257;
    font-size: 18px;
    font-weight: 500;
    margin: 0 0 0 12px;
}

nav .brand p,
nav .list span {
    opacity: 0;
    pointer-events: none;
    transform: translateX(20px);
}

nav:hover .brand p {
    animation: fadeIn .4s ease-out forwards;
    animation-delay: .4s;
}

nav:hover .list span {
    animation: fadeIn .3s ease-out forwards;
}

@keyframes fadeIn {
    to {
        opacity: 1;
        pointer-events: unset;
        transform: translateX(0);
    }
}
</style>