<template>
	<div class="container">
		<div class="row">
			<div class="col-sm-8 blog-main">
					<blog-detail :blog="blog" />
					<comment-list :comments="comments"/>
					<comment-box @postComment="postComment" :comment="comment" /> 		
			</div>
			<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
          </div>
          <div class="sidebar-module">
            <h4>Archives</h4>
            <ol class="list-unstyled">
              <li><a href="#">March 2014</a></li>
              <li><a href="#">February 2014</a></li>
              <li><a href="#">January 2014</a></li>
              <li><a href="#">December 2013</a></li>
              <li><a href="#">November 2013</a></li>
              <li><a href="#">October 2013</a></li>
              <li><a href="#">September 2013</a></li>
              <li><a href="#">August 2013</a></li>
              <li><a href="#">July 2013</a></li>
              <li><a href="#">June 2013</a></li>
              <li><a href="#">May 2013</a></li>
              <li><a href="#">April 2013</a></li>
            </ol>
          </div>
          <div class="sidebar-module">
            <h4>Elsewhere</h4>
            <ol class="list-unstyled">
              <li><a href="#">GitHub</a></li>
              <li><a href="#">Twitter</a></li>
              <li><a href="#">Facebook</a></li>
            </ol>
          </div>
        </div>
		</div>
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
.container {
  padding: 60px 15px 0;
}

.blog-main {
  font-size: 18px;
  line-height: 1.5;
}

.blog-sidebar {
  text-align: left;
}

.sidebar-module {
  padding: 15px;
  margin: 0 -15px 15px;
}
.sidebar-module-inset {
  padding: 15px;
  background-color: #f5f5f5;
  border-radius: 4px;
}
.sidebar-module-inset p:last-child,
.sidebar-module-inset ul:last-child,
.sidebar-module-inset ol:last-child {
  margin-bottom: 0;
}

</style>