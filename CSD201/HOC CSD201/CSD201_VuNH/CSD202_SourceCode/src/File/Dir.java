/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Queue.SingleEndedQueue.Queue;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Dir {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
//        MyFileQueue obj = new MyFileQueue();
////        System.out.print("Enter a pathname: ");
////        String pathname = sc.next();
//        String pathname = "D:\\Ảnh\\HALLO BARBER\\Extra Tasks";
//        File f = new File(pathname);
//        for (int i = 0; i < f.listFiles().length; i++) {
////            System.out.println(f.listFiles()[i].toString());
//            obj.enqueue(f.listFiles()[i].toString());
//        }
//        while (!obj.isEmpty()) {
//            String child = obj.dequeue().info;
//            System.out.println(child);
//            f = new File(child);
//            if (f.isDirectory()) {
//                for (int i = 0; i < f.listFiles().length; i++) {
//                    System.out.println(f.listFiles()[i].toString());
//                    obj.enqueue(f.listFiles()[i].toString());
//                }
//            }
//        }
        String pathname= "D:\\Ảnh\\HALLO BARBER\\Extra Tasks";
        File f= new File(pathname);
        System.out.print("Disk usage: ");
        System.out.println(diskUsage(f));
    }

    public static long diskUsage(File root) throws IOException {
        long total = root.length();
        if (root.isDirectory()) {
            File child;
            for (int i = 0; i < root.list().length; i++) {
                String fname = root.list()[i];
                child = new File(root, fname);
                System.out.println(child);
                total += diskUsage(child);
            }
        }
        return total;
    }
}
