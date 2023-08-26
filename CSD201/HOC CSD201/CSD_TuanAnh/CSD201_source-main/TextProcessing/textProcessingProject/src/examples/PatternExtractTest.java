package examples;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class PatternExtractTest {
 
  public static void main(String[] args) {
    String search_string = "aabb cc3333 ddd 2223e44  fff5gg  hh";
    String pattern_string = "([a-z]+)(\\d+)";
 
    Pattern pattern = Pattern.compile(pattern_string);
    Matcher matcher = pattern.matcher(search_string);
 
    while (matcher.find()) {
      System.out.format("matched substring: %s\n", matcher.group());
      System.out.format(
              "matched sub-patterns: %s,%s\n", matcher.group(1), matcher.group(2));
      System.out.println("-----------------------");
    }
  }
}