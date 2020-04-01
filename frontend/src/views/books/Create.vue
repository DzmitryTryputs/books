<template>
    <v-container id="addBook" fluid tag="section" >
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
                        Populate Book information
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
                    <v-text-field class="purple-input" name="title" label="Title" hint="Enter book Title" value="Input text" v-model="book.title" required/>
                    <v-text-field class="purple-input" label="Year" name="year" type="number" hint="Enter Year of the Book" v-model="book.year" />
                    <v-text-field class="purple-input" label="Pages" name="pages" type="number" hint="Enter Pages count of the Book" v-model="book.pages"/>
                    <v-select class="purple-input" chips multiple :items="genres" item-text="name" item-value="id" label="Genres" v-model="book.genres" return-object />
                    <v-select class="purple-input" chips multiple :items="authors" item-text="firstName" item-value="id" label="Authors" v-model="book.authors" return-object>
                        <template slot="item" slot-scope="data">
                            {{ data.item.firstName }} {{ data.item.lastName }}
                        </template>
                        <template v-slot:selection="{ item, index }">
                            <v-chip>
                                <span>{{ item.firstName }} {{ item.lastName }}</span>
                            </v-chip>
                        </template>
                        </v-select>
                </v-container>
            </v-form>
        </v-card>
    </v-container>
</template>

<script>
    import axios from "axios";

    export default {
        name: "CreateBook",
        components: {
        },
        data() {
            return {
                genres: [],
                authors: [],
                book: {
                    title: "",
                    year: "",
                    pages: "",
                    genres: [],
                    authors: []
                },
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
                default: 'mdi-book-open-variant',
            },

            title: {
                type: String,
                default: 'Create Book',
            },

        },
        methods: {
            save() {
                axios.post("/backend/books/add", this.book)
                    .then(() => this.$router.push("/books"));
            },

            cancel() {
                this.$router.push("/books");
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
            }
        },
        mounted: function () {
            this.getAllGenres();
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