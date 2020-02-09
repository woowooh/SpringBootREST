<template>
  <div class="blogListContainer" style="background-color: #E8E5E4">
    <div class="row">
      <div class="blogs" v-for="(blog, index) in blogs" :key=index>
          <div class="card text" style="width: 15rem;">
              <img class="card-img-top" :src=blog.imgPath alt="Card image cap" height="">
              <div class="card-body">
                <h4 class="card-title">
                    <router-link v-bind:to="'/blog/' + blog.id" class="blog-title">
                        {{ blog.title }}
                    </router-link>
                </h4>
                <p class="card-text">{{ blog.content }}</p>
                <small class="text-muted">Published by {{ blog.authorName }} 3 mins ago</small>
                <router-link v-bind:to="'/blog/' + blog.id" class="btn btn-outline-dark btn-sm pull-right">
                Read More 
                <i class="fa fa-arrow-right" aria-hidden="true"></i>                    
                </router-link>
              </div>
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
        blogs: {

        },
    }
}
</script>
<style scoped>
    .blog-title {
        color: #343a40;
    }
</style>
