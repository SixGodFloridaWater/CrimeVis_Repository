<template>
  <div id="main" style="width:600px;height:500px;"></div>
</template>

<script>
import * as echarts from 'echarts';
import 'echarts/extension/bmap/bmap';

export default {
  mounted() {
    const chartDom = document.getElementById('main');
    const myChart = echarts.init(chartDom);

    const data = [
      { name: '海门', value: 9 },
      { name: '鄂尔多斯', value: 12 },
      { name: '招远', value: 12 },
      { name: '舟山', value: 12 },
      { name: '齐齐哈尔', value: 14 },
      { name: '盐城', value: 15 },
      { name: '赤峰', value: 16 },
      { name: '青岛', value: 18 }
    ];

    const geoCoordMap = {
      海门: [-118, 34],
      鄂尔多斯: [-118.12, 34.34],
      招远: [-118.36, 34.03],
      舟山: [-118.4, 34.5],
      齐齐哈尔: [-118.1, 34.24],
      盐城: [-118.15, 34.2],
      赤峰: [-118.87, 34.28],
      青岛: [-118.43, 34.07]
    };

    const convertData = function (data) {
      var res = [];
      for (var i = 0; i < data.length; i++) {
        var geoCoord = geoCoordMap[data[i].name];
        if (geoCoord) {
          res.push({
            name: data[i].name,
            value: geoCoord.concat(data[i].value)
          });
        }
      }
      return res;
    };

    const option = {
      title: {
        text: '美国洛杉矶犯罪分布 - 百度地图',
        subtext: 'data from Kaggle',
        sublink: 'http://www.pm25.in',
        left: 'center'
      },
      tooltip: {
        show:false
      },
      bmap: {
        center: [-118, 34],
        zoom: 11,
        roam: true,
        mapStyle: {
          styleId: '3d71dc5a4ce6222d3396801dee06622d'
        }
      },
      series: [
        {
          type: 'effectScatter',
          coordinateSystem: 'bmap',
          data: convertData(data),
          symbolSize: function (val) {
            return val[2];
          },
          encode: {
            value: 2
          },
          // showEffectOn: 'render',
          // rippleEffect: {
          // brushType: 'stroke'
          // },
          // label: {
          // formatter: '{b}',
          // position: 'right',
          // show: false
          // },
          itemStyle: {
            color: 'blue',
            shadowBlur: 10,
            shadowColor: '#333'
          },
          // emphasis: {
          // scale: true
          // },
          zlevel: 1
        }
      ]
    };

    option && myChart.setOption(option);
  }
};
</script>

<style scoped>
/* 样式 */
</style>
