import java.io.*; // for file
import java.util.*; // for reading the file (Scanner)

public class DonorList {
    private String name, address, phone, gender, bg, date;
    private File file2;
    private FileWriter fwritter2; // for inserting or writing in a text file
    private Scanner sc; // for reading the file
	private Donor[] donorList;

    public DonorList(String name, String address, String phone, String gender, String bg, String date) 
	{
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

    public void addDonorList(DonorList dn) 
	{
		donorList = new Donor[counterValue()];
        try {
            file2 = new File("./AllDonorList.txt");
            file2.createNewFile();
            fwritter2 = new FileWriter(file2, true);
            String addedData =  "\n" + getName() + "\t" + getAddress() + "\t" + getPhone() + "\t"+ getGender()+ "\t"+ getBg() + "\t" + getDate() ;
            fwritter2.write(addedData);
			fwritter2.flush();
            fwritter2.close();
			
			File counterFile = new File("./counter.txt");
			FileReader txtReaderFile = new FileReader(counterFile);
			BufferedReader txtReader = new BufferedReader(txtReaderFile);
			String count = txtReader.readLine();

			int countInt = Integer.parseInt(count);
			txtReader.close();

			txtReaderFile.close();
			int newCount = countInt + 1;
			
			FileWriter counterWriter = new FileWriter(counterFile, false); // Overwrite mode

			counterWriter.write(String.valueOf(newCount));
			
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

			String count = txtReader.readLine();

			int countInt = Integer.parseInt(count);

			txtReader.close();

			txtReaderFile.close();
			
			return countInt;
			

		} catch (Exception e) {

			return 0;

		}

	}

    public boolean checkDonor(String name, String address, String phone, String gender, String bg, String date) {
        boolean flag = false;
        file2 = new File("./AllDonorList.txt"); // Corrected the file name with extension
        try {
            sc = new Scanner(file2);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] value = line.split("\t");
                if (value[0].equals(name) && value[1].equals(address) && value[2].equals(phone) &&
                    value[3].equals(gender) && value[4].equals(bg) && value[5].equals(date)) {
                    flag = true;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return flag;
    }
	public int getIndexByPhone(String phone) 
	{
		int c = -1;
		for (int i = 0; i < counterValue(); i++) {
			if (donorList[i].getPhone().equals(phone)) {
				c = i;
				break;
			}
		}
		// System.out.println("Index: " + c);

		return c;

	}
	
	

    public static void main(String[] args) {
        
    }
}
