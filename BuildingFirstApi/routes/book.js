const mongoose = require('mongoose');

// Genre Schema
const bookSchema = mongoose.Schema({
    name:{
        type: String,
        required: true
    },
    create_date:{
        type: Date,
        default: Date.now
    }
});

const Book = module.exports = mongoose.model('Book', bookSchema , "books");

// Get Genres
module.exports.getBooks = function(callback, limit){
    Book.find(callback).limit(limit);
};

module.exports.getBooksById = function(id,callback){
    Book.findById(id , callback) ;
};