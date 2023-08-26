/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assign2_1;

/**
 *
 * @author Admin
 */
public class MyQueue {
    NodeQueue head, tail;
    public MyQueue(){
        head = tail = null;
    }
    boolean isEmpty(){
        return head == null;
    }
    void Enqueue(Node value){
        NodeQueue node = new NodeQueue(value);
        if(isEmpty()){
            head = tail = node;
        }
        else{
            tail.next = node;
            tail = node;
        }
    }
    Node Dequeue(){
        if(isEmpty()){
            return null;
        }
        Node node = head.value;
        head = head.next;
        return node;
    }
}
