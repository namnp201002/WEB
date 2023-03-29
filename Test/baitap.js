// console.log("ashbkd")

// document.getElementById("cal").onclick = function(){
//     let a = document.querySelector("#numbera").value;
// let b = document.querySelector("#numberb").value;
//     document.getElementById("solution").innerHTML += Number(a)+Number(b);
//     // console.log(Number(a) + Number(b));
// };


// let store = new Map([["Nam", 20], ['Duy', 120]]);
// store.set("Minh", 101);
// store.forEach((key, value) => console.log(key, value));
// console.log(store.has("Mo"))

// class SinhVien{
//     constructor(name, age, cls){
//         this.name = name;
//         this.age = age;
//         this.cls = cls;
//     }
//     toString(){
//         console.log(`Name: ${this.name}; Age: ${this.age}; Class: ${this.cls}`);
//     }
// }
// let SV = new SinhVien("Nguyen Phuong Nam", 20, "D20CQCN01-B");
// SV.toString()

const myLable = document.getElementById("clock");

setInterval(update, 1000);
function update(){
    let date = new Date();

    myLable.innerHTML = formartDate(date);

    function formartDate(date){
        let hours = date.getHours();
        let minutes = date.getMinutes();
        let seconds = date.getSeconds();
        hours = formartZero(hours);
        seconds = formartZero(seconds);
        minutes = formartZero(minutes);
        return `${hours}:${minutes}:${seconds}`;
    }
    function formartZero(time){
        time = time.toString();
        return time.length < 2 ? "0"+time : time;
    }
}