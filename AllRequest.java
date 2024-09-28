import java.lang.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AllRequest extends JFrame implements ActionListener 
{
    private JPanel panel;
    private JButton btnExit, btnLogout, btnBack; // Added btnBack
    private JTextArea jtxt;
    private JLabel bgLabel;
    private ImageIcon icon;

    public AllRequest() {
        this.setTitle("AIUB BLOOD BANK");
        this.setSize(800, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
		
		icon = new ImageIcon(getClass().getResource("bb.png"));
        this.setIconImage(icon.getImage());

        JLabel lb1 = new JLabel("ALL Request LIST");
        lb1.setBounds(270, 20, 270, 50);
        lb1.setFont(new Font("Cambria", Font.BOLD, 32));
        lb1.setForeground(Color.WHITE);
        panel.add(lb1);

        jtxt = new JTextArea();
        jtxt.setFont(new Font("Cambria", Font.BOLD, 18));
        jtxt.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(jtxt);
        scrollPane.setBounds(50, 100, 700, 200);
        panel.add(scrollPane);

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(50, 350, 100, 40);
        btnLogout.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogout.addActionListener(this);
        panel.add(btnLogout);

        btnExit = new JButton("Exit");
        btnExit.setBounds(650, 350, 100, 40);
        btnExit.setFont(new Font("Arial", Font.BOLD, 14));
        btnExit.addActionListener(this);
        panel.add(btnExit);

        // Adding the Back button
        btnBack = new JButton("Back");
        btnBack.setBounds(350, 350, 100, 40); // Centered at the bottom
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.addActionListener(this);
        panel.add(btnBack);

        ImageIcon image = new ImageIcon("red-blood.JPG");
        bgLabel = new JLabel(image);
        bgLabel.setBounds(0, 0, 800, 450);
        panel.add(bgLabel);

        this.add(panel);

        loadAllRequest();
    }

    private void loadAllRequest() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("./AllRequestList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading request list.");
        }
        jtxt.append(content.toString()); // Append the loaded content to the existing header
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnExit) {
            System.exit(0);
        }
        if (ae.getSource() == btnLogout) {
            setVisible(false);
            Home frame = new Home();
            frame.setVisible(true);
        }
        if (ae.getSource() == btnBack) {
            this.setVisible(false);
            DashboardFrame frame = new DashboardFrame();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        AllRequest frame = new AllRequest();
        frame.setVisible(true);
    }
}
