import BlogIndexPage from '@/views/blog/BlogIndexPage.vue'
import AddBlogPage from '@/views/blog/AddBlogPage.vue'
import BlogDetailPage from '@/views/blog/BlogDetailPage.vue'  
import LoginPage from '@/views/index/LoginPage.vue'  

export const routes = [
  {
    path: '/',
    name: 'LoginPage',
    component: LoginPage,
    meta: {
      keepAlive: true
    }
  },
  {
    path: '/blogs',
    name: 'ShowBlogs',
    component: BlogIndexPage
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
