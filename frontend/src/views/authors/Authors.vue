<template>
    <v-container id="authors" fluid tag="section">
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
                </div>
                <div style="align-self: center;">
                    <v-btn class="mt-n2" elevation="1" fab small color="primary" style="float:right;" @click.native.stop="rightDrawer = !rightDrawer">
                        <v-icon>mdi-magnify</v-icon>
                    </v-btn>

                    <v-btn class="mt-n2" elevation="1" fab small color="primary" style="float:right;"  @click.native="add">
                        <v-icon>mdi-plus</v-icon>
                    </v-btn>
                </div>
            </div>

            <slot />

            <v-simple-table>
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Date of Birth</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="(author, index) in authors" :key="index">
                    <td>{{author.id}}</td>
                    <td>{{author.firstName}}</td>
                    <td>{{author.lastName}}</td>
                    <td>{{toDate(author.dob)}}</td>
                </tr>
                </tbody>

            </v-simple-table>

        </v-card>

        <template>
            <search-panel :rightDrawer="rightDrawer" @cancelSearch="cancelSearch" @searchData="searchProducts">
                <v-layout row>
                    <v-flex xs11 offset-xs1>
                        <v-text-field name="productName" label="Product" light ></v-text-field>
                    </v-flex>
                </v-layout>
                <v-layout row>
                    <v-flex xs11 offset-xs1>

                    </v-flex>
                </v-layout>
                <v-layout row>
                    <v-flex xs8 offset-xs1>

                    </v-flex>
                    <v-flex xs3>

                    </v-flex>
                </v-layout>
                <v-layout row>
                    <v-flex xs8 offset-xs1>

                    </v-flex>
                    <v-flex xs3>

                    </v-flex>
                </v-layout>
            </search-panel>
        </template>
    </v-container>
</template>

<script>
    import axios from "axios";
    import SearchPanel from "@/components/base/SearchPanel.vue";
    import moment from "moment";

    export default {
        name: "AuthorsList",
        components: {
            SearchPanel
        },
        data() {
            return {
                authors: [],
                loading: false,
                rightDrawer: false
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
                default: 'Authors',
            },

        },
        methods: {
            toDate(dob) {
                if (moment(dob).isValid()) {
                    return moment(dob).format("D MMM YYYY");
                } else {
                    return "";
                }
            },
            async getAllAuthors() {
                this.loading = true;
                axios.get('backend/authors')
                    .then(response => {
                        this.authors = response.data;
                    });
                this.loading = false;
            },
            add () {
                this.$router.push("/authors/create");
            },
            searchProducts () {
                this.rightDrawer = !this.rightDrawer;

            },
            cancelSearch () {
                this.rightDrawer = false;
            }
        },
        mounted() {
            this.getAllAuthors();
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