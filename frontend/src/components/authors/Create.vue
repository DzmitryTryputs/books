<template>
    <a-card title="Add Author" class="paper" :bordered="false">
        <a-form :form="form">
            <a-form-item label="First Name" :labelCol="{ span: 5 }" :wrapperCol="{ span: 12 }">
                <a-input v-decorator="['firstName', {
                           rules: [{ required: true, message: 'Please input Author First Name!'}]
                        }]" placeholder="Enter First Name of the Author"/>
            </a-form-item>
            <a-form-item label="Last Name" :labelCol="{ span: 5 }" :wrapperCol="{ span: 12 }">
                <a-input v-decorator="['lastName', {
                           rules: [{ required: true, message: 'Please input Author Last Name!'}]
                        }]" placeholder="Enter Last Name of the Author"/>
            </a-form-item>
            <a-form-item label="Date of Birth" :labelCol="{ span: 5 }" :wrapperCol="{ span: 12 }">
                <a-date-picker v-decorator="['dob']"/>
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
        name: "Create",
        data() {
            return {
                author: {
                    firstName: "",
                    lastName: "",
                    dob: ""
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
                        this.author.firstName = values.firstName;
                        this.author.lastName = values.lastName;
                        this.author.dob = values.dob;
                        axios.post("/backend/authors/add", this.author)
                            .then(() => this.$router.push({name: "authors"}))
                            .catch(error => {
                                this.$notification["error"]({
                                    message: "Error",
                                    description: error.message
                                });
                            });
                    }
                });
            }
        }
    }
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
