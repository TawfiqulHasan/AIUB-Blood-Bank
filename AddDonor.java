import java.lang.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDonor extends JFrame implements MouseListener, ActionListener {
	private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8;
	private JPanel panel;
	private JTextField tf1, tf2, tf3, tf4;
	private JComboBox<String> combo1, combo2;
	private JButton btn1, btn2, btn3, btn4;
	private Font f1, f2, f3, f4, f5, f6, f7, f8, f9, f10;
	private Color color1, color2, color4, color5, color6, color7, color8, color9, color10, color11, color12, color13;
	private ImageIcon image;

	public AddDonor() {
		this.setTitle("AIUB BLOOD BANK");
		this.setSize(800, 450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);

		lb8 = new JLabel("ADD NEW DONOR");
		lb8.setBounds(250, 20, 270, 40);
		color2 = new Color(255, 255, 255);
		lb8.setForeground(color2);
		f1 = new Font("Cambria", Font.BOLD, 30);
		lb8.setFont(f1);
		panel.add(lb8);

		lb2 = new JLabel("Name");
		lb2.setBounds(80, 80, 100, 50);
		color4 = new Color(255, 255, 255);
		lb2.setForeground(color4);
		tf1 = new JTextField();
		tf1.setBounds(200, 95, 150, 25);
		f2 = new Font("Cambria", Font.BOLD, 16);
		lb2.setFont(f2);
		panel.add(lb2);
		panel.add(tf1);

		lb3 = new JLabel("Address");
		lb3.setBounds(80, 130, 100, 50);
		color5 = new Color(255, 255, 255);
		lb3.setForeground(color5);
		tf2 = new JTextField();
		tf2.setBounds(200, 145, 150, 25);
		f3 = new Font("Cambria", Font.BOLD, 16);
		lb3.setFont(f3);
		panel.add(lb3);
		panel.add(tf2);

		lb4 = new JLabel("Phone Number");
		lb4.setBounds(80, 180, 120, 50);
		color6 = new Color(255, 255, 255);
		lb4.setForeground(color6);
		tf3 = new JTextField();
		tf3.setBounds(200, 195, 150, 25);
		f4 = new Font("Cambria", Font.BOLD, 16);
		lb4.setFont(f4);
		panel.add(lb4);
		panel.add(tf3);

		lb5 = new JLabel("Gender");
		lb5.setBounds(420, 90, 100, 25);
		color7 = new Color(255, 255, 255);
		lb5.setForeground(color7);
		String[] gender = { "", "Male", "Female" };
		combo1 = new JComboBox<>(gender);
		combo1.setBounds(580, 90, 160, 25);
		f5 = new Font("Cambria", Font.BOLD, 16);
		lb5.setFont(f5);
		panel.add(lb5);
		panel.add(combo1);

		lb6 = new JLabel("Blood Group");
		lb6.setBounds(420, 145, 100, 25);
		color8 = new Color(255, 255, 255);
		lb6.setForeground(color8);
		String[] bloodGroup = { "", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" };
		combo2 = new JComboBox<>(bloodGroup);
		combo2.setBounds(580, 150, 160, 25);
		f6 = new Font("Cambria", Font.BOLD, 16);
		lb6.setFont(f6);
		panel.add(lb6);
		panel.add(combo2);

		lb7 = new JLabel("Last Donated Date");
		lb7.setBounds(420, 185, 150, 50);
		color9 = new Color(255, 255, 255);
		lb7.setForeground(color9);
		tf4 = new JTextField();
		tf4.setBounds(580, 200, 160, 25);
		f7 = new Font("Cambria", Font.BOLD, 16);
		lb7.setFont(f7);
		panel.add(lb7);
		panel.add(tf4);

		btn1 = new JButton("Save");
		btn1.setBounds(90, 320, 100, 40);
		color10 = new Color(255, 51, 153);
		btn1.addMouseListener(this);
		btn1.addActionListener(this);
		btn1.setForeground(color10);
		f8 = new Font("Cambria", Font.BOLD, 20);
		btn1.setFont(f8);
		panel.add(btn1);

		btn2 = new JButton("Back");
		btn2.setBounds(430, 320, 100, 40);
		color11 = new Color(128, 0, 128);
		btn2.addMouseListener(this);
		btn2.addActionListener(this);
		color13 = new Color(153, 51, 102);
		btn2.setBackground(color13);
		btn2.setForeground(Color.BLACK);
		f9 = new Font("Cambria", Font.BOLD, 20);
		btn2.setFont(f9);
		panel.add(btn2);

		btn3 = new JButton("Exit");
		btn3.setBounds(600, 320, 100, 40);
		color12 = new Color(150, 75, 0);
		btn3.addMouseListener(this);
		btn3.addActionListener(this);
		btn3.setForeground(color12);
		f10 = new Font("Cambria", Font.BOLD, 20);
		btn3.setFont(f10);
		panel.add(btn3);

		btn4 = new JButton("Clear");
		btn4.setBounds(260, 320, 100, 40);
		btn4.addMouseListener(this);
		btn4.addActionListener(this);
		btn4.setForeground(color12);
		btn4.setFont(f10);
		panel.add(btn4);

		image = new ImageIcon("red 1.JPG");
		lb1 = new JLabel(image);
		lb1.setBounds(0, 0, 800, 450);
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
			btn1.setText("Saved");
		}
		if (me.getSource() == btn2) {
			btn2.setText("Back");
		}
		if (me.getSource() == btn3) {
			btn3.setText("Exit");
		}
	}

	public void mouseEntered(MouseEvent me) {
		if (me.getSource() == btn2) {
			btn2.setBackground(color11);
			btn2.setForeground(Color.WHITE);
		}
	}

	public void mouseExited(MouseEvent me) {
		if (me.getSource() == btn2) {
			btn2.setBackground(color13);
			btn2.setForeground(Color.BLACK);
		}
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btn1) {
			String s1 = tf1.getText(), s2 = tf2.getText(), s3 = tf3.getText(), 
				   s4 = combo1.getSelectedItem().toString(), 
				   s5 = combo2.getSelectedItem().toString(), 
				   s6 = tf4.getText();

			if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty() || s6.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Fill All");
			} else {
				DonorList dn = new DonorList(s1, s2, s3, s4, s5, s6);
				if (dn.checkDonor(s1, s2, s3, s4, s5, s6)) 
				{
					JOptionPane.showMessageDialog(this, "Already exist");
				} else {
					dn.addDonorList(dn);
					JOptionPane.showMessageDialog(this, "Added");
				}
			}
		}

		if (ae.getSource() == btn2) {
			this.setVisible(false);
			DashboardFrame frame = new DashboardFrame();
			frame.setVisible(true);
		}
		if (ae.getSource() == btn3) {
			System.exit(0);
		}
		if (ae.getSource() == btn4) {
			this.setVisible(false);
			AddDonor frame = new AddDonor();
			frame.setVisible(true);
		}
	}

	public static void main(String[] args) {
		AddDonor frame = new AddDonor();
		frame.setVisible(true);
	}
}
