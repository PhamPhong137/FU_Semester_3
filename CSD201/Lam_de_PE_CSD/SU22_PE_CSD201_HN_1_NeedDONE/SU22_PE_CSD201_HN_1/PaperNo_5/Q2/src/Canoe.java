// ======= DO NOT EDIT THIS FILE ============
class Canoe {
  String driver;
  int rate,color;
  Canoe() {
   }
  Canoe(String xDriver, int xRate, int xColor){
    driver=xDriver;rate=xRate; color=xColor;
   }
  public String toString(){
    return("(" +driver+","+rate + "," + color + ")");
   }
 }