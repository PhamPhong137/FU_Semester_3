class Corn
{   
    String code;
    int type, price;

    public Corn(String code, int type, int price) {
        this.code = code;
        this.type = type;
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "(" + code + "," + type + "," + price + ")";
    }
}
