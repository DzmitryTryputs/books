<template>
  <div class="card-background">
    <template v-if="loading">
      <a-spin tip="Loading...">
        <a-skeleton :paragraph="{rows: 10}"/>
      </a-spin>
    </template>
    <template v-else>
      <a-table :dataSource="books" key="id">
        <a-table-column title="Number" dataIndex="id" key="id" width="5%"/>
        <a-table-column title="Book Title" dataIndex="title" key="title" width="30%"/>
        <a-table-column title="Year" dataIndex="year" key="year" width="5%"/>
        <a-table-column title="Pages" dataIndex="pages" key="pages" width="5%"/>
        <a-table-column title="Genres" dataIndex="genres" key="genres" width="20%">
          <template slot-scope="genres">
            <span>
              <div>{{concatGenres(genres)}}</div>
            </span>
          </template>
        </a-table-column>
        <a-table-column title="Authors" dataIndex="authors" key="authors" width="30%">
          <template slot-scope="authors">
            <div>{{concatAuthorNames(authors)}}</div>
          </template>
        </a-table-column>
      </a-table>
    </template>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "BooksList",
  data() {
    return {
      books: [],
      loading: false
    };
  },
  methods: {
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
    async getAllInvoices() {
      this.loading = true;
      axios.get('backend/books')
              .then(response => {
                this.books = response.data;
              });
      this.loading = false;
    }
  },
  mounted() {
    this.getAllInvoices();
  }
};
</script>

<style lang="scss" scoped>
.ant-skeleton {
  margin: 30px;
}
</style>

