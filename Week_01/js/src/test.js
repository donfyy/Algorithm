console.log(0.1 + 0.2)
console.log(0.1 + 0.2 == 0.3)
console.log(0.1 + 0.2 - 0.3 < Number.EPSILON)

let y
console.log(y)
undefined = 'aaaaaaaaaa'
let x
console.log(x)

const bufferView = Uint16Array.from([0, 1, 2]);
const data = bufferView.buffer;
console.log(data)
console.log(JSON.stringify(data))


function foo() {
    var test = 1
}

foo.myName = "hhh foo"
foo.uName = "hhh u name"
foo.fun0 = function fun0() {}

console.log(foo)

const obj = {}
obj.name = "a obj"
obj.age = 10
obj.print = function(){}
console.log(obj)
var xx = console.log
function sout(a) {
    console.log(a)
}

(function (){
   sout(this);
})()
function foo1(){
    sout(this)
}
foo1()
