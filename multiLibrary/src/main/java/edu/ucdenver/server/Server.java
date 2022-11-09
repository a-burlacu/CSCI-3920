package edu.ucdenver.server;

import edu.ucdenver.library.Library;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final int port;
    private final int backlog; // how many clients can wait until they get connected
    private int connectionCounter; // keep track of how many clients are connected
    private ServerSocket serverSocket;


    private Library library;


    public Server(int port, int backlog) {
        this.port = port;
        this.backlog = backlog;
        this.connectionCounter = 0;
        this.library = new Library("Auraria");
    }

    public Server() {
        this(9888, 10);
    }


    private Socket waitForClientConnection() throws IOException {
        System.out.println("Waiting for a connection....");
        Socket clientConnection = this.serverSocket.accept();
        this.connectionCounter++;
        System.out.printf("Connection #%d accepted from %s %n", this.connectionCounter,
                clientConnection.getInetAddress().getHostName());

        return clientConnection;
    }


    /**
     * Will run the server using the information stored in the object
     */
    public void runServer() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            this.serverSocket = new ServerSocket(this.port, this.backlog);

            while (true) {
                try {
                    Socket clientConnection = this.waitForClientConnection();

                    // Create new thread that executes the client connection
                    ClientWorker cw = new ClientWorker(clientConnection, this.library, this.connectionCounter);

                    executorService.execute(cw);
                }
                catch (IOException ioe) {
                    System.out.println("\n-------------------\nServer Terminated");
                    ioe.printStackTrace();
                }
            }
        } catch (IOException ioe) {
            System.out.println("\n++++++ Cannot open the server ++++++\n");
            executorService.shutdown();
            ioe.printStackTrace();
        }
    }
}
