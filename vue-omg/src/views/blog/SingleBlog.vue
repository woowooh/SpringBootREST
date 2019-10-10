<template>
	<div id="container">
		<div id="single-blog">
			<h1>{{blog.title}}</h1>
			<article>{{blog.content}}</article>
			<p>作者: {{blog.authorName}}</p>
		</div>
		<div id="single-blog">
			<ul class="comments">
				<li v-for="(comment, index) in comments" :key="index">
				</li>
			</ul>
			<h1>{{blog.title}}</h1>
			<p>作者: {{blog.authorName}}</p>
		</div>
		<transition name="fade">
      	<div id="editor" v-show="editComment">
			<mavon-editor ref="editor" style="height: 10px;border-radius: 7px"        
			:subfield="false"
			:placeholder="'...'"
			:fontSize="'14'" 
			:toolbarsFlag=false
			v-model="blog.content"
			>
        	</mavon-editor>  
      	</div>  
    	</transition>
		<br>
		<button class="btn btn-outline-dark btn-sm" @click.prevent="addComment">添加评论</button>  
    	<button class="btn btn-outline-dark btn-sm" @click.prevent="submit">发布</button>  
	</div>
</template>

<script>
import axios from 'axios'
	export default{
		name:"single-blog",
		data(){
			return{
				id:this.$route.params.id,
				blog:{},
				editComment: false,
				comments: {},
			}
		},
		created(){
			var id = this.$route.params.id
			var path = "http://localhost:8082/blog/" +  id
			axios.get(path)
			.then(res => {
				this.blog = res.data.data;         
			})
		},
		methods: {
			submit: function() {    
			var path = 'http://localhost:8082/addBlog'
				// axios.post(path, this.blog)
				//   .then(res => {
				//     console.log(res);
				//   })
			},
			addComment: function() {
				console.log("workd")
				this.editComment = !this.editComment
    		},
		}
	}
</script>
<style scoped>

#single-blog{
	max-width: 960px;
	margin: 0 auto;
	padding: 20px;
	background: #eee;
	border: 1px dotted #aaa;
}

#editor {
    margin: auto;
    width: 45%;    
	/* height: 10px; */
}
</style>