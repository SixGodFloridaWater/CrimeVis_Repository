<template>
  <!-- <el-radio-group v-model="size" label="size control" size="small">
    <el-radio-button label="large">large</el-radio-button>
    <el-radio-button label="default">default</el-radio-button>
    <el-radio-button label="small">small</el-radio-button>
  </el-radio-group> -->
    
  <div>
    <!-- 顶部信息条创建 -->
    <header>
      <h1>洛杉矶犯罪数据洞察系统</h1>
    </header>
    <!-- 大容器 -->
    <section class="container">
      <!-- 左容器 -->
      <section class="itemLeft">
        <ItemPage/>
        <ItemPage/>
      </section>
      <!-- 中容器 -->
      <section class="itemCenter">
      
      </section>
      <!-- 右容器 -->
      <section class="itemRight">
        <ItemPage/>
        <ItemPage/>
      </section>
    </section>
  </div>

  <!-- <div class="demo-date-picker">
    <div class="block">
      <span class="demonstration">Default</span>
      <el-date-picker
        v-model="value1"
        type="date"
        placeholder="Pick a day"
        :size="size"
      />
    </div>
    <div class="block">
      <span class="demonstration">Picker with quick options</span>
      <el-date-picker
        v-model="value2"
        type="date"
        placeholder="Pick a day"
        :disabled-date="disabledDate"
        :shortcuts="shortcuts"
        :size="size"
      />
    </div>
  </div> -->
  

</template>

<script>
import ItemPage from '../../components/itemPage.vue';
export default {
  components:{
    ItemPage
  }
};
// import { ref } from 'vue'
// import MapData from '../../assets/json/USA.json' //引用地图json文件
// const size = ref<'default' | 'large' | 'small'>('default')

// const value1 = ref('')
// const value2 = ref('')

// const shortcuts = [
//   {
//     text: 'Today',
//     value: new Date(),
//   },
//   {
//     text: 'Yesterday',
//     value: () => {
//       const date = new Date()
//       date.setTime(date.getTime() - 3600 * 1000 * 24)
//       return date
//     },
//   },
//   {
//     text: 'A week ago',
//     value: () => {
//       const date = new Date()
//       date.setTime(date.getTime() - 3600 * 1000 * 24 * 7)
//       return date
//     },
//   },
// ]

// const disabledDate = (time) => {
//   return time.getTime() > Date.now()
// }
</script>

<style>
header{
  height: 60px;
  width: 100%;
  background-color: rgba(0, 0, 0, 0.2);
  
}
/* 标题的文字样式 _洛杉矶犯罪数据洞察系统*/
h1{
  font-size: 28px;
  color: #fff;
  text-align: center;
  line-height: 4rem;
}

/* 对大容器的样式进行设计 */
.container{
  /* 最大最小宽度 */
  min-width: 1200px;
  max-width: 2048px;
  margin: 0 auto;
  /* border: 1px solid red; */
  padding: .125rem .125rem 0;
  /* height: 500px;
  background-color: gray; */
  display: flex;
} 
/* 设置左右在页面的份数*/
.itemLeft,.itemRight{
  flex: 3;
}
.itemCenter{
  flex: 5;
}

/* .demo-date-picker {
  display: flex;
  width: 100%;
  padding: 0;
  flex-wrap: wrap;
}

.demo-date-picker .block {
  padding: 30px 0;
  text-align: center;
  border-right: solid 1px var(--el-border-color);
  flex: 1;
}

.demo-date-picker .block:last-child {
  border-right: none;
}

.demo-date-picker .demonstration {
  display: block;
  color: var(--el-text-color-secondary);
  font-size: 14px;
  margin-bottom: 20px;
} */
</style>