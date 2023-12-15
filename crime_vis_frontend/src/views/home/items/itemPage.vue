<template>
  <div class="item">
    <!-- 设置插槽 -->
    <slot></slot>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.item{
    height: 20rem;
    border-width: 1px;
    border-color: black;
    border-sytle:solid;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0,0,0,0.5); /* 设置边框阴影 */
    border-color: rgba(0,0,0,0.5); /* 设置边框颜色为半透明黑色 */
    margin: .25rem;
    
}
</style>