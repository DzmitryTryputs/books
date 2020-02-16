<template>
    <div class="card-background">
        <a-card title="Authors" :bordered="false">
            <a-table :dataSource="authors">
                <a-table-column title="Id" dataIndex="id" key="id" width="5%"/>
                <a-table-column title="First Name" dataIndex="firstName" key="firstName" width="10%"/>
                <a-table-column title="Last Name" dataIndex="lastName" key="lastName" width="10%"/>
                <a-table-column title="Date of Birth" dataIndex="dob" key="dob" width="5%">
                  <template slot-scope="dob">
                      <div>{{toDate(dob)}}</div>
                  </template>
                </a-table-column>
            </a-table>
        </a-card>
    </div>
</template>

<script>
    import axios from "axios";
    import moment from "moment";

    export default {
        name: "AuthorsList",
        data() {
            return {
                authors: [],
                loading: false
            };
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
            }
        },
        mounted() {
            this.getAllAuthors();
        }
    };
</script>

<style lang="scss" scoped>
    .ant-skeleton {
        margin: 30px;
    }
</style>

