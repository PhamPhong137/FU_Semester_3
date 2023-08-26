/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_0;

/**
 *
 * @author Admin
 */
public class MyList {
    Node head, tail;
    int size;

    public MyList() {
        head = tail = null;
        size = 0;
    }
    
    public boolean isEmpty(){ //check xem list co rong khong
        return head == null;
    }
    
    public void display(){ //in ra list
        Node cur = head;
        while(cur!=null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("");
    }
    
    public void addLast(int value){ //them vao cuoi cung cua list
        Node node = new Node(value);
        if (isEmpty()){
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
        size++;
    }
    
    public void addFirst(int value){ //them vao dau tien cua list
        Node node = new Node(value);
        if (isEmpty()){
            head = tail = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }
    
    public boolean checkPrime(int n){ //kiem tra so nguyen to
        if(n<2) return false;
        for (int i=2; i<= Math.sqrt(n); i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }
    
    public int findIndex1(){ //tim index cua SNT dau tien
        int index = 0;
        Node cu = head;
        int count=0;
        while(cu!=null){
            if(checkPrime(cu.value)){
                count++;
            }
            if(count==1){
                return index+1;
            }
            cu=cu.next;
            index++;
        }
        return 0;
    }
    
    public int findIndex2(){ //tim index cua SNT thu 2
        int index = 0;
        Node cu = head;
        int count=0;
        while(cu!=null){
            if(checkPrime(cu.value)){
                count++;
            }
            if(count==2){
                return index+1;
            }
            cu=cu.next;
            index++;
        }
        return 0;
    }
    
    public int findIndex3(){ //tim index cua SNT cuoi cung
        int index = 0;
        int indexFound=0;
        Node cu = head;
        while(cu!=null){
            if(checkPrime(cu.value)){
                indexFound = index;
            }
            cu=cu.next;
            index++;
        }
        return indexFound+1;
    }
    
    public void addIndex(int index, int value) { //them vao list theo index
        if (index <= 0) {
            addFirst(value);
            return;
        }
        if (index >= size) {
            addLast(value);
            return;
        }
        int count = 0;
        Node current = head;
        while (current != null && count != index - 1) {
            count++;
            current = current.next;
        }
        if (current == null) {
            return;
        } else {
            Node temp = new Node(value);
            temp.next = current.next;
            current.next = temp;
            size++;
        }
    }
    
    public int deleteFirst(){ //xoa so dau tien co tra ve
        if(isEmpty()){
            return 0;
        }
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }
    
    public void delFirst(){ //xoa so dau tien ko tra ve
        if(isEmpty()){
            return;
        }
        head = head.next;
        size--;
    }
    
    public int deleteLast(){ //xoa so cuoi cung co tra ve
        if(isEmpty()){
            return 0;
        }
        if(head.next == null){
            int value = head.value;
            head = null;
            size--;
            return value;
        }
        Node cu = head;
        while(cu.next.next !=null){
            cu = cu.next;
        }
        int value = cu.next.value;
        cu.next = null;
        size--;
        tail = cu;
        return value;
    }
    
    public void delLast(){ //xoa so cuoi cung ko tra ve
        if(isEmpty()){
            return;
        }
        if (head.next == null){
            head = null;
            size--;
            return;
        }
        Node cu = head;
        while(cu.next.next != null){
            cu = cu.next;
        }
        cu.next = null;
        tail = cu;
        size--;
    }
    
    public void deleteIndex(int index){ //xoa theo index
        if(index<0||index>=size){
            return;
        }
        if(index ==0 ){
            delFirst();
            return;
        }
        else if (index == size-1){
            delLast();
            return;
        }
        int count=0;
        Node cu = head;
        while(count!= index -1){
            count++;
            cu = cu.next;
        }
        cu.next = cu.next.next;
        size--;
    }
    
    
    
}
