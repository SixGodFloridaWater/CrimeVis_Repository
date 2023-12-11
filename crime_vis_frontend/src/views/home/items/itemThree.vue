<template>
  <div>
    <div class="title">
      <h2>其他各种图表</h2>
    </div>
    <div class="chart" id="ThreeChart">
        <!-- 图表的容器 -->
        <PrinterView/>
    </div>
  </div>
</template>

<script setup>
import PrinterView from '@/views/component/printer.vue';
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