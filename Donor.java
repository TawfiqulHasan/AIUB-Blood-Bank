import java.io.*;
import java.util.*;

public class Donor {

	private String name, address, phone, gender, bg, date;

	private File file, file2;

	private FileWriter fwritter2; // for insert or write in text file

	private Scanner sc; // for read the file

	private Donor[] donorList;

	private Donor[] filterDonor;

	public int filterCounter(String blood) {

		int c = 0;

		for (int i = 0; i < counterValue(); i++) {

			if (donorList[i].getBg().equals(blood)) {

				c++;

			}

		}

		return c;

	}

	public void filterData(String blood) {

		int filterNumber = filterCounter(blood);

		filterDonor = new Donor[filterNumber];

		int c = 0;

		for (int i = 0; i < counterValue(); i++) {

			if (donorList[i].getBg().equals(blood)) {

				filterDonor[c] = donorList[i];

				c++;

			}

		}

		for (int i = 0; i < filterCounter(blood); i++) {

			filterDonor[i].consoleData();

		}

	}

	public Donor(String name, String address, String phone, String gender, String bg, String date) {

		donorList = new Donor[counterValue()];

		this.name = name;

		this.phone = phone;

		this.gender = gender;

		this.address = address;

		this.bg = bg;

		this.date = date;

	}

	public void setName(String name) {

		this.name = name;

	}

	public void setAddress(String address) {

		this.address = address;

	}

	public void setPhone(String phone) {

		this.phone = phone;

	}

	public void setGender(String gender) {

		this.gender = gender;

	}

	public void setBg(String bg) {

		this.bg = bg;

	}

	public void setDate(String date) {

		this.date = date;

	}

	public String getName() {

		return this.name;

	}

	public String getAddress() {

		return this.address;

	}

	public String getPhone() {

		return this.phone;

	}

	public String getGender() {

		return this.gender;

	}

	public String getBg() {

		return this.bg;

	}

	public String getDate() {

		return this.date;

	}

	public void addDonor(Donor dn) {

		this.showDonor();

		System.out.println("=========================Here's come the filtered data=====================");

		this.filterData("B+");

		donorList = new Donor[counterValue()];

		// need to implement for add the account in text file

		try {

			// possible type errors

			file2 = new File("./Donor1.txt");

			file2.createNewFile();

			fwritter2 = new FileWriter(file2, true);

			// fwritter2.write("\r\n");

			// fwritter2.write(System.lineSeparator());

			// fwritter2.write(getName() + "#fff#");

			// fwritter2.write(getName() + "#fff#");

			// fwritter2.write(getName() + "#fff#");

			// fwritter2.write(getGender() + "#fff#");

			// fwritter2.write(getBg() + "#fff#");

			// fwritter2.write(getDate() + "#fff#");

			String addedData = "\r\n" + getName() + "#fff#" + getName() + "#fff#" + getName() + "#fff#" + getGender()

					+ "#fff#"

					+ getBg() + "#fff#" + getDate() + "#fff#";

			fwritter2.write(addedData);

			fwritter2.flush();

			fwritter2.close();

			File counterFile = new File("./counter.txt");

			// Read the current value from counter.txt using FileReader and BufferedReader

			FileReader txtReaderFile = new FileReader(counterFile);

			BufferedReader txtReader = new BufferedReader(txtReaderFile);

			// Read the first line and parse it to an integer

			String count = txtReader.readLine();

			int countInt = Integer.parseInt(count);

			// System.out.println("Current count: " + countInt); // Print the current value

			// Close the reader after reading

			txtReader.close();

			txtReaderFile.close();

			// Increment the value

			int newCount = countInt + 1;

			// System.out.println("New count: " + newCount); // Print the incremented value

			// Write the incremented value back to counter.txt using FileWriter

			FileWriter counterWriter = new FileWriter(counterFile, false); // Overwrite mode

			counterWriter.write(String.valueOf(newCount)); // Write the new count as a string

			// Flush and close the writer

			counterWriter.flush();

			counterWriter.close();

		} catch (IOException ioe) {

			ioe.printStackTrace();

		}

	}

	public int counterValue() {

		try {

			File counterFile = new File("./counter.txt");

			FileReader txtReaderFile = new FileReader(counterFile);

			BufferedReader txtReader = new BufferedReader(txtReaderFile);

			// Read the first line and parse it to an integer

			String count = txtReader.readLine();

			int countInt = Integer.parseInt(count);

			// System.out.println("Current count: " + countInt); // Print the current value

			// Close the reader after reading

			txtReader.close();

			txtReaderFile.close();

			return countInt;

		} catch (Exception e) {

			return 0;

		}

	}

	public void showDonor() {

		File donorFile = new File("Donor1.txt"); // File object for Donor1.txt

		try {

			// Create a BufferedReader to read the file line by line

			BufferedReader reader = new BufferedReader(new FileReader(donorFile));

			String tempData;

			int i = 0; // Variable to hold each line of the file

			for (int j = 0; j < counterValue(); j++) {

				donorList[j] = new Donor("1", "1", "1", "1", "1", "1");

			}

			// Loop through each line in the file

			while ((tempData = reader.readLine()) != null) {

				// tempData now holds the current line of the file

				String[] arr = tempData.split("#fff#");

				donorList[i] = new Donor(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);

				i++;

				// You can process the tempData here as needed

			}

			for (int j = 0; j < counterValue(); j++) {

				donorList[j].consoleData();

			}

			// Close the BufferedReader after reading the file

			reader.close();

		} catch (IOException e) {

			// Handle exceptions if the file is not found or unreadable

			e.printStackTrace();

		}

	}

	private void consoleData() {

		System.out.println(this.getName());

		System.out.println(this.getAddress());

		System.out.println(this.getPhone());

		System.out.println(this.getGender());

		System.out.println(this.getBg());

		System.out.println(this.getDate());

		System.out.println("=======================");

	}

	public boolean searchDonor(String name, String address, String phone, String gender, String bg, String date) {

		// need to implement for checking the existing username, pass before insert

		boolean flag = false;

		file = new File("./Donor.txt");

		try {

			sc = new Scanner(file); // scan the file

			while (sc.hasNextLine()) {

				String line = sc.nextLine();

				String[] value = line.split("\t");

				if (value[2].equals(phone)) {

					flag = true;

				}

			}

		} catch (IOException ioe) {

			ioe.printStackTrace();

		}

		return flag;

	}

	public static void main(String[] args) {

		// Donor frame = new Donor();

		// frame.setVisible(true);

	}

}
