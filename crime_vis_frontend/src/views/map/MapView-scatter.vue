<template>
  <div id="main" style="width:45vw;height:36.5vw;"></div>
</template>

<script>
import * as echarts from 'echarts';
import 'echarts/extension/bmap/bmap';

export default {
  props:["data","geoCoordMap"],
mounted() {
  const chartDom = document.getElementById('main');
  const myChart = echarts.init(chartDom);
  const data = this.data;
  const geoCoordMap = this.geoCoordMap;
  // const data = [
  // { name: '海门', value: 9 },
  // { name: '鄂尔多斯', value: 12 },
  // { name: '招远', value: 12 },
  // { name: '舟山', value: 12 },
  // { name: '齐齐哈尔', value: 14 },
  // { name: '盐城', value: 15 },
  // { name: '赤峰', value: 16 },
  // { name: '青岛', value: 18 }
  // ];

  // const geoCoordMap = {
  // 海门: [-118, 34],
  // 鄂尔多斯: [-118.12, 34.34],
  // 招远: [-118.36, 34.03],
  // 舟山: [-118.4, 34.5],
  // 齐齐哈尔: [-118.1, 34.24],
  // 盐城: [-118.15, 34.2],
  // 赤峰: [-118.87, 34.28],
  // 青岛: [-118.43, 34.07]
  // };

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
      textStyle:{
          "color":"#FFFFFF"
      },
      subtext: 'data from Kaggle',
      left: 'center'
  },
  tooltip: {
      show:false
  },
  bmap: {
      center: [-118.3, 34.1],
      zoom: 12,
      roam: true,
      mapStyle: {
          styleJson:[{
    "featureType": "background",
    "elementType": "geometry",
    "stylers": {
        "visibility": "on"
    }
}, {
    "featureType": "land",
    "elementType": "geometry",
    "stylers": {
        "color": "#fcf8f3ff",
        "visibility": "on"
    }
}, {
    "featureType": "building",
    "elementType": "geometry.fill",
    "stylers": {
        "color": "#f1ece4ff",
        "visibility": "on"
    }
}, {
    "featureType": "building",
    "elementType": "geometry.stroke",
    "stylers": {
        "color": "#e2dacbff",
        "visibility": "on"
    }
}, {
    "featureType": "road",
    "elementType": "geometry.fill",
    "stylers": {
        "color": "#f6f1e2ff",
        "visibility": "on"
    }
}, {
    "featureType": "road",
    "elementType": "geometry.stroke",
    "stylers": {
        "color": "#d8cebaff",
        "visibility": "on"
    }
}, {
    "featureType": "water",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#f6f1e2ff",
        "visibility": "on"
    }
}, {
    "featureType": "water",
    "elementType": "geometry",
    "stylers": {
        "color": "#a9cee0ff",
        "visibility": "on"
    }
}, {
    "featureType": "country",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "city",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "continent",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "village",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "town",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "district",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "districtlabel",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff"
    }
}, {
    "featureType": "districtlabel",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff"
    }
}, {
    "featureType": "poilabel",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#a9cee0ff"
    }
}, {
    "featureType": "poilabel",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#295427ff"
    }
}, {
    "featureType": "poilabel",
    "elementType": "labels.icon",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "scenicspotslabel",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#a9cee0ff",
        "visibility": "on"
    }
}, {
    "featureType": "scenicspotslabel",
    "elementType": "labels.icon",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "transportationlabel",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#a9cee0ff",
        "visibility": "on"
    }
}, {
    "featureType": "transportationlabel",
    "elementType": "labels.icon",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "airportlabel",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "airportlabel",
    "elementType": "labels.icon",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "green",
    "elementType": "geometry",
    "stylers": {
        "color": "#588157ff",
        "visibility": "on"
    }
}, {
    "featureType": "district",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff"
    }
}, {
    "featureType": "city",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff"
    }
}, {
    "featureType": "country",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff"
    }
}, {
    "featureType": "continent",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff"
    }
}, {
    "featureType": "town",
    "elementType": "labels",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "village",
    "elementType": "labels",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "town",
    "elementType": "labels.icon",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "city",
    "elementType": "labels.icon",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "railway",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "subway",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "highwaysign",
    "elementType": "labels",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "nationalwaysign",
    "elementType": "labels",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "nationalwaysign",
    "elementType": "labels.icon",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "provincialwaysign",
    "elementType": "labels",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "provincialwaysign",
    "elementType": "labels.icon",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "tertiarywaysign",
    "elementType": "labels",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "tertiarywaysign",
    "elementType": "labels.icon",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "subwaylabel",
    "elementType": "labels",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "subwaylabel",
    "elementType": "labels.icon",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "road",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "road",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff",
        "weight": 1.5
    }
}, {
    "featureType": "highway",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff"
    }
}, {
    "featureType": "nationalway",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff"
    }
}, {
    "featureType": "provincialway",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff"
    }
}, {
    "featureType": "cityhighway",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff"
    }
}, {
    "featureType": "arterial",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff"
    }
}, {
    "featureType": "tertiaryway",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff"
    }
}, {
    "featureType": "fourlevelway",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff"
    }
}, {
    "featureType": "local",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#295427ff"
    }
}, {
    "featureType": "scenicspotslabel",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#295427ff"
    }
}, {
    "featureType": "subway",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#fcf8f3ff"
    }
}, {
    "featureType": "shopping",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "manmade",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "manmade",
    "elementType": "labels",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "highwaysign",
    "elementType": "labels.icon",
    "stylers": {
        "visibility": "off"
    }
}, {
    "featureType": "water",
    "elementType": "labels.text.stroke",
    "stylers": {
        "color": "#295427ff"
    }
}, {
    "featureType": "road",
    "elementType": "labels.text",
    "stylers": {
        "fontsize": 28
    }
}, {
    "featureType": "highway",
    "elementType": "geometry.fill",
    "stylers": {
        "color": "#f6f1e2ff",
        "visibility": "on"
    }
}, {
    "featureType": "highway",
    "elementType": "geometry.stroke",
    "stylers": {
        "color": "#d8cebaff",
        "visibility": "on",
        "weight": 1.5
    }
}, {
    "featureType": "highway",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "nationalway",
    "elementType": "geometry.fill",
    "stylers": {
        "color": "#f6f1e2ff",
        "visibility": "on"
    }
}, {
    "featureType": "nationalway",
    "elementType": "geometry.stroke",
    "stylers": {
        "color": "#d8cebaff",
        "visibility": "on",
        "weight": 1.5
    }
}, {
    "featureType": "nationalway",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "provincialway",
    "elementType": "geometry.fill",
    "stylers": {
        "color": "#f6f1e2ff",
        "visibility": "on"
    }
}, {
    "featureType": "cityhighway",
    "elementType": "geometry.fill",
    "stylers": {
        "color": "#f6f1e2ff",
        "visibility": "on"
    }
}, {
    "featureType": "arterial",
    "elementType": "geometry.fill",
    "stylers": {
        "color": "#f6f1e2ff",
        "visibility": "on"
    }
}, {
    "featureType": "tertiaryway",
    "elementType": "geometry.fill",
    "stylers": {
        "color": "#f6f1e2ff",
        "visibility": "on"
    }
}, {
    "featureType": "fourlevelway",
    "elementType": "geometry.fill",
    "stylers": {
        "color": "#f6f1e2ff",
        "visibility": "on"
    }
}, {
    "featureType": "local",
    "elementType": "geometry.fill",
    "stylers": {
        "color": "#f6f1e2ff",
        "visibility": "on"
    }
}, {
    "featureType": "provincialway",
    "elementType": "geometry.stroke",
    "stylers": {
        "color": "#d8cebaff",
        "visibility": "on",
        "weight": 1.5
    }
}, {
    "featureType": "cityhighway",
    "elementType": "geometry.stroke",
    "stylers": {
        "color": "#d8cebaff",
        "visibility": "on",
        "weight": 1.5
    }
}, {
    "featureType": "arterial",
    "elementType": "geometry.stroke",
    "stylers": {
        "color": "#d8cebaff",
        "visibility": "on",
        "weight": 1.5
    }
}, {
    "featureType": "tertiaryway",
    "elementType": "geometry.stroke",
    "stylers": {
        "color": "#d8cebaff",
        "visibility": "on",
        "weight": 1.5
    }
}, {
    "featureType": "fourlevelway",
    "elementType": "geometry.stroke",
    "stylers": {
        "color": "#d8cebaff",
        "visibility": "on",
        "weight": 1.5
    }
}, {
    "featureType": "local",
    "elementType": "geometry.stroke",
    "stylers": {
        "color": "#d8cebaff",
        "visibility": "on",
        "weight": 1.5
    }
}, {
    "featureType": "nationalway",
    "stylers": {
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "6"
    }
}, {
    "featureType": "nationalway",
    "stylers": {
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "7"
    }
}, {
    "featureType": "nationalway",
    "stylers": {
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "8"
    }
}, {
    "featureType": "nationalway",
    "stylers": {
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "9"
    }
}, {
    "featureType": "nationalway",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "6"
    }
}, {
    "featureType": "nationalway",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "7"
    }
}, {
    "featureType": "nationalway",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "8"
    }
}, {
    "featureType": "nationalway",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "9"
    }
}, {
    "featureType": "nationalway",
    "elementType": "labels",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "6"
    }
}, {
    "featureType": "nationalway",
    "elementType": "labels",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "7"
    }
}, {
    "featureType": "nationalway",
    "elementType": "labels",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "8"
    }
}, {
    "featureType": "nationalway",
    "elementType": "labels",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "9"
    }
}, {
    "featureType": "provincialway",
    "stylers": {
        "curZoomRegionId": "0",
        "curZoomRegion": "8,10",
        "level": "8"
    }
}, {
    "featureType": "provincialway",
    "stylers": {
        "curZoomRegionId": "0",
        "curZoomRegion": "8,10",
        "level": "9"
    }
}, {
    "featureType": "provincialway",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "8,10",
        "level": "8"
    }
}, {
    "featureType": "provincialway",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "8,10",
        "level": "9"
    }
}, {
    "featureType": "provincialway",
    "elementType": "labels",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "8,10",
        "level": "8"
    }
}, {
    "featureType": "provincialway",
    "elementType": "labels",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "8,10",
        "level": "9"
    }
}, {
    "featureType": "cityhighway",
    "stylers": {
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "6"
    }
}, {
    "featureType": "cityhighway",
    "stylers": {
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "7"
    }
}, {
    "featureType": "cityhighway",
    "stylers": {
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "8"
    }
}, {
    "featureType": "cityhighway",
    "stylers": {
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "9"
    }
}, {
    "featureType": "cityhighway",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "6"
    }
}, {
    "featureType": "cityhighway",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "7"
    }
}, {
    "featureType": "cityhighway",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "8"
    }
}, {
    "featureType": "cityhighway",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "9"
    }
}, {
    "featureType": "cityhighway",
    "elementType": "labels",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "6"
    }
}, {
    "featureType": "cityhighway",
    "elementType": "labels",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "7"
    }
}, {
    "featureType": "cityhighway",
    "elementType": "labels",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "8"
    }
}, {
    "featureType": "cityhighway",
    "elementType": "labels",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "6,9",
        "level": "9"
    }
}, {
    "featureType": "arterial",
    "stylers": {
        "curZoomRegionId": "0",
        "curZoomRegion": "9,9",
        "level": "9"
    }
}, {
    "featureType": "arterial",
    "elementType": "geometry",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "9,9",
        "level": "9"
    }
}, {
    "featureType": "arterial",
    "elementType": "labels",
    "stylers": {
        "visibility": "off",
        "curZoomRegionId": "0",
        "curZoomRegion": "9,9",
        "level": "9"
    }
}, {
    "featureType": "local",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "fourlevelway",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "tertiaryway",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "arterial",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "cityhighway",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "provincialway",
    "elementType": "labels.text.fill",
    "stylers": {
        "color": "#285326ff",
        "visibility": "on"
    }
}, {
    "featureType": "scenicspots",
    "elementType": "geometry",
    "stylers": {
        "color": "#588157ff",
        "visibility": "on"
    }
}]
          }
  },
  
    series: [
        {
        type: 'effectScatter',
        coordinateSystem: 'bmap',
        data: convertData(data),
        symbolSize: 7,
        encode: {
            value: 2
        },
        
        itemStyle: {
            color: 'red',
            shadowBlur: 10,
            shadowColor: '#434343'
        },
        showEffectOn: 'render',
        rippleEffect: {
            brushType: 'stroke'
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

