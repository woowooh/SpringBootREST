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
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(blog, index) in blogs" :key=index >
                <th scope="row">{{ index + 1}}</th>
                <td>{{ blog.title }}</td>
                <td>{{ blog.content }}</td>
                <td>{{ blog.authorName }}</td>
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
            blogs: [],
        }
    },
    created(){    
        var path = "http://localhost:8082/blogList"
        axios.get(path)
        .then(res => {
        let data = res.data;      
        for (let i = 0; i < data.length; i++) {
            let j = i % 12
            data[i].imgPath = `./../static/imgs/${j}.jpg`;
        }  
        this.blogs = res.data;        
        })
    },
}
</script>

<style>
.blog-main {
    text-align: left;
}
</style>