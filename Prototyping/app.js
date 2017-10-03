function User() {
    this.name = "" ;
    this.points = 100 ;
    this.givePoints = function givePoints(targetPlayer) {
        targetPlayer.points += 1 ;
        console.log(this.name + " gave 1 point to "  + targetPlayer.name) ;
    }
}

var Vasu = new User() ;
var Steve = new User() ;

Vasu.name = "Vasu" ;
Steve.name = "Steve" ;

Vasu.givePoints(Steve) ;
console.log("Vasu Points : " + Vasu.points) ;
console.log("Steve Points : " + Steve.points) ;

// We can add functions to all objects
User.prototype.upperCut = function upperCut(targetPlayer) {
    targetPlayer.points -= 3 ;
    console.log(this.name + " just uppercut "  + targetPlayer.name) ;
}

Steve.upperCut(Vasu) ;
console.log("Vasu Points : " + Vasu.points) ;
console.log("Steve Points : " + Steve.points) ;

// We can add properties to all objects
User.prototype.magic = 60 ;
console.log("Vasu Magic Points : " + Vasu.magic) ;
console.log("Steve Magic Points : " + Steve.magic) ;