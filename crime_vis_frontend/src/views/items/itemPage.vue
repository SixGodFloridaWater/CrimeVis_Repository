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
    border: 1px solid blue;
    margin: .25rem;
    background-color: rgba(255, 0, 0, .15);
}
</style>