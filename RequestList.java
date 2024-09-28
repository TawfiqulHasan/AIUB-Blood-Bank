import java.io.*; // for file
import java.util.*; // for reading the file (Scanner)

public class RequestList {
    private String name, address, phone, gender, bg, date;
    private File file2;
    private FileWriter fwritter2;
    private Scanner sc;
	private RequestList[] requestList;

    public RequestList(String name, String address, String phone, String bg) 
	{
		requestList = new RequestList[counterValue()];
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.bg = bg;
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

    public void setBg(String bg) {
        this.bg = bg;
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

    public String getBg() {
        return this.bg;
    }

    public void addRequestList(RequestList rq) 
	{
		requestList = new RequestList[counterValue()];
        try {
            file2 = new File("./AllRequestList.txt");
            file2.createNewFile();
            fwritter2 = new FileWriter(file2, true);
            String addedData = "\n" + getName() + "\t" + getAddress() + "\t" + getPhone() + "\t"+ getBg() ;
            fwritter2.write(addedData);
			fwritter2.flush();
            fwritter2.close();
			
			File counterFile = new File("./counter2.txt");
			FileReader txtReaderFile = new FileReader(counterFile);
			BufferedReader txtReader = new BufferedReader(txtReaderFile);
			String count = txtReader.readLine();

			int countInt = Integer.parseInt(count);
			txtReader.close();

			txtReaderFile.close();
			int newCount = countInt + 1;
			
			FileWriter counterWriter = new FileWriter(counterFile, false);

			counterWriter.write(String.valueOf(newCount));
			
			counterWriter.flush();

			counterWriter.close();
			
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
	public int counterValue() {

		try {

			File counterFile = new File("./counter2.txt");

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

    public boolean checkDonor(String name, String address, String phone,String bg) {
        boolean flag = false;
        file2 = new File("./AllRequestList.txt"); // Corrected the file name with extension
        try {
            sc = new Scanner(file2);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] value = line.split("\t");
                if (value[0].equals(name) && value[1].equals(address) && value[2].equals(phone) && value[3].equals(bg)) {
                    flag = true;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return flag;
    }
	

    public static void main(String[] args) {
        
    }
}
