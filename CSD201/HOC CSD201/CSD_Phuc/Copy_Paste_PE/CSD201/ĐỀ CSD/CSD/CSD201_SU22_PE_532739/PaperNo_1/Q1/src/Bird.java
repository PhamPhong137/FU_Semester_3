// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Bird {
  String type;
  int rate,wing;
  Bird() {
   }
  Bird(String xType, int xRate, int xWing){
    type=xType;rate=xRate; wing=xWing;
   }
  public String toString(){
    return("(" +type+","+rate + "," + wing + ")");
   }
 }
