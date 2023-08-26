/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exdoublelinkedlist;

/**
 *
 * @author PC-Phong
 */
public class Student {

    String studentID;
    String name;
    double mark1;
    double mark2;
    double mark3;

    public Student() {
    }

    public Student(String studentID, String name, double mark1, double mark2, double mark3) {
        this.studentID = studentID;
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark1() {
        return mark1;
    }

    public void setMark1(double mark1) {
        this.mark1 = mark1;
    }

    public double getMark2() {
        return mark2;
    }

    public void setMark2(double mark2) {
        this.mark2 = mark2;
    }

    public double getMark3() {
        return mark3;
    }

    public void setMark3(double mark3) {
        this.mark3 = mark3;
    }

    public double getAverage() {
        return Math.round((mark1 + mark2 + mark3) / 3.0 * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Student{" + "StudentID=" + studentID + ", Name=" + name + ", Mark1=" + mark1 + ", Mark2=" + mark2 + ", Mark3=" + mark3 + ", Average=" + getAverage() + '}';
    }

}
