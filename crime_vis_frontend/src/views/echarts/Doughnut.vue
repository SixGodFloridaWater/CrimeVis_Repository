<template>
    <div ref="chart" class="chart"></div>
</template>

<script setup>
import { ref, onMounted, defineProps } from 'vue';
import * as echarts from 'echarts';
const props = defineProps(['ageData']);
const chart = ref(null);
let myChart = null;
const option = {
  tooltip: {
    trigger: 'item'
  },
  legend: {
    bottom: '5%',
    left: 'center'
  },
  series: [
    {
      name: '受害者年龄',
      type: 'pie',
      radius: ['40%', '70%'],
      center: ['50%', '40%'],
      avoidLabelOverlap: false,
      itemStyle: {
        borderRadius: 10,
        borderColor: '#fff',
        borderWidth: 2
      },
      label: {
        show: false,
        position: 'center'
      },
      emphasis: {
        label: {
          show: true,
          fontSize: 20,
          fontWeight: 'bold'
        }
      },
      labelLine: {
        show: false
      },
      data: props.ageData
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
    height: 20vw;
}
</style>
