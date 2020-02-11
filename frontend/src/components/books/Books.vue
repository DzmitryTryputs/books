<template>
    <div>
        <a-row type="flex">
            <a-col :span="12">
                <h1>Books</h1>
            </a-col>
        </a-row>
        <a-row>
            <list/>
        </a-row>
    </div>
</template>

<script>
    import List from "@/components/books/List";
    export default {
        components: {
            List
        }
    };
</script>
