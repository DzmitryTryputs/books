<template>
<v-navigation-drawer right v-model="rightDrawer" :disable-resize-watcher="true" fixed style="width: 35%">
  <v-list class="align-center">
    <v-list-item class="ml-6">
      <v-list-item-title class="card-title font-weight-light" style="font-size: 1.25rem">Advanced Search</v-list-item-title>
    </v-list-item>
    <slot/>
    <v-layout class="pt-3 ml-1 offset-xs1" row>
        <v-col class="pr-4">
        <v-btn color="primary" style="margin-left: 40px" rounded @click.native="$emit('searchData')">Search</v-btn>
        </v-col>
        <v-col class="pr-4">
        </v-col>
        <v-col class="pr-4" style="margin-left: 30px">
        <v-btn color="primary" style="margin-left: 50px" rounded @click.native="$emit('cancelSearch')">Cancel</v-btn>
        </v-col>
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
