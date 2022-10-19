import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {

        System.out.println("Running CLIENT App");

        Socket serverConnection = null;
        BufferedReader input = null;
        PrintWriter output = null;
        String message = "";
        try{
            System.out.println("Connecting to Server...");

            // "connect"
            serverConnection = new Socket("127.0.0.1", 9888);

            // create input/output streams
            input = new BufferedReader(new InputStreamReader(serverConnection.getInputStream()));
            output = new PrintWriter(serverConnection.getOutputStream(), true);

            //"read"
            String response = input.readLine();
            System.out.println("[SRV]>>"+response);

            //"send"
            message = "Hello, welcome to networking!";

            //"read & print"
            output.println(message);
            response = input.readLine();
            System.out.println("[SRV]>>"+response);

        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                input.close();
                output.close();
                serverConnection.close();

            }
            catch(IOException|NullPointerException e) {
                System.err.println(e);
            }
        }

    }
}
