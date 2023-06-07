## 效果图

<switchBut></switchBut>

## 代码

```html
<template>
  <div>
    <video
      :style="checked == true ? 'filter: grayscale(100%)' : ''"
      id="camera"
      ref="camera"
    ></video>
    <input type="checkbox" @click="closeMediaPlayer($event)" id="sun_switch" />
    <label for="sun_switch">
      <div class="switch">
        <div class="light3"></div>
        <div class="light2"></div>
        <div class="light1"></div>
        <div class="clouds-back">
          <div class="cloud7"></div>
          <div class="cloud6"></div>
          <div class="cloud5"></div>
          <div class="cloud4"></div>
          <div class="cloud3"></div>
          <div class="cloud2"></div>
          <div class="cloud1"></div>
        </div>
        <div class="clouds-front">
          <div class="cloud7"></div>
          <div class="cloud6"></div>
          <div class="cloud5"></div>
          <div class="cloud4"></div>
          <div class="cloud3"></div>
          <div class="cloud2"></div>
          <div class="cloud1"></div>
        </div>
        <div class="stars">
          <div class="star star1"></div>
          <div class="star star2"></div>
          <div class="star star3"></div>
          <div class="star star4"></div>
          <div class="star star5"></div>
        </div>
        <div class="circle">
          <div class="moon_circle1"></div>
          <div class="moon_circle2"></div>
          <div class="moon_circle3"></div>
        </div>
      </div>
    </label>
  </div>
</template>
```

```js
import { onMounted, ref, onUnmounted, onBeforeUnmount } from "vue";
const camera = ref(null);
const checked = ref(false);
let mediastream = null;
let tracks = null;
onMounted(async () => {
  mediastream = await navigator.mediaDevices.getUserMedia({
    audio: true,
    video: true,
  });
  tracks = mediastream.getTracks();
  console.log(camera.value);
  let audioTrack = mediastream.getAudioTracks()[0];
  console.log("user audio configeration:");
  console.log(audioTrack);
  let videoElement = camera.value;
  videoElement.srcObject = mediastream;
  videoElement.play();
});
const closeMediaPlayer = (event) => {
  checked.value = !checked.value;
  if (event.currentTarget.checked) {
    camera.value.pause();
  } else {
    camera.value.play();
  }
};
onBeforeUnmount(() => {
  for (let track of tracks) {
    track.stop();
  }
});
```

```css
#camera {
  width: 300px;
  height: 300px;
  border-radius: 50%;
}

label {
  //更改按钮大小
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
  transition: all 0.5s ease-in-out;
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
  transition: transform 0.25s ease-in-out;
}

.light1 {
  position: absolute;
  left: -49px;
  top: -48px;
  width: 216px;
  height: 216px;
  background: rgb(48, 145, 255);
  border-radius: 50%;
  transition: transform 0.5s ease-in-out, all 0.5s ease-in-out;
}

.light2 {
  position: absolute;
  left: -6px;
  top: -50px;
  width: 216px;
  height: 216px;
  background: rgb(29, 130, 245);
  border-radius: 50%;
  transition: transform 0.5s ease-in-out, all 0.5s ease-in-out;
}

.light3 {
  position: absolute;
  left: 38px;
  top: -44px;
  width: 216px;
  height: 216px;
  background: rgb(16, 116, 230);
  border-radius: 50%;
  transition: transform 0.5s ease-in-out, background 0.5s ease-in-out;
}

.clouds-front {
  background: #fff;
}

.clouds-back {
  background: rgba(255, 255, 255, 0.5);
  transform: translate(-10px, -15px);
}

.cloud1 {
  position: absolute;
  left: 13px;
  top: 95px;
  width: 65px;
  height: 65px;
  border-radius: 50%;
  background: inherit;
}

.cloud2 {
  position: absolute;
  left: 71px;
  top: 95px;
  width: 51px;
  height: 51px;
  border-radius: 50%;
  background: inherit;
}

.cloud3 {
  position: absolute;
  left: 115px;
  top: 73px;
  width: 76px;
  height: 76px;
  border-radius: 50%;
  background: inherit;
}

.cloud4 {
  position: absolute;
  left: 174px;
  top: 90px;
  width: 76px;
  height: 76px;
  border-radius: 50%;
  background: inherit;
}

.cloud5 {
  position: absolute;
  left: 201px;
  top: 70px;
  width: 72px;
  height: 68px;
  border-radius: 50%;
  background: inherit;
}

.cloud6 {
  position: absolute;
  left: 252px;
  top: 36px;
  width: 136px;
  height: 136px;
  border-radius: 50%;
  background: inherit;
}

.cloud7 {
  position: absolute;
  left: 278px;
  top: 0px;
  width: 136px;
  height: 136px;
  border-radius: 50%;
  background: inherit;
}

.moon_circle1 {
  position: absolute;
  left: 55px;
  top: 56px;
  width: 16px;
  height: 16px;
  border-radius: 50%;
  background: rgb(168, 168, 168);
  box-shadow: inset 0 0 2px rgba(0, 0, 0, 0.25);
}

.moon_circle2 {
  position: absolute;
  left: 15px;
  top: 39px;
  width: 25px;
  height: 25px;
  border-radius: 50%;
  background: rgb(168, 168, 168);
  box-shadow: inset 0 0 2px rgba(0, 0, 0, 0.25);
}

.moon_circle3 {
  position: absolute;
  left: 51px;
  top: 21px;
  width: 12px;
  height: 12px;
  border-radius: 50%;
  background: rgb(168, 168, 168);
  box-shadow: inset 0 0 2px rgba(0, 0, 0, 0.25);
}

#sun_switch:not(:checked) ~ * .moon_circle1,
#sun_switch:not(:checked) ~ * .moon_circle2,
#sun_switch:not(:checked) ~ * .moon_circle3 {
  display: none;
}

#sun_switch {
  opacity: 0;
  width: 0px;
  height: 0px;
}

#sun_switch:checked ~ * .circle {
  background: #ccc;
  transform: translate(195px, 0);
}

#sun_switch:checked ~ * .switch {
  background: #000;
}

#sun_switch:checked ~ * .light1 {
  background: #555;
  transform: translate(195px, 0);
}

#sun_switch:checked ~ * .light2 {
  background: #333;
  transform: translate(115px, 0);
}

#sun_switch:checked ~ * .light3 {
  background: #222;
  transform: translate(30px, 0);
}

.star {
  position: relative;
  height: 20px;
  width: 20px;
  background: #fff;
  clip-path: path(
    "M 5 0 C 5 5 4 10 0 10 C 4 10 5 15 5 20 C 5 15 6 10 10 10 C 6 10 5 5 5 0"
  );
}

#sun_switch:not(:checked) ~ * .star {
  display: none;
}

.star1 {
  top: 50px;
  left: 50px;
}

.star2 {
  top: 20px;
  left: 30px;
}

.star3 {
  top: 20px;
  left: 120px;
}

.star4 {
  top: -15px;
  left: 150px;
}

.star5 {
  top: -55px;
  left: 135px;
}
```

## 简述

简单编写了获取用户摄像头和音频的功能，以及一个相当不错的主题切换按钮！

## BUG

如果发现 bug 或者其他需求可以联系作者
也十分欢迎 pr
[前往 github](https://github.com/Bayn-Web/bcomponent)
