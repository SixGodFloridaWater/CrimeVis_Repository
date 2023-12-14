<template>
    <div>
        <div id="map" style="width:45vw;height:36.5vw;"></div>
    </div>
</template>
<script>
import BMapGL from "BMapGL";
import * as mapvgl from "mapvgl";
export default {
    props:["points"],
    data() {
    return {
    //模拟的经纬度及热力值数据；lng：经度 lat: 纬度 count：热力值
        pointList:this.points,
        // pointList: [
        //     { lng: -118.532669, lat: 34.291358, count: 5 },
        //     { lng: -118.531493, lat: 34.27278, count: 15 },
        //     { lng: -118.533388, lat: 34.289686, count: 9 },
        //     { lng: -118.537341, lat: 34.240986, count: 8 },
        //     { lng: -118.554157, lat: 34.242994, count: 20 },
        //     { lng: -118.56005, lat: 34.244599, count: 25 },
        //     { lng: -118.590664, lat: 34.255036, count: 7 },
        //     { lng: -118.594976, lat: 34.254367, count: 32 },
        //     { lng: -118.597994, lat: 34.250085, count: 5 },
        //     { lng: -118.51123, lat: 34.24123, count: 10 },
        //     { lng: -118.511, lat: 34.264123, count: 20 },
        //     { lng: -118.512, lat: 34.245123, count: 30 },
        //     { lng: -118.511233, lat: 34.271238, count: 20 },
        //     { lng: -118.54123, lat: 34.281235, count: 45 },
        //     { lng: -118.551231, lat: 34.212365, count: 20 },
        //     { lng: -118.574, lat: 34.281238, count: 25 },
        //     { lng: -118.543, lat: 34.261201, count: 7 },
        //     { lng: -118.58123, lat: 34.2123641, count: 32 },
        //     { lng: -118.566, lat: 34.24268, count: 5 },
        //     { lng: -118.575, lat: 34.23235, count: 10 },
        //     { lng: -118.57787, lat: 34.242364, count: 30 },
        //     { lng: -118.571567, lat: 34.21265, count: 10 },
        //     { lng: -118.52134, lat: 34.261238, count: 20 },
        //     ],
        map: null,
        };
    },
    mounted() {
        this.init();
        this.drawHeatMap(); // 添加这行来绘制热力图
    },
    methods: {
        init() {
            /* 绘制地图 */
            this.map = new BMapGL.Map("map"); // 创建Map实例1
            //设置中心点
            let point = new BMapGL.Point(-118.35, 34.1);
            //设置地图显示级别
            this.map.centerAndZoom(point, 12);
            //设置地图能够缩放
            this.map.enableScrollWheelZoom();
            //这个是百度地图开发平台中的个性化地图，可以使用id来设置地图底层的样式
            this.map.setMapStyleV2({
                styleId: "c4dbdfcb92a3751ea489c3d98deaa878",
            });
        },
    /* 绘制热力图 方法一*/
    drawHeatMap() {
        let view = new mapvgl.View({
            map: this.map,
        });
        let pointData = [];
        for (let i = 0; i < this.pointList.length; i++) {
            let item = this.pointList[i];
            pointData.push({
            geometry: {
            type: "Point",
            coordinates: [item.lng, item.lat],
        },
        properties: {
            count: item.count,
        },
    });
}
let heatmap = new mapvgl.HeatmapLayer({
    size: 400, // 单个点绘制大小
    max: 40, // 最大阈值
    height: 0, // 最大高度，默认为0
    unit: "m", // 单位，m:米，px: 像素
    gradient: {
        // 对应比例渐变色
        0.1: "rgba(0, 0, 255, 1)",
        0.3: "rgba(0, 255, 0, 1)",
        0.5: "rgba(255, 255, 0, 1)",
        0.7: "rgba(255, 165, 0, 1)",
        0.9: "rgba(255, 0, 0, 1)",
        1: "rgba(139, 0, 0, 1)",
    },
});
    view.addLayer(heatmap);
    heatmap.setData(pointData);
},
// /* 方法二 */
// drawHeatMap() {
//   let view = new mapvgl.View({
//     map: this.map,
//   });
//
//   fetch('./util/beijing.json').then(rs => {
//     return rs.json();
//   }).then(rs => {
//     rs = rs.result.data[0].bound;
//     let data = [];
//     for (let i = 0; i < rs.length; i++) {
//       let item = rs[i];
//       data.push({
//         geometry: {
//           type: 'Point',
//           coordinates: [item[0], item[1]]
//         },
//         properties: {
//           count: item[2]
//         }
//       });
//     }
//     let heatmap = new mapvgl.HeatmapLayer({
//       size: 500, // 单个点绘制大小
//       max: 40, // 最大阈值
//       height: 0, // 最大高度，默认为0
//       unit: "m", // 单位，m:米，px: 像素
//       gradient: {
//         // 对应比例渐变色
//         0.25: "rgba(0, 0, 255, 1)",
//         0.55: "rgba(0, 255, 0, 1)",
//         0.85: "rgba(255, 255, 0, 1)",
//         1: "rgba(255, 0, 0, 1)",
//       },
//     });
//     view.addLayer(heatmap);
//     heatmap.setData(data);
//   });
// },
},
};
</script>
