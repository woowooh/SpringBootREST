<template>
  <div class="container">
    <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Account</label>
        <input type="text" v-model="loginForm.account" id="inputEmail" class="form-control" placeholder="Email address" autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" v-model="loginForm.password" id="inputPassword" class="form-control" placeholder="Password">
        <div class="checkbox">
            <label>
            <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" @click.prevent="login" type="submit">Sign in</button>
        <button class="btn btn-lg btn-primary btn-block" @click.prevent="regist" type="submit">Register</button>        
    </form>
    <div class="alert alert-warning" style="display: none;" v-html="message">
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "login-view",
  data() {
    return {
      loginForm: {
        account: "",
        password: "",
      },
      message: "",
    }
  },
  methods: {
    regist: function() {
      if (!this.validInput()) {
        return
      }
      var path = 'http://localhost:8082/user/regist'
      axios.post(path, this.loginForm)
        .then(res => {          
          console.log(res.data)
          if (res.data.data == true) {
            this.flashMessage("<strong>Register success ~</strong>")
          } else {
            this.flashMessage("<strong>Verify user failed ~</strong>")
          }
        }) 
    },
    login: function() {
      if (!this.validInput()) {
        return
      }
      var path = 'http://localhost:8082/user/login'
      axios.post(path, this.loginForm)
        .then(res => {          
          console.log(res.data)
          if (res.data.data == true) {
            this.$router.push({path: "/blogs"})
          } else {
            this.flashMessage("<strong>Verify user failed</strong>")
          }
        }) 
    },
    validInput: function() {
      if (this.loginForm.account.trim() == "") {        
        this.flashMessage("<strong>Account can not be empty</strong>")
        return false
      }
      if (this.loginForm.password.trim() == "") {
        this.flashMessage("<strong>password can not be empty</strong>")
        return false
      }
      return true
    },
    flashMessage: function(message) {
      this.message = message
      $('.alert').show()
      window.setTimeout(function() {
        $('.alert').hide()
      }, 1500);
    }
  }
}
</script>

<style scoped>
  body {
    padding-top: 40px;
    padding-bottom: 40px;
    background-color: #eee;
  }
  .container {
    margin-top: 90px;
  }
  .form-signin {
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
  }
  .form-signin .form-signin-heading,
  .form-signin .checkbox {
    margin-bottom: 10px;
  }
  .form-signin .checkbox {
    font-weight: normal;
  }
  .form-signin .form-control {
    position: relative;
    height: auto;
    -webkit-box-sizing: border-box;
       -moz-box-sizing: border-box;
            box-sizing: border-box;
    padding: 10px;
    font-size: 16px;
  }
  .form-signin .form-control:focus {
    z-index: 2;
  }
  .form-signin input[type="email"] {
    margin-bottom: -1px;
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
  }
  .form-signin input[type="password"] {
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
  }
</style>
