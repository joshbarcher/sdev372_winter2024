
const printName = (first, last) => {
    const fullName = first + " " + last;
    console.log(fullName);
}

printName("Sarah", "Smithers");
printName("Job", "Smith");

const print = msg => console.log(msg);
const shout = msg => console.log(msg.toUpperCase());
const whisper = msg => console.log(msg.toLowerCase());

print("Hello, world!");
shout("Hello, world!");
whisper("Hello, world!");

let names = ["Josh", "Jennifer", "Mark", "Jo", "Nathan"];

names.sort((el1, el2) => {
    if (el1 < el2) {
        return -1;
    } else if (el1 > el2) {
        return 1;
    }
    return 0;
});

//convert each "name" to "name is awesome!"
names = names.map(name => `${name} is awesome!`);
names.forEach(name => console.log(name));