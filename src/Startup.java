import javax.swing.*;
import java.awt.*;

public class Startup extends JFrame
{
    JButton submit = new JButton("Submit");
    JButton exit = new JButton("Exit");
    JLabel ipLabel = new JLabel("Enter Server IP address : ");
    JTextField ip = new JTextField();
    JLabel portLabel = new JLabel("Enter Port number : ");
    JTextField port = new JTextField();

    public Startup()
    {
        ipLabel.setBounds(10,10,200,50);
        ipLabel.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        ipLabel.setBackground(new Color(255, 255, 255));
        ipLabel.setForeground(Color.black);

        ip.setBounds(200,10,200,40);
        ip.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        ip.setBackground(new Color(255, 255, 255));
        ip.setForeground(Color.black);

        portLabel.setBounds(10,80,200,50);
        portLabel.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        portLabel.setBackground(new Color(255, 255, 255));
        portLabel.setForeground(Color.black);

        port.setBounds(200,80,200,40);
        port.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        port.setBackground(new Color(255, 255, 255));
        port.setForeground(Color.black);

        submit.setBounds(10,150,200,50);
        submit.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        submit.setBackground(new Color(255, 255, 255));
        submit.setForeground(Color.black);

        exit.setBounds(250,150,200,50);
        exit.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        exit.setBackground(new Color(255, 255, 255));
        exit.setForeground(Color.black);

        add(ipLabel);
        add(ip);
        add(portLabel);
        add(port);
        add(submit);
        add(exit);

        setTitle("Startup");
        setLayout(null);
        setSize(500,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        submit.addActionListener(e -> {
            try {
                int portNumber = Integer.parseInt(port.getText().trim());
                String ipAddress = ip.getText().trim();

                dispose();

                SocketServer ss = new SocketServer(portNumber);
                SocketClient sc = new SocketClient(ipAddress,portNumber);

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        });

        exit.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args)
    {
        Startup st = new Startup();
        st.setVisible(true);
    }

}
