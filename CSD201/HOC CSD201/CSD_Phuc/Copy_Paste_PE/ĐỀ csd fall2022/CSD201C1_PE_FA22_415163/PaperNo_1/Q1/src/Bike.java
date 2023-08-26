// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Bike {
  String brand;
  int color,weight;
  Bike() {
   }
  Bike(String xBrand, int xColor, int xWeight){
    brand=xBrand;color=xColor; weight=xWeight;
   }
  public String toString(){
    return("(" +brand+","+color + "," + weight + ")");
   }
 }
