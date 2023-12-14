<template>
  <div>
    <GraphTitle :text="title"/>
    <div class="chart" id="ThreeChart">
        <!-- 图表的容器 -->
        <GenderView v-if="isGender" :dateocc="dateocc" :mNumber="mNumber" :fNumber="fNumber"/>
    </div>
  </div>
</template>

<script setup>
import GraphTitle from "@/views/component/graphTitle.vue"
import GenderView from "@/views/echarts/gender.vue"
import { defineProps } from 'vue'
const title = '性别雨量关系图';
const props = defineProps(['isGender','dateocc','mNumber','fNumber']);

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