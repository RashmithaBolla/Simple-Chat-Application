import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleChatApplication extends JFrame implements ActionListener {

    JComboBox users;        
    JTextArea chatArea;
    JTextField textField;
    JButton sendButton;

    public SimpleChatApplication() {

        setTitle("Simple Chat App");
        setSize(400, 400);
        setLayout(new BorderLayout());

        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);

        // WhatsApp light background (same)
        chatArea.setBackground(new Color(240, 242, 245));
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        // Bottom Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // ComboBox
        String names[] = {"Gracy", "Rashmitha", "Nikitha","Nithya","Dhathri"};
        users = new JComboBox(names);
        panel.add(users, BorderLayout.WEST);

        // Text Field
        textField = new JTextField();
        panel.add(textField, BorderLayout.CENTER);

        // Send Button (WhatsApp green)
        sendButton = new JButton("Send");
        sendButton.setBackground(new Color(37, 211, 102));
        sendButton.setForeground(Color.WHITE);
        sendButton.addActionListener(this);
        panel.add(sendButton, BorderLayout.EAST);

        add(panel, BorderLayout.SOUTH);

        // ⭐ UNIQUE BACKGROUND COLOR ADDED HERE ⭐
        getContentPane().setBackground(new Color(180, 200, 255));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = (String) users.getSelectedItem();
        String msg = textField.getText();

        if (!msg.equals("")) {
            chatArea.append(user + ": " + msg + "\n");
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new SimpleChatApplication();
    }
}