// ====================
//  variables
// ====================

a = 5;
console.log(a) //5
var a

var b
console.log(b) //undefined
b = 6;

function example() {
    for (var i = 0; i < 5; i++) {
        console.log(i);
    }
    console.log(i);
}
example()


// ====================
//  functions
// ====================

named()
function named() {
    console.log("Named function called")
}


// ====================
//  anonymous-functions
// ====================
// console.log(anon) //ReferenceError: Cannot access 'anon' before initialization

// anon() //ReferenceError: Cannot access 'anon' before initialization
let anon = function () {
    console.log("Anon function assigned to let variable called")
}

// console.log(anon2) //undefined
// anon2() //TypeError: anon2 is not a function
var anon2 = function () {
    console.log("Anon function assigned to var variable called")
}

anon2() //Anon function assigned to var variable called

console.log(anon2) //[Function: anon2]
