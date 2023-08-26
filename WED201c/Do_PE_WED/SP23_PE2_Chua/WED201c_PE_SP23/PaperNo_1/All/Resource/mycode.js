var places = document.querySelector("select");
var c =0;
places.onchange = function (e) {
  document.querySelector(".price0 span").innerText = e.target.value;
  c = e.target.value;
};
function CalTotal() {
  var number = document.querySelector("#number");
  var total = 0;
  total = Number.parseFloat(c) * Number.parseFloat(number.value);
  document.querySelector(".total span").innerText = total;
}
