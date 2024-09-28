import java.lang.*;
import java.io.*; //for file
import java.util.*; //for read the file (Scanner)
public class Account 
{
	private String username;
	private String password;
	private String email;
	private String phone;
	private File file;
	private FileWriter fwritter; //for insert or write in text file
	private Scanner sc; //for read the file
	
	public Account() { }
	
	public Account(String username, String email, String phone, String password)
	{
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getUsername() { return this.username; }
	public String getEmail() { return this.email; }
	public String getPhone() { return this.phone; }
	public String getPassword() { return this.password; }
	
	public void addAccount(Account ac) 
	{
		try
		{
			file = new File("./data.txt");
			file.createNewFile();
			
			fwritter = new FileWriter(file, true);
			fwritter.write(getUsername()+"\t");
			fwritter.write(getEmail()+"\t");
			fwritter.write(getPhone()+"\t");
			fwritter.write(getPassword()+"\n");
			fwritter.flush();
			fwritter.close();				
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public boolean checkAccount(String phone, String password)
	{
		boolean flag = false;
		file = new File("./data.txt");
		try 
		{
			sc = new Scanner(file); //scan the file
			
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				String[] value = line.split("\t");
				if(value[2].equals(phone) && value[3].equals(password))
				{
					flag = true;
				}
			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		return flag;
	}
	
	public static void main(String[] args) {
		Account frame = new Account();
		
	}
}
