/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_csd_doublelylinkedlist;

/**
 *
 * @author PC-Phong
 */
public class Student {

    private String studentID;
    private String name;
    private double pt1;
    private double pt2;
    private double as1;
    private double as2;
    private double pe;
    private double fe;
    private double avg;

    public Student() {
    }

    public Student(String studentID, String name, double pt1, double pt2, double as1, double as2, double pe, double fe, double avg) {
        this.studentID = studentID;
        this.name = name;
        this.pt1 = pt1;
        this.pt2 = pt2;
        this.as1 = as1;
        this.as2 = as2;
        this.pe = pe;
        this.fe = fe;
        this.avg = (double) 0.1 * (pt1 + pt2 + as1 + as2) + 0.3 * (pe + fe);
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

    public double getPt1() {
        return pt1;
    }

    public void setPt1(double pt1) {
        this.pt1 = pt1;
    }

    public double getPt2() {
        return pt2;
    }

    public void setPt2(double pt2) {
        this.pt2 = pt2;
    }

    public double getAs1() {
        return as1;
    }

    public void setAs1(double as1) {
        this.as1 = as1;
    }

    public double getAs2() {
        return as2;
    }

    public void setAs2(double as2) {
        this.as2 = as2;
    }

    public double getPe() {
        return pe;
    }

    public void setPe(double pe) {
        this.pe = pe;
    }

    public double getFe() {
        return fe;
    }

    public void setFe(double fe) {
        this.fe = fe;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        return studentID.equals(other.studentID)
                && name.equals(other.name)
                && pt1 == other.pt1
                && pt2 == other.pt2
                && as1 == other.as1
                && as2 == other.as2
                && pe == other.pe
                && fe == other.fe
                && avg == other.avg;
    }

    public String toString() {
        return "StudentID = " + studentID + "  Name=" + name + "  PT1= " + pt1 + "  PT2= " + pt2 + "  AS1=" + as1 + "  AS2= " + as2 + "  PE=" + pe + "  FE= " + fe + "  AVG= " + avg;
    }
}
