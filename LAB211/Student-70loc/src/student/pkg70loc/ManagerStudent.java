/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.pkg70loc;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ManagerStudent {

    Scanner sc = new Scanner(System.in);
    List<Student> list = new ArrayList<>();
    Validate v = new Validate();

    public void createStudent(List<Student> list) {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Classes: ");
        String classes = sc.nextLine();
        double math = v.checkMark("Maths: ", 0, 10, "Math");
        double chemistry = v.checkMark("Chemistry: ", 0, 10, "Chemistry");
        double physical = v.checkMark("Physical: ", 0, 10, "Physical");
        list.add(new Student(name, classes, math, physical, chemistry));
    }

    public void printInfo(List<Student> list) {
        int index = 1;

//        Collections.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                // return Double.compare(o1.getAVG(), o2.getAVG());
//                return o1.getName().compareTo(o2.getName());
//            }
//
//        });



        for (Student o : list) {
            System.out.println("-----Student" + index + " Info------");
            o.display();
            index++;
        }
    }

    public HashMap<String, Double> getPercentTypeStudent(List<Student> list) {

        HashMap<String, Double> hashmap = new HashMap<>();

        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        for (Student o : list) {
            if (o.getAVG() > 7.5) {
                countA++;
            } else if (o.getAVG() >= 6.5) {
                countB++;
            } else if (o.getAVG() >= 4) {
                countC++;
            } else {
                countD++;
            }
        }
        int totalStudent = list.size();
        hashmap.put("A", 100.0 * countA / totalStudent);
        hashmap.put("B", 100.0 * countB / totalStudent);
        hashmap.put("C", 100.0 * countC / totalStudent);
        hashmap.put("D", 100.0 * countD / totalStudent);
        return hashmap;
    }

    public void displayAll() {
        while (true) {
            createStudent(list);
            String check = v.inputYN();
            if (check.equalsIgnoreCase("N")) {
                break;
            }

        }
        printInfo(list);
        HashMap<String, Double> mapStudent = getPercentTypeStudent(list);
        System.out.println("-------- Classification Info -----");
        DecimalFormat df = new DecimalFormat("#.#");
        mapStudent.forEach((key, value) -> System.out.println(key + ": " + df.format(value) + "%"));
    }
}
