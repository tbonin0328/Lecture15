import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWriter 
{
	private static final String SOCIAL_FILE = "output/socials.txt";
	
	private Scanner in = new Scanner(System.in);
	
	//give me a file name, and I will return to you the print writer
	public PrintWriter getFileWriter(String fileName)
	{
		FileOutputStream file = null;
			
		try 
		{
			file = new FileOutputStream(SOCIAL_FILE, true);
		} 
		
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			return null; //System.exit(-1); let's someone decide instead of automatic exit?
		}
		
		return new PrintWriter(file);
		//PrintWriter writer = new PrintWriter(file);
	}
	
	public void play()
	{
		PrintWriter writer = getFileWriter(SOCIAL_FILE);
		
		if (writer == null) return;
		
		//get social from user and add it to the file
		String social = getString("Enter Social: ");
		writer.println(social);
		
		writer.close();
	}
	
	public String getString(String prompt)
	{
		System.out.println(prompt);
		return in.nextLine();
	}
	
	public static void main (String[] args)
	{
		FileWriter program = new FileWriter();
		program.play();
	}
}
