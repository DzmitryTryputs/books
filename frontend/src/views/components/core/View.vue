<template>
  <v-app>
  <v-content>
    <router-view />


  </v-content>

      <books-core-footer style="padding-left: 260px; padding-top: 0; padding-bottom: 0"/>

  </v-app>
</template>

<script>
  export default {
    name: 'BooksCoreView',

    components: {
      BooksCoreFooter: () => import('./Footer'),
    },
  }
</script>
