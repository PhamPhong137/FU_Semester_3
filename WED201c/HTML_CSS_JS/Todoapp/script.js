function addItem() {
  let input = document.getElementById("input");
  let text = input.value;
  let li = document.createElement('li');
  li.innerHTML=text
  let todoList = document.getElementById('list-todo')
  todoList.appendChild(li)
  input.value=""
}
