import java.io.*;
import java.util.*;

public class DeleteData {
    private String name, address, phone, gender, bg, date;
    private File file, file2;
    private FileWriter fwritter2;
    private Scanner sc;
    private Donor[] donorList;

    public void showDonor() {
        File donorFile = new File("AllDonorList.txt");
        try {
            int count = counterValue(); // Get the number of donors
            donorList = new Donor[count]; // Initialize the donorList array
            BufferedReader reader = new BufferedReader(new FileReader(donorFile));
            String tempData;
            int i = 0;

            while ((tempData = reader.readLine()) != null) {
                String[] arr = tempData.split("\t");
                donorList[i] = new Donor(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
                i++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds. Check the donor list size.");
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

    public int getIndexByPhone(String phone) {
        int c = -1;
        for (int i = 0; i < donorList.length; i++) { // Use donorList.length instead of counterValue()
            if (donorList[i] != null && donorList[i].getPhone().equals(phone)) { // Check if donorList[i] is not null
                c = i;
                break;
            }
        }
        //System.out.println("Index: " + c);
        return c;
    }

    public void DeleteDataByPhone(String phone) {
        this.showDonor();
        int index = getIndexByPhone(phone);
        if (index == -1) {
            return;
        }
        boolean firstCheck = true;
        for (int in = 0; in < donorList.length; in++) { // Use donorList.length instead of counterValue()
            if (in != index) {
                try {
                    file2 = new File("./AllDonorList.txt");
                    file2.createNewFile();
                    fwritter2 = (firstCheck) ? new FileWriter(file2, false) : new FileWriter(file2, true);
                    String addedData;

                    if (firstCheck) {
                        addedData = donorList[in].getName() + "\t" + donorList[in].getAddress() + "\t"
                                + donorList[in].getPhone() + "\t" + donorList[in].getGender() + "\t"
                                + donorList[in].getBg() + "\t" + donorList[in].getDate() + "\t";
                        firstCheck = false;
                    } else {
                        addedData = "\r\n" + donorList[in].getName() + "\t" + donorList[in].getAddress() + "\t"
                                + donorList[in].getPhone() + "\t" + donorList[in].getGender() + "\t"
                                + donorList[in].getBg() + "\t" + donorList[in].getDate() + "\t";
                    }

                    fwritter2.write(addedData);
                    fwritter2.flush();
                    fwritter2.close();
                    //System.out.println(in);
                    // if (in == (donorList.length - 1)) { // Use donorList.length instead of
                    // counterValue()

                    // }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        try {
            File counterFile = new File("./counter.txt");
            FileReader txtReaderFile = new FileReader(counterFile);
            BufferedReader txtReader = new BufferedReader(txtReaderFile);
            String count = txtReader.readLine();
            int countInt = Integer.parseInt(count);
            txtReader.close();
            txtReaderFile.close();
            int newCount = countInt - 1;
            FileWriter counterWriter = new FileWriter(counterFile, false);
            counterWriter.write(String.valueOf(newCount));
            counterWriter.flush();
            counterWriter.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
