var x = document.querySelectorAll('button')
x.forEach(element => {
    element.onclick = function show() {
        var c = prompt("enter the name");
        alert('hello')
    };
});
    
