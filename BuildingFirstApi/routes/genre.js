const mongoose = require('mongoose');

// Genre Schema
const genreSchema = mongoose.Schema({
    name:{
        type: String,
        required: true
    },
    genre:{
        type: String,
        required: true
    },
    description:{
        type: String
    },
    author:{
        type: String,
        required: true
    },
    publisher:{
        type: String
    },
    pages:{
        type: String
    },
    create_date:{
        type: Date,
        default: Date.now
    }
});

const Genre = module.exports = mongoose.model('Genre', genreSchema , "genre");

// Get Genres
module.exports.getGenres = function(callback, limit){
    Genre.find(callback).limit(limit);
}