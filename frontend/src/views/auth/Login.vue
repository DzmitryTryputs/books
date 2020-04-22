<template>
    <v-app>
        <v-content>
            <v-container fluid>
                <v-row align="center" justify="center">
                    <v-col cols="12" sm="8" md="4">
                        <v-card>
                            <v-toolbar color="primary" dark flat>
                                <v-toolbar-title>Books Application</v-toolbar-title>
                                <v-spacer/>
                            </v-toolbar>
                            <v-card-text>
                                <v-form  class="login">
                                    <v-text-field
                                            v-model="email"

                                            label="Email"
                                            name="email"
                                            prepend-icon="mdi-account"
                                            type="email"
                                            class="py-0"
                                    />

                                    <v-text-field
                                            v-model="password"
                                            id="password"
                                            label="Password"
                                            name="password"
                                            prepend-icon="mdi-lock"
                                            type="password"
                                    />
                                </v-form>
                            </v-card-text>
                            <v-row align="center" justify="center">
                                <v-col cols="12">
                                    <v-card-actions>
                                        <v-spacer/>
                                        <v-btn @click="login" color="primary" style="margin-right: 0">Login</v-btn>
                                        <v-spacer/>
                                        <v-btn color="primary" style="margin-right: 7px" to="/register">Register</v-btn>
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
                email: "",
                password: ""
            };
        },
        methods: {
            login: function () {
                let email = this.email;
                let password = this.password;
                this.$store
                    .dispatch("login", {email, password})
                    .then(() => this.$router.push("/"))
                    .catch(err => console.log(err));
            }
        }
    };
</script>