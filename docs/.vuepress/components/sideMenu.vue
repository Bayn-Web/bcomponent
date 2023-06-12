<template>
    <div class="container">
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
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
const li = ref(null)
// onMounted(() => {
//     let delayTime = 3;
//     let spans = document.querySelectorAll("li>span");
//     spans.forEach((e) => {
//         e.style.animationDelay = `.${delayTime++}s`
//     })
// })
// const addClass = (e) => {
//     li.value && li.value.classList.remove("active")
//     e.currentTarget.classList.add("active")
//     li.value = e.currentTarget
// }
</script>

<style scoped>
.container * {
    margin: 0;
    padding: 0;
    border: 0;
    box-sizing: border-box;
}

.container {
    width: 100%;
    height: 40vh;
    position: fixed;
    top: 60px;
    right: 10px;
    display: flex;
    align-items: start;
    justify-content: end;
    z-index: 99;
}

.container nav {
    overflow-x: hidden;
    width: 80px;
    height: min-content;
    padding: 16px;
    padding-bottom: 8px;
    border-radius: 12px;
    backdrop-filter: blur(18px);
    background: rgba(230, 235, 240, .7);
    border: 2px solid rgba(230, 235, 240, .7);
    box-shadow: 0 0 30px rgba(0, 0, 0, .05);
    transition: .6s cubic-bezier(.8, .5, .5, .8);
}

.container nav:hover {
    width: 200px;
}

.brand {
    width: 100%;
    display: flex;
    align-items: center;
}

.brand img {
    width: 65px;
    border-radius: 50%;
    border: 4px solid rgba(230, 235, 240, .8);
}

.brand p {
    color: #505257;
    font-weight: 500;
    font-style: italic;
    text-align: left;
    line-height: 22px;
    margin-left: 4px
}

.brand p span {
    color: #3c3e43;
    display: block;
    font-size: 26px;
    font-style: normal;
}

nav .line {
    width: 100%;
    height: 2px;
    margin: 10px 0;
    border-radius: 30%;
    background: #87a3af;
}

nav .list {
    width: 100%;
}

nav .list li {
    display: flex;
    margin: 10px 0;
    padding: 5px 9px;
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

@keyframes fadeIn {
    to {
        opacity: 1;
        pointer-events: unset;
        transform: translateX(0);
    }
}

nav:hover .brand p {
    animation: fadeIn .4s ease-out forwards;
    animation-delay: .4s;
}

nav:hover .list span {
    animation: fadeIn .3s ease-out forwards;
}
</style>