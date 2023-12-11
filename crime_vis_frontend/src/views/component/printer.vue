<template>
    <el-card>
        <p>{{ typedText }}</p>
    </el-card>
</template>

<script>
export default {
data() {
    return {
    text: '我是一段需要打字机效果的文字。', // 这就是要打出来的全文
    typedText: '', // 这是已经打出来的文字
    typeSpeed: 200, // 打字速度, 单位: 毫秒 
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