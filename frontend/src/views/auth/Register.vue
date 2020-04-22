<template>
  <v-app>
    <v-content>
      <v-container fluid>
        <v-row align="center" justify="center">
          <v-col cols="12" sm="8" md="4">
            <v-card>
              <v-toolbar color="primary" dark flat>
                <v-toolbar-title>Register</v-toolbar-title>
                <v-spacer/>
              </v-toolbar>
              <v-card-text>
                <v-form  class="register">
                  <v-text-field
                          v-model="email"
                          label="Email"
                          name="login"
                          required
                          type="email"
                          class="py-0"
                  />

                  <v-text-field
                          v-model="password"
                          id="password"
                          label="Password"
                          name="password"
                          required
                          type="password"
                  />
                  <v-text-field
                          v-model="password_confirmation"
                          id="password-confirm"
                          label="Confirm Password"
                          name="password-confirm"
                          required
                          type="password"
                  />
                </v-form>
              </v-card-text>
              <v-row align="center" justify="center">
                <v-col cols="12">
                  <v-card-actions>
                    <v-spacer/>
                    <v-btn @click="register" color="primary" style="margin-right: 0">Register</v-btn>
                    <v-spacer/>
                    <v-btn color="primary" style="margin-right: 7px" to="/login">Cancel</v-btn>
                  </v-card-actions>
                </v-col>
              </v-row>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
  </v-app>
</template>
<script>
export default {
  data() {
    return {
      name: "",
      email: "",
      password: "",
      password_confirmation: "",
      is_admin: null
    };
  },
  methods: {
    register: function() {
      let data = {
        email: this.email,
        password: this.password
      };
      this.$store
        .dispatch("register", data)
        .then(() => this.$router.push("/login"))
        .catch(err => console.log(err));
    }
  }
};
</script>