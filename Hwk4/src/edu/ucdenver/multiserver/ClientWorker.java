package edu.ucdenver.multiserver;

import edu.ucdenver.morse.Morse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Objects;

public class ClientWorker implements Runnable{
    private Server server;
    private Socket connection;
    private Boolean keepRunningClient;
    private PrintWriter output;
    private BufferedReader input;

    private Morse morse;

    public ClientWorker(Server server,Socket connection){
        this.connection = connection;
        this.server = server;
        this.morse = new Morse();
        this.keepRunningClient = true;

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

    private void closeConnection(){
        try{this.input.close();} catch(IOException|NullPointerException e){e.printStackTrace();}
        try{this.output.close();} catch(NullPointerException e){e.printStackTrace();}
        try{this.connection.close();} catch(IOException|NullPointerException e){e.printStackTrace();}
    }

    protected String processClientMessage(String message) throws IOException {
        displayMessage("CLIENT SAID >> " + message);

        /*  ::: PROTOCOL ::
        "E|text" → requesting the server to encode the clean text "text" into Morse Code.
        "D|morse" → requesting the server to decode the received text "morse" from Morse Code into clean text.
        "T|" → Indicates that the client will disconnect and the client worker should stop listening for new messages
        "TERMINATE|" → when a client sends this command, the server will start the shutdown process
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

                case "T":
                    this.keepRunningClient = false;
                    response = "0|OK";
                    break;

                case "TERMINATE":
                    server.shutdown();
                    response = "0|OK";
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


    protected void forceShutdown() throws IOException {
        this.keepRunningClient = false;
        connection.close();
    }


    @Override
    public void run() {
        BufferedReader input;
        PrintWriter output;
        String message;

        displayMessage("Getting Data Streams");
        try {
            output = getOutputStream(connection);
            input = getInputStream(connection);

            String inputMessage = input.readLine();

            while (this.keepRunningClient) {
                message = processClientMessage(inputMessage);
                if (Objects.equals(message, "T|")) {
                    sendMessage("0|OK", output);
                    this.keepRunningClient = false; // while loop ends
                    break;
                }
                displayMessage(message);
                sendMessage(message, output);
                inputMessage = input.readLine();

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                System.out.println("Terminating connection");
                closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                server.shutdown(); // then finally close the socket
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
