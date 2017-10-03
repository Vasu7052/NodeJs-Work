var express = require('express');
var path = require('path');
var logger = require('morgan'); // For showing logs
var cookieParser = require('cookie-parser'); // For Handling Cookies
var bodyParser = require('body-parser'); // For parsing a text/json body

var index = require('./routes/index'); // routes are brains behind everything
var about = require("./routes/about") ;

var app = express(); // Connect framework

app.locals.points = "8.4778" ;

app.locals.videodata = require("./video_data.json") ;

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

app.use('/', index); // Looking up for paths
app.use('/about', about);


// catch 404 and forward to error handler          // This block of error handler is used at the time of development
app.use(function(req, res, next) {
  var err = new Error('Not Found');  // Error Handler
  err.status = 404;
  next(err); // Passes to next error handler
});

// error handler                      // This block of error handler is used when the project is live
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
