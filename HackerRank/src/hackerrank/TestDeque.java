/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 *
 * @author PC-Phong
 */
public class TestDeque {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // số lượng quái vật
        int k = scanner.nextInt(); // số lượng quái vật trong mỗi đợt tấn công

        int[] strengths = new int[n];
        for (int i = 0; i < n; i++) {
            strengths[i] = scanner.nextInt();
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && strengths[i] <= strengths[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        

        for (int i = k; i < n; i++) {
            System.out.print(strengths[dq.peekFirst()] + " ");
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }
            
            while (!dq.isEmpty() && strengths[i] <= strengths[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        System.out.print(strengths[dq.peekFirst()]);
    }
}
