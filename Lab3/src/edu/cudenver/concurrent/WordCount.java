package edu.cudenver.concurrent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCount implements Runnable {
    private final String filename;
    private final Map<String,Integer> wordCount;

    /**
     * Initializes the map to store the word count.
     */
    public WordCount(String filename){
        this.filename = filename;
        this.wordCount = new HashMap<>(10_000);
    }

    /**
     * Given a line counts the words and update the map
     * @param line line to inspect
     */
    private void countWords(String line){
        line = line.replaceAll("[^A-Za-z0-9 ]+", "");

        String[] tokens = line.split(" ");

        for (String token : tokens) {
            String word = token.toLowerCase();
            if (word.trim() == "")
                continue;
            if (this.wordCount.containsKey(word)) {
                int count = this.wordCount.get(word);
                this.wordCount.put(word, count + 1);
            }
            else {
                this.wordCount.put(word, 1);
            }
        }
         //TODO : Count the words in the line, and update the instance variable map.
    }


    public Map<String,Integer> getWordCount(){
        return this.wordCount;
    }


    /*
    * TODO : Implement the methods to execute in the thread.
    *  In summary: open the file, read the lines, and for each line count the words.
    *
    * */

    @Override
    public void run() {

        System.out.println("Executing thread...." + filename);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(this.filename));
            String line = reader.readLine();
            while (line != null) {
                this.countWords(line);
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
