var http = require("http") ;

/* function onRequest(request , response) {
    console.log("A User made a request" + request.url);
    response.writeHead(200 , {"Content-Type" : "text/plain"}); // 200 is a status code that means that all is ok
    response.write("Here is your response") ;
    response.end() ;
}

http.createServer(onRequest).listen(8888);
console.log("Server is Now Running..") ;  */  // This is for sending a basic string in response

var fs = require("fs");

// 404 response
function send404Response(response) {
    response.writeHead(404 , {"Content-Type" : "text/plain"}) ;
    response.write("Error 404 Not Found");
    response.end();
}

// Handle a user request
function onRequest(request , response) {
    if (request.method == "GET" && request.url == "/") {  // forward slash means they are trying to connect to the homepage
        response.writeHead(200, {"Content-Type": "text/html"});
        fs.createReadStream("./index.html").pipe(response);
    } else {
        send404Response(response);
    }
}


http.createServer(onRequest).listen(8888);
console.log("Server is Now Running..") ;

