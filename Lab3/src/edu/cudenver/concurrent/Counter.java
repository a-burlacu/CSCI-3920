package edu.cudenver.concurrent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Counter {
    private final String filePath;
    private final Map<String, Integer> totalWordCount;

    public Counter(String filePath){
        this.filePath = filePath;
        this.totalWordCount = new HashMap<>(10_000);
    }

    /**
     * Process all files in the filepath.
     */
    public void processFiles() {

        /*
        for each folder name, create a new thread for every file in the folder
        String[] foldernames = f.list(); is a list of folder names
        for each folder in foldernames:
               create new String[] filenames = foldernames.list() ? <- create new list of filenames

        WordCount(filePath + / + foldername + / + filename) <- new thread for one .txt file
         */
//        File folder = new File(this.filePath);
//        String[] foldernames = folder.list(); // Populates the array with names of directories
//
//        ArrayList<String> filename = new ArrayList<>();
//
//        for(int i=0; i<foldernames.length;i++) { //Populates arraylist with names of files
//            File f = new File(this.filePath+ "\\" +foldernames[i]);
//            String[] f1 = f.list();
//            filename.addAll(Arrays.asList(f1));
//        }
//
//        for(String file : foldernames) {
//            File f = new File(file);
//            String[] filenames = f.list();
//
//            ArrayList<WordCount> threads = new ArrayList<>();
//
//            if (filenames != null) {  //successfully retrieved filenames
//                ExecutorService executorService = Executors.newCachedThreadPool();
//
//                for (String file1 : filenames) {
//                    System.out.println(".");
//                    threads.add(new WordCount(file1));
//                }
//                for (WordCount thread : threads) {
//                    executorService.execute(thread);
//                    updateMap(this.totalWordCount, thread.getWordCount());
//                }
//                try {
//                    executorService.awaitTermination(5, TimeUnit.MINUTES);
//                    executorService.shutdownNow();
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                throw new FileNotFoundException("Filename not found");
//            }
//        }
        File directory = new File(this.filePath);
        String[] directories = directory.list();

        assert directories != null;
        for(String d : directories) {
            File filename = new File(this.filePath + "/" +d);
            String[] filenames = filename.list();

            ArrayList<WordCount> threads = new ArrayList<>();

            if(filenames != null) {

                for(String file: filenames){
                    System.out.println(".");
                    threads.add(new WordCount(this.filePath + "\\" + d + "\\" + file));
                }
                ExecutorService executorService = Executors.newCachedThreadPool();

                for(WordCount thread : threads){
                    executorService.execute(thread);
                    updateMap(this.totalWordCount,thread.getWordCount());
                }
                try {
                    executorService.awaitTermination(5, TimeUnit.MINUTES);
                    executorService.shutdownNow();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.printf("Invalid File Path. %n");
            }
        }
    }

    /**
     * Returns the total Word Count map
     * @return returns the total word count map
     */
    public Map<String, Integer> getTotalWordCount() {
        return totalWordCount;
    }


    /**
     * Appends the counts from Map 2 into Map 1.
     * @param map1 first main map. This map object will be updated with map2
     * @param map2 map to add to map1
     */
    private synchronized void updateMap(Map<String, Integer> map1,Map<String, Integer> map2 ){

        for (Map.Entry<String,Integer> entry : map2.entrySet()) {
            if  (map1.containsKey(entry.getKey())) {
                int count = map1.get(entry.getKey());
                map1.put(entry.getKey(), count + entry.getValue());
            }
            else {
                map1.put(entry.getKey(), entry.getValue());
            }
        }
    }
}
