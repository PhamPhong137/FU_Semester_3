import java.io.*;
import java.util.*;
class zCopyToR_f_4
 {
  static boolean exist(String fname) throws Exception
    {File g = new File(fname);
     if(g.exists()) return(true); else return(false);
    }

  static void copyFile(String fname1, String fname2) throws Exception
   {File g = new File(fname1);
    if(!g.exists())
      {System.out.println(" The file " + fname1 + " does not exist!");
       return;
      }
    g = new File(fname2);
    if(g.exists()) g.delete();
    RandomAccessFile f,h;
    f = new RandomAccessFile(fname1, "r");
    h = new RandomAccessFile(fname2, "rw");
    String s;
    while((s = f.readLine()) != null )  h.writeBytes(s+"\r\n");
    f.close();
    h.close();
   }

  static void copyToResultFiles(int n) throws Exception
   {String fname1, fname2;int i;
    for(i=1;i<=n;i++)
     {fname1 = "f" + i + ".txt";
      fname2 = "R_f" + i + ".txt";
      copyFile(fname1,fname2);
     }
   }
//=========================================
  public static void main(String args[]) throws Exception
   {int n=4;
    copyToResultFiles(n);      
    System.out.println();
   }
 }

