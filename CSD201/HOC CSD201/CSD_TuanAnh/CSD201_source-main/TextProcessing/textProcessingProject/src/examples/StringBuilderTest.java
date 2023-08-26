package examples;

/**
 * @author Robert Kline
 */
public class StringBuilderTest {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    StringBuilder construction = new StringBuilder();
    construction.append("AAAAAAAAAAA ");
    construction.append("BBBBBBBB ");
    construction.append("CCCC");

    System.out.println(construction);

    construction.replace(0, 8, "********");

    System.out.println(construction);

    StringBuilder construction2 = new StringBuilder();
    construction2.append("AAAAAAAAAAA ").append("BBBBBBBB ").append("CCCC");
    
    System.out.println(construction2);
    
    //String answer = construction.toString();
    //System.out.println(answer);

  }

}
