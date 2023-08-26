/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue.SingleEndedQueue;

/**
 *
 * @author Hp
 */
public class QueueUI {

    public static void main(String[] args) {
        Queue hoenQueue = new Queue();
        hoenQueue.enqueueWithPriority(new Node(5));
        hoenQueue.enqueueWithPriority(new Node(10));
        hoenQueue.enqueueWithPriority(new Node(7));
        hoenQueue.enqueueWithPriority(new Node(20));
        hoenQueue.traverse();
    }
}
