<template>
  <!-- <div>
    <div class="title">
      <h2>犯罪基本信息</h2>
    </div>
    <div class="info" id="TwoChart">
      <p v-for="(item,index) in crimedates" :key="index">犯罪时间:  {{ item.data }}   {{ item.time }}</p>
      <p>犯罪地点:   {{ crimeplace }}</p>
      <p>犯罪描述:   {{ crimedescribe }}</p>
      <p v-for="item in victiminfo" :key="item.id">受害人性别年龄:  {{ item.sex }}   {{ item.age }}</p>
      <p>受害者描述:   {{ victimdiscribe }}</p>
    </div>
  </div> -->
  <GraphTitle :text="title"/>
  <div class="chart" id="ThreeChart">
        <!-- 图表的容器 -->
        <DoughnutView v-if="isAge" :ageData="ageData"/>
    </div>
</template>

<script setup>
import { defineProps } from 'vue'
import GraphTitle from "@/views/component/graphTitle.vue"
import DoughnutView from "@/views/echarts/Doughnut.vue";
const props = defineProps(['isAge','ageData']);
const title = '受害者年龄分布环形图';
// export default{
//   data(){
//     return{
//       crimedates:[{
//         "data":"2023/10/22/",
//         "time":"10:30",
//       }],
//       crimeplace:"chengdu",
//       crimedescribe:"terrible",
//       victiminfo:[{
//         "id":1,
//         "sex":"woman",
//         "age":"18",
//       }],
//       victimdiscribe:"I am innocent",
//     }
//   },
// }

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
  background: #4C1A24;
  text-align: center;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
p{
  font-size: 14px;
  color: #fff;
  line-height: 2rem;
  position: relative;  
  left: 10px;
}

</style>