package Guide;

import Model.Dictionary;
import Model.Validation;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
public class Menu {

    private static String[] ops = {
        "Add word",
        "Delete word",
        "Translate",
        "Exit"
    };

    public static void display() throws IOException {
        Dictionary d = new Dictionary();
        int choice;

        do {
            System.out.println("======== Dictionary program ========");
            for (int i = 0; i < ops.length; i++) {
                System.out.println((i + 1) + ". " + ops[i]);
            }
            choice = Validation.getInt("Choose: ", 1, ops.length);
            switch (choice) {
                case 1:
                    d.addWord();
                    break;
                case 2:
                    d.removeWord();
                    break;
                case 3:
                    d.translate();
                    break;
                case 4:
                    break;
            }
        } while (choice != ops.length);
    }
}
