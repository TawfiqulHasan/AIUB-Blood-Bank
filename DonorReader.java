import java.io.*;
import java.util.*;

public class DonorReader {

	public static void main(String[] args) {

		 try {
            File file = new File("./AllDonorList.txt");
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }

            scan.close(); // Close the scanner after reading the file

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

	}

}