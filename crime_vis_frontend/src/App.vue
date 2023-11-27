<template>
  <router-view v-slot="{ Component }">
    <component :is="Component"></component>
  </router-view>
</template>

<script setup>
  import { RouterView } from 'vue-router'

</script>

<script>
  import {provide} from "vue"
  import * as echarts from "echarts"
  import axios from "axios"
  export default{
    setup(){
      // provider("名字随便起","传递的内容")
      provide("echarts",echarts)
      provide("axios",echarts)
    }
  }
</script>
<style>
/* 背景图的绘制 */
body{
  background: url("~@/assets/bg.jpg") no-repeat center center fixed;
  -webkit-background-size: cover;  
  -moz-background-size: cover;  
  -o-background-size: cover;  
  background-size: cover;  
  height: 100vh;  
  width: 100vw; 
}
/* 所有样式的初始化 */
*{
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
}
</style>
