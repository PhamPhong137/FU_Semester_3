
class Bell {

    String tower;
    int sound;
    int type;

    Bell(String tower, int sound, int type) {
        this.tower = tower;
        this.sound = sound;
        this.type = type;
    }

    public String toString() {
        return ("(" + tower + "," + sound + "," + type + ")");
    }
}
