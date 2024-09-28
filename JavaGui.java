import java.io.*;
import java.util.*;

public class JavaGui {

    Scanner scnr;
    static String fileText;

    public void openfile(){
        try{
            scnr = new Scanner(new File("./AllDonorList.txt"));
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found. Try Again!");
        }
    }

    public void readfile(){
         while (scnr.hasNextLine()){
             fileText = scnr.nextLine();
             System.out.println(fileText);
         }
        scnr.close();
    }
}