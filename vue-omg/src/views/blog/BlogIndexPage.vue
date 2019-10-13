<template>
  <blog-list :blogs="blogs" />
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
      this.blogs = res.data;        
    })
  },
  components: {
    BlogList,
  }
}
</script>
