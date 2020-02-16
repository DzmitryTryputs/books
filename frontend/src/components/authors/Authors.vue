<template>
    <div>
        <a-row type="flex">
            <a-col :span="12">
                <h1>Authors</h1>
            </a-col>
            <a-col :span="12">
                <router-link
                        class="ant-btn ant-btn-primary"
                        style="float:right;"
                        to="/authors/create"
                >Add Author</router-link>
            </a-col>
        </a-row>
        <a-row>
            <list/>
        </a-row>
    </div>
</template>

<script>
    import List from "@/components/authors/List";
    export default {
        components: {
            List
        }
    };
</script>
