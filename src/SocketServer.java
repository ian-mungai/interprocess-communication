import java.io.*;
import java.net.*;

public class SocketServer
{
    DataInputStream dis;
    Socket s;

    public SocketServer(int port) throws IOException
    {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server Socket is online on port " + port);
        s = ss.accept();
        System.out.println("Connection with client established");
    }

    public String outputs() throws IOException
    {
        dis = new DataInputStream(s.getInputStream());
        String str ="";

        while(dis != null)
        {
            str = dis.readUTF();
            break;
        }

        return str;
    }
}
