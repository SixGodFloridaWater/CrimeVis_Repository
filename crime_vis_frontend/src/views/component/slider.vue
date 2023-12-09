<template>
  <div class="slider-demo-block">
  <el-slider v-model="value" range :marks="marks" :max="8" :show-tooltip="false"/>
  </div>
</template>
  
<script setup>
import { reactive, ref, watch } from 'vue'

const { getMonth } = defineProps(['getMonth']);

const value = ref([0, 0])
const marks = reactive({
  0:'1月',
  1:'2月',
  2:'3月',
  3:'4月',
  4:'5月',
  5:'6月',
  6:'7月',
  7:'8月',
  8:'9月',
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
  margin-left: 24px;
  margin-right: 24px;
  }
  </style>