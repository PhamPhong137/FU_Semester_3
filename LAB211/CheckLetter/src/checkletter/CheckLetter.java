/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkletter;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import sun.util.locale.StringTokenIterator;

/**
 *
 * @author PC-Phong
 */
public class CheckLetter {

    public static String checkInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your content: ");
            String content = scanner.nextLine();
            if (content.isEmpty()) {
                System.out.println("Content must be a non-empty string");
            } else {
                return content;
            }
        }
    }

    public static HashMap<String, Integer> wordCount(String content) {
        HashMap<String, Integer> wordCount = new HashMap<>();
//        String[] words = content.split(" ");
//        for (String word : words) {
//            if (wordCount.containsKey(word)) {
//                wordCount.put(word, wordCount.get(word) + 1);
//            } else {
//                wordCount.put(word, 1);
//            }
//        }
//        return wordCount;

        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCount.containsKey(token)) {
                wordCount.put(token, 1);
            } else {
                wordCount.put(token, ((int) wordCount.get(token)) + 1);
            }
        }
        return wordCount;
    }

    public static HashMap<Character, Integer> charCount(String content) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : content.toCharArray()) {
            if (c != ' ') {
                if (charCount.containsKey(c)) {
                    charCount.put(c, charCount.get(c) + 1);
                } else {
                    charCount.put(c, 1);
                }
            }
        }
        return charCount;
    }

    public static void display(String content) {
        System.out.println(wordCount(content));
        System.out.println(charCount(content));
    }

    public static void main(String[] args) {
        String content = checkInput();
        display(content);
    }

}
