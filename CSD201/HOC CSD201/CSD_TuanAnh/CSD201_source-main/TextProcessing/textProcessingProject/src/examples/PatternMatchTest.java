package examples;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class PatternMatchTest {
 
  public static void main(String[] args) {
    String search_string = "1234abc89zw....the end";
    String pattern_string = "[a-z]+";
 
    System.out.println("search string : " + search_string);
    System.out.println("pattern string: " + pattern_string);
 
    System.out.println("");
 
    Pattern pattern = Pattern.compile(pattern_string);
    Matcher matcher = pattern.matcher(search_string);
    while (matcher.find()) {
      int start = matcher.start();
      int end = matcher.end();
      String matched = matcher.group();
      System.out.format("matched=%s,start=%d,end=%d\n", matched, start, end);
    }
  }
}