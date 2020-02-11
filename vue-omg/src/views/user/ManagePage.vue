<template>
    <div class="row">
    <div class="col-sm-8 col-sm-offset-2 blog-main">
        <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">Panel heading</div>
        <div class="panel-body">
            <p>Some default panel content here. Nulla vitae elit libero, a pharetra augue. Aenean lacinia bibendum nulla sed consectetur. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
        </div>

        <!-- Table -->
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Account</th>
                <th>Add Time</th>
                <th>Last modify</th>
                <th>Operation</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(user, index) in users" :key=index >
                <th scope="row">{{ index + 1}}</th>
                <td>{{ user.account }}</td>
                <td>{{ user.createTime }}</td>
                <td>{{ user.updateTime }}</td>
                <td><button class="btn btn-default" @click.prevent="diasble">disable</button></td>
            </tr>
            </tbody>
        </table>
        </div>
        </div>
    </div>
</template>


<script>
import axios from 'axios'

export default {
    name: "manage-page",
    data(){
        return {
            users: [],
        }
    },
    methods: {
        diasble: function() {
            var path = "http://localhost:8082/user/disable"
            axios.post(path, {}).then(res => {          
                
            }) 
        }
    },
    created(){    
        var path = "http://localhost:8082/user/userList"
        axios.get(path).then(res => {
            this.users = res.data.data;        
        })
    },
}
</script>

<style>
.blog-main {
    text-align: left;
}
</style>