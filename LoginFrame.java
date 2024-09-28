import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements MouseListener, ActionListener {
    private JPanel panel;
    private ImageIcon image, icon;
    private JButton btnLogin, btnBack;
    private JTextField phoneField;
    private JPasswordField passwordField;
    private JLabel phoneLabel, passwordLabel, lb2, titleLabel;

    public LoginFrame() {
        this.setTitle("AIUB BLOOD BANK");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        icon = new ImageIcon(getClass().getResource("bb.png"));
        this.setIconImage(icon.getImage());

        // Title label "User Login"
        titleLabel = new JLabel("User Login");
        titleLabel.setBounds(220, 30, 200, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(150, 100, 150, 30);
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneLabel.setForeground(Color.WHITE);
        panel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(270, 100, 200, 30);
        panel.add(phoneField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(150, 150, 150, 30);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(270, 150, 200, 30);
        panel.add(passwordField);

        btnBack = new JButton("Back");
        btnBack.setBounds(180, 220, 120, 50);
        panel.add(btnBack);
        btnBack.addActionListener(this);
        btnBack.addMouseListener(this);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(350, 220, 120, 50);
        panel.add(btnLogin);
        btnLogin.addActionListener(this);
        btnLogin.addMouseListener(this);

        image = new ImageIcon("login.JPG");
        lb2 = new JLabel(image);
        lb2.setBounds(0, 0, 600, 400);
        panel.add(lb2);
        lb2.setOpaque(true);

        this.add(panel);
    }

    public void mousePressed(MouseEvent me) {}

    public void mouseReleased(MouseEvent me) {}

    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == btnLogin) {
            String name = phoneField.getText();
            String pass = new String(passwordField.getPassword());

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your phone number.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your password.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
            }
        }
        if (me.getSource() == btnBack) {}
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == btnLogin) {
            btnLogin.setBackground(Color.GREEN);
        }
        if (me.getSource() == btnBack) {
            btnBack.setBackground(Color.RED);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == btnLogin) {
            btnLogin.setBackground(null);
        }
        if (me.getSource() == btnBack) {
            btnBack.setBackground(null);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnLogin) {
            String name = phoneField.getText();
            String pass = new String(passwordField.getPassword());

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your phone number.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your password.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Account acc = new Account("","",name, pass);
                if (acc.checkAccount(name, pass)) {
                    UserDashboard obj1 = new UserDashboard();
                    obj1.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "User doesn't exist");
                }
            }
        }

        if (ae.getSource() == btnBack) {
            setVisible(false);
            Home frame = new Home();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        LoginFrame frame = new LoginFrame();
        frame.setVisible(true);
    }
}
