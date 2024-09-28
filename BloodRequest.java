import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BloodRequest extends JFrame implements MouseListener, ActionListener {
    private JLabel lb1, lb2, lb3, lb4, lb6, lb8;
    private JPanel panel;
    private Font f1, f2, f3, f4, f6, f8, f10;
    private JButton btn1, btn3, btn4, btnLogout;
    private Color color2, color4, color5, color6, color8, color10, color12;
    private JTextField tf1, tf2, tf3;
    private ImageIcon image ,icon;
    private JComboBox combo2;

    public BloodRequest() {
        this.setTitle("AIUB BLOOD BANK ");
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon = new ImageIcon(getClass().getResource("bb.png"));
        this.setIconImage(icon.getImage());
        panel = new JPanel();
        panel.setLayout(null);

        lb8 = new JLabel("BLOOD REQUEST");
        lb8.setBounds(250, 20, 270, 40);
        color2 = new Color(255, 255, 255);
        lb8.setForeground(color2);
        f1 = new Font("Cambria", Font.BOLD, 30);
        lb8.setFont(f1);
        panel.add(lb8);

        lb2 = new JLabel("Patient Name");
        lb2.setBounds(60, 80, 150, 50);
        color4 = new Color(255, 255, 255);
        lb2.setForeground(color4);
        panel.add(lb2);
        tf1 = new JTextField();
        tf1.setBounds(200, 95, 150, 25);
        panel.add(tf1);
        f2 = new Font("Cambria", Font.BOLD, 20);
        lb2.setFont(f2);

        lb3 = new JLabel("Address ");
        lb3.setBounds(80, 150, 100, 50);
        color5 = new Color(255, 255, 255);
        lb3.setForeground(color5);
        panel.add(lb3);
        tf2 = new JTextField();
        tf2.setBounds(200, 165, 150, 25);
        panel.add(tf2);
        f3 = new Font("Cambria", Font.BOLD, 20);
        lb3.setFont(f3);

        lb6 = new JLabel("Blood Group");
        lb6.setBounds(420, 90, 150, 25);
        color8 = new Color(255, 255, 255);
        lb6.setForeground(color8);
        panel.add(lb6);
        String bloodGroup[] = new String[] { "", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" };
        combo2 = new JComboBox<>(bloodGroup);
        combo2.setBounds(580, 90, 160, 25);
        panel.add(combo2);
        f6 = new Font("Cambria", Font.BOLD, 20);
        lb6.setFont(f6);

        lb4 = new JLabel("Phone Number ");
        lb4.setBounds(420, 165, 150, 25);
        color6 = new Color(255, 255, 255);
        lb4.setForeground(color6);
        panel.add(lb4);
        tf3 = new JTextField();
        tf3.setBounds(580, 165, 160, 25);
        panel.add(tf3);
        f4 = new Font("Cambria", Font.BOLD, 20);
        lb4.setFont(f4);
		
		f10 = new Font("Cambria", Font.BOLD, 20);

        // Logout Button positioned at bottom-left
        btnLogout = new JButton("Logout");
        btnLogout.setBounds(50, 300, 120, 40); // Adjusted position
        btnLogout.addMouseListener(this);
        btnLogout.setForeground(color12);
        panel.add(btnLogout);
        btnLogout.addActionListener(this);
        btnLogout.setFont(f10);

        // Request Button at bottom-middle
        btn1 = new JButton("Request");
        btn1.setBounds(450, 250, 120, 40); // Adjusted position
        color10 = new Color(255, 51, 153);
        btn1.addMouseListener(this);
        btn1.addActionListener(this);
        btn1.setForeground(color10);
        panel.add(btn1);
        f8 = new Font("Cambria", Font.BOLD, 20);
        btn1.setFont(f8);

        // Clear Button at bottom-middle
        btn4 = new JButton("Clear");
        btn4.setBounds(200, 250, 120, 40);
        color12 = new Color(150, 75, 0);
        btn4.addMouseListener(this);
        btn4.setForeground(color12);
        panel.add(btn4);
        btn4.addActionListener(this);
        btn4.setFont(f10);

        // Exit Button at bottom-right
        btn3 = new JButton("Exit");
        btn3.setBounds(620, 300, 100, 40);
        btn3.addMouseListener(this);
        btn3.setForeground(color12);
        panel.add(btn3);
        btn3.addActionListener(this);
        btn3.setFont(f10);

        image = new ImageIcon("mobarak5.JPG");
        lb1 = new JLabel(image);
        lb1.setBounds(0, 0, 800, 400);
        panel.add(lb1);
        lb1.setOpaque(true);

        this.add(panel);
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == btn1) {
            btn1.setText("Accepted");
        }
        if (me.getSource() == btn3) {
            btn3.setText("Exit");
        }
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            String s1 = tf1.getText(), s2 = tf2.getText(), s3 = combo2.getSelectedItem().toString(), s4 = tf3.getText();

            if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill All");
            } else {
                RequestList rq = new RequestList(s1, s2, s3, s4);
                if (rq.checkDonor(s1, s2, s3, s4)) {
                    JOptionPane.showMessageDialog(this, "Already exist");
                } else {
                    rq.addRequestList(rq);
                    JOptionPane.showMessageDialog(this, "Added");
                }
            }
        }
        if (ae.getSource() == btn3) {
            System.exit(0);
        }
        if (ae.getSource() == btn4) {
            this.setVisible(false);
            BloodRequest frame = new BloodRequest();
            frame.setVisible(true);
        }
        if (ae.getSource() == btnLogout) {
            this.setVisible(false);
            Home frame = new Home();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        BloodRequest frame = new BloodRequest();
        frame.setVisible(true);
    }
}
