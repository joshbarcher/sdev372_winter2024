
const nameParts = ["Mr", "Josh", "B", "Archer"];

const [ nameTitle, first, middle, last ] = nameParts;

console.log(`Title: ${nameTitle}`);
console.log(`First: ${first}`);
console.log(`Middle: ${middle}`);
console.log(`Last: ${last}`);

const fullnameParts = [{
        first: "Josh",
        last: "Archer"
    },{
        first: "Nathan",
        last: "Waters"
    },{
        first: "James",
        last: "Motherwell"
    }
]

const [ josh, nathan, james ] = fullnameParts;

console.log(josh.first);
console.log(nathan.last);

console.log(fullnameParts[0]);

const classRoom = {
    title: "Software as a Service",
    id: "SDEV 372",
    hybrid: true,
    days: ["Tue", "Thur", "Fri"],
    time: "1pm"
}

const { id, title, days, time, hybrid } = classRoom;

console.log(`Our class is ${id}: (${title})`);
console.log(`We meet on the following days: ${days}`);