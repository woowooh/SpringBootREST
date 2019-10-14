<template>
	<div id="container">
		<blog-detail :blog="blog" />
		<comment-list :comments="comments"/>
		<comment-box @postComment="postComment" :comment="comment" /> 		
	</div>
</template>

<script>
import axios from 'axios'
import CommentBox  from "./components/CommentBox"
import CommentList from "./components/CommentList"
import BlogDetail from "./components/BlogDetail"

export default{
	name:"blog-detail-page",
	data(){
		return{				
			blog: {				
			},
			comment: {	
				blogId: this.$route.params.id,
				words: "",
				wordsHTML: "", 
			},			
			comments: [],
		}
	},
	created(){
		var blogId = this.$route.params.id
		this.getBlog(blogId)
		this.getBlogComments(blogId)
	},
	methods: {
		postComment: function() {  
			var path = 'http://localhost:8082/addComment'		
			axios.post(path, this.comment)
				.then(res => {
					this.getBlogComments(this.blog.id)					
					this.resetInput()					
				})					
		},

		getBlog: function(blogId) {				
			var path = "http://localhost:8082/blog/" +  blogId
			axios.get(path)
			.then(res => {
				var d = res.data.data;
				this.blog = d || this.blog     
			})
		},
		getBlogComments: function(blogId) {			
			var path = "http://localhost:8082/Comments/" +  blogId
			axios.get(path)
			.then(res => {
				this.comments = res.data.data;  							     
			})
		},
		resetInput: function() {
			this.comment.words = ""
			this.comment.wordsHTML = ""
		}
	},
	components: {
		CommentBox,
		CommentList,
		BlogDetail,		
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
</style>