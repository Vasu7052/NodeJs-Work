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
    }

});

const Users = module.exports = mongoose.model("Users" , usersSchema , "userList") ;

module.exports.getAllUsers = function (callback,limit) {
    Users.find(callback).limit(limit) ;
};

module.exports.getUserById = function (id , callback) {
    Users.findById(id,callback) ;
};

module.exports.getUserByEmailAndPassword = function (object,callback) {
    Users.findOne(object,callback) ;
};