const mongoose = require('mongoose');

// Genre Schema
const genreSchema = mongoose.Schema({
    name:{
        type: String,
        required: true
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

// Add Genre
module.exports.addGenre = function(genre, callback){
    Genre.create(genre, callback);
}

// Update Genre
module.exports.updateGenre = function(id, genre, options, callback){
    var query = {_id: id};
    var update = {
        name: genre.name
    }
    Genre.findOneAndUpdate(query, update, options, callback);
}


// Delete Genre
module.exports.removeGenre = function(id, callback){
    var query = {_id: id};
    Genre.remove(query, callback);
}