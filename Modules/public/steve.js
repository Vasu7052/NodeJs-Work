var movie = require("./sharedMovie") ;
console.log("Steve fav movie : " + movie.favMovie) ;

var objectFactoryMovie = require("./objectFactoryMovie");
var steveMovies = objectFactoryMovie() ;
// steveMovies.favMovie = "SuperMan" ;
console.log("(ObjectFactory) Steve fav movie : " + steveMovies.favMovie) ;