<template>
  <v-app>
    <books-core-app-bar v-if="isLoggedIn" />

    <books-core-drawer v-if="isLoggedIn"/>

    <books-core-view />
  </v-app>
</template>

<script>

  export default {
    name: 'BooksIndex',
    computed : {
      isLoggedIn : function(){ return this.$store.getters.isLoggedIn}
    },
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
