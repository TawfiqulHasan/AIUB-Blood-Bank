import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashboardFrame extends JFrame implements ActionListener {
    private JPanel panel;
    private ImageIcon image;
    private JLabel lbl4, lbl1;
    private Font f1;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    private Color color2;

    public DashboardFrame() {
        this.setTitle("AIUB BLOOD BANK Dashboard");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        lbl1 = new JLabel("ADMIN DASHBOARD");
        lbl1.setBounds(170, 20, 350, 40);
        color2 = new Color(255, 255, 255);
        lbl1.setForeground(color2);
        f1 = new Font("Cambria", Font.BOLD, 25);
        lbl1.setFont(f1);
        panel.add(lbl1);

        btn2 = new JButton("Add Donor");
        btn2.setBounds(50, 80, 200, 40);
        btn2.addActionListener(this); 
        panel.add(btn2);

        btn3 = new JButton("Delete Donor");
        btn3.setBounds(50, 130, 200, 40);
        btn3.addActionListener(this); 
        panel.add(btn3);

        btn7 = new JButton("Blood Request");
        btn7.setBounds(50, 180, 200, 40);
        btn7.addActionListener(this); 
        panel.add(btn7);

        btn1 = new JButton("Donor List");
        btn1.setBounds(350, 80, 200, 40);
        btn1.addActionListener(this); 
        panel.add(btn1);

        btn4 = new JButton("Request List");
        btn4.setBounds(350, 130, 200, 40);
        btn4.addActionListener(this); 
        panel.add(btn4);

        btn8 = new JButton("Available Stock");
        btn8.setBounds(350, 180, 200, 40);
        btn8.addActionListener(this); 
        panel.add(btn8);

        btn5 = new JButton("Logout");
        btn5.setBounds(50, 320, 90, 40);
        btn5.addActionListener(this); 
        panel.add(btn5);

        btn6 = new JButton("Exit");
        btn6.setBounds(460, 320, 90, 40);
        btn6.addActionListener(this); 
        panel.add(btn6);

        image = new ImageIcon("dashboard2.JPG");
        lbl4 = new JLabel(image);
        lbl4.setBounds(0, 0, 600, 400); 
        panel.add(lbl4);
        lbl4.setOpaque(true);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            setVisible(false);
            AllDonor frame = new AllDonor();
            frame.setVisible(true);
        }
        if (ae.getSource() == btn2) {
            setVisible(false);
            AddDonor frame = new AddDonor();
            frame.setVisible(true);
        }
        if (ae.getSource() == btn3) {
            setVisible(false);
            DeleteDonor frame = new DeleteDonor();
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
        if (ae.getSource() == btn4) {
            setVisible(false);
            AllRequest frame = new AllRequest();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        DashboardFrame frame = new DashboardFrame();
        frame.setVisible(true);
    }
}
