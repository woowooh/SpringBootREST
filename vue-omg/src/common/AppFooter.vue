<template>
  <div>
    <footer class="footer">
      <div class="container">
        <p class="text-muted">Place sticky footer content here.</p>
      </div>
    </footer>
  </div>
</template>

<script>
export default {
    name: "app-footer"
}
</script>

<style>
.footer > .container {
  padding-right: 15px;
  padding-left: 15px;
}
.footer {
  position: absolute;
  bottom: 0;
  width: 100%;
  /* Set the fixed height of the footer here */
  height: 60px;
  background-color: #f5f5f5;
}
body {
  /* Margin bottom by footer height */
  margin-bottom: 60px;
}
html {
  position: relative;
  min-height: 100%;
}
</style>