import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteDonor extends JFrame implements MouseListener, ActionListener {
    private JLabel titleLabel, phoneLabel, backgroundLabel;
    private JPanel panel;
    private Font titleFont, labelFont, buttonFont;
    private JButton deleteButton, backButton, clearButton;
    private JTextField phoneField;
    private ImageIcon backgroundImage;

    public DeleteDonor() {
        this.setTitle("AIUB Blood Bank - Delete Donor");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        titleLabel = new JLabel("Delete Donor");
        titleLabel.setBounds(180, 20, 240, 50);
        titleLabel.setForeground(new Color(255, 255, 255));
        titleFont = new Font("Cambria", Font.BOLD, 30);
        titleLabel.setFont(titleFont);
        panel.add(titleLabel);

        phoneLabel = new JLabel("Donor Phone Number:");
        phoneLabel.setBounds(60, 100, 220, 30);
        phoneLabel.setForeground(new Color(255, 255, 255));
        labelFont = new Font("Cambria", Font.BOLD, 20);
        phoneLabel.setFont(labelFont);
        panel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(280, 100, 180, 30);
        panel.add(phoneField);

        // Clear Button to clear the text field
        clearButton = new JButton("Clear");
        clearButton.setBounds(470, 100, 80, 30);
        clearButton.setForeground(Color.BLACK);
        clearButton.setFont(new Font("Cambria", Font.PLAIN, 16));
        clearButton.addMouseListener(this);
        clearButton.addActionListener(this);
        panel.add(clearButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(350, 300, 150, 40);
        deleteButton.setForeground(new Color(255, 51, 153));
        deleteButton.setFont(new Font("Cambria", Font.BOLD, 20));
        deleteButton.addMouseListener(this);
        deleteButton.addActionListener(this);
        panel.add(deleteButton);

        backButton = new JButton("Back");
        backButton.setBounds(100, 300, 130, 40);
        backButton.setForeground(Color.BLACK);
        backButton.setFont(new Font("Cambria", Font.BOLD, 20));
        backButton.addMouseListener(this);
        backButton.addActionListener(this);
        panel.add(backButton);

        backgroundImage = new ImageIcon("mobarak.JPG");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 600, 400);
        panel.add(backgroundLabel);

        this.add(panel);
    }

    public void mousePressed(MouseEvent me) {}

    public void mouseReleased(MouseEvent me) {}

    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == deleteButton) {
                deleteButton.setText("Deleted");
            
        }
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == backButton) {
            backButton.setBackground(new Color(255, 51, 153));
            backButton.setForeground(Color.WHITE);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == backButton) {
            backButton.setBackground(null);
            backButton.setForeground(Color.BLACK);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deleteButton) {
            if (phoneField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a phone number.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                DeleteData deleteData = new DeleteData();
                deleteData.DeleteDataByPhone(phoneField.getText().toString());
            }
        }

        if (ae.getSource() == clearButton) { // Clear button action
            phoneField.setText(""); // Clear the text field
        }

        if (ae.getSource() == backButton) {
            this.setVisible(false);
            DashboardFrame frame = new DashboardFrame();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        DeleteDonor frame = new DeleteDonor();
        frame.setVisible(true);
    }
}
