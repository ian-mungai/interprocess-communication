import java.io.*;
import java.net.*;

public class SocketClient
{
    Socket s;
    DataOutputStream data;

    public SocketClient(String ip, int port ) throws IOException
    {
        s = new Socket(ip ,port);
        System.out.println("Connection with server established");
        data = new DataOutputStream(s.getOutputStream());
    }

    public void inputs(String input) throws IOException
    {
        data.writeUTF(input);
        data.flush();
        data.close();
    }

}
