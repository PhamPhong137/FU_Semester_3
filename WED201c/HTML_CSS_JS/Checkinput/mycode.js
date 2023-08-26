function send() {
  var arr = document.getElementsByTagName("input");
  var name = arr[0].value;
  var age = arr[1].value;
  var addres = arr[2].value;
  var check1 = arr[5].checked;
  var check2 = arr[6].checked;
  var check3 = arr[7].checked;
  var gender = "";
  var favourite="";
  if (arr[3].checked) {
    gender = arr[3].value;
  } else {
    gender = arr[4].value;
  }
  for(var i=5;i<=7;i++){
    if(arr[i].checked){
        favourite+=arr[i].value
    }
  }
  if (name == "" || age == "" || addres == "") {
    alert("fill all fields");
    return;
  }
  if (isNaN(age)) {
    alert("fill number age");
  }
  if (!(check1 || check2 || check3)) {
    alert("fill favourie");
  }

  var choice=confirm("confirm" + name + age + addres + "\n" + gender+"\n"+favourite);
  if(choice==1){
    alert("DONE")
  }
}
function reset(){
    document.getElementsByTagName('form')[0].reset();
}
