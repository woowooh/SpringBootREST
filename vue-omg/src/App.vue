<template>
  <div id="app">
      <app-navbar v-if="!$route.meta.keepAlive" id="appHeader"/>
      <router-view v-on:public_header="public_header" v-on:public_footer="public_footer"></router-view>
      <app-footer v-if="!$route.meta.keepAlive" id="appFooter"/>
  </div>
</template>


<script>
import AppNavbar from "./common/AppNavbar"
import AppFooter from "./common/AppFooter"
import $ from 'jquery'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'


export default {
  name: 'App',
  data() {
    return {
      header_show: true,
      footer_show: true,
    }
  },
  components: {
    AppNavbar,
    AppFooter,
  },
  methods: {
      public_header:function (bool) {
        this.header_show = bool;
      },
      //是否显示底部
      public_footer:function (bool) {
          this.footer_show = bool;
      }
  },
  created:function () {
    this.$emit('public_header', false);
  }
}
</script>

<style scoped>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;    
  }
</style>

