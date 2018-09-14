var mysql = require('mysql');
var pool  = null;

exports.connect = function() {
  pool = mysql.createPool({
    host     : '127.0.0.1',
    user     : 'root',
    password : '',
    database : 'mydb'
  });
}

exports.get = function() {
  return pool;
}
