package edu.ucdenver.printTask;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) {
        //let's create 3 thread of printtask runnable objects
        ArrayList<PrintTask> tasks = new ArrayList<>();
        tasks.add(new PrintTask("task1"));
        tasks.add(new PrintTask("task2"));
        tasks.add(new PrintTask("task3"));

        System.out.println(">> Starting Execution");

        //Create a ExecutionService object which will manage the threads.
        ExecutorService executorService = Executors.newCachedThreadPool();   //don't use new! we use the Factory Executors

        for (PrintTask task : tasks){
            executorService.execute(task);
        }



        //at this point all three threads are running

        // Shut down Executor Service   --- the ES will decide when to shut down threads.
        // this will also prevent new tasks (threads) to be added to the execution service.

//        executorService.shutdown();
        try {
            executorService.awaitTermination(2, TimeUnit.SECONDS);
            executorService.shutdownNow();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(">>> tasks started, main thread ends. \n");
    }
}
