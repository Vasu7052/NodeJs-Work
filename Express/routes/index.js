var express = require('express');
var router = express.Router();

var passData = "Passing Data Through router" ;

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', {
    title: 'Express AndroFly' ,
    name : "Vasu Gupta" ,
    passData : passData
  }); // It says that we want to use index as view and passing title as Express
});

module.exports = router;
