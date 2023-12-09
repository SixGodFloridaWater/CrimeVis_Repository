<template>
  <div class="slider-demo-block">
  <el-slider v-model="value" range :marks="marks" :max="9" :show-tooltip="false"/>
  </div>
</template>
  
<script setup>
import { reactive, ref, watch } from 'vue'

const { getMonth } = defineProps(['getMonth']);

const value = ref([0, 0])
const marks = reactive({
  0:'Jan',
  1:'Feb',
  2:'Mar',
  3:'Apr',
  4:'May',
  5:'Jun',
  6:'Jul',
  7:'Aug',
  8:'Sep',
  9:'Oct',
})

watch(() => {
  getMonth(value.value)
});

</script>
  
  <style scoped>
  .slider-demo-block {
  display: flex;
  align-items: center;
  }
  .slider-demo-block .el-slider {
  margin-top: 50px;
  margin-left: 24px;
  margin-right: 24px;
  }
  </style>