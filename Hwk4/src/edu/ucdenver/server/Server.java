package edu.ucdenver.server;

import edu.ucdenver.morse.Morse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

public class Server implements Runnable {

    private int port;
    private int backlog;
    private int connectionCounter;
    private Socket connection;
    private ServerSocket socketServer;



    public Server(int port, int backlog) {
        this.port = port;
        this.backlog = backlog;
        this.connectionCounter = 0;

        try {
            this.socketServer = new ServerSocket(this.port, this.backlog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Socket waitForConnection() throws IOException {
        System.out.println("Waiting for a connection....");
        this.connection = this.socketServer.accept();
        this.connectionCounter++;
        System.out.printf("Connection #%d accepted from %s %n", this.connectionCounter,
                this.connection.getInetAddress().getHostName());

        return this.connection;
    }

    private void sendMessage(String message, PrintWriter output) {
        //displayMessage("[SRV]SERVER << " + message);
        output.println(message);
    }

    private void displayMessage(String message) {
        System.out.println("[SRV]" + message);
    }

    private PrintWriter getOutputStream(Socket connection) throws IOException {
        return new PrintWriter(connection.getOutputStream(), true);
    }

    private BufferedReader getInputStream(Socket connection) throws IOException {
        return new BufferedReader(new InputStreamReader(connection.getInputStream()));
    }

    private void closeConnection(Socket connection, BufferedReader input, PrintWriter output) {
        // Try to close all input, output and socket
        try {
            output.close();
            input.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String processClientMessage(String message) throws IOException {
        displayMessage("CLIENT SAID >> " + message);

        /*  ::: PROTOCOL ::
        "E|text" → requesting the server to encode the clean text "text" into Morse Code.
        "D|morse" → requesting the server to decode the received text "morse" from Morse Code into clean text.
         */

        String[] arguments = message.split("\\|"); // this splits the string using | as delimiter
        String response; // This will be the response to the server

        try {
            Morse morse = new Morse();
            switch (arguments[0]) { //arguments[0] must be the command
                case "E": // encode text
                    if(arguments[1] != null) {
                        response = "0|" + morse.encode(arguments[1]);
                    }
                    else{
                        response = "2| Invalid Message Format";
                    }
                    break;
                case "D": // decode morse
                    if(arguments[1] != null) {
                        response = "0|" + morse.decode(arguments[1]);
                    }
                    else{
                        response = "2| Invalid Message Format";
                    }
                    break;

                default:
                    response = "1| Not Implemented: Unknown Command";
            }
        }
        catch(IllegalArgumentException iae) {
            response = "ERR| " + iae.getMessage();
        }

        return response;
    }



    @Override
    public void run() {

        PrintWriter output = null;
        BufferedReader input = null;
        this.connection = null;

        while (true){
            try {
                this.connection = this.waitForConnection();

                displayMessage("Getting Data Streams");
                output = getOutputStream(connection);
                input = getInputStream(connection);


                // Now we process the requests and send the responses
                displayMessage("Connected to simple Java Server");
                String clientMessage = input.readLine();
                String response;
                while (clientMessage != null) {
                    response = processClientMessage(clientMessage);
                    displayMessage(response);
                    sendMessage(response,output);
                    clientMessage = input.readLine();
                }
            }
            catch (Exception e) {
                break;
            }
            finally {
                try {
                    System.out.println("Terminating connection....");
                    closeConnection(connection, input, output); // close connection here when it is done looping
                    //++connectionCounter;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    socketServer.close(); // then finally close the socket
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



