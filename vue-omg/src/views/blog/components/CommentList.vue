<template>
    <div class="commentList" style="width: 68%; margin: 0 auto; width: 68%;">
			<div class="comments">
				<div v-for="(comment, index) in filteredComments" :key="index">					
					<div class="comment" v-if="comment.wordsHTML" style="clear: both">	
						<div class="comment-box">
							<div v-html="comment.wordsHTML" >								
							</div>							
							<button class="btn btn-outline-dark btn-sm pull-right" v-on:click="deleteComment(comment.id)">Delete it</button>						
						</div>					
					</div>
				</div>
			</div>
		</div>
</template>

<script>
import axios from 'axios'

export default {
	name: "comment-list",
	data() {
		return {
			comment: {},
			filteredComments: "",
		}
	},
    props: {
		comments: {
			type: Array,
		}
	},
	methods: {
		deleteComment: function(commentId) {
			var path = "http://localhost:8082/deleteComment/" + commentId
			axios.get(path)
				.then(res => {					
					this.filterComments(commentId)									
				})						
		},
		filterComments(commentId) {
			this.filteredComments = this.filteredComments.filter(comment => comment.id !== commentId)								
		}		
	},
	watch:{
   		comments(newValue,oldValue) {
    		this.filteredComments = newValue
		},
	},
}
</script>
<style scoped>
a {
	color: #343a40;
}
button {
	color: red;
}
</style>