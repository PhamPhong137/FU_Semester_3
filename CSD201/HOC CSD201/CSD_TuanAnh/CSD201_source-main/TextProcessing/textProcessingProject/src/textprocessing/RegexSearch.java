package textprocessing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

import views.SearchFrame;

public class RegexSearch {

  private final SearchFrame frame = new SearchFrame();

  private String search_string;

  public RegexSearch() throws IOException {
    frame.setTitle(getClass().getSimpleName());
    frame.setSize(600, 500);
    frame.setLocationRelativeTo(null);

    String load_file = "testing.txt";
    String content = new String(Files.readAllBytes(Paths.get(load_file)));
    
    // set initial content from file content
    frame.getTargetTextArea().setText(content);

    frame.getFindButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        frame.clearHighlights();

        // read search_string from textarea
        search_string = frame.getTargetTextArea().getText();
        
        // search_for is a regular expression string
        String search_for = frame.getSearchTextField().getText(); 

        if (search_for.isEmpty()) {
          JOptionPane.showMessageDialog(frame, "search string cannot be empty");
          return;
        }

        Pattern pattern = Pattern.compile(search_for);
        Matcher matcher = pattern.matcher(search_string);

        // highlight all matched substrings
        while (matcher.find()) {
          int begin = matcher.start();
          int end = matcher.end();
          System.out.println(matcher.group());
          
          frame.setHighlights(begin, end);
        }
      }
    });

    frame.getResetButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.clearHighlights();
        // scroll textarea back to the top
        frame.getTargetTextArea().setCaretPosition(0);
      }
    });

  }

  public static void main(String[] args) throws IOException {
    RegexSearch app = new RegexSearch();
    app.frame.setVisible(true);
  }
}
