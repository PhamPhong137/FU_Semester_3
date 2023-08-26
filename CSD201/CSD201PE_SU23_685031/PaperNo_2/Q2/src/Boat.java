// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Boat {
  String sea;
  int sail,paddle;
  Boat() {
   }
  Boat(String xSea, int xSail, int xPaddle){
    sea=xSea;sail=xSail; paddle=xPaddle;
   }
  public String toString(){
    return("(" +sea+","+sail + "," + paddle + ")");
   }
 }
