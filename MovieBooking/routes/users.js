const mongoose = require("mongoose") ;

const usersSchema = mongoose.Schema({

    name : {
        type : String ,
        required : true
    },email : {
        type : String ,
        required : true
    },password : {
        type : String ,
        required : true
    },type : {
        type : String ,
        required : true
    },profilePhtot : {
        type : String ,
        required : true
    },create_date:{
        type: Date,
        default: Date.now
    }
},{versionKey : false});

const Users = module.exports = mongoose.model("Users" , usersSchema , "userList") ;