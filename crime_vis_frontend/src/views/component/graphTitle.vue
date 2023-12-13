<template>
    <div class="title">
      <h2>{{ typedText }}</h2>
    </div>
</template>

<script>
export default {
    props:['text'],
    data() {
        return {
        // text: '我是一段需要打字机效果的文字。', // 这就是要打出来的全文
        typedText: '', // 这是已经打出来的文字
        
        typeSpeed: 200, // 打字速度, 单位: 毫秒 
        };
    },
    created() {
        console.log(this.text)
        // 使用电子钟表函数每隔一定时间向 `typedText` 增加一个字符
        let i = 0;
        const timer = setInterval(() => {
        this.typedText += this.text[i];
        i += 1;
        // 如果所有的文字都已经打出来了，就取消电子钟表
        if (i >= this.text.length) {
            clearInterval(timer);
        }
        }, this.typeSpeed);
    }
};
</script>

<style scoped>
title{
  position: relative;
  text-align: center;
  background-size: cover;
  color: transparent;
  height: 60px;
  line-height: 46px;
}
h2{
  font-size: 18px;
  font-weight: 900;
  letter-spacing: 6px;
  width: 100%;
  background: linear-gradient(
    92deg,
    #0072ff 0%,
    #00eaff 48.8525390625%,
    #01aaff 100%
  );
  text-align: center;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
</style>