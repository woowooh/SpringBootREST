<template>
  <div class="container" style="background-color: #E8E5E4">
    <div class="row">
      <div class="blogs" v-for="(blog, index) in blogs" :key=index>
          <div class="card text" style="width: 15rem;">
              <img class="card-img-top" :src=blog.imgPath alt="Card image cap" height="">
              <div class="card-body">
                  <h4 class="card-title">{{ blog.title }}</h4>
                  <p class="card-text">{{ blog.content }}</p>
                  <small class="text-muted">Published by {{ blog.authorName }} 3 mins ago</small>
                  <router-link v-bind:to="'/blog/' + blog.blogId" class="btn btn-outline-dark btn-sm pull-right">
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
  data(){
    return {
      blogs:[],
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
