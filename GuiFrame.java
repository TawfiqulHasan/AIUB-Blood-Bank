import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.*;


public class GuiFrame {
    private JTextArea jtxt = new JTextArea(30, 30);
    private JFrame fr = new JFrame("Donor List Viewer");

    //static String filePath = "AllDonorList.txt"; // Specify the path to your text file

    public GuiFrame() {
        // Set layout manager
        //fr.setLayout(new BorderLayout());
        
        // Adding JScrollPane for JTextArea to enable scrolling
        JScrollPane scrollPane = new JScrollPane(jtxt);
        fr.add(scrollPane);
        
        // Frame settings
        fr.setSize(500, 400); // Set the size of the frame
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the app closes properly
        fr.setVisible(true);

        loadDonorList(); // Load the donor list when the frame is created
    }

    public static void main(String[] args) {
        new GuiFrame(); // Create the GUI frame
    }

    private void loadDonorList() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("AllDonorList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n"); // Append each line with a newline
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(fr, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        jtxt.setText(content.toString()); // Set the text area content
    }
}
