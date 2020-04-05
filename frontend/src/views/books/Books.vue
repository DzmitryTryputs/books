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
            <search-panel :rightDrawer="rightDrawer" @cancelSearch="cancelSearch" @searchData="searchBooks">
                <v-layout row>
                    <v-flex  offset-xs1 style="margin-left: 4%; margin-right: 4%">
                            <v-subheader style="font-size: 14px">Book Years range:</v-subheader>
                                        <v-range-slider
                                                v-model="yearsRange"
                                                :max="max"
                                                :min="min"
                                                step="1"
                                                hide-details
                                                class="align-center"
                                        >
                                            <template v-slot:prepend>
                                                <v-text-field
                                                        :value="yearsRange[0]"
                                                        class="mt-0 pt-0"
                                                        hide-details
                                                        single-line
                                                        type="number"
                                                        style="width: 60px"
                                                        @change="$set(yearsRange, 0, $event)"
                                                ></v-text-field>
                                            </template>
                                            <template v-slot:append>
                                                <v-text-field
                                                        :value="yearsRange[1]"
                                                        class="mt-0 pt-0"
                                                        hide-details
                                                        single-line
                                                        type="number"
                                                        style="width: 60px"
                                                        @change="$set(yearsRange, 1, $event)"
                                                ></v-text-field>
                                            </template>
                                        </v-range-slider>


                    </v-flex>
                </v-layout>
                <v-layout row>
                    <v-flex  offset-xs1 style="margin-left: 4%; margin-right: 4%">
                        <v-subheader style="font-size: 14px">Book Pages range:</v-subheader>
                        <v-range-slider
                                v-model="pagesRange"
                                :max="pageMax"
                                :min="min"
                                step="1"
                                hide-details
                                class="align-center"
                        >
                            <template v-slot:prepend>
                                <v-text-field
                                        :value="pagesRange[0]"
                                        class="mt-0 pt-0"
                                        hide-details
                                        single-line
                                        type="number"
                                        style="width: 60px"
                                        @change="$set(pagesRange, 0, $event)"
                                ></v-text-field>
                            </template>
                            <template v-slot:append>
                                <v-text-field
                                        :value="pagesRange[1]"
                                        class="mt-0 pt-0"
                                        hide-details
                                        single-line
                                        type="number"
                                        style="width: 60px"
                                        @change="$set(pagesRange, 1, $event)"
                                ></v-text-field>
                            </template>
                        </v-range-slider>


                    </v-flex>
                </v-layout>
                <v-layout row>
                    <v-flex  offset-xs1 style="margin-left: 4%; margin-right: 4%">
                        <v-subheader style="font-size: 14px">Authors:</v-subheader>

                        <v-select class="purple-input" chips multiple :items="authors" item-text="firstName"
                                  item-value="id"  v-model="search.authors" return-object style="padding-top: 0">
                            <template slot="item" slot-scope="data">
                                {{ data.item.firstName }} {{ data.item.lastName }}
                            </template>
                            <template v-slot:selection="{ item, index }">
                                <v-chip>
                                    <span>{{ item.firstName }} {{ item.lastName }}</span>
                                </v-chip>
                            </template>
                        </v-select>
                    </v-flex>
                </v-layout>
                <v-layout row>
                    <v-flex  offset-xs1 style="margin-left: 4%; margin-right: 4%">
                        <v-subheader style="font-size: 14px">Genres:</v-subheader>
                        <v-select class="purple-input" chips multiple :items="genres" item-text="name" item-value="id" style="padding-top: 0"
                                   v-model="search.genres" return-object />
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
                genres:[],
                authors:[],
                loading: false,
                rightDrawer: false,
                min: 1,
                max: 2100,
                pageMax:3000,
                slider: 40,
                yearsRange: [1, 2100],
                pagesRange: [1, 3000],
                search: {
                    yearFrom:1,
                    yearTo:2100,
                    pagesFrom:1,
                    pagesTo:3100,
                    genres:[],
                    authors:[]
                }
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
            async getAllGenres() {
                axios.get('/backend/genres')
                    .then(response => {
                        this.genres = response.data;
                    });
            },
            async getAllAuthors() {
                axios.get('/backend/authors')
                    .then(response => {
                        this.authors = response.data;
                    });
            },
            searchBooks () {
                this.rightDrawer = !this.rightDrawer;
                this.loading = true;
                this.search.yearFrom = this.yearsRange[0];
                this.search.yearTo = this.yearsRange[1];
                this.search.pagesFrom = this.pagesRange[0];
                this.search.pagesTo = this.pagesRange[1];
                axios.post('backend/books/search', this.search)
                    .then(response => {
                        this.books = response.data;
                    });
                this.loading = false;
            },
            cancelSearch () {
                this.rightDrawer = false;
            }
        },
        mounted() {
            this.getAllBooks();
            this.getAllAuthors();
            this.getAllGenres();
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