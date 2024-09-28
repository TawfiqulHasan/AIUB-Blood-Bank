import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BloodStock extends JFrame implements ActionListener 
{
    private JPanel panel;
    private JButton btnExit, btnLogout;
    private JLabel lblStock, lblRequest, lblStockTitle, lblRequestTitle;
    private JLabel bgLabel;
    private ImageIcon icon;

    public BloodStock() {
        this.setTitle("AIUB BLOOD BANK");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        icon = new ImageIcon(getClass().getResource("bb.png"));
        this.setIconImage(icon.getImage());

        lblStockTitle = new JLabel("Blood Stock");
        lblStockTitle.setBounds(140, 250, 200, 40);
        lblStockTitle.setFont(new Font("Cambria", Font.BOLD, 34));
        lblStockTitle.setForeground(Color.YELLOW);
        panel.add(lblStockTitle);

        lblRequestTitle = new JLabel("Blood Request");
        lblRequestTitle.setBounds(500, 250, 300, 40);
        lblRequestTitle.setFont(new Font("Cambria", Font.BOLD, 34));
        lblRequestTitle.setForeground(Color.YELLOW);
        panel.add(lblRequestTitle);

        lblStock = createStyledLabel();
        lblStock.setBounds(170, 100, 120, 120);
        panel.add(lblStock);

        lblRequest = createStyledLabel();
        lblRequest.setBounds(530, 100, 120, 120);
        panel.add(lblRequest);

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(120, 350, 150, 40);
        btnLogout.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogout.addActionListener(this);
        panel.add(btnLogout);

        btnExit = new JButton("Exit");
        btnExit.setBounds(530, 350, 150, 40);
        btnExit.setFont(new Font("Arial", Font.BOLD, 14));
        btnExit.addActionListener(this);
        panel.add(btnExit);

        ImageIcon image = new ImageIcon("red-blood.JPG");
        bgLabel = new JLabel(image);
        bgLabel.setBounds(0, 0, 800, 500);
        panel.add(bgLabel);

        this.add(panel);

        loadAll(); 
    }

    private JLabel createStyledLabel() {
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Cambria", Font.BOLD, 36));
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        return label;
    }

    private void loadAll() 
	{
        StringBuilder stockContent = new StringBuilder();
        StringBuilder requestContent = new StringBuilder();

        try (BufferedReader brStock = new BufferedReader(new FileReader("./counter.txt"))) {
            String line;
            while ((line = brStock.readLine()) != null) 
			{
                stockContent.append(line).append("\n");
            }
        }
		catch (IOException ioe) 
		{
		ioe.printStackTrace();
        }

        try (BufferedReader brRequest = new BufferedReader(new FileReader("./counter2.txt"))) 
		{
            String line;
            while ((line = brRequest.readLine()) != null) 
			{
                requestContent.append(line).append("\n");
            }
        } 
		catch (IOException ioe) 
		{
		ioe.printStackTrace();
        }
        lblStock.setText(stockContent.toString().trim());
        lblRequest.setText(requestContent.toString().trim());
    }

    public void actionPerformed(ActionEvent ae) 
	{
        if (ae.getSource() == btnExit) 
		{
            System.exit(0);
        }
        if (ae.getSource() == btnLogout) 
		{
            setVisible(false);
            Home frame = new Home();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) 
	{
        BloodStock frame = new BloodStock();
        frame.setVisible(true);
    }
}
