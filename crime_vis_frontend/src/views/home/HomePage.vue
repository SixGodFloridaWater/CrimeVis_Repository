<template>
  <div class="home">
    <!-- 顶部信息条创建 -->
    <div class="d-flex jc-center title_wrap">
      <div class="zuojuxing"></div>
      <div class="youjuxing"></div>
      <div class="guang"></div>
      <header>
        <HomeTitle :text="title"/>
      </header>
    </div>
    
    <!-- 大容器 -->
    <section class="container">
      <!-- 左容器 -->
      <section class="itemLeft">
        <ItemPage>
          <ItemOne :isSankey="isSankey" :linkdata="linkdata"/>
        </ItemPage>
        <ItemPage>
          <ItemFour/>
        </ItemPage>
      </section>
      <!-- 中容器 -->
      <section class="itemCenter">
        <div class="map">
          <el-button 
            v-if="isHeat"
            class="map-button"
            size="large"
            @click="handleMapChange()"
            plain
            text
            bg
          >
            点击切换散点图
          </el-button>
          <el-button 
            v-if="isScatter"
            class="map-button"
            size="large"
            @click="handleMapChange()"
            plain
            text
            bg
          >
            点击切换热力图
          </el-button>
          <MapViewScatter v-if="isScatter" :data="data" :geoCoordMap="geoCoordMap"/>
          <MapViewHeat v-if="isHeat" :points="points"/>
        </div>
        <div class="select">
          <div class="slider">
              <SliderView :getMonth="getMonth"/>
          </div>
          <div class="button">
            <el-button :icon="Search" circle size="large" @click="handleSearchButton()"/>
          </div>
        </div>
      </section>
      <!-- 右容器 -->
      <section class="itemRight">
        <ItemPage>
          <ItemTwo :isAge="isAge" :ageData="ageData"/>
        </ItemPage>
        <ItemPage>
          <ItemThree :isGender="isGender" :dateocc="dateocc" :mNumber="mNumber" :fNumber="fNumber"/>
        </ItemPage>
      </section>
    </section>
  </div>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue';
import { dataSelectService, dataCountService, dataGenderService } from "@/api/data.js"
import { ElMessage, ElButton } from 'element-plus'
import { Search } from '@element-plus/icons-vue'
import ItemPage from '@/views/home/items/itemPage.vue';
import ItemOne from '@/views/home/items/itemOne.vue';
import ItemTwo from '@/views/home/items/itemTwo.vue';
import ItemThree from '@/views/home/items/itemThree.vue';
import ItemFour from '@/views/home/items/itemFour.vue';
import MapViewScatter from "@/views/map/MapView-scatter.vue"
import MapViewHeat from "@/views/map/MapView-heat.vue"
import SliderView from "@/views/component/slider.vue"
import HomeTitle from "@/views/component/homeTitle.vue"

const title = '洛杉矶犯罪数据洞察系统';
//graph显示标签
const isSankey = ref(false);
const isAge = ref(false);
const isGender = ref(false);
const isScatter = ref(false);
const isHeat = ref(false);
//月份数据
const month = reactive({
  monthStart:"",
  monthEnd:"",
});
const points = ref([])
const crimedata = ref([])
//散点图数据
const data = ref()
const geoCoordMap = ref()
//桑基图数据
const linkdata = ref({
          part1_gun: 925,
          part1_knife: 394,
          part1_vehicle: 93,
          part1_bodily_force: 1239,
          part1_other_types: 951,
          part2_gun: 94,
          part2_knife: 7,
          part2_vehicle: 11,
          part2_bodily_force: 4155,
          part2_other_types: 1158,
          gun_handgun: 632,
          gun_unknown_firearm: 179,
          gun_semi_automatic_pistol: 208,
          knife_knife_with_blade_6inches_or_less: 236,
          knife_other_knife: 165,
          other_types_unknown_weapon: 1197,
          other_types_verbal_threat: 782,
          other_types_mace_pepper_spray: 130,
          handgun_AA: 81,
          handgun_AO: 46,
          handgun_IC: 498,
          handgun_JA: 6,
          handgun_JO: 1,
          unknown_firearm_AA: 19,
          unknown_firearm_AO: 9,
          unknown_firearm_IC: 149,
          unknown_firearm_JA: 2,
          semi_automatic_pistol_AA: 29,
          semi_automatic_pistol_AO: 14,
          semi_automatic_pistol_IC: 162, 
          semi_automatic_pistol_JA: 3,
          knife_with_blade_6inches_or_less_AA: 59,
          knife_with_blade_6inches_or_less_AO: 42,
          knife_with_blade_6inches_or_less_IC: 129,
          knife_with_blade_6inches_or_less_JA: 4,
          knife_with_blade_6inches_or_less_JO: 2,
          other_knife_AA: 31,
          other_knife_AO: 20,
          other_knife_IC: 112,
          other_knife_JA:2,
          vehicle_AA: 25,
          vehicle_AO: 9,
          vehicle_IC: 70,
          bodily_force_AA: 571,
          bodily_force_AO: 984,
          bodily_force_IC: 3780,
          bodily_force_JA: 34,
          bodily_force_JO: 25,
          unknown_weapon_AA: 115,
          unknown_weapon_AO: 119,
          unknown_weapon_IC: 958,
          unknown_weapon_JA: 2,
          unknown_weapon_JO: 3,
          verbal_threat_AA: 118,
          verbal_threat_AO: 121,
          verbal_threat_IC: 539,
          verbal_threat_JA: 1,
          verbal_threat_JO: 3,
          mace_pepper_spray_AA: 11,
          mace_pepper_spray_AO: 13,
          mace_pepper_spray_IC: 105,
          mace_pepper_spray_JA: 1,
})
//年龄数据
const ageData = ref([])
//性别雨量图数据
const dateocc = ref([])
const fNumber = ref([])
const mNumber = ref([])

// 月份选择函数
const getMonth = (value) => {
  month.monthStart = value[0];
  month.monthEnd = value[1];
  console.log("当前选择月份",month)
};
// 月份查询按钮函数
const handleSearchButton = ()=>{
  if(isScatter.value){
    isScatter.value = false
  }
  selectByMonth(month)
}
// 地图切换按钮函数
const handleMapChange = ()=>{
  if(isScatter.value){
    countNumber();
  }
  if(isHeat.value){
    scatterShow();
  }
}
// 地图显示函数
const scatterShow = ()=>{
  //显示散点图
  isHeat.value = false
  isScatter.value = true
}
const heatShow = ()=>{
  //显示热力图
  isScatter.value = false
  isHeat.value = true
}
// 按月份请求数据函数
const selectByMonth = async()=>{
  //取消显示桑基图和玫瑰图
  isSankey.value = false
  isAge.value = false
  let result = await dataSelectService(month);
  crimedata.value = result.data
  ElMessage.success(result.msg ? result.msg : '查询成功')
  console.log("crimedata数据",crimedata)
  //处理散点数据
  data.value = crimedata.value.map(item => ({ name: item.drNo, value: 1 }))
  geoCoordMap.value = crimedata.value.reduce((acc, item) => {
    acc[item.drNo] = [item.lon, item.lat];
    return acc;
  }, {})
  if(!isHeat.value){
    isScatter.value = true
  }
  updateLinkData()
  updateAgeData()
}

// 请求热力图数据函数
const countNumber = async()=>{
  let result = await dataCountService();
  points.value = result.data.map(item => ({ lng: item.lon, lat: item.lat, count: item.xcount }))
  ElMessage.success(result.msg ? result.msg : '查询成功')
  console.log("热力图数据",points)
  heatShow()
}

// 请求性别数据函数
const countGender = async()=>{
  let result = await dataGenderService();
  // points.value = result.data.map(item => ({ lng: item.lon, lat: item.lat, count: item.xcount }))
  dateocc.value = Array.from(new Set(result.data.map(item => (item.dateocc))))
  mNumber.value = result.data.filter(item => item.victSex === 'M').map(item => (item.occurrenceCount))
  fNumber.value = result.data.filter(item => item.victSex === 'F').map(item => (item.occurrenceCount))
  console.log("性别数据",dateocc,mNumber,fNumber)
  ElMessage.success(result.msg ? result.msg : '查询成功')
  //显示雨量图
  isGender.value = true
}

// 武器数据更新函数
function updateLinkData(){
    let i=0;
    for (let key in linkdata.value) {
      linkdata.value[key] = 0;
    }
    for(i = 0; i < crimedata.value.length; i++){
      if(crimedata.value[i].part12==1){
        if(crimedata.value[i].weaponusedcd==102 || crimedata.value[i].weaponusedcd==106 || crimedata.value[i].weaponusedcd==109){
          linkdata.value.part1_gun++
        }
        if(crimedata.value[i].weaponusedcd==200 || crimedata.value[i].weaponusedcd==207){
          linkdata.value.part1_knife++
        }
        if(crimedata.value[i].weaponusedcd==307){
          linkdata.value.part1_vehicle++
        } 
        if(crimedata.value[i].weaponusedcd==400){
          linkdata.value.part1_bodily_force++
        }
        if(crimedata.value[i].weaponusedcd==500 || crimedata.value[i].weaponusedcd==511 || crimedata.value[i].weaponusedcd==512){
          linkdata.value.part1_other_types++
        }
      }
      if(crimedata.value[i].part12==2){
        if(crimedata.value[i].weaponusedcd==102 || crimedata.value[i].weaponusedcd==106 || crimedata.value[i].weaponusedcd==109){
          linkdata.value.part2_gun++
        }
        if(crimedata.value[i].weaponusedcd==200 || crimedata.value[i].weaponusedcd==207){
          linkdata.value.part2_knife++
        }
        if(crimedata.value[i].weaponusedcd==307){
          linkdata.value.part2_vehicle++
        }
        if(crimedata.value[i].weaponusedcd==400){
          linkdata.value.part2_bodily_force++
        }
        if(crimedata.value[i].weaponusedcd==500 || crimedata.value[i].weaponusedcd==511 || crimedata.value[i].weaponusedcd==512){
          linkdata.value.part2_other_types++
        }
      }
    }
    for(i = 0; i < crimedata.value.length; i++){
      if(crimedata.value[i].weaponusedcd==102){
        linkdata.value.gun_handgun++
      }
      if(crimedata.value[i].weaponusedcd==106){
        linkdata.value.gun_unknown_firearm++
      }
      if(crimedata.value[i].weaponusedcd==109){
        linkdata.value.gun_semi_automatic_pistol++
      }
      if(crimedata.value[i].weaponusedcd==200){
        linkdata.value.knife_knife_with_blade_6inches_or_less++
      }
      if(crimedata.value[i].weaponusedcd==207){
        linkdata.value.knife_other_knife++
      }
      if(crimedata.value[i].weaponusedcd==500){
        linkdata.value.other_types_unknown_weapon++
      }
      if(crimedata.value[i].weaponusedcd==511){
        linkdata.value.other_types_verbal_threat++
      }
      if(crimedata.value[i].weaponusedcd==512){
        linkdata.value.other_types_mace_pepper_spray++
      }
    }
    for(i = 0; i < crimedata.value.length; i++){
      if(crimedata.value[i].status=="AA"){
        if(crimedata.value[i].weaponusedcd==102){
          linkdata.value.handgun_AA++
        }
        if(crimedata.value[i].weaponusedcd==106){
          linkdata.value.unknown_firearm_AA++
        }
        if(crimedata.value[i].weaponusedcd==109){
          linkdata.value.semi_automatic_pistol_AA++
        }
        if(crimedata.value[i].weaponusedcd==200){
          linkdata.value.knife_with_blade_6inches_or_less_AA++
        }
        if(crimedata.value[i].weaponusedcd==207){
          linkdata.value.other_knife_AA++
        }
        if(crimedata.value[i].weaponusedcd==307){
          linkdata.value.vehicle_AA++
        }
        if(crimedata.value[i].weaponusedcd==400){
          linkdata.value.bodily_force_AA++
        }
        if(crimedata.value[i].weaponusedcd==500){
          linkdata.value.unknown_weapon_AA++
        }
        if(crimedata.value[i].weaponusedcd==511){
          linkdata.value.verbal_threat_AA++
        }
        if(crimedata.value[i].weaponusedcd==512){
          linkdata.value.mace_pepper_spray_AA++
        }
      }
      if(crimedata.value[i].status=="AO"){
        if(crimedata.value[i].weaponusedcd==102){
          linkdata.value.handgun_AO++
        }
        if(crimedata.value[i].weaponusedcd==106){
          linkdata.value.unknown_firearm_AO++
        }
        if(crimedata.value[i].weaponusedcd==109){
          linkdata.value.semi_automatic_pistol_AO++
        }
        if(crimedata.value[i].weaponusedcd==200){
          linkdata.value.knife_with_blade_6inches_or_less_AO++
        }
        if(crimedata.value[i].weaponusedcd==207){
          linkdata.value.other_knife_AO++
        }
        if(crimedata.value[i].weaponusedcd==307){
          linkdata.value.vehicle_AO++
        }
        if(crimedata.value[i].weaponusedcd==400){
          linkdata.value.bodily_force_AO++
        }
        if(crimedata.value[i].weaponusedcd==500){
          linkdata.value.unknown_weapon_AO++
        }
        if(crimedata.value[i].weaponusedcd==511){
          linkdata.value.verbal_threat_AO++
        }
        if(crimedata.value[i].weaponusedcd==512){
          linkdata.value.mace_pepper_spray_AO++
        }
      }
      if(crimedata.value[i].status=="IC"){
        if(crimedata.value[i].weaponusedcd==102){
          linkdata.value.handgun_IC++
        }
        if(crimedata.value[i].weaponusedcd==106){
          linkdata.value.unknown_firearm_IC++
        }
        if(crimedata.value[i].weaponusedcd==109){
          linkdata.value.semi_automatic_pistol_IC++
        }
        if(crimedata.value[i].weaponusedcd==200){
          linkdata.value.knife_with_blade_6inches_or_less_IC++
        }
        if(crimedata.value[i].weaponusedcd==207){
          linkdata.value.other_knife_IC++
        }
        if(crimedata.value[i].weaponusedcd==307){
          linkdata.value.vehicle_IC++
        }
        if(crimedata.value[i].weaponusedcd==400){
          linkdata.value.bodily_force_IC++
        }
        if(crimedata.value[i].weaponusedcd==500){
          linkdata.value.unknown_weapon_IC++
        }
        if(crimedata.value[i].weaponusedcd==511){
          linkdata.value.verbal_threat_IC++
        }
        if(crimedata.value[i].weaponusedcd==512){
          linkdata.value.mace_pepper_spray_IC++
        }
      }
      if(crimedata.value[i].status=="JA"){
        if(crimedata.value[i].weaponusedcd==102){
          linkdata.value.handgun_JA++
        }
        if(crimedata.value[i].weaponusedcd==106){
          linkdata.value.unknown_firearm_JA++
        }
        if(crimedata.value[i].weaponusedcd==109){
          linkdata.value.semi_automatic_pistol_JA++
        }
        if(crimedata.value[i].weaponusedcd==200){
          linkdata.value.knife_with_blade_6inches_or_less_JA++
        }
        if(crimedata.value[i].weaponusedcd==207){
          linkdata.value.other_knife_JA++
        }
        if(crimedata.value[i].weaponusedcd==400){
          linkdata.value.bodily_force_JA++
        }
        if(crimedata.value[i].weaponusedcd==500){
          linkdata.value.unknown_weapon_JA++
        }
        if(crimedata.value[i].weaponusedcd==511){
          linkdata.value.verbal_threat_JA++
        }
        if(crimedata.value[i].weaponusedcd==512){
          linkdata.value.mace_pepper_spray_JA++
        }
      }
      if(crimedata.value[i].status=="JO"){
        if(crimedata.value[i].weaponusedcd==102){
          linkdata.value.handgun_JO++
        }
        if(crimedata.value[i].weaponusedcd==200){
          linkdata.value.knife_with_blade_6inches_or_less_JO++
        }
        if(crimedata.value[i].weaponusedcd==400){
          linkdata.value.bodily_force_JO++
        }
        if(crimedata.value[i].weaponusedcd==500){
          linkdata.value.unknown_weapon_JO++
        }
        if(crimedata.value[i].weaponusedcd==511){
          linkdata.value.verbal_threat_JO++
        }
      }
    }
    console.log("武器数据",linkdata.value)
    isSankey.value = true
}
// 年龄数据更新函数
function updateAgeData(){
  // 计算年龄范围的统计
  ageData.value = crimedata.value.reduce((acc, curr) => {
  const age = curr.victage;
  if (age >= 0 && age < 10) {
    acc[0].value++;
  } else if (age >= 10 && age < 20) {
    acc[1].value++;
  } else if (age >= 20 && age < 30) {
    acc[2].value++;
  } else if (age >= 30 && age < 40) {
    acc[3].value++;
  } else if (age >= 40 && age < 50) {
    acc[4].value++;
  } else if (age >= 50 && age < 60) {
    acc[5].value++;
  } else if (age >= 60 && age < 70) {
    acc[6].value++;
  } else if (age >= 70 && age < 80) {
    acc[7].value++;
  } else if (age >= 80 && age < 90) {
    acc[8].value++;
  } else if (age >= 90 && age <= 100) {
    acc[9].value++;
  }
    return acc;
  }, [
    { value: 0, name: '0-10' },
    { value: 0, name: '10-20' },
    { value: 0, name: '20-30' },
    { value: 0, name: '30-40' },
    { value: 0, name: '40-50' },
    { value: 0, name: '50-60' },
    { value: 0, name: '60-70' },
    { value: 0, name: '70-80' },
    { value: 0, name: '80-90' },
    { value: 0, name: '90-100' }
  ]);
  // ageRanges 数组包含了统计结果
  console.log("年龄统计数据",ageData);
  //显示玫瑰图
  isAge.value = true
}
onMounted(() => {
  countNumber()
  selectByMonth(month)
  countGender()
});
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
.title_wrap {
  margin-top: 5px;
  height: 50px;
  /* background-image: url("../../assets/img/top.png"); */
  background-size: cover;
  background-position: center center;
  position: relative;
}
.guang {
  position: absolute;
  bottom: -26px;
  /* background-image: url("../../assets/img/guang.png"); */
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
  /* background-image: url("../../assets/img/headers/juxing1.png"); */
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
  flex: 4;
}
.itemCenter{
  flex: 5;
  height: 10.5rpx;
  border-width: 1px;
  border-color: black;
  border-sytle:solid;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0,0,0,0.5); /* 设置边框阴影 */
  border-color: rgba(0,0,0,0.5); /* 设置边框颜色为半透明黑色 */
  padding: 0.125rem;
  margin: .25rem;
  .map{
    width:45vw;
    height:36.5vw;
    position: relative;
    .map-button{
      position: absolute;
      bottom: 1px;
      left: 1px;
      z-index: 999
    }
  }
  .select{
    display: flex;
    .slider{
      margin-top: 20px;
      flex: 9.5;
    }
    .button{
      margin-top: 15px;
      flex: 0.8;
    }
  }
  
}
</style>