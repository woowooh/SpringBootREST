import Vue from 'vue'
import VueRouter from 'vue-router'
import HelloWorld from '@/components/HelloWorld.vue'
import ShowBlogs from '@/views/blog/ShowBlogs.vue'
import AddBlog from '@/views/blog/AddBlog.vue'
import SingleBlog from '@/views/blog/SingleBlog.vue'  

export const routes = [
  {
    path: '/',
    name: 'HelloWorld',
    component: HelloWorld
  },
  {
    path: '/blog',
    name: '博客',
    component: ShowBlogs,          
  },
  {
    path: '/add',
    name: '添加博客',
    component: AddBlog,          
  },
  {
    path: '/blog/:id',
    name: '博客细节',
    component: SingleBlog,          
  }
]
