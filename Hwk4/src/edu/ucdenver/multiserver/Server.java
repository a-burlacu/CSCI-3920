package edu.ucdenver.multiserver;

import edu.ucdenver.morse.Morse;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {
    private final int port;
    private final int backlog; // how many clients can wait until they get connected
    private int connectionCounter; // keep track of how many clients are connected
    private ServerSocket socketServer;
    private boolean keepServerRunning;

    ArrayList<ClientWorker> clientWorkers = new ArrayList<>(); //List of client connections

    public Server(int port, int backlog) {
        this.port = port;
        this.backlog = backlog;
        this.connectionCounter = 0;
        this.keepServerRunning = true;

    }

    private void displayMessage(String message) { // We can improve this method to be log-type one
        System.out.printf("CLIENT[%d] >> %s%n", this.connectionCounter, message);
    }

    private Socket waitForClientConnection() throws IOException {
        System.out.println("Waiting for a connection....");
        Socket connection = this.socketServer.accept();
        this.connectionCounter++;
        System.out.printf("Connection #%d accepted from %s %n", this.connectionCounter,
                connection.getInetAddress().getHostName());

        return connection;
    }

    @Override
    public void run() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            this.socketServer = new ServerSocket(this.port, this.backlog);

            while (keepServerRunning) {
                try {
                    Socket connection = this.waitForClientConnection();


                    // Create new thread that executes the client connection
                    ClientWorker cw = new ClientWorker(new Server(this.port, this.backlog), connection);
                    executorService.execute(cw);
                    clientWorkers.add(cw);
                    connectionCounter++;
                } catch (IOException ioe) {
                    System.out.println("\n-------------------\nServer Terminated");
                    ioe.printStackTrace();
                    break;
                }
            }
        } catch (IOException ioe) {
            System.out.println("\n++++++ Cannot open the server ++++++\n");
            executorService.shutdown();
            ioe.printStackTrace();
        }
    }

    public void shutdown() throws IOException {

        try {
            keepServerRunning = false;
            socketServer.close();
        } catch (IOException e) {
            //  e.printStackTrace(); //ignoring errors
        } finally {
            // Shut down client workers one by one?
            for (ClientWorker worker : clientWorkers)
                worker.forceShutdown();
        }
    }
}
