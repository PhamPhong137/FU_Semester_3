package textprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Robert Kline
 */
public class SplitString {

  /**
   * read the file "tell-tale-heart.txt" and "tokenize" it,
   * generating an array of Strings split by the given 
   * regular expression
   * 
   * @param args the command line arguments
   * @throws java.io.IOException: if the file does not exist
   */
  public static void main(String[] args) throws IOException {
    String target = "tell-tale-heart.txt";
    String content = new String(Files.readAllBytes(Paths.get(target)));
    
    String regex;
    regex = "\\s+";  // whitespace sequences
    //regex = "\\W+";  // non-identifier sequences
    //regex = "\\n+";  // newline sequences
   
    // spit the file content string by regex sequences
    String[] pieces = content.split(regex);
    
    // construct the format sting to be used to print lines
    Integer num_pieces = pieces.length;
    int field_len = num_pieces.toString().length();
    String format_str = "%" + field_len + "d: %s";
    
    System.out.format("format string: \"%s\"\n", format_str);

    StringBuilder output = new StringBuilder();
    int line = 0;
    for (String piece : pieces) {
      String str = String.format(format_str + "\n", ++line, piece);
      output.append( str );
    }
    System.out.println(output.toString());
  }
}
