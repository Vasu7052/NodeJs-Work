var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var mongoose  = require("mongoose") ;
mongoose.connect('mongodb://localhost/movieBooking', { useMongoClient: true }) ;

var index = require('./routes/index');
var Users = require('./routes/users');
var Movies = require('./routes/movies');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', index);

// =============================================== Users =============================================

app.get("/api/users/all/" , function (req,res) {
    Users.find({}).exec(function(err, users) {
        if(err) {
            res.send('error occured')
        } else {
            var temp = {queriedUsers : users} ;
            res.json(temp);
        }
    });
});

app.get("/api/users/byId/:_id" , function (req,res) {
    Users.findOne({
        _id: req.params._id
    }).exec(function(err, users) {
        if(err) {
            res.send('error occured')
        } else {
            var temp = {queriedUsers : users} ;
            res.json(temp);
        }
    });
});

app.get("/api/users/byEmailPass/:email&:password" , function (req,res) {
    Users.find({ $and : [
        { email: req.params.email },
        { password : req.params.password }
    ]}).exec(function(err, users) {
            if(err) {
                res.send('error occured')
            } else {
                var temp = {queriedUsers : users} ;
                res.json(temp);
            }
        });
});

app.get("/api/users/byEmailPass/:email&:password" , function (req,res) {
    Users.findOne({
        email: req.params.email ,
        password : req.params.password
    }).exec(function(err, users) {
        if(err) {
            res.send('error occured')
        } else {
            var temp = {queriedUsers : users} ;
            res.json(temp);
        }
    });
});

// ====================================================================================================

// =============================================== Movies =============================================

app.get("/api/movies/all/" , function (req,res) {
    Movies.find({}).exec(function(err, movies) {
        if(err) {
            res.send('error occured')
        } else {
            var temp = {queriedMovies : movies} ;
            res.json(temp);
        }
    });
});

app.get("/api/movies/byId/:_id" , function (req,res) {
    Movies.findOne({
        _id: req.params._id
    }).exec(function(err, movies) {
        if(err) {
            res.send('error occured')
        } else {
            var temp = {queriedMovies : movies} ;
            res.json(temp);
        }
    });
});


// ====================================================================================================

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
