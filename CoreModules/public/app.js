var fs = require("fs") ; // File System Module

fs.writeFileSync("corn.txt" , "Corn is Good and sweet") ;
console.log(fs.readFileSync("corn.txt").toString());