import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Registration extends JFrame implements MouseListener, ActionListener {
    private JPanel panel;
    private ImageIcon image, icon;
    private JLabel label1, lb2, nameLabel, emailLabel, phoneLabel, passwordLabel, titleLabel;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField nameField, emailField, phoneField, tf5;
    private JPasswordField passwordField;
    private JButton btn1, btn2, btn3, btn4, btnClear;
    private Color color1, color2, color3;
    private int a, b; 

    public Registration() {
        this.setTitle("AIUB BLOOD BANK ");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        icon = new ImageIcon(getClass().getResource("bb.png"));
        this.setIconImage(icon.getImage());

        f1 = new Font("Segoe UI Black", Font.BOLD, 35);
        f2 = new Font("Segoe UI Black", Font.BOLD, 25);
        f3 = new Font("Segoe UI Semibold", Font.BOLD, 35);
        f4 = new Font("Segoe UI", Font.BOLD, 28);
        f5 = new Font("Segoe UI", Font.BOLD, 21);
        f6 = new Font("Segoe UI", Font.BOLD, 27);

        titleLabel = new JLabel("User Information");
        titleLabel.setBounds(250, 20, 300, 40);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(200, 100, 150, 40);
        nameLabel.setFont(f4);
        nameLabel.setForeground(Color.WHITE);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(350, 105, 215, 30);
        nameField.setFont(f5);
        panel.add(nameField);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(200, 150, 150, 40);
        emailLabel.setFont(f4);
        emailLabel.setForeground(Color.WHITE);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(350, 155, 215, 30);
        emailField.setFont(f5);
        panel.add(emailField);

        phoneLabel = new JLabel("Phone Num:");
        phoneLabel.setBounds(180, 200, 180, 40);
        phoneLabel.setFont(f4);
        phoneLabel.setForeground(Color.WHITE);
        panel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(350, 205, 215, 30);
        phoneField.setFont(f5);
        panel.add(phoneField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(200, 250, 150, 40);
        passwordLabel.setFont(f4);
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(350, 255, 215, 30);
        passwordField.setFont(f5);
        panel.add(passwordField);
		
		 Random rand = new Random();
        a = rand.nextInt(10);
        b = rand.nextInt(10);

        label1 = new JLabel();
        label1.setText(" " + a + " + " + b + " ");
        label1.setBounds(220, 300, 150, 40);
        label1.setFont(f4);
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        tf5 = new JTextField();
        tf5.setBounds(350, 305, 215, 30);
        tf5.setFont(f5);
        panel.add(tf5);

        btn1 = new JButton("Exit");
        btn1.setBounds(600, 400, 150, 50);
        btn1.setFont(f2);
        panel.add(btn1);
        btn1.addActionListener(this);
        btn1.addMouseListener(this);

        btn2 = new JButton("Back");
        btn2.setBounds(50, 400, 150, 50);
        btn2.setFont(f2);
        panel.add(btn2);
        btn2.addActionListener(this);
        btn2.addMouseListener(this);

        btn4 = new JButton("Register");
        btn4.setBounds(600, 170, 150, 50);
        btn4.setFont(f2);
        panel.add(btn4);
        btn4.addActionListener(this);
        btn4.addMouseListener(this);

        btnClear = new JButton("Clear");
        btnClear.setBounds(600, 230, 150, 50);
        btnClear.setFont(f2);
        panel.add(btnClear);
        btnClear.addActionListener(this);

        image = new ImageIcon("Registration.JPG");
        lb2 = new JLabel(image);
        lb2.setBounds(0, 0, 1000, 800);
        panel.add(lb2);
        lb2.setOpaque(true);

        this.add(panel);
    }

    public void mousePressed(MouseEvent me) {}

    public void mouseReleased(MouseEvent me) {}

    public void mouseClicked(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == btn1) {
            btn1.setBackground(Color.RED);
        }
        if (me.getSource() == btn2) {
            btn2.setBackground(Color.GREEN);
        }
        if (me.getSource() == btn4) {
            btn4.setBackground(Color.BLUE);
        }
        if (me.getSource() == btnClear) {
            btnClear.setBackground(Color.YELLOW);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == btn1) {
            btn1.setBackground(null);
        }
        if (me.getSource() == btn2) {
            btn2.setBackground(null);
        }
        if (me.getSource() == btn4) {
            btn4.setBackground(null);
        }
        if (me.getSource() == btnClear) {
            btnClear.setBackground(null);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            System.exit(0);
        }

        if (ae.getSource() == btn2) {
            setVisible(false);
            Home frame = new Home();
            frame.setVisible(true);
        }

        if (ae.getSource() == btn4) {
            String s1, s2, s3, s4, s5;
            s1 = nameField.getText();
            s2 = emailField.getText();
            s3 = phoneField.getText();
            s4 = passwordField.getText();
            s5 = tf5.getText();

            int result = 0;
            if (s5.isEmpty()) { 
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                result = Integer.parseInt(s5); 
                if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Fill All");
                } else if (result != (a + b)) {
                    JOptionPane.showMessageDialog(null, "Wrong Captcha.", "Warning!", JOptionPane.WARNING_MESSAGE);
                } else {
                    Account acc = new Account(s1, s2, s3, s4);
                    if (acc.checkAccount(s3, s4)) {
                        JOptionPane.showMessageDialog(this, "Already exist");
                    } else {
                        acc.addAccount(acc);
                        JOptionPane.showMessageDialog(this, "Added");
                    }
                }
            }
        }

        if (ae.getSource() == btnClear) {
            this.setVisible(false);
            Registration frame = new Registration();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Registration frame = new Registration();
        frame.setVisible(true);
    }
}
