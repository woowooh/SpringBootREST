<template>
  <div class="add-blog">
    <h2>添加博客</h2>
    <transition name="fade">
      <div id="editor" v-show="editComment">
        <mavon-editor style="height: 100%; border-radius: 7px"        
          :subfield="false"
          :placeholder="'...'"
          :fontSize="'14'"
          @save="save"
          v-model="blog.content"
        ></mavon-editor>  
      </div>  
    </transition>
    <button @click.prevent="addComment">添加评论</button>  
    <button @click.prevent="submit">发布</button>  
  </div>  
</template>

<script>
import axios from 'axios'
import { mavonEditor } from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

export default {
  // https://jsonplaceholder.typicode.com
  name: "addBlog",
  data() {
    return {
      blog: {
        title: "",
        content: "",
        categories: [],
        author: "",        
      },
      authors: {
        names: ["xf", "www", "Q v Q"],
      },
      submited: false,
      editComment: false,
    }
  },
  methods: {
    submit: function() {
      console.log(this.blog.content)
    },
    addComment: function() {
      console.log("workd")
      this.editComment = !this.editComment
    },
    save: function(value, render) {
      console.log("value", value)
      console.log("render", render)
    }
  },
  components: {
    mavonEditor,
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#add-blog *{
  box-sizing: border-box;
}
#editor {
    margin: auto;
    width: 61.8%;
    height: 430px;
}

#add-blog{
  margin: 20px auto;
  max-width: 600px;
  padding: 20px;
}

.fade-enter-active, .fade-leave-active {
  transition: opacity .4s;
}

.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}

label{
  display: block;
  margin: 20px 0 10px;
}

input[type="text"],textarea,select{
  display: block;
  width: 100%;
  padding: 8px;
}

textarea{
  height: 200px;
}

#checkboxes label{
  display: inline-block;
  margin-top: 0;
}

#checkboxes input{
  display: inline-block;
  margin-right: 10px;
}

button{
  display: block;
  margin: 20px 0;
  background: crimson;
  color: #fff;
  border: 0;
  padding: 14px;
  border-radius: 4px;
  font-size: 18px;
  cursor: pointer;
}

#preview{
  padding: 10px 20px;
  border: 1px dotted #ccc;
  margin: 30px 0;
}

h3{
  margin-top: 10px;
}

</style>
