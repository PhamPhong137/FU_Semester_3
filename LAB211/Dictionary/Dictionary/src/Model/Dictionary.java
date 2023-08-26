package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private Map<String, String> dict;

    public Dictionary() throws IOException {
        dict = new HashMap<>();
        loadData();

    }

    private void loadData() throws IOException {
        File f = new File("dictionary.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            String[] words = line.split("[-]");
            String eng = words[0].trim();
            String vie = words[1].trim();
            dict.put(eng, vie);   //them vao map

        }

        br.close(); //dong lai ko se gay mat data
        fr.close();
    }

    private void saveData() throws IOException {
        File f = new File("dictionary.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Map.Entry<String, String> entry : dict.entrySet()) {
            bw.write(entry.getKey() + " - " + entry.getValue() + "\n");
        }

        bw.close();
        fw.close();

    }

    public void addWord() throws IOException {
        System.out.println("------------- Add -------------");
        String eng = Validation.getString("Enter English: ");
        if (dict.containsKey(eng) && !Validation.getYN(eng + " is already exist in dictionary, do you want to update?(Y/N) ")) {
            return;
        } else {
            String vie = Validation.getString("Enter Vietnamese: ");
            dict.put(eng, vie);
        }
        saveData();
        System.out.println("ADD SUCCESSFUL !!!");
    }

    public void removeWord() throws IOException {
        System.out.println("------------ Delete ----------------");
        String eng = Validation.getString("Enter English: ");
        if (!dict.containsKey(eng)) {
            System.out.println("Not Found");
            return;
        } else {
            dict.remove(eng);
        }
        saveData();
        System.out.println("DELETE SUCCESSFULL !!!");
    }

    public void translate() throws IOException {
        System.out.println("------------- Translate ------------");
        String eng = Validation.getString("Enter English: ");
        
        if (!dict.containsKey(eng)) {
            System.out.println("Not Found");
        } else {
            System.out.println("Vietnamese: " + dict.get(eng));
        }
    }
}
