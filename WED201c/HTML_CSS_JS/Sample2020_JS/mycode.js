function show(){
    if(document.getElementById('table').style.display =='none'){
    document.getElementById('table').style.display='block';
    document.getElementsByTagName('h1')[0].innerHTML='Hide register form'
    }else{
        document.getElementById('table').style.display='none';
        document.getElementsByTagName('h1')[0].innerHTML='Show register form'
    }
}

function submit(){
    var arr=document.getElementsByTagName('input');
    var name =arr[0].value;
    var email = arr[1].value
    if(name==""||email==""){
        alert('fill up');
    }
}