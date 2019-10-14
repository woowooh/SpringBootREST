<template>
    <div id="single-blog">
        <h1>{{ blog.title }}</h1>
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