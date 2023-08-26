package examples;

import java.util.Arrays;

public class SplitTest {

  public static void main(String[] args) {

    String test_str = "Here is a    very common sentence - hope you like it!";
    String regex;
    
    regex = "\\s+";

    String[] pieces = test_str.split(regex);

    for (String piece : pieces) {
      System.out.println(piece);
    }
  }
}
