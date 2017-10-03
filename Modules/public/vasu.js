var movie = require("./sharedMovie") ;
movie.favMovie = "Iron Man" ;
console.log("Vasu fav movie : " + movie.favMovie) ;

var objectFactoryMovie = require("./objectFactoryMovie");
var vasuMovies = objectFactoryMovie() ;
vasuMovies.favMovie = "SuperMan" ;
console.log("(ObjectFactory) Vasu fav movie : " + vasuMovies.favMovie) ;