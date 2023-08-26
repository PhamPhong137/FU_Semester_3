package textprocessing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import views.CharMatchFrame;

/**
 * @author Robert Kline
 */
public class CharMatch {

  private final CharMatchFrame frame = new CharMatchFrame();

  /**
   * Constructor.
   */
  public CharMatch() {
    
    frame.setTitle(getClass().getSimpleName());

    frame.getCheckButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JTextField inputField = frame.getInputField();
        String input = inputField.getText();

        boolean isValid = isValid1(input);
        //boolean isValid = isValid2(input);
        
        if (!isValid) {
          JOptionPane.showMessageDialog(frame, "invalid");
        } else {
          JOptionPane.showMessageDialog(frame, "valid");          
        }
      }
    });
  }
    
  /***
   * Test if param matches pattern. Check length and then
   * check each character in sequence.
   * @param custNumber
   * @return whether matches given pattern
   */
  private boolean isValid1(String custNumber) {
    if (custNumber.length() != 7) {
      return false;
    }
    for(int i = 0; i < 3; ++i) {
      char c = custNumber.charAt(i);
      if (!Character.isLetter(c)) {
        return false;
      }
    }
    for(int i = 3; i < 7; ++i) {
      char c = custNumber.charAt(i);
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }
  
  /***
   * Test if param matches pattern. Simple one-liner, but difficult
   * because it relies on regular expression knowledge.
   * @param custNumber
   * @return whether matches given pattern
   */
  private boolean isValid2(String custNumber) {
    return custNumber.matches("[a-zA-Z]{3}\\d{4}"); 
    // Input 3 letters followed by 4 digits.
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    CharMatch app = new CharMatch();
    app.frame.setVisible(true);
  }
}
