/* eslint-disable */
import Vue from 'vue'
import App from './App'
import {routes} from './router'
import VueRouter from 'vue-router'
import mavonEditor from 'mavon-editor'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(VueRouter)
Vue.use(mavonEditor)
const router = new VueRouter({
	routes: routes,
	mode:"history"
})

Vue.config.productionTip = false
new Vue({
  el: '#app',
  router: router,
  components: { App },
  template: '<App/>'
})