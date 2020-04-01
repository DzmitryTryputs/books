<template>
    <v-container id="books" fluid tag="section">
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
                        <th scope="col">Book Title</th>
                        <th scope="col">Year</th>
                        <th scope="col">Pages</th>
                        <th scope="col">Genres</th>
                        <th scope="col">Authors</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="(book, index) in books" :key="index">
                        <td>{{book.id}}</td>
                        <td>{{book.title}}</td>
                        <td>{{book.year}}</td>
                        <td>{{book.pages}}</td>
                        <td>{{concatGenres(book.genres)}}</td>
                        <td>{{concatAuthorNames(book.authors)}}</td>
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

    export default {
        name: "BooksList",
        components: {
            SearchPanel
        },
        data() {
            return {
                books: [],
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
                default: 'mdi-book-open-variant',
            },

            title: {
                type: String,
                default: 'Books',
            },

        },
        methods: {
            add () {
                this.$router.push("/books/create");
            },
            concatAuthorNames(authors) {
                return authors.map(function(author) {
                    return author.firstName + " " + author.lastName;
                }).join(", ");
            },
            concatGenres(genres) {
                return genres.map(function(genre) {
                    return genre.name;
                }).join(", ");
            },
            async getAllBooks() {
                this.loading = true;
                axios.get('backend/books')
                    .then(response => {
                        this.books = response.data;
                    });
                this.loading = false;
            },
            searchProducts () {
                this.rightDrawer = !this.rightDrawer;

            },
            cancelSearch () {
                this.rightDrawer = false;
            }
        },
        mounted() {
            this.getAllBooks();
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