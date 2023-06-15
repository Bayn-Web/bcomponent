<template>
    <div>
        <video :style="checked == true ? 'filter: grayscale(100%)' : ''" id="camera" ref="camera"></video>
        <input ref="checkBox" v-model="checked" type="checkbox" id="sun_switch">
        <label for="sun_switch">
            <div class="switch">
                <div class="light light3"></div>
                <div class="light light2"></div>
                <div class="light light1"></div>
                <div class="clouds-back">
                    <div class="cloud cloud7"></div>
                    <div class="cloud cloud6"></div>
                    <div class="cloud cloud5"></div>
                    <div class="cloud cloud4"></div>
                    <div class="cloud cloud3"></div>
                    <div class="cloud cloud2"></div>
                    <div class="cloud cloud1"></div>
                </div>
                <div class="clouds-front">
                    <div class="cloud cloud7"></div>
                    <div class="cloud cloud6"></div>
                    <div class="cloud cloud5"></div>
                    <div class="cloud cloud4"></div>
                    <div class="cloud cloud3"></div>
                    <div class="cloud cloud2"></div>
                    <div class="cloud cloud1"></div>
                </div>
                <div class="stars">
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                </div>
                <div class="circle">
                    <div class="moon_circle moon_circle1"></div>
                    <div class="moon_circle moon_circle2"></div>
                    <div class="moon_circle moon_circle3"></div>
                </div>
            </div>
        </label>
    </div>
</template>
<script setup>
import { watch, onMounted, ref, onBeforeUnmount } from 'vue';
const { liveTime, isDay } = defineProps({
    liveTime: {
        type: Boolean,
        default: false
    }, isDay: {
        type: Boolean,
        default: null
    }
})
const camera = ref(null)
const checked = ref(null);
const checkBox = ref(null);
let mediastream = null;
let tracks = null
onMounted(async () => {
    await startMeidaPlayer();
    if (liveTime) {
        switchStartByLiveTime();
        return;
    }
    if (isDay != null) {
        checked.value = !isDay
    }
    if (isDay == null && !liveTime) {
        checked.value = true
    }
    randomPlaceStars()
})
const randomPlaceStars = () => {
    const stars = document.querySelectorAll(".switch>.stars>div")
    console.log(stars)
    stars.forEach((e) => {
        e.classList.add("star");
        e.style.top = Math.floor(Math.random() * 80) - 40 + "px";
        e.style.left = Math.floor(Math.random() * 180) + "px";
    })
}
const switchStartByLiveTime = () => {
    let now_hour = (new Date()).getHours();
    if (now_hour > 6 && now_hour < 18) {
        //is day
        checked.value = false;
    } else {
        //is night
        checked.value = true;
    }
}
watch(checked, (newV) => {
    if (!newV) {
        camera.value.play();
    } else {
        randomPlaceStars()
        camera.value.pause();
    }
})
const startMeidaPlayer = async () => {
    mediastream = await navigator.mediaDevices.getUserMedia({ audio: true, video: true })
    tracks = mediastream.getTracks();
    camera.value.srcObject = mediastream;
}
onBeforeUnmount(() => {
    for (let track of tracks) {
        track.stop();
    }
})
</script>
<style scoped>
#camera {
    width: 300px;
    height: 300px;
    border-radius: 50%;
}

label {
    transform: scale(0.3);
    display: block;
    position: relative;
    margin-left: -240px;
    margin-top: -80px;
}

.switch {
    position: relative;
    overflow: hidden;
    width: 314px;
    height: 120px;
    border-radius: 100px;
    box-shadow: 0 2px 4px 0px inset rgba(0, 0, 0, 0.25);
    background: rgb(0, 104, 222);
    transition: all .5s ease-in-out;
}

.circle {
    position: absolute;
    left: 15px;
    top: 15px;
    width: 90px;
    height: 90px;
    border-radius: 50%;
    box-shadow: 0px 2px 4px 0 rgba(0, 0, 0, 0.25), inset 5px 5px 8px 0px rgba(255, 255, 255, 1);
    background: rgb(255, 195, 0);
    transition: transform .25s ease-in-out;
}

.ligth {
    position: absolute;
    border-radius: 50%;
    width: 216px;
    height: 216px;
    transition: transform .5s ease-in-out, all .5s ease-in-out;
}

.light1 {
    left: -49px;
    top: -48px;
    background: rgb(48, 145, 255);
}

.light2 {
    left: -6px;
    top: -50px;
    background: rgb(29, 130, 245);
}

.light3 {
    left: 38px;
    top: -44px;
    background: rgb(16, 116, 230);
}

.clouds-front {
    background: #fff;
}

.clouds-back {
    background: rgba(255, 255, 255, 0.5);
    transform: translate(-10px, -15px);
}

.cloud {
    position: absolute;
    border-radius: 50%;
    background: inherit;
}

.cloud1 {
    left: 13px;
    top: 95px;
    width: 65px;
    height: 65px;
}

.cloud2 {
    left: 71px;
    top: 95px;
    width: 51px;
    height: 51px;
}

.cloud3 {
    left: 115px;
    top: 73px;
    width: 76px;
    height: 76px;
}

.cloud4 {
    left: 174px;
    top: 90px;
    width: 76px;
    height: 76px;
}

.cloud5 {
    left: 201px;
    top: 70px;
    width: 72px;
    height: 68px;
}

.cloud6 {
    left: 252px;
    top: 36px;
    width: 136px;
    height: 136px;
}

.cloud7 {
    left: 278px;
    top: 0px;
    width: 136px;
    height: 136px;
}

.moon_circle {
    position: absolute;
    border-radius: 50%;
    background: rgb(168, 168, 168);
    box-shadow: inset 0 0 2px rgba(0, 0, 0, 0.25);
}

.moon_circle1 {
    left: 55px;
    top: 56px;
    width: 16px;
    height: 16px;
}

.moon_circle2 {
    left: 15px;
    top: 39px;
    width: 25px;
    height: 25px;
}

.moon_circle3 {
    left: 51px;
    top: 21px;
    width: 12px;
    height: 12px;
}

#sun_switch:not(:checked)~* .moon_circle1,
#sun_switch:not(:checked)~* .moon_circle2,
#sun_switch:not(:checked)~* .moon_circle3 {
    display: none;
}

#sun_switch {
    opacity: 0;
    width: 0px;
    height: 0px;
}

#sun_switch:checked~* .circle {
    background: #ccc;
    transform: translate(195px, 0);
}

#sun_switch:checked~* .switch {
    background: #000;
}

#sun_switch:checked~* .light1 {
    background: #555;
    transform: translate(195px, 0);
}

#sun_switch:checked~* .light2 {
    background: #333;
    transform: translate(115px, 0);
}

#sun_switch:checked~* .light3 {
    background: #222;
    transform: translate(30px, 0);
}

.star {
    position: relative;
    height: 20px;
    width: 20px;
    background: #fff;
    clip-path: path('M 5 0 C 5 5 4 10 0 10 C 4 10 5 15 5 20 C 5 15 6 10 10 10 C 6 10 5 5 5 0');
}

#sun_switch:not(:checked)~* .star {
    animation: rise forwards ease-out .5s;
}

@keyframes rise {
    to {
        transform: translateY(-100%);
        opacity: 0%;
    }
}
</style>