<template>
  <div class="card-background">
    <template v-if="loading">
      <a-spin tip="Loading...">
        <a-skeleton :paragraph="{rows: 10}"/>
      </a-spin>
    </template>
    <template v-else>
      <a-table :columns="columns" :dataSource="books" />
    </template>
  </div>
</template>

<script>
import axios from "axios";

const columns = [
  {
    dataIndex: "id",
    title: "Number",
    key: "book_number",
    width: "10%"
  },
  {
    dataIndex: "title",
    title: "Book Title",
    key: "book.title",
    width: "60%"
  },
  {
    title: "Author",
    dataIndex: "authors",
    key: "book.author",
    width: "15%",
  }
];

export default {
  name: "BooksList",
  data() {
    return {
      columns: columns,
      books: [],
      loading: false
    };
  },
  methods: {
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

