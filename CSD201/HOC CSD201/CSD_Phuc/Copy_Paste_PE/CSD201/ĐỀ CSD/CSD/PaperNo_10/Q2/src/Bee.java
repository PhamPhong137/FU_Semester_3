// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Bee {
  String forest;
  int rate,sound;
  Bee() {
   }
  Bee(String xForest, int xRate, int xSound){
    forest=xForest;rate=xRate; sound=xSound;
   }
  public String toString(){
    return("(" +forest+","+rate + "," + sound + ")");
   }
 }
