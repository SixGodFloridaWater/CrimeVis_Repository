<template>
  <router-view v-slot="{ Component }">
    <component :is="Component"></component>
  </router-view>
</template>

<script setup>
import { RouterView } from 'vue-router'
</script>

<style>
/* 背景图的绘制 */
body{
  background: url("~@/assets/background.jpg") no-repeat center center fixed;
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
