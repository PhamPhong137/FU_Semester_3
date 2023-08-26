package examples;

public class StringSearchTest {
  public static void main(String[] args) {
    String srch = "0123abc78abc";
    String str = "abc";

    System.out.format("srch: %s\nstr:  %s\n", srch, str);
    System.out.println();

    int find_pos;
    
    // indexOf, lastIndexOf from 0

    find_pos = srch.indexOf(str);
    System.out.format("%s.indexOf(%s) = %d\n", srch, str, find_pos);

    find_pos = srch.lastIndexOf(str);
    System.out.format("%s.lastIndexOf(%s) = %d\n", srch, str, find_pos);

    System.out.println();

    // indexOf, lastIndexOf from other positions

    for (int start : new int[]{4, 5, 10}) {
      find_pos = srch.indexOf(str, start);
      System.out.format("%s.indexOf(%s,%s) = %s\n", srch, str, start, find_pos);
    }

    System.out.println();

    for (int start : new int[]{9, 8, 4, 3}) {
      find_pos = srch.lastIndexOf(str, start);
      System.out.format("%s.lastIndexOf(%s,%s) = %s\n",
          srch, str, start, find_pos);
    }

    System.out.println();
    
    // repeated indexOf calls to find all substrings:
    // you may want to use different strings here for testing:
    // srch = ...
    // str = ...

    System.out.printf("%s found in %s at positions:\n", str, srch);
    int search_start = 0;
    do {
      int index = srch.indexOf(str, search_start);
      if (index == -1) {
        break;
      }
      System.out.println(index);
      search_start = index + 1;
    }
    while (true);

  }
}
