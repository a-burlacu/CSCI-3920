package edu.ucdenver.printTask;

import java.security.SecureRandom;

public class PrintTask implements Runnable{
    //Static attribute to generate random sleep times
    private static final SecureRandom generator = new SecureRandom();

    //Instance attributes
    private final int sleepTime;    //final as we won't change that after the object is initialized
    private final String taskName;

    public PrintTask(String name){
        this.taskName = name;
        this.sleepTime = generator.nextInt(5000);  //will wait some time between 0 - 5000 ms (5sec)
    }

    @Override   //as we override the run method all errors go away.
    public void run(){
        try {
            System.out.printf("%s thread sleeping for %d milliseconds.%n",this.taskName, this.sleepTime);
            Thread.sleep(this.sleepTime);  //This will sleep the current thread not the main program.
            System.out.printf("%s done sleeping.%n",this.taskName);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();  //if thread was interrupted while sleeping, we need to re-interrupt the thread
            System.out.printf("%s interrupted.%n",this.taskName);
        }
    }






}
