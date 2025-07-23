package UtdDsa.HashTables;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.println("Current directory: " + System.getProperty("user.dir"));
        try {
            // take in the txt file
            File file = new File("src/UtdDsa/HashTables/test2.txt");
            Scanner scanner = new Scanner(file);
            CustomHashTable myHashTable = new CustomHashTable();
            int lineNumber = 1;

            // take in one line at a time keeping track of the line number
            // read one word at a time
            // must clean the word of punctuation and make them all lower case
            // for each word insert it into the tree using the insert method with the line
            // number
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] words = line.split(" ");

                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z'-]", "").toLowerCase();
                    if (!word.isEmpty()) {
                        myHashTable.insert(word, lineNumber);
                    }
                }
                lineNumber++;
            }
            // print out the hash table
            myHashTable.print();
            scanner.close();
        } catch (Exception e) {
            System.out.println("There was an error:" + e);
        }

    }
}
