import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLoginFrame extends JFrame implements MouseListener, ActionListener
{
    private JPanel panel;
    private ImageIcon image,icon;
    private JButton btnLogin, btnBack;
    private JTextField phoneField;
    private JPasswordField passwordField;
    private JLabel phoneLabel, passwordLabel,lb1,lb2;

    public AdminLoginFrame()
    {
        this.setTitle("AIUB BLOOD BANK");
        this.setSize(600,400); 
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        icon = new ImageIcon(getClass().getResource("bb.png"));
        this.setIconImage(icon.getImage());
        lb1 = new JLabel("ADMIN LOGIN ");
        lb1.setBounds(200, 5, 300, 100);
		lb1.setFont(new Font("Cambria", Font.BOLD, 34));
	    lb1.setForeground(Color.WHITE);
        panel.add(lb1);
		
        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(100, 100, 150, 30);
	    phoneLabel.setForeground(Color.WHITE);
		phoneLabel.setFont(new Font("Cambria", Font.BOLD, 20));
        panel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(270, 100, 200, 30);
        panel.add(phoneField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(150, 150, 150, 30);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Cambria", Font.BOLD, 20));
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(270, 150, 200, 30);
        panel.add(passwordField);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(350, 220, 120, 50);
        panel.add(btnLogin);
		btnLogin.addActionListener(this);
        btnLogin.addMouseListener(this);

        btnBack = new JButton("Back");
        btnBack.setBounds(180, 220, 120, 50); 
        panel.add(btnBack);
		btnBack.addActionListener(this);
		btnBack.addMouseListener(this);
		
        image = new ImageIcon("adminlogin.JPG");
        lb2 = new JLabel(image);
        lb2.setBounds(0,0,600,400); 
        panel.add(lb2);
		lb2.setOpaque(true);

        this.add(panel);
    }
	public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == btnLogin) // 'Exit' button clicked
        {
            String  name= phoneField.getText();
            String pass = new String(passwordField.getPassword());

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your phone number.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (pass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your password.", "Error", JOptionPane.ERROR_MESSAGE);
                } else 
				{			
			Account acc = new Account("","",name,pass);
			if(name.equals("1") && pass.equals("1"))
			{
				DashboardFrame obj1=new DashboardFrame();
				obj1.setVisible(true);
				this.setVisible(false);
			}
			else 
			{
				JOptionPane.showMessageDialog(this, "UserName 1 \n Password 1");
			}
        }
		}

        if (ae.getSource() == btnBack) 
        {
			setVisible(false);
            Home frame = new Home();
            frame.setVisible(true);
        }
    }
	public void mousePressed(MouseEvent me) {}

    public void mouseReleased(MouseEvent me) {}

    public void mouseClicked(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == btnLogin) {
            btnLogin.setBackground(Color.GREEN);
        }
        if (me.getSource() == btnBack) {
            btnBack.setBackground(Color.YELLOW);
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

    public static void main(String[] args) {
        AdminLoginFrame frame = new AdminLoginFrame();
        frame.setVisible(true);
    }
}
