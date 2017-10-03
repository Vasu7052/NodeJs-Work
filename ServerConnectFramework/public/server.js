var connect = require("connect");
var http = require("http") ;

var app = connect();

/* function doFirst(request , response , next) {
    console.log("Candy1") ;
    next() ;
}

function doSecond(request , response , next) {
    console.log("Candy2") ;
    next() ;
}

app.use(doFirst) ;
app.use(doSecond) ;    */

function profile(request , response) {
    console.log("User Requested profile page")
}

function forum(request , response) {
    console.log("User Requested forum page")
}

app.use("/profile" , profile) ;
app.use("/forum" , forum) ;

http.createServer(app).listen(8888) ;

console.log("Server is running...");