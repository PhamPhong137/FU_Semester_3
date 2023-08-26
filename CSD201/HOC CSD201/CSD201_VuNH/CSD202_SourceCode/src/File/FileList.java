/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

//import Queue.SingleEndedQueue.MyQueue;
import java.io.File;

/**
 *
 * @author Hp
 */
public class FileList {

    public static void main(String[] args) {
        MyFileQueue obj = new MyFileQueue();
        String pathName = "D:\\File cua Huyen\\FPT\\TERM 03 FA22\\LAB211";
        File f = new File(pathName);
        for (int i = 0; i < f.listFiles().length; i++) {
//            System.out.println(f.listFiles()[i].toString());
            obj.enqueue(f.listFiles()[i].toString());
        }

        while (!obj.isEmpty()) {
            String child = obj.dequeue().info;
            f = new File(child);
            if (f.isDirectory()) {
                System.out.println("DIR " + child);
                for (int i = 0; i < f.listFiles().length; i++) {
                    obj.enqueue(f.listFiles()[i].toString());
                }
            } else {
                System.out.println("    " + child);
            }
        }
    }
}
