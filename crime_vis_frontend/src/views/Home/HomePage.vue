<template>
  <div class="home">
    <!-- 顶部信息条创建 -->
    <div class="d-flex jc-center title_wrap">
      <div class="zuojuxing"></div>
      <div class="youjuxing"></div>
      <div class="guang"></div>
      <header>
        <h1>洛杉矶犯罪数据洞察系统</h1>
      </header>
    </div>
    
    <!-- 大容器 -->
    <section class="container">
      <!-- 左容器 -->
      <section class="itemLeft">
        <ItemPage>
          <ItemOne/>
        </ItemPage>
        <ItemPage>
          <ItemThree/>
        </ItemPage>
      </section>
      <!-- 中容器 -->
      <section class="itemCenter">
        <MapView/>
      </section>
      <!-- 右容器 -->
      <section class="itemRight">
        <ItemPage>
          <ItemTwo/>
        </ItemPage>
        <ItemPage>
          <ItemFour/>
        </ItemPage>
      </section>
    </section>
  </div>
</template>

<script setup>
import ItemPage from '@/views/items/itemPage.vue';
import ItemOne from '@/views/items/itemOne.vue';
import ItemTwo from '@/views/items/itemTwo.vue';
import ItemThree from '@/views/items/itemThree.vue';
import ItemFour from '@/views/items/itemFour.vue';
import MapView from "@/views/map/MapView.vue"

// import MapView from "@/views/map/MapView.vue"

</script>

<style scoped>
header{
  position: relative;
  text-align: center;
  background-size: cover;
  color: transparent;
  height: 50px;
  line-height: 46px;
}
/* 标题的文字样式 _洛杉矶犯罪数据洞察系统*/
h1{
  font-size: 28px;
  font-weight: 900;
  letter-spacing: 6px;
  width: 100%;
  background: linear-gradient(
    92deg,
    #0072ff 0%,
    #00eaff 48.8525390625%,
    #01aaff 100%
  );
  text-align: center;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
.title_wrap {
height: 60px;
background-image: url("../../assets/img/top.png");
background-size: cover;
background-position: center center;
position: relative;
margin-bottom: 4px;
}
.guang {
  position: absolute;
  bottom: -26px;
  background-image: url("../../assets/img/guang.png");
  background-position: 80px center;
  width: 100%;
  height: 56px;
}

.zuojuxing,
.youjuxing {
  position: absolute;
  top: -2px;
  width: 140px;
  height: 6px;
  background-image: url("../../assets/img/headers/juxing1.png");
}

.zuojuxing {
  left: 11%;
}

.youjuxing {
  right: 11%;
  transform: rotate(180deg);
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
  flex: 5;
}
.itemCenter{
  flex: 5;
  height: 10.5rpx;
  border: 1px solid blue;
  padding: 0.125rem;
  margin: .25rem;
}
</style>