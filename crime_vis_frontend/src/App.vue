<template>
  <router-view v-slot="{ Component }">
    <component :is="Component"></component>
  </router-view>
</template>

<script setup>
import { RouterView } from 'vue-router'
</script>

<style>

</style>
