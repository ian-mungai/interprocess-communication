import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.IOException;

public class ServerProtocol extends JFrame
{
    JButton exit = new JButton("Exit");
    JTextArea textArea = new JTextArea();

    public ServerProtocol(int port) throws IOException
    {
        SocketServer ss = new SocketServer(port);

        textArea.setBounds(10, 10, 1000, 600);
        textArea.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
        textArea.setBackground(new Color(255, 255, 255));
        textArea.setForeground(Color.black);
        textArea.setBorder(new MatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));

        exit.setBounds(10, 640, 200, 50);
        exit.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
        exit.setBackground(new Color(255, 255, 255));
        exit.setForeground(Color.black);

        add(textArea);
        add(exit);

        setTitle("Server Protocol");
        setLayout(null);
        setVisible(true);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exit.addActionListener(e -> System.exit(0));

    }

}
