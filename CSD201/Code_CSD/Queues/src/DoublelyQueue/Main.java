/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublelyQueue;

/**
 *
 * @author PC-Phong
 */
public class Main {

    public static void main(String[] args) {
        MyQueue mq = new MyQueue();

        mq.enqueue("5");
        mq.enqueue("6");
        mq.enqueue("7");
        mq.enqueue("9");
        mq.enqueue("10");
        mq.enqueue("15");
        mq.enqueue("-5");
        mq.enqueue("-6");
        mq.enqueue("10");
        mq.enqueue("9");
        
        
        mq.display();
        
        //Lấy phần tử đầu tiên và xóa 
        System.out.println("");
        Object x = mq.dequeue();
        System.out.println(x);
        mq.display();
        //Lấy phần tử đầu tiên và không xóa 
        System.out.println("");
        Object a = mq.front();
        System.out.println(a);

    }
}
