import javax.swing.JOptionPane;
 
/**
   This program displays the number of letters,
   digits, and whitespace characters in a string.
*/
 
public class StringAnalyzer
{
   public static void main(String [] args)
   {
      String input;        // To hold input
      char[] array;        // Array for input
      int letters = 0;     // Number of letters
      int digits = 0;      // Number of digits
      int whitespaces = 0; // Number of whitespaces
 
      // Get a string from the user.
      input = JOptionPane.showInputDialog("Enter " +
                                       "a string:");
 
      // Convert the string to a char array.
      array = input.toCharArray();
 
      // Analyze the characters.
      for (int i = 0; i < array.length; i++)
      {
         if (Character.isLetter(array[i]))
            letters++;
         else if (Character.isDigit(array[i]))
            digits++;
         else if (Character.isWhitespace(array[i]))
            whitespaces++;
      }
 
      // Display the results.
      JOptionPane.showMessageDialog(null,
                      "That string contains " +
                      letters + " letters, " +
                      digits + " digits, and " +
                      whitespaces +
                      " whitespace characters.");
 
      System.exit(0);
   }
}