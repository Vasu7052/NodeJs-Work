var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', {
    title: 'Express AndroFly' ,
    name : "Vasu Gupta"
  }); // It says that we want to use index as view and passing title as Express
});

module.exports = router;
