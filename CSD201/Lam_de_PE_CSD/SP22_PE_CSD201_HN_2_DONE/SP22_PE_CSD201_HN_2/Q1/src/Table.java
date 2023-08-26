
class Table {

    String color;
    int area;
    int peri;

    public Table(String color, int area, int peri) {
        this.color = color;
        this.area = area;
        this.peri = peri;
    }   

    public String toString() {
        return ("(" + color + "," + area + "," + peri + ")");
    }
}
