public class Main
  {static void thapHN(int n, char a, char b,char c)
     {if(n==1)
       System.out.println(" " + a + " -> " + b);
        else
         {thapHN(n-1,a,c,b);
          thapHN(1,a,b,c);
          thapHN(n-1,c,b,a);
         }
     }
   public static void main(String [] args)
     {char a,b,c; a='A';b='B';c='C';
      int n;
      System.out.println();
      n=3;
      System.out.println(" Ha noi tower for n = " + n);
      thapHN(n,a,b,c);
      System.out.println();
      n=5;
      System.out.println(" Ha noi tower for n = " + n);
      thapHN(n,a,b,c);
      System.out.println();
     }
  }
