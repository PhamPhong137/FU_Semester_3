// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Bird {
  String forest;
  int rate,sound;
  Bird() {
   }
  Bird(String xForest, int xRate, int xSound){
    forest=xForest;rate=xRate; sound=xSound;
   }
  public String toString(){
    return("(" +forest+","+rate + "," + sound + ")");
   }
 }
