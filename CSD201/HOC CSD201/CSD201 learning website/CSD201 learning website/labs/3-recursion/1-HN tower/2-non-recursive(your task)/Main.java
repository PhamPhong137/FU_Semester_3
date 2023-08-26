import java.util.*;
class Suite
 {int n;char a,b,c;
  Suite(int n1, char a1, char b1, char c1)
   {n=n1;a=a1;b=b1;c=c1;
   }
 }
class MyStack
 {LinkedList t;
  MyStack() {t=new LinkedList();}
  void clear() {t.clear();}
  boolean isEmpty() {return(t.isEmpty());}
  void push(Suite x)
   {t.add(x);
   }
  Suite pop() 
   {if(isEmpty()) return(null);
    Suite x = (Suite) t.removeLast();
    return(x);
   }
  Suite top() 
   {if(isEmpty()) return(null);
    Suite x = (Suite) t.getLast();
    return(x);
   }
 }
public class Main
  {static void thapHN(Suite x)
     {Suite g,h;
      int n; char a,b,c;
      MyStack t = new MyStack();
      t.push(x);
     }
   public static void main(String [] args)
     {int n;char a,b,c; a='A';b='B';c='C';
      Suite x;
      System.out.println();
      n=3;
      x = new Suite(n,a,b,c);
      System.out.println(" Ha noi tower for n = " + n);
      thapHN(x);
      System.out.println();
      n=5;
      x = new Suite(n,a,b,c);
      System.out.println(" Ha noi tower for n = " + n);
      thapHN(x);
      System.out.println();
     }
  }
