import BlogIndexPage from '@/views/blog/BlogIndexPage.vue'
import AddBlogPage from '@/views/blog/AddBlogPage.vue'
import BlogDetailPage from '@/views/blog/BlogDetailPage.vue'  
import Login from '@/views/index/Login.vue'  

export const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/blogs',
    name: 'ShowBlogs',
    component: BlogIndexPage
  },
  {
    path: '/blog',
    name: '博客首页',
    component: BlogIndexPage,          
  },
  {
    path: '/add',
    name: '添加博客',
    component: AddBlogPage,          
  },
  {
    path: '/blog/:id',
    name: '博客细节',
    component: BlogDetailPage,          
  }
]
