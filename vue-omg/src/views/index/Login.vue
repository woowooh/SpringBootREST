<template>
  <div class="container">
    <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" v-model="loginForm.account" id="inputEmail" class="form-control" placeholder="Email address" autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" v-model="loginForm.password" id="inputPassword" class="form-control" placeholder="Password">
        <div class="checkbox">
            <label>
            <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" @click.prevent="submit" type="submit">Sign in</button>
    </form>
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
      }
    }
  },
  methods: {
    submit: function() {
      if (!this.validInput()) {
        return
      }
      var path = 'http://localhost:8082/mock'
      this.validInput()
      axios.post(path, this.loginForm)
        .then(res => {          
          console.log(res.data)
        }) 
    },
    validInput: function() {
      if (this.loginForm.account.trim() == "") {
        this.flashMessage("Account can not be empty")
        return false
      }
      if (this.loginForm.password.trim() == "") {
        this.flashMessage("password can not be empty")
        return false
      }
      return true
    },
    flashMessage: function(message) {
      console.log(message)
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
