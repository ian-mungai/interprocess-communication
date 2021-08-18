import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketClient
{
    Socket s;
    DataOutputStream outputData;
    DataInputStream inputData;

    public SocketClient(String ip, int port ) throws IOException
    {
        String response = "Input received : ";
        String question;

        s = new Socket(ip ,port);
        System.out.println("Connection with server established");

        for(int i=0; i<4; i++)
        {
            inputData = new DataInputStream(s.getInputStream());
            outputData = new DataOutputStream(s.getOutputStream());

            question = inputData.readUTF();
            System.out.println(question);

            Scanner inputScanner = new Scanner(System.in);

            outputData.writeUTF(response + inputScanner.nextLine());
            outputData.flush();
        }

    }

}
