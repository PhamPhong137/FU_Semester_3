package examples;
 
public class MatchTest {
 
  public static void main(String[] args) {
 
    String test_str;
    String pattern_str;
 
    test_str = "aBc1234";
    pattern_str = "[a-zA-Z]{3}\\d{4}";
 
    System.out.println( "1: " + test_str.matches(pattern_str) );
 
    test_str = "BEFORE aBc1234 AFTER";
    System.out.println( "2: " + test_str.matches(pattern_str) );
 
    pattern_str = ".*[a-zA-Z]{3}\\d{4}.*";
    System.out.println( "3: " + test_str.matches(pattern_str) );
  }
}