var express = require('express');
var router = express.Router();

/* GET about page. */
router.get('/', function(req, res, next) {
    res.render('about', {
        title: 'Express AndroFly' ,
        name : "Vasu Gupta"
    }); // It says that we want to use about as view and passing title as Express
});

module.exports = router;
