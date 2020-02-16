<template>
    <a-card title="Add Book" class="paper" :bordered="false">
        <a-form :form="form">
            <a-form-item label="Title" :labelCol="{ span: 5 }" :wrapperCol="{ span: 12 }">
                <a-input v-decorator="['title', {
                           rules: [{ required: true, message: 'Please input Book Title!'}]
                        }]" placeholder="Enter Book Title"/>
            </a-form-item>
            <a-form-item label="Year" :labelCol="{ span: 5 }" :wrapperCol="{ span: 12 }">
                <a-input-number style="width: 100%;" :min="1" :step="1" v-decorator="['year']"
                                placeholder="Enter Year of the Book"/>
            </a-form-item>
            <a-form-item label="Book Pages" :labelCol="{ span: 5 }" :wrapperCol="{ span: 12 }">
                <a-input-number style="width: 100%;" :min="1" :step="1" v-decorator="['pages']"
                                placeholder="Enter Pages count of the Book"/>
            </a-form-item>
            <a-form-item label="Genres" :labelCol="{ span: 5 }" :wrapperCol="{ span: 12 }">
                <a-select mode="multiple"
                          v-decorator="['genres_id']"
                          showSearch
                          placeholder="Select a country">
                    <a-select-option v-for="(genre, index) in genres" :key="index" :value="genre.id">{{genre.name}}
                    </a-select-option>
                </a-select>
            </a-form-item>
            <a-form-item label="Authors" :labelCol="{ span: 5 }" :wrapperCol="{ span: 12 }">
                <a-select mode="multiple"
                    v-decorator="['authors_id']"
                    showSearch
                    placeholder="Select a country">
                    <a-select-option v-for="(author, index) in authors" :key="index" :value="author.id">
                        {{concatAuthorName(author)}}
                    </a-select-option>
                </a-select>
            </a-form-item>
            <div>
                <a class="ant-btn ant-btn-default" @click="$router.go(-1)">Cancel</a>
                <a-form-item style="float:right;">
                    <a-button type="primary" @click="handleSubmit">Add</a-button>
                </a-form-item>
            </div>
        </a-form>
    </a-card>
</template>
<script>

    import axios from "axios";

    export default {
        name: "CreateBook",
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
                genre: {
                    id:""
                },
                author: {
                    id:""
                }

            };
        },
        beforeCreate() {
            this.form = this.$form.createForm(this, {name: 'form'});
        },
        methods: {
            handleSubmit() {
                this.form.validateFields((err, values) => {
                    if (!err) {
                        this.book.title = values.title;
                        this.book.year = values.year;
                        this.book.pages = values.pages;
                        this.book.genres = this.prepareGenres(values.genres_id);
                        this.book.authors = this.prepareAuthors(values.authors_id);
                        axios.post("/backend/books/add", this.book)
                            .then(() => this.$router.push({name: "books"}))
                            .catch(error => {
                                this.$notification["error"]({
                                    message: "Error",
                                    description: error.message
                                });
                            });
                    }
                });
            },
            prepareGenres: function (genres_id) {
                let genres = [];
                for (let i = 0; i < genres_id.length; ++i) {
                    let genre = {
                        id: "",
                    };
                    genre.id = genres_id[i];
                    genres.push(genre);
                }
                return genres;
            },
            prepareAuthors: function (authors_id) {
                let authors = [];
                for (let i = 0; i < authors_id.length; ++i) {
                    let author = {
                        id: "",
                    };
                    author.id = authors_id[i];
                    authors.push(author);
                }
                return authors;
            },
            concatAuthorName(author) {
                return author.firstName + " " + author.lastName;
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

<style lang="scss" scoped>
    .paper {
        background: #fff;
        box-shadow: /* The top layer shadow */
                0 -1px 1px rgba(0, 0, 0, 0.15),
                    /* The second layer */
                0 -10px 0 -5px #eee,
                    /* The second layer shadow */
                0 -10px 1px -4px rgba(0, 0, 0, 0.15),
                    /* The third layer */
                0 -20px 0 -10px #eee,
                    /* The third layer shadow */
                0 -20px 1px -9px rgba(0, 0, 0, 0.15);
        padding: 30px;
    }
</style>