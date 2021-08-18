import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SocketServer
{
    DataInputStream inputData;
    DataOutputStream outputData;
    Socket s;
    int port;

    public SocketServer(int port) throws IOException
    {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server Socket is online on port " + port);
        s = ss.accept();
        System.out.println("Connection with client established");

        ArrayList<String> questions = new ArrayList<String>();
        ArrayList<String> responses = new ArrayList<String>();
        questions.add("Enter Student Number : ");
        questions.add("Enter Student Name : ");
        questions.add("Enter Faculty, Course and Degree : ");
        questions.add("Enter Personal Code : ");

        for(int i=0; i<4; i++)
        {
            outputData = new DataOutputStream(s.getOutputStream());
            outputData.writeUTF(questions.get(i));
            outputData.flush();

            inputData = new DataInputStream(s.getInputStream());
            responses.add(inputData.readUTF());
            System.out.println(responses.get(i));

            outputData.writeUTF("Response received : " + responses.get(i));

        }

    }

}
