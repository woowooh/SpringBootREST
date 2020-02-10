<template>
    <div id="blog-post">
        <h2 class="blog-post-title">{{ blog.title }}</h2>
        <p class="blog-post-meta">January 1, 2014 by <a href="#">Mark</a></p>
        <hr>
        <div class="blog-content" v-html="blog.contentHTML">            
        </div>
        <p>作者: {{ blog.authorName }}</p>
    </div>
</template>

<script>
export default {
    name: "blog-detail",
    props: {
        blog: {
            type: Object,
            default: ()=> ({})
        },
    },
}
</script>