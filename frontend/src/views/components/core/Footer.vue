<template>
  <v-footer
    id="books-core-footer"
  >
    <v-container>
      <v-row
        align="center"
        no-gutters
      >
        <v-col>
          <div class="body-1 font-weight-light pt-6 pt-md-0 text-center">Made by <a href="https:/github.com/DmitryTryput">Dzmitry Tryputs</a>
          </div>
        </v-col>
      </v-row>
    </v-container>
  </v-footer>
</template>

<script>
  export default {
    name: 'BooksCoreFooter',
  }
</script>

<style lang="sass">
  #books-core-footer
    a
      font-size: .825rem
      font-weight: 500
      text-decoration: none
      text-transform: uppercase
</style>
