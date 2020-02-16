<template>
  <a-layout-header>
    <a-menu theme="dark" mode="horizontal" :defaultSelectedKeys="['1']" :style="{ lineHeight: '52px' }">
      <a-menu-item key="1">
        <router-link :to="{name: 'home'}">Home</router-link>
      </a-menu-item>
      <a-menu-item key="2">
        <router-link :to="{name: 'books'}">Books</router-link>
      </a-menu-item>
      <a-menu-item key="3">
        <router-link :to="{name: 'authors'}">Authors</router-link>
      </a-menu-item>
    </a-menu>
  </a-layout-header>
</template>
<script>
export default {
  name: "Header"
};
</script>
<style lang="scss" scoped>
.ant-layout-header {
  height: 55px;
  line-height: 55px;
  background: #0078c8;
  margin-bottom: 15px;
  .ant-menu {
    max-width: 980px;
    width: 100%;
    margin: auto;
    &.ant-menu-dark {
      font-weight: bold;
      background: #0078c8;
      .ant-menu-item-selected {
        background: transparent;
        border-bottom: solid 3px rgba(255, 255, 255, 0.75);
      }
    }
  }
}
</style>
