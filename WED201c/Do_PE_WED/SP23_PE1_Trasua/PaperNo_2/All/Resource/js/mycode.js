function CalTotal(){
    var items=document.querySelectorAll('.menu-list-item')
    var write = document.querySelector('.no')
    write.innerHTML="";
    var total=0 ;
    items.forEach((item) =>{
        if(item.querySelector('input').checked){
            write.innerHTML+='<p>'+ item.querySelector('label').innerText+'</p>'
            total+=Number.parseFloat(item.querySelector('input').value)
        }
    })
    document.querySelector('#total-price').innerText=total
    document.querySelector('.menu-list-footer').style='display:block'
}

