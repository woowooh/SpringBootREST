<template>
  <div class="container">
    <div class="page-header" style="padding-top: 30px">
      <button class="btn btn-outline-dark pull-right" v-on:click="jumpBlogAdd">Add Blog</button>						
    </div>
    <div class="page-header">
      <blog-list :blogs="blogs" />
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import BlogList from "./components/BlogList"

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
      console.log(data)
      console.log(typeof(data))
      this.blogs = data;        
    })
  },
  methods: {
    jumpBlogAdd: function() {
      this.$router.push({path: "/add"})
    }
  },
  components: {
    BlogList,
  }
}
</script>
<style>
  button {
    color: green;
    margin-right: 40px;
  }
  /* Sticky footer styles
-------------------------------------------------- */
html {
  position: relative;
  min-height: 100%;
}
body {
  /* Margin bottom by footer height */
  margin-bottom: 60px;
}
.footer {
  position: absolute;
  bottom: 0;
  width: 100%;
  /* Set the fixed height of the footer here */
  height: 60px;
  background-color: #f5f5f5;
}

.container .text-muted {
  margin: 20px 0;
}

</style>
