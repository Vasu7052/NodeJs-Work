const mongoose = require("mongoose") ;

const moviesSchema = mongoose.Schema({

    title : {
        type : String ,
        required : true
    },year : {
        type : Number ,
        required : true
    },genre : {
        type : String ,
        required : true
    },description : {
        type : String ,
        required : true
    },director : {
        type : String ,
        required : true
    },stars : {
        type : String ,
        required : true
    },imdbRating : {
        type : Number ,
        required : true
    },create_date:{
        type: Date,
        default: Date.now
    }

});

const Movie = module.exports = mongoose.model("Movie" , moviesSchema , "movieList") ;
