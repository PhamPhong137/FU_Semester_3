
class Car {

    String owner;
    int price;

    Car(String xOwner, int xPrice) {
        owner = xOwner;
        price = xPrice;
    }

    public String toString() {
        return ("(" + owner + "," + price + ")");
    }
}
