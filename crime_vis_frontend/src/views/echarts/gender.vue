<template>
  <div ref="chart" style="width: 100%; height: 19vw;"></div>
</template>

<script setup>
import { ref, onMounted, defineProps } from 'vue';
import * as echarts from 'echarts';
const chart = ref(null);
let myChart = null;
const props = defineProps(['dateocc','mNumber','fNumber']);
const option = {
  textStyle:{
    color:'#FFFFFF'
  },
  grid: {
    bottom: 80
  },
  toolbox: {
    feature: {
      dataZoom: {
        yAxisIndex: 'none'
      },
      restore: {},
      saveAsImage: {}
    }
  },
  tooltip: {
    trigger: 'axis',
    axisPointer: {
      type: 'cross',
      animation: false,
      label: {
        backgroundColor: '#505765'
      }
    }
  },
  legend: {
    data: ['Female', 'Male'],
    left: 10,
    textStyle: {
          color: '#fff' // 设置 x 轴文字颜色为白色
        }
  },
  dataZoom: [
    {
      show: true,
      realtime: true,
      start: 65,
      end: 85
    },
    {
      type: 'inside',
      realtime: true,
      start: 65,
      end: 85
    }
  ],
  xAxis: [
    {
      type: 'category',
      boundaryGap: false,
      axisLine: { onZero: false },
      // prettier-ignore
      data: props.dateocc,
      axisLabel: {
        textStyle: {
          color: '#fff' // 设置 x 轴文字颜色为白色
        }
      }
    }
  ],
  yAxis: [
    {
      name: 'Female',
      type: 'value',
      axisLabel: {
        textStyle: {
          color: '#fff' // 设置 y 轴文字颜色为白色
        }
      }
    },
    {
      name: 'Male',
      nameLocation: 'start',
      alignTicks: true,
      type: 'value',
      inverse: true,
      axisLabel: {
        textStyle: {
          color: '#fff' // 设置 y 轴文字颜色为白色
        }
      }
    }
  ],
  series: [
    {
      name: 'Female',
      type: 'line',
      areaStyle: {},
      lineStyle: {
        width: 1
      },
      emphasis: {
        focus: 'series'
      },
      markArea: {
        silent: true,
        itemStyle: {
          opacity: 0.3
        },
        data: [
          [
            {
              xAxis: '2009/9/12\n7:00'
            },
            {
              xAxis: '2009/9/22\n7:00'
            }
          ]
        ]
      },
      // prettier-ignore
      data: props.fNumber
    },
    {
      name: 'Male',
      type: 'line',
      yAxisIndex: 1,
      areaStyle: {},
      lineStyle: {
        width: 1
      },
      emphasis: {
        focus: 'series'
      },
      markArea: {
        silent: true,
        itemStyle: {
          opacity: 0.3
        },
        data: [
          [
            {
              xAxis: '2009/9/10\n7:00'
            },
            {
              xAxis: '2009/9/20\n7:00'
            }
          ]
        ]
      },
      // prettier-ignore
      data: props.mNumber
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

</style>
