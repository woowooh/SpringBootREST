<template>
    <div class="commentList">
			<ul class="comments">
				<li v-for="(comment, index) in comments" :key="index">
					<div class="comment">
						<p>{{ comment.words }}<p>
						<p>{{ comment.wordsHTML}}</p>
					</div>
				</li>
			</ul>
		</div>
</template>

<script>
export default {
    name: "comment-list",
    props: {
        comments: {            
        },
    }
}
</script>