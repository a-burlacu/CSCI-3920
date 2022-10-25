package ser;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ObjectClient {

    public static void main(String[] args) {

        Socket client;

        ObjectOutputStream output = null;
        ObjectInputStream input = null;

        try{
            client = new Socket("localhost", 9888);

            output = new ObjectOutputStream(client.getOutputStream());
            input = new ObjectInputStream(client.getInputStream());

            try {
                // receive an obj, must cast to String
                String response = (String)input.readObject();
                System.out.println("SRV<<<" + response);

                //create objects here:
                Person p = Person.getSamplePerson();
                System.out.println("SRV>>>" + p);

                output.writeObject(p);
                output.flush();

                Person pp = (Person) input.readObject();
                System.out.println("SRV<<<" + pp);

            }
            catch(ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
        }
        catch(Exception e){

        }

    }

}
