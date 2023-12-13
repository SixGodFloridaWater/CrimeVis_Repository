<template>
  <div>
    <GraphTitle :text="title"/>
    <div class="Force-oriented" id="FourChart">
        <!-- 图表的容器 -->
        <PowerGraph/>
    </div>
  </div>
</template>

<script setup>
import PowerGraph from "@/views/echarts/PowerGraph.vue"
import GraphTitle from "@/views/component/graphTitle.vue"
const title = '犯罪类型力导向图';
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