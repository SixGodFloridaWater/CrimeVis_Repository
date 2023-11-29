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
          <MapView/>
        </section>
        <!-- 右容器 -->
        <section class="itemRight">
          <ItemPage/>
          <ItemPage/>
        </section>
      </section>
    </div>

  </template>

  <script>
  import ItemPage from '@/components/itemPage.vue';
  import MapView from "@/views/map/MapView.vue";
  export default {
    components:{
      MapView,
      ItemPage
    }
  };
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
    flex: 3.5;
  }
  .itemCenter{
    flex: 3;
    margin-top: 50px;
    align-items: center;
    justify-content: center;
  }
  </style>