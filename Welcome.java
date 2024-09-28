import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Welcome extends JFrame implements MouseListener, ActionListener {
    private JLabel lb1, lb2;
    private JPanel panel;
    private ImageIcon image;
    private ImageIcon icon;
    private Font f1, f2;
    private JButton btn1, btn2, btn3;

    public Welcome() {

        this.setTitle("AIUB BLOOD BANK ");
        this.setSize(900, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon = new ImageIcon(getClass().getResource("bb.png"));
        this.setIconImage(icon.getImage());

        panel = new JPanel();
        panel.setLayout(null);
        f1 = new Font("Segoe UI Black", Font.BOLD, 20);
        f2 = new Font("Segoe UI Black", Font.BOLD, 35);

        lb1 = new JLabel("WELCOME TO AIUB BLOOD BANK");
        lb1.setBounds(120, 100, 650, 80);
        lb1.setFont(f2);
        lb1.setForeground(Color.WHITE);
        panel.add(lb1);

        btn1 = new JButton("Exit");
        btn1.setBounds(90, 280, 200, 50);
        btn1.setFont(f1);
        btn1.addMouseListener(this);
        btn1.addActionListener(this);
        panel.add(btn1);

        btn2 = new JButton("Contribution");
        btn2.setBounds(325, 280, 245, 50);
        btn2.setFont(f1);
        btn2.addMouseListener(this);
        btn2.addActionListener(this);
        panel.add(btn2);

        btn3 = new JButton("Next");
        btn3.setBounds(605, 280, 200, 50);
        btn3.setFont(f1);
        btn3.addMouseListener(this);
        btn3.addActionListener(this);
        panel.add(btn3);

        image = new ImageIcon("welcome1.JPG");
        lb2 = new JLabel(image);
        lb2.setBounds(0, 0, 900, 500);
        panel.add(lb2);
        lb2.setOpaque(true);

        this.add(panel);
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == btn1) {
            btn1.setBackground(Color.RED);
        }
        if (me.getSource() == btn2) {
            btn2.setBackground(Color.GREEN);
        }
        if (me.getSource() == btn3) {
            btn3.setBackground(Color.BLUE);
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
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            System.exit(0);
        }
        if (ae.getSource() == btn2) {
            Contribution frame = new Contribution();
            frame.setVisible(true);
        }
        if (ae.getSource() == btn3) {
            this.setVisible(false);
            Home obj = new Home();
            obj.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Welcome frame = new Welcome();
        frame.setVisible(true);
    }
}
