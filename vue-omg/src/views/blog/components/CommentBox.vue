<template>
    <div class="commentBox">
        <transition name="fade">
            <div id="editor" v-show="editComment">
                <mavon-editor ref="editor" style="border-radius: 7px"        
                :subfield="false"
                :placeholder="'...'"
                :fontSize="'14'" 
                :toolbarsFlag=false                
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
import { mavonEditor } from 'mavon-editor'

export default {
    name: "comment-box",
    data() {
        return {            
            editComment: false,            
        }
    },
    props: {
        comment: {},
    },
    methods: {
        addComment: function() {
			this.editComment = !this.editComment
        },
        submit: function() {
            this.getInput();
            this.$emit("postComment");
        },
        getInput: function() {
            var refEdit = this.$refs.editor;
            this.comment.words = refEdit.d_value
            this.comment.wordsHTML = refEdit.d_render
        }
    }
}
</script>
<style scoped>
#editor {
    margin: auto;
    width: 45%;    
	/* height: 10px; */
}
</style>