<template>
<v-navigation-drawer right v-model="rightDrawer" :disable-resize-watcher="true" fixed>
  <v-list>
    <v-list-tile class="ml-6">
      <v-list-tile-title class="card-title ">Advanced Search</v-list-tile-title>
    </v-list-tile>
    <slot/>
    <v-layout class="pt-3 ml-1" row>
        <v-btn color="primary" rounded @click.native="$emit('searchData')">Search</v-btn>
        <v-btn color="primary" rounded @click.native="$emit('searchData')">Cancel</v-btn>
    </v-layout>
  </v-list>
</v-navigation-drawer>
</template>

<script>

  export default {
    name: 'search-panel',
    props: {
      rightDrawer: ''
    },
    data () {
      return {
        right: true,
      }
    },
    methods: {
      cancelSearch () {},
      searchData () {},
    },

    mounted () {
      this.$nextTick(() => {
      })
    }
  }
</script>
