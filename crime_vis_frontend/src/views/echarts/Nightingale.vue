<template>
    <div ref="chart" class="chart"></div>
</template>

<script setup>
import { ref, onMounted, defineProps } from 'vue';
import * as echarts from 'echarts';
const chart = ref(null);
let myChart = null;
const option = {
  legend: {
    top: 'bottom'
  },
  toolbox: {
    show: true,
    feature: {
      mark: { show: true },
      dataView: { show: true, readOnly: false },
      restore: { show: true },
      saveAsImage: { show: true }
    }
  },
  series: [
    {
      name: 'Nightingale Chart',
      type: 'pie',
      radius: [20, 100],
      center: ['50%', '42%'],
      roseType: 'area',
      itemStyle: {
        borderRadius: 8
      },
      data: [
        { value: 40, name: 'rose 1' },
        { value: 38, name: 'rose 2' },
        { value: 32, name: 'rose 3' },
        { value: 30, name: 'rose 4' },
        { value: 28, name: 'rose 5' },
        { value: 26, name: 'rose 6' },
        { value: 22, name: 'rose 7' },
        { value: 18, name: 'rose 8' }
      ]
    }
  ]
};
onMounted(() => {
  myChart = echarts.init(chart.value);
  myChart.setOption(option);
});
</script>

<style>
/* 根据需要调整样式 */
.chart{
    height: 19vw;
}
</style>
