import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements MouseListener, ActionListener {
    private JPanel panel;
    private JLabel titleLabel, imgLabel;
    private Font f1, f2;
    private JButton btn1, btn2, btn3, btn4, btn5;
    private ImageIcon image;

    public Home() {
        this.setTitle("AIUB BLOOD BANK ");
        this.setSize(600, 500); // Width, Height
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        f1 = new Font("Tahoma", Font.BOLD, 48);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Title Label
        titleLabel = new JLabel("AIUB Blood Bank");
        titleLabel.setBounds(5, 30, 590, 60);
        titleLabel.setFont(f1);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        // Buttons in the middle
        int buttonWidth = 195;
        int buttonHeight = 50;
        int buttonX = (600 - buttonWidth) / 2; // Center X position

        btn1 = new JButton("Login");
        btn1.setBounds(buttonX, 130, buttonWidth, buttonHeight);
        btn1.setFont(f2);
        btn1.addMouseListener(this);
        btn1.addActionListener(this);
        panel.add(btn1);

        btn2 = new JButton("Sign Up"); // Renamed from "Register" to "Sign Up"
        btn2.setBounds(buttonX, 200, buttonWidth, buttonHeight);
        btn2.setFont(f2);
        btn2.addMouseListener(this);
        btn2.addActionListener(this);
        panel.add(btn2);

        btn4 = new JButton("Admin Login");
        btn4.setBounds(buttonX, 270, buttonWidth, buttonHeight);
        btn4.setFont(f2);
        btn4.addMouseListener(this);
        btn4.addActionListener(this);
        panel.add(btn4);

        // Back and Exit Buttons at bottom corners
        btn5 = new JButton("Back");
        btn5.setBounds(20, 400, 150, 50);
        btn5.setFont(f2);
        btn5.addMouseListener(this);
        btn5.addActionListener(this);
        panel.add(btn5);

        btn3 = new JButton("Exit");
        btn3.setBounds(420, 400, 150, 50);
        btn3.setFont(f2);
        btn3.addMouseListener(this);
        btn3.addActionListener(this);
        panel.add(btn3);

        // Background Image
        image = new ImageIcon("home.JPG");
        imgLabel = new JLabel(image);
        imgLabel.setBounds(0, 0, 600, 500);
        panel.add(imgLabel);
        imgLabel.setOpaque(true);

        this.add(panel);
    }

    public void mousePressed(MouseEvent me) {}

    public void mouseReleased(MouseEvent me) {}

    public void mouseClicked(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == btn1) {
            btn1.setBackground(Color.GREEN);
        }
        if (me.getSource() == btn2) {
            btn2.setBackground(Color.YELLOW);
        }
        if (me.getSource() == btn3) {
            btn3.setBackground(Color.RED);
        }
        if (me.getSource() == btn4) {
            btn4.setBackground(Color.ORANGE);
        }
        if (me.getSource() == btn5) {
            btn5.setBackground(Color.CYAN);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == btn1) {
            btn1.setBackground(null);
        }
        if (me.getSource() == btn2) {
            btn2.setBackground(null);
        }
        if (me.getSource() == btn3) {
            btn3.setBackground(null);
        }
        if (me.getSource() == btn4) {
            btn4.setBackground(null);
        }
        if (me.getSource() == btn5) {
            btn5.setBackground(null);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            setVisible(false);
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
        }

        if (ae.getSource() == btn2) {
            this.setVisible(false);
            Registration frame = new Registration();
            frame.setVisible(true);
        }

        if (ae.getSource() == btn3) {
            System.exit(0);
        }

        if (ae.getSource() == btn4) {
            setVisible(false);
            AdminLoginFrame frame = new AdminLoginFrame();
            frame.setVisible(true);
        }

        if (ae.getSource() == btn5) {
            setVisible(false);
            Welcome frame = new Welcome();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Home home = new Home();
        home.setVisible(true);
    }
}
