import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserDashboard extends JFrame implements MouseListener, ActionListener {
    private JPanel panel;
    private ImageIcon image,icon;
    private JLabel imgLabel;
    private Font f1;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    private Color color1, color2, color3;
    private JLabel lb1;

    public UserDashboard() {
        this.setTitle("AIUB BLOOD BANK ");
        this.setSize(600, 400); 
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon = new ImageIcon(getClass().getResource("bb.png"));
        this.setIconImage(icon.getImage());

        panel = new JPanel();
        panel.setLayout(null);

        lb1 = new JLabel("USER DASHBOARD ");
        lb1.setBounds(180, 50, 280, 50);
        color1 = new Color(255, 255, 255);
        lb1.setForeground(color1);
        f1 = new Font("Cambria", Font.BOLD, 30);
        lb1.setFont(f1);
        panel.add(lb1);

        btn1 = new JButton("Donor List");
        btn1.setBounds(120, 140, 200, 40);
        btn1.addMouseListener(this);
        panel.add(btn1);
        btn1.addActionListener(this);

        btn8 = new JButton("Available Stock");
        btn8.setBounds(120, 200, 200, 40);
        btn8.addMouseListener(this);
        panel.add(btn8);
        btn8.addActionListener(this);

        btn7 = new JButton("Blood Request");
        btn7.setBounds(350, 140, 200, 40);
        btn7.addMouseListener(this);
        panel.add(btn7);
        btn7.addActionListener(this);

        btn4 = new JButton("Request List");
        btn4.setBounds(350, 200, 200, 40);
        btn4.addMouseListener(this);
        panel.add(btn4);
        btn4.addActionListener(this);

        btn5 = new JButton("Logout");
        btn5.setBounds(20, 310, 100, 40);
        btn5.addMouseListener(this);
        panel.add(btn5);
        btn5.addActionListener(this);

        btn6 = new JButton("Exit");
        btn6.setBounds(480, 310, 100, 40);
        btn6.addMouseListener(this);
        panel.add(btn6);
        btn6.addActionListener(this);

        image = new ImageIcon("user.JPG");
        lb1 = new JLabel(image);
        lb1.setBounds(0, 0, 600, 400);
        panel.add(lb1);
        lb1.setOpaque(true);

        this.add(panel);
    }

    public void mousePressed(MouseEvent me) {}

    public void mouseReleased(MouseEvent me) {}

    public void mouseClicked(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == btn1) {
            btn1.setBackground(Color.GREEN);
        }
        if (me.getSource() == btn8) {
            btn8.setBackground(Color.GRAY);
        }
        if (me.getSource() == btn5) {
            btn5.setBackground(Color.RED);
        }
        if (me.getSource() == btn6) {
            btn6.setBackground(Color.PINK);
        }
        if (me.getSource() == btn7) {
            btn7.setBackground(Color.BLUE);
        }
        if (me.getSource() == btn4) {
            btn4.setBackground(Color.GREEN);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == btn1) {
            btn1.setBackground(null);
        }
        if (me.getSource() == btn8) {
            btn8.setBackground(null);
        }
        if (me.getSource() == btn5) {
            btn5.setBackground(null);
        }
        if (me.getSource() == btn6) {
            btn6.setBackground(null);
        }
        if (me.getSource() == btn7) {
            btn7.setBackground(null);
        }
        if (me.getSource() == btn4) {
            btn4.setBackground(null);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            setVisible(false);
            AllDonor frame = new AllDonor();
            frame.setVisible(true);
        }
        if (ae.getSource() == btn5) {
            setVisible(false);
            Home frame = new Home();
            frame.setVisible(true);
        }
        if (ae.getSource() == btn6) {
            System.exit(0);
        }
        if (ae.getSource() == btn7) {
            setVisible(false);
            BloodRequest frame = new BloodRequest();
            frame.setVisible(true);
        }
        if (ae.getSource() == btn8) {
            setVisible(false);
            BloodStock frame = new BloodStock();
            frame.setVisible(true);
        }
		if (ae.getSource() == btn4) 
		{
            JOptionPane.showMessageDialog(null, "Only Admin Can View That", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        UserDashboard frame = new UserDashboard();
        frame.setVisible(true);
    }
}
