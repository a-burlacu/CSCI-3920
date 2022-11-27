package edu.ucdenver.server;

import edu.ucdenver.library.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;

public class ClientWorker implements Runnable {

    private final Socket clientConnection; // the reference is not changing, but the state(content of the object) will
    private final Library library;
    private final int id;

    private PrintWriter output;
    private BufferedReader input;
    private boolean keepRunningClient;



    public ClientWorker(Socket connection, Library library, int id){
        this.clientConnection = connection;
        this.library = library;
        this.id = id;
        this.keepRunningClient = true;

    }

    private void getOutputStream(Socket clientConnection) throws IOException {
        this.output = new PrintWriter(clientConnection.getOutputStream(), true);
    }

    private void getInputStream(Socket clientConnection) throws IOException {
        this.input = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
    }

    private void sendMessage(String message) {
        displayMessage("SERVER << " + message);
        this.output.println(message);
    }

    private void processClientRequest() throws IOException {

        String clientMessage = this.input.readLine(); //recv from client
        displayMessage("CLIENT SAID >> " + clientMessage);

        /*  ::: PROTOCOL :::
        server will take this message and perform action based on "command" (aka first letter)
        take clientMessage and split it, use switch() statement to execute appropriate action
        "B|" -> add Book
        "B|My Book|2020,10,01|150|John Grisham"

        "A|" -> add Author
        "A|John Grisham"

        "L|" -> print the Library

        "T|" -> TERMINATE CLIENT CONNECTION
         */

        String[] arguments = clientMessage.split("\\|"); // this splits the string using | as delimiter
        String response; // This will be the response to the server

        try {
            switch (arguments[0]) { //arguments[0] must be the command
                case "A": // add Author
                    this.library.addAuthor(arguments[1]);
                    response = "OK|";
                    break;
                case "B":
                    String[] dateFields = arguments[2].split(","); //"YYYY","MM,"DD"
                    LocalDate date = LocalDate.of(Integer.parseInt(dateFields[0]), Integer.parseInt(dateFields[1]), Integer.parseInt(dateFields[2]));
                    this.library.addBook(arguments[1], date, Integer.parseInt(arguments[3]), arguments[4]);
                    response = "OK|";
                    break;
                case "L":
                    response = "OK|" + this.library.toString();
                    break;
                case "T":
                    this.keepRunningClient = false;
                    response = "OK|";
                    break;
                default:
                    response = "ERR| Unknown Command";
            }
        }
        catch(IllegalArgumentException iae) {
            response = "ERR| " + iae.getMessage();
        }

        this.sendMessage(response);
    }

    private void closeClientConnection() {
        // Try to close all input, output and socket
        try {
            this.input.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        try {
            this.output.close();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            this.clientConnection.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void displayMessage(String message) { // We can improve this method to be log-type one
        System.out.printf("CLIENT[%d] >> %s%n", this.id,message);
    }

    @Override
    public void run() {
        displayMessage("Getting Data Streams");
        try {
            getOutputStream(clientConnection);
            getInputStream(clientConnection);

            // Now we process the requests and send the responses
            sendMessage("Connected to simple Java Server");

            while (this.keepRunningClient) {
                processClientRequest();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            closeClientConnection();
        }
    }
}
