<template>
    <v-container id="addAuthor" fluid tag="section" >
        <v-card class="v-card--material pa-3 px-5 py-3">
            <div class="d-flex grow flex-wrap">
                <v-sheet
                        :color="'primary'"
                        :max-height="icon ? 90 : undefined"
                        :width="icon ? 'auto' : '100%'"
                        elevation="6"
                        class="pa-7 text-start v-card--material__heading mb-n6"
                        dark><v-icon size="32" v-text="icon"/>
                </v-sheet>
                <div class="ml-6" style="width: 85%">
                    <div class="card-title font-weight-light" v-text="title" />
                    <div class="subtitle-1 font-weight-light">
                        Populate Author information
                    </div>
                </div>
                <div style="align-self: center;">
                    <v-btn class="mt-n2" elevation="1" fab small color="primary" style="float:right;"  @click.native="cancel">
                        <v-icon>mdi-cancel</v-icon>
                    </v-btn>
                    <v-btn class="mt-n2" elevation="1" fab small color="primary" style="float:right;"  @click.native="save">
                        <v-icon>mdi-content-save</v-icon>
                    </v-btn>
                </div>
            </div>

            <slot />

            <v-form>
                <v-container class="py-0">
                    <v-text-field class="purple-input" name="firstName" label="First Name" hint="Enter First Name" value="Input text" v-model="author.firstName" />
                    <v-text-field class="purple-input" name="lastName" label="Last Name" hint="Enter Last Name" value="Input text" v-model="author.lastName" />
                    <v-menu
                            ref="menu"
                            v-model="menu"
                            :close-on-content-click="false"
                            :return-value.sync="author.dob"
                            offset-y
                            min-width="290px"
                    >
                        <template v-slot:activator="{ on }">
                            <v-text-field v-model="author.dob" label="Date of Birth" readonly v-on="on" />
                        </template>
                        <v-date-picker v-model="date" min="1" scrollable show-current="false" style="margin-top: 0; margin-bottom: 0">
                            <v-btn text color="primary" @click="this.menu = false">Cancel</v-btn>
                            <v-btn text color="primary" @click="clearCalendar">Clear</v-btn>
                            <v-btn text color="primary" @click="$refs.menu.save(date)">OK</v-btn>
                        </v-date-picker>
                    </v-menu>

                </v-container>
            </v-form>
        </v-card>
    </v-container>
</template>

<script>
    import axios from "axios";

    export default {
        name: "CreateAuthor",
        components: {
        },
        data() {
            return {
                author: {
                    firstName: "",
                    lastName: "",
                    dob: ""
                },
                date: new Date().toISOString().substr(0, 10),
                menu: false,
                modal: false,
                menu2: false,
                loading: false
            };
        },
        props: {
            color: {
                type: String,
                default: 'primary',
            },
            icon: {
                type: String,
                default: 'mdi-account-group',
            },

            title: {
                type: String,
                default: 'Add Author',
            },

        },
        methods: {
            save() {
                axios.post("/backend/authors/add", this.author)
                    .then(() => this.$router.push("/authors"));
            },

            cancel() {
                this.$router.push("/authors");
            },

            clearCalendar() {
                this.date = null;
                $refs.menu.save(this.date);
                this.menu = false;
            }
        }
    };
</script>

<style lang="sass">
    .v-card--material
        &__heading
            position: relative
            top: -40px
            transition: .3s ease
            z-index: 1
</style>