<template>
  <v-app>
    <books-core-app-bar />

    <books-core-drawer />

    <books-core-view />
  </v-app>
</template>

<script>
  export default {
    name: 'BooksIndex',

    components: {
      BooksCoreAppBar: () => import('./AppBar'),
      BooksCoreDrawer: () => import('./Drawer'),
      BooksCoreView: () => import('./View'),
    },

    data: () => ({
      expandOnHover: false,
    }),
  }
</script>
