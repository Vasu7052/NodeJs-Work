var fs = require("fs") ; // File System Module

fs.writeFileSync("corn.txt" , "Corn is Good and sweet") ;
console.log(fs.readFileSync("corn.txt").toString());

var path = require("path") ;
var websiteHome = "Desktop/Vasu//index.html" ;
var websiteAbout = "Desktop/Vasu/about.html" ;

console.log(path.normalize(websiteHome));
console.log(path.normalize(websiteAbout));

console.log(path.dirname(websiteHome));
console.log(path.basename(websiteHome));
console.log(path.extname(websiteHome));