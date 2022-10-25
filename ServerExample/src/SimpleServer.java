import jdk.internal.util.xml.impl.Input;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        System.out.println("Running SERVER App");

        try{
            //"listen"
            ServerSocket serverSocket = new ServerSocket(9888,5); //constructor sets up port to already "listen"
            Socket client = null;
            BufferedReader input = null; //take string and convert to bytes
            PrintWriter output = null;  //read from input stream and return string

            while(true) {
                try{
                    System.out.println("Waiting for connection...");
                    // "accept"
                    client = serverSocket.accept(); //takes server socket that is already listening, wait till
                    // connection avail then accept, returns new socket for client

                    System.out.println("Connection From:" + client.getInetAddress().getHostName());

                    System.out.println("GET Input/Output Streams");

                    // open input/output streams
                    input = new BufferedReader(new InputStreamReader(client.getInputStream()));

                    output = new PrintWriter(client.getOutputStream(), true); //'flush' sends the string immediately

                    Thread.sleep(3000); //slows the program so we can see what happens

                    // "send"
                    output.println("Hello - Connected to Java Simple Server.");
                    //"read"
                    String clientMsg = input.readLine();

                    System.out.println("[CLI]<<"+clientMsg);
                    //"send"
                    output.println(clientMsg.toUpperCase());
                }
                catch (Exception e) {
                    System.err.println(e);
                }
                finally {
                    System.out.println("Terminating connection...");
                    try{
                        output.close();
                        input.close();
                        client.close();

                    }
                    catch(Exception e){

                    }
                }
            }
        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
