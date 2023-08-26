/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.pkg70loc;

/**
 *
 * @author PC-Phong
 */
public class Student {

    private String name;
    private String classname;
    private double math;
    private double physical;
    private double chemistry;

    public Student() {
    }

    public Student(String name, String classname, double math, double physical, double chemistry) {
        this.name = name;
        this.classname = classname;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getChemistyr() {
        return chemistry;
    }

    public void setChemistyr(double chemistyr) {
        this.chemistry = chemistyr;
    }

    public double getAVG() {
        double avg = (math + physical + chemistry) / 3;
        return avg;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Classes: " + classname);
        double avg = (math + physical + chemistry) / 3;
        System.out.printf("AVG: %.2f\n", avg);
        String type = null;
        if (avg > 7.5) {
            type = "A";
        } else if (avg >= 6.5) {
            type = "B";
        } else if (avg >= 4) {
            type = "C";
        } else {
            type = "D";
        }
        System.out.println("Type: " + type);
    }
}
