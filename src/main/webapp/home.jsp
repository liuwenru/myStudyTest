<html>

<head>
<title>Docker运营监控平台</title>
<script src="./resources/vue.js"></script>

</head>
<div id="app">
  <p>{{ message }}</p>
  <input v-model="message">
</div>
<body>
</body>
<script type="text/javascript">
new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue.js!'
  }
})
</script>
</html>
