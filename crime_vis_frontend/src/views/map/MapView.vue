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
              styleJson: [{
            "featureType": "land",
            "elementType": "geometry",
            "stylers": {
                "color": "#242f3eff"
            }
        }, {
            "featureType": "manmade",
            "elementType": "geometry",
            "stylers": {
                "color": "#242f3eff"
            }
        }, {
            "featureType": "water",
            "elementType": "geometry",
            "stylers": {
                "color": "#17263cff"
            }
        }, {
            "featureType": "road",
            "elementType": "geometry.fill",
            "stylers": {
                "color": "#9e7d60ff"
            }
        }, {
            "featureType": "road",
            "elementType": "geometry.stroke",
            "stylers": {
                "color": "#554631ff"
            }
        }, {
            "featureType": "districtlabel",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#d69563ff"
            }
        }, {
            "featureType": "districtlabel",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#17263cff",
                "weight": "3"
            }
        }, {
            "featureType": "poilabel",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#d69563ff"
            }
        }, {
            "featureType": "poilabel",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#17263cff",
                "weight": "3"
            }
        }, {
            "featureType": "subway",
            "elementType": "geometry",
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
            "featureType": "poilabel",
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
            "featureType": "provincialwaysign",
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
            "featureType": "nationalwaysign",
            "elementType": "labels.icon",
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
            "featureType": "highwaysign",
            "elementType": "labels.icon",
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
            "featureType": "green",
            "elementType": "geometry",
            "stylers": {
                "color": "#263b3eff"
            }
        }, {
            "featureType": "nationalwaysign",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#d0021bff"
            }
        }, {
            "featureType": "nationalwaysign",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#ffffffff"
            }
        }, {
            "featureType": "city",
            "elementType": "labels",
            "stylers": {
                "visibility": "on"
            }
        }, {
            "featureType": "city",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "city",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#d69563ff"
            }
        }, {
            "featureType": "city",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#17263cff"
            }
        }, {
            "featureType": "water",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#d69563ff"
            }
        }, {
            "featureType": "water",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#242f3eff"
            }
        }, {
            "featureType": "local",
            "elementType": "geometry.fill",
            "stylers": {
                "color": "#38414eff"
            }
        }, {
            "featureType": "local",
            "elementType": "geometry.stroke",
            "stylers": {
                "color": "#ffffff00"
            }
        }, {
            "featureType": "fourlevelway",
            "elementType": "geometry.fill",
            "stylers": {
                "color": "#38414eff"
            }
        }, {
            "featureType": "fourlevelway",
            "elementType": "geometry.stroke",
            "stylers": {
                "color": "#ffffff00"
            }
        }, {
            "featureType": "tertiaryway",
            "elementType": "geometry.fill",
            "stylers": {
                "color": "#38414eff"
            }
        }, {
            "featureType": "tertiaryway",
            "elementType": "geometry.stroke",
            "stylers": {
                "color": "#ffffff00"
            }
        }, {
            "featureType": "tertiaryway",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#759879ff"
            }
        }, {
            "featureType": "fourlevelway",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#759879ff"
            }
        }, {
            "featureType": "highway",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#759879ff"
            }
        }, {
            "featureType": "highway",
            "elementType": "geometry.fill",
            "stylers": {
                "color": "#9e7d60ff"
            }
        }, {
            "featureType": "highway",
            "elementType": "geometry.stroke",
            "stylers": {
                "color": "#554631ff"
            }
        }, {
            "featureType": "provincialway",
            "elementType": "geometry.fill",
            "stylers": {
                "color": "#9e7d60ff"
            }
        }, {
            "featureType": "provincialway",
            "elementType": "geometry.stroke",
            "stylers": {
                "color": "#554631ff"
            }
        }, {
            "featureType": "tertiaryway",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#1a2e1cff"
            }
        }, {
            "featureType": "fourlevelway",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#1a2e1cff"
            }
        }, {
            "featureType": "highway",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#1a2e1cff"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#1a2e1cff"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#759879ff"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "geometry.fill",
            "stylers": {
                "color": "#9e7d60ff"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "geometry.stroke",
            "stylers": {
                "color": "#554631ff"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "geometry.fill",
            "stylers": {
                "color": "#9e7d60ff"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "geometry.stroke",
            "stylers": {
                "color": "#554631ff"
            }
        }, {
            "featureType": "arterial",
            "elementType": "geometry.fill",
            "stylers": {
                "color": "#9e7d60ff"
            }
        }, {
            "featureType": "arterial",
            "elementType": "geometry.stroke",
            "stylers": {
                "color": "#554631fa"
            }
        }, {
            "featureType": "medicallabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "medicallabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "entertainmentlabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "entertainmentlabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "estatelabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "estatelabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "businesstowerlabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "businesstowerlabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "companylabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "companylabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "governmentlabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "governmentlabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "restaurantlabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "restaurantlabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "hotellabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "hotellabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "shoppinglabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "shoppinglabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "lifeservicelabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "lifeservicelabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "carservicelabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "carservicelabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "financelabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "financelabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "otherlabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "otherlabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "airportlabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "on"
            }
        }, {
            "featureType": "airportlabel",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#d69563ff"
            }
        }, {
            "featureType": "airportlabel",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#17263cff"
            }
        }, {
            "featureType": "airportlabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "highway",
            "stylers": {
                "level": "6",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "stylers": {
                "level": "7",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "stylers": {
                "level": "8",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "stylers": {
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "stylers": {
                "level": "10",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "6",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "7",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "8",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "10",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "stylers": {
                "level": "6",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "stylers": {
                "level": "7",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "stylers": {
                "level": "8",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "stylers": {
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "stylers": {
                "level": "10",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "6",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "7",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "8",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "10",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "6",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "7",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "8",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "nationalway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "10",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "6",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "7",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "8",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "highway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "10",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "provincialway",
            "stylers": {
                "level": "8",
                "curZoomRegionId": "0",
                "curZoomRegion": "8-9"
            }
        }, {
            "featureType": "provincialway",
            "stylers": {
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "8-9"
            }
        }, {
            "featureType": "provincialway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "8",
                "curZoomRegionId": "0",
                "curZoomRegion": "8-9"
            }
        }, {
            "featureType": "provincialway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "8-9"
            }
        }, {
            "featureType": "provincialway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "8",
                "curZoomRegionId": "0",
                "curZoomRegion": "8-9"
            }
        }, {
            "featureType": "provincialway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "8-9"
            }
        }, {
            "featureType": "cityhighway",
            "stylers": {
                "level": "6",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "stylers": {
                "level": "7",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "stylers": {
                "level": "8",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "stylers": {
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "stylers": {
                "level": "10",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "6",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "7",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "8",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "10",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "6",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "7",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "8",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "10",
                "curZoomRegionId": "0",
                "curZoomRegion": "6-10"
            }
        }, {
            "featureType": "arterial",
            "stylers": {
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "9-10"
            }
        }, {
            "featureType": "arterial",
            "stylers": {
                "level": "10",
                "curZoomRegionId": "0",
                "curZoomRegion": "9-10"
            }
        }, {
            "featureType": "arterial",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "9-10"
            }
        }, {
            "featureType": "arterial",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off",
                "level": "10",
                "curZoomRegionId": "0",
                "curZoomRegion": "9-10"
            }
        }, {
            "featureType": "arterial",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "9",
                "curZoomRegionId": "0",
                "curZoomRegion": "9-10"
            }
        }, {
            "featureType": "arterial",
            "elementType": "labels",
            "stylers": {
                "visibility": "off",
                "level": "10",
                "curZoomRegionId": "0",
                "curZoomRegion": "9-10"
            }
        }, {
            "featureType": "building",
            "elementType": "geometry.topfill",
            "stylers": {
                "color": "#2a3341ff"
            }
        }, {
            "featureType": "building",
            "elementType": "geometry.sidefill",
            "stylers": {
                "color": "#313b4cff"
            }
        }, {
            "featureType": "building",
            "elementType": "geometry.stroke",
            "stylers": {
                "color": "#1a212eff"
            }
        }, {
            "featureType": "road",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#759879ff"
            }
        }, {
            "featureType": "road",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#1a2e1cff"
            }
        }, {
            "featureType": "provincialway",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#759879ff"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#759879ff"
            }
        }, {
            "featureType": "arterial",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#759879ff"
            }
        }, {
            "featureType": "provincialway",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#1a2e1cff"
            }
        }, {
            "featureType": "cityhighway",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#1a2e1cff"
            }
        }, {
            "featureType": "arterial",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#1a2e1cff"
            }
        }, {
            "featureType": "local",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "manmade",
            "elementType": "labels.text.fill",
            "stylers": {
                "color": "#d69563ff"
            }
        }, {
            "featureType": "manmade",
            "elementType": "labels.text.stroke",
            "stylers": {
                "color": "#17263cff"
            }
        }, {
            "featureType": "subwaystation",
            "elementType": "geometry",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "transportationlabel",
            "elementType": "labels.icon",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "transportationlabel",
            "elementType": "labels",
            "stylers": {
                "visibility": "off"
            }
        }, {
            "featureType": "estate",
            "elementType": "geometry",
            "stylers": {
                "color": "#2a3341ff"
            }
        }]
            }
      },
	  tooltip: {
	      backgroundColor: 'rgba(255,255,255,0.7)',
	      formatter: function (param) {
	        var value = param.value;
	        // prettier-ignore
	        return '<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 18px;padding-bottom: 7px;margin-bottom: 7px">'
	                  
	                  + '</div>'
	                  + '犯罪类型' + '：' + value[2] + '<br>'
	      }
	    },
      series: [
        {
          type: 'scatter',
          coordinateSystem: 'bmap',
          data: convertData(data),
          symbolSize: function (val) {
            return val[2];
          },
          encode: {
            // 第三个维度对应颜色
            tooltip: 2,
            itemStyle: 2
            },
            itemStyle: {
            color: function(params) {
              // 根据第三个维度的值创建颜色渐变
              var value = params.value[2];
              return echarts.color.createLinearGradient(
              0, 0, 0, 1,
              [
                {offset: 0, color: 'blue'},
                {offset: 1, color: 'red'}
              ].map(function(item) {
                return {
                offset: item.offset,
                color: value > 50 ? item.color : 'gray'
                };
              })
              );
            }
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
