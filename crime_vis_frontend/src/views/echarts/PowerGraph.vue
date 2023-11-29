<template>
    <div class="about">
      <div id="myecharts" ref="demoh"></div>
    </div>
  </template>
  
  <script>
  import * as echarts from "echarts";
  
  export default {
    name: 'RelationGraph',
    data() {
      return {
        categories: [
        {
            "name": "暴力犯罪",
            "keyword": {},
            "base": "网格关系"
        },
        {
            "name": "财产犯罪",
            "keyword": {},
            "base": "网格关系"
        },
        {
            "name": "性犯罪",
            "keyword": {},
            "base": "网格关系"
        },
        {
            "name": "威胁和违反法律",
            "keyword": {},
            "base": "网格关系"
        },
        {
            "name": "白领犯罪",
            "keyword": {},
            "base": "网格关系"
        },
        ],

        nodes: [
        // {
        //   name: "犯罪类别",
        //   color: "#000000",
        //   id: "0",
        //   symbol : 'rect',
        //   symbolSize: 50,
        //   x: 30,
        //   y: 30,
        // },
        //暴力犯罪
        {
            name: "暴力犯罪",
            color: "#ff7f50",
            id: "10",
            category: 0,
            x: 10,
            y: 10,
            symbolSize: 30
        },
        {
            name: "攻击型犯罪",
            category: 0,
            id: "11",
            x: 10,
            y: 20,
            symbolSize: 10
        },
        {
            name: "武器相关犯罪",
            category: 0,
            id: "12",
            x: 15,
            y: 15,
            symbolSize: 10
        },
        {
            name: "抢劫犯罪",
            category: 0,
            id: "13",
            x: 20,
            y: 10,
            symbolSize: 10
        },
        {
            name: "亲密关系暴力",
            category: 0,
            id: "14",
            x: 0,
            y: 10,
            symbolSize: 10
        },
        {
            name: "性犯罪",
            category: 0,
            id: "15",
            x: 10,
            y: 0,
            symbolSize: 10
        },
        {
            name: "滥用职权犯罪",
            category: 0,
            id: "16",
            x: 5,
            y: 10,
            symbolSize: 10
        },
        {
            name: "恐怖主义相关犯罪",
            category: 0,
            id: "17",
            x: 10,
            y: 5,
            symbolSize: 10
        },
        {
            name: "犯罪集团相关犯罪",
            category: 0,
            id: "18",
            x: 5,
            y: 5,
            symbolSize: 10
        },
        {
            name: "侵犯财产犯罪",
            category: 0,
            id: "19",
            x: 15,
            y: 15,
            symbolSize: 10
        },

        //财产犯罪
        {
            name: "财产犯罪",
            color: "#91cc75",
            id: "20",
            category: 1,
            symbolSize: 30
        },
        {
            name: "破坏财产",
            category: 1,
            id: "21",
            symbolSize: 10
        },
        {
            name: "盗窃",
            category: 1,
            id: "22",
            symbolSize: 10
        },
        {
            name: "诈骗",
            category: 1,
            id: "23",
            symbolSize: 10
        },
        {
            name: "抢劫",
            category: 1,
            id: "24",
            symbolSize: 10
        },
        {
            name: "非法占有",
            category: 1,
            id: "25",
            symbolSize: 10
        },
        {
            name: "欺诈",
            category: 1,
            id: "26",
            symbolSize: 10
        },
        {
            name: "侵犯知识产权",
            category: 1,
            id: "27",
            symbolSize: 10
        },

        //性犯罪
        {
            name: "性犯罪",
            color: "#91cc75",
            id: "30",
            category: 2,
            symbolSize: 30
        },
        {
            name: "性侵犯",
            category: 2,
            id: "31",
            symbolSize: 10
        },
        {
            name: "儿童性侵",
            category: 2,
            id: "32",
            symbolSize: 10
        },
        {
            name: "性交易",
            category: 2,
            id: "33",
            symbolSize: 10
        },
        {
            name: "性骚扰",
            category: 2,
            id: "34",
            symbolSize: 10
        },
        {
            name: "非法性行为",
            category: 2,
            id: "35",
            symbolSize: 10
        },


        //威胁和违反法律
        {
            name: "威胁和违反法律",
            color: "#91cc75",
            id: "40",
            category: 3,
            symbolSize: 30
        },
        {
            name: "威胁恐吓",
            category: 3,
            id: "41",
            symbolSize: 10
        },
        {
            name: "违反法院命令",
            category: 3,
            id: "42",
            symbolSize: 10
        },
        {
            name: "违反保护令",
            category: 3,
            id: "43",
            symbolSize: 10
        },
        {
            name: "扰乱公共秩序",
            category: 3,
            id: "44",
            symbolSize: 10
        },
        {
            name: "敲诈勒索",
            category: 3,
            id: "45",
            symbolSize: 10
        },
        {
            name: "虚假报警",
            category: 3,
            id: "46",
            symbolSize: 10
        },


        //白领犯罪
        {
            name: "白领犯罪",
            color: "#91cc75",
            id: "50",
            category: 4,
            symbolSize: 30
        },
        {
            name: "金融犯罪",
            category: 4,
            id: "51",
            symbolSize: 10
        },
        {
            name: "商业犯罪",
            category: 4,
            id: "52",
            symbolSize: 10
        },
        {
            name: "税务犯罪",
            category: 4,
            id: "53",
            symbolSize: 10
        },
        {
            name: "知识产权犯罪",
            category: 4,
            id: "54",
            symbolSize: 10
        },
        {
            name: "职务犯罪",
            category: 4,
            id: "55",
            symbolSize: 10
        },
        {
            name: "造假犯罪",
            category: 4,
            id: "56",
            symbolSize: 10
        },

        ],

        //关系数据
        links: [
        // {
        //   source: "10",
        //   target: "20",
        // },
        // {
        //   source: "20",
        //   target: "30",
        // },
        // {
        //   source: "30",
        //   target: "40",
        // },
        // {
        //   source: "40",
        //   target: "50",
        // },
        // {
        //   source: "50",
        //   target: "10",
        // },
        {
            source: "15",
            target: "30",
        },
        {
            source: "13",
            target: "20",
        },
        //二级关系
        {
            source: "10",
            target: "11",
        },
        {
            source: "10",
            target: "12",
        },
        {
            source: "10",
            target: "13",
        },
        {
            source: "10",
            target: "14",
        },
        {
            source: "10",
            target: "15",
        },
        {
            source: "10",
            target: "16",
        },
        {
            source: "10",
            target: "17",
        },
        {
            source: "10",
            target: "18",
        },
        {
            source: "10",
            target: "19",
        },

        {
            source: "20",
            target: "21",
        },
        {
            source: "20",
            target: "22",
        },
        {
            source: "20",
            target: "23",
        },
        {
            source: "20",
            target: "24",
        },
        {
            source: "20",
            target: "25",
        },
        {
            source: "20",
            target: "26",
        },
        {
            source: "20",
            target: "27",
        },

        {
            source: "30",
            target: "31",
        },
        {
            source: "30",
            target: "32",
        },
        {
            source: "30",
            target: "33",
        },
        {
            source: "30",
            target: "34",
        },
        {
            source: "30",
            target: "35",
        },

        {
            source: "40",
            target: "41",
        },
        {
            source: "40",
            target: "42",
        },
        {
            source: "40",
            target: "43",
        },
        {
            source: "40",
            target: "44",
        },
        {
            source: "40",
            target: "45",
        },
        {
            source: "40",
            target: "46",
        },
        

        {
            source: "50",
            target: "51",
        },
        {
            source: "50",
            target: "52",
        },
        {
            source: "50",
            target: "53",
        },
        {
            source: "50",
            target: "54",
        },
        {
            source: "50",
            target: "55",
        },
        {
            source: "50",
            target: "56",
        },

        ],
      };
    },
  
    mounted() {
      let myChart = echarts.init(this.$refs.demoh);
      let option = {
        legend: {
            textStyle:{
                color:'#FFFFFF'
            },
            data: [
            {
                name :'暴力犯罪',
                icon:'circle',
            },
            {
                name :'财产犯罪',
                icon:'circle',
            },
            {
                name :'性犯罪',
                icon:'circle',
            },
            {
                name :'威胁和违反法律',
                icon:'circle',
            },
            {
                name :'白领犯罪',
                icon:'circle',
            },
        ]
        },
        series: {
            type: "graph", //关系图
            data: this.nodes,
            categories: this.categories,
            layout: "force", //引导布局
            roam: true, //开启平移与缩放
            // coordinateSystem : null,//坐标系可选
            // xAxisIndex : 0, //x轴坐标 有多种坐标系轴坐标选项
            // yAxisIndex : 0, //y轴坐标
            // 根据value放缩节点
            
            draggable : true,//节点是否可以拖拽
            // itemStyle: {
            //   color: "#95dcb2"
            // },
            label: { // 图形上的文字
                show: true,
                position: "right",
                distance: 6, // 距离图形的位置
                fontSize: 12,
                // color: "#FFFFFF"
                //align: "center"
            },
            // circular: {
            //   rotateLabel: true
            // },
            force: { // 设置间距
                repulsion: 50, // 点之间的间距
                qravity: 0.01, // 距离中心点的位置
                edgeLength: 100, // 两边点的距离
                //initLayout: [this.nodes.x,this.nodes.y],
                layoutAnimation : true,
            },
            links: this.links,
            lineStyle: {
                width: 2,
                curveness: 0.2
            }
        }
      };
      // 绘制图表 setOption 配置图表的配置项
      myChart.setOption(option);
    }
  };
  </script>
  
  <style scoped>
  #myecharts {
    height: 19vw;
  }
  </style>
  