var http = require("http") ;

/* function onRequest(request , response) {
    console.log("A User made a request" + request.url);
    response.writeHead(200 , {"Content-Type" : "text/plain"}); // 200 is a status code that means that all is ok
    response.write("Here is your response") ;
    response.end() ;
}

http.createServer(onRequest).listen(8888);
console.log("Server is Now Running..") ;  */  // This is for sending a basic string in response

function onRequest(request , response) {
    
}

http.createServer(onRequest).listen(8888);
console.log("Server is Now Running..") ;

