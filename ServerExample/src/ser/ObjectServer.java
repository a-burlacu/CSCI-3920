package ser;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ObjectServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(9888, 5);
            Socket connection = null;

            ObjectOutputStream output = null;
            ObjectInputStream input = null;

            while (true) {
                connection = server.accept();

                output = new ObjectOutputStream(connection.getOutputStream());
                input = new ObjectInputStream(connection.getInputStream());

                // everything in Java is an object, so we can use String as object too
                output.writeObject("Connected to Java Object Server.");
                output.flush(); // must flush or the obj will remain in the buffer of the network connection until
                // it's full or the connection is terminated, flush deletes object
                try {
                    //accept object of type Person, cast Person obj to readObject
                    // may throw exception, since we don't actually know what we receive in readObject() is an object of
                    // Person type, can throw ClassNotFoundException()
                    Person p = (Person) input.readObject();
                    System.out.println(p);

                    Thread.sleep(3000);

                    //send the object back with new info
                    p.setName("Alina");
                    System.out.println("Sending>>>" + p);
                    output.writeObject(p);
                    output.flush();


                } catch (ClassNotFoundException cnfe) {
                    System.out.println(cnfe);

                }
                output.close();
                input.close();
                connection.close();

            }
        } catch (Exception e) {
            System.err.print(e);
        } finally {
            try {
                if (server != null) {
                    server.close();
                }
            } catch (Exception e) {

            }
        }
    }
}
