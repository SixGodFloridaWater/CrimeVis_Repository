<template>
    <div class="title">
        <h1>{{typedText}}</h1>
    </div>
</template>

<script>
export default {
    props:['text'],
    data() {
        return {
        // text: '我是一段需要打字机效果的文字。', // 这就是要打出来的全文
        typedText: '', // 这是已经打出来的文字
        typeSpeed: 100, // 打字速度, 单位: 毫秒 
        };
    },
    created() {
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
h1{
    font-size: 28px;
    font-weight: 900;
    letter-spacing: 6px;
    width: 100%;
    background: #4C1A24;
    text-align: center;
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
}
</style>
