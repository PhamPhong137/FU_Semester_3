package textprocessing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import views.SearchFrame;

public class SubstringSearch {

  private final SearchFrame frame = new SearchFrame();

  private int search_start = 0;
  
  private String search_string;

  public SubstringSearch() throws IOException {
    frame.setTitle(getClass().getSimpleName());
    frame.setSize(750, 500);
    frame.setLocationRelativeTo(null);

    String load_file = "tell-tale-heart.txt";
    String content = new String(Files.readAllBytes(Paths.get(load_file)));

    // set initial content from file content
    frame.getTargetTextArea().setText(content);

    frame.getFindButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.getTargetTextArea().setEditable(false);
        
        frame.clearHighlights();

        // read search_string from textarea, avoid case issues
        search_string = frame.getTargetTextArea().getText().toLowerCase();
        
        // read search_from from textarea, avoid case issues
        String search_for = frame.getSearchTextField().getText().toLowerCase();
        
        int find_pos = search_string.indexOf(search_for, search_start);
        if (find_pos == -1) {
          JOptionPane.showMessageDialog(frame, "string not found");
        }
        else {
          frame.setHighlights(find_pos, find_pos + search_for.length());
          search_start = find_pos + 1;
        }
      }
    });

    frame.getResetButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.getTargetTextArea().setEditable(true);
        frame.clearHighlights();
        // scroll textarea back to the top
        frame.getTargetTextArea().setCaretPosition(0);
        // reset start position
        search_start = 0;
      }
    });
  }

  public static void main(String[] args) throws IOException {
    SubstringSearch app = new SubstringSearch();
    app.frame.setVisible(true);
  }
}
