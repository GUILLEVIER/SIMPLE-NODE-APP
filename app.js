var express = require('express')
var app = express()

app.get('/', function (req, res) {
  res.send('Hola Mundo!')
})

var server = app.listen(3000, function () {
  var host = server.address().address
  var port = server.address().port
  console.log('App escuchando a http://%s:%s', host, port)
})
