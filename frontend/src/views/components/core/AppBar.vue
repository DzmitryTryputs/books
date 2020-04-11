<template>
  <v-app-bar
    id="app-bar"
    absolute
    app
    color="transparent"
    flat
    height="75"
  >
    <v-btn
      class="mr-3"
      elevation="1"
      fab
      small
      @click="setDrawer(!drawer)"
    >
      <v-icon v-if="!drawer">
        mdi-view-quilt
      </v-icon>

      <v-icon v-else>
        mdi-dots-vertical
      </v-icon>
    </v-btn>

    <v-toolbar-title
      class="hidden-sm-and-down font-weight-light"
      v-text="$route.name"
    />

    <v-spacer />

    <div class="mx-3" />

    <div class="text-center">
      <v-menu
              offset-y
              origin="top right"
              transition="scale-transition"
      >
        <template v-slot:activator="{ on }">
          <v-btn
                  v-on="on"
                  min-width="0"
                  height="50px"
                  text
                  style="margin-right: 15px;"
          >
            <v-icon>mdi-account</v-icon>
          </v-btn>
        </template>

        <v-card style="margin-top: 0; margin-bottom: 0">
          <v-list>
            <v-list-item>
              <v-list-item-avatar>
                <img src="avatar.png" alt="John">
              </v-list-item-avatar>

              <v-list-item-content>
                <v-list-item-title>USERNAME</v-list-item-title>
                <v-list-item-subtitle>NAME LASTNAME</v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
          </v-list>

          <v-divider></v-divider>

          <v-list dense>
            <v-list-item-group  color="primary">
              <v-list-item @click="logout">
                <v-list-item-icon>
                  <v-icon>mdi-door</v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title >Logout</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list-item-group>
          </v-list>
        </v-card>
      </v-menu>
    </div>
  </v-app-bar>
</template>

<script>
  // Utilities
  import { mapState, mapMutations } from 'vuex'

  export default {
    name: 'BooksCoreAppBar',

    components: {
    },

    computed: {
      ...mapState(['drawer']),
    },

    methods: {
      ...mapMutations({
        setDrawer: 'SET_DRAWER',
      }),

      logout: function() {
          this.$store
                  .dispatch("logout")
                  .then(() => this.$router.push("/login"))
                  .catch(err => console.log(err));
        }
    },
  }
</script>
