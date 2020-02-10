<template>
  <div class="row">
        <div class="col-xs-6 col-sm-3" v-for="(blog, index) in blogs" :key=index >
          <div class="thumbnail">
                <router-link v-bind:to="'/blog/' + blog.id" >
                <img :src=blog.imgPath alt="Card image cap" style="height: 200px; width: 100%; display: block;">
                </router-link>
                <div class="caption">
                <h3 >
                    <router-link v-bind:to="'/blog/' + blog.id" class="blog-title">
                        {{ blog.title }}
                    </router-link>
                </h3>
                <p >{{ blog.content }}</p>
                <small >Published by {{ blog.authorName }} 3 mins ago</small>
                <router-link v-bind:to="'/blog/' + blog.id">
                <p>Read More </p>
                </router-link>
              </div>
          </div>
        </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
    name: "blog-list",
    data(){
        return {}
    },
    props: {
        blogs: [],
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
<style scoped>
    .blog-title {
        color: #343a40;
    }
</style>
