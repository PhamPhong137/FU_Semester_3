package srcQ3;


// ======= DO NOT EDIT THIS FILE ============
import java.io.*;
import java.util.*;
class Main {
   public static void main(String args[]) throws Exception {
    Graphsrc t = new Graphsrc();
    int choice;
    Scanner sca = new Scanner(System.in);
    System.out.println();
    System.out.println(" 1. Test f1 (1 mark)");
    System.out.println(" 2. Test f2 (1 mark)");
    System.out.println(" 3. Test f41 (1 mark)");
    System.out.println(" 4. Test f42 (1 mark)");
    System.out.println(" 5. Test f43 (1 mark)");
    System.out.println(" 6. Test DFS (1 mark)");
    System.out.println(" 0. Exit");
    System.out.print("    Your selection (0 -> 6): ");
    choice = sca.nextInt();
    sca.nextLine();
    if(choice==0) return;
    switch(choice) {
       case 1: t.f1();
               System.out.println("Your output:");
               Lib.viewFile("f1.txt");
               break;
       case 2: t.f2();
               System.out.println("Your output:");
               Lib.viewFile("f2.txt");
               break;
        case 3: t.f2();
               System.out.println("Your output:");
               Lib.viewFile("f2.txt");
               break;
        case 4: t.f2();
               System.out.println("Your output:");
               Lib.viewFile("f2.txt");
               break;
        
       default: System.out.println("Wrong selection");
      }
     System.out.println();
   }      
 }
