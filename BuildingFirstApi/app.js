var express = require('express');
var path = require('path');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var mongoose = require("mongoose") ;
mongoose.connect('mongodb://localhost/bookstore', { useMongoClient: true }) ;
var db = mongoose.connection ;

Genre = require("./routes/genre");
Book = require("./routes/book");

var index = require('./routes/index');

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

// app.use('/', index);

app.get("/" , function (req , res) {
    res.send("Hello World") ;
});

// <================================= GENRES =========================
app.get('/api/genres/', function(req, res){
    Genre.getGenres(function(err, genres){
    if(err){
        throw err;
    }
    var temp = {"allGenres" : genres};
    res.json(temp);
});
});

app.post('/api/genres/add', function(req, res){
    var genre = req.body;
    Genre.addGenre(genre, function(err, genre){
    if(err){
        throw err;
    }
    res.json(genre);
});
});

app.put('/api/genres/put/:_id', function(req, res){
    var id = req.params._id;
    var genre = req.body;
    Genre.updateGenre(id, genre, {}, function(err, genre){
    if(err){
        throw err;
    }
    res.json(genre);
});
});

app.delete('/api/genres/delete/:_id', function(req, res){
    var id = req.params._id;
    Genre.removeGenre(id, function(err, genre){
    if(err){
        throw err;
    }
    res.json(genre);
});
});

// <=======================================================================


// <================================= BOOKS ===============================
app.get('/api/books/', function(req, res){
    Book.getBooks(function(err, books){
        if(err){
            throw err;
        }
        var temp = {allBooks : books} ;
        res.json(temp);
    });
});

app.get('/api/books/:_id', function(req, res){
    Book.getBooksById(req.params._id, function(err, book){
    if(err){
        throw err;
    }
    res.json(book);
});
});

app.post('/api/books', function(req, res){
    var book = req.body;
    Book.addBook(book, function(err, book){
    if(err){
        throw err;
    }
    res.json(book);
});
});

app.put('/api/books/:_id', function(req, res){
    var id = req.params._id;
    var book = req.body;
    Book.updateBook(id, book, {}, function(err, book){
    if(err){
        throw err;
    }
    res.json(book);
});
});

app.delete('/api/books/:_id', function(req, res){
    var id = req.params._id;
    Book.removeBook(id, function(err, book){
    if(err){
        throw err;
    }
    res.json(book);
});
});

// <=======================================================================


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
