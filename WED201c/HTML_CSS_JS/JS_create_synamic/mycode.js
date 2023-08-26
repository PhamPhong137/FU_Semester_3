let JsonObject = [
  {
    name: "Toan",
    password: "1234",
  },
  {
    name: "Van",
    password: "1234",
  },
  {
    name: "Anh",
    password: "1234",
  },
];

var tbody = document.getElementById("tbody");

function createTbody(person) {
 
    tbody.innerHTML +=
      "<tr><td>" +
      person.name +
      "</td>" +
      "<td>" +
      person.password +
      "</td></tr>";
  
}

for (let i = 0; i < JsonObject.length; i++) {
    createTbody(JsonObject[i]);
  }
var button = document.getElementById("button");
var username = document.getElementById("name");
var password = document.getElementById("password");
var form = document.getElementsByTagName('form')[0];

button.onclick = function () {
    JsonObject.push({name:username.value , password: password.value})
    // tbody.innerHTML +=
    // "<tr><td>" +
    // username.value +
    // "</td>" +
    // "<td>" +
    // password.value +
    // "</td></tr>";
    let person ={name:username.value , password: password.value};
    createTbody(person);
     form.reset();  
};


