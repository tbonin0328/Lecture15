import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class BirdName 
{

	private static final String BIRD_FILE = "output/birds.txt";
	
	private Scanner in = new Scanner(System.in);
	
	//give me a file name, and I will return to you the print writer
	public PrintWriter getFileWriter(String fileName)
	{
		FileOutputStream file = null;
			
		try 
		{
			file = new FileOutputStream(BIRD_FILE, true);
		} 
		
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			return null; //System.exit(-1); let's someone decide instead of automatic exit?
		}
		
		return new PrintWriter(file);
		//PrintWriter writer = new PrintWriter(file);
	}
	
	public Scanner getFileReader(String fileName)
	{
		File file = new File(fileName);
		
		try 
		{
			return new Scanner(file);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			System.exit(-1);
			return null;
		}
	}
	
	public void play()
	{
		System.out.println("I love Birds.");
	
		while (true)
		{
			String command = getString("(E)nter, (P)rint, (Q)uit");
			
			if (command.toLowerCase().equals("q")) break;
			
			if (command.toLowerCase().equals("e"))
			{
				enterBird();
			}
			
			if (command.toLowerCase().equals("p"))
			{
				printBird();
			}
		}
	}
	
	public void enterMore()
	{
		
	}
	public void enterBird()
	{
		PrintWriter writer = getFileWriter(BIRD_FILE);
		
		if (writer == null) return;
		
		//get social from user and add it to the file
		String bird = getString("Bird Name: ");
		writer.println(bird);
		writer.close();
	}
	
	public void printBird()
	{
		Scanner fileIn = getFileReader(BIRD_FILE);
		//loop through the file and display its contents
		while(fileIn.hasNextLine())
		{
			String line = fileIn.nextLine();
			System.out.println(line);
		}
		
		fileIn.close();
	}
	
	public String getString(String prompt)
	{
		System.out.println(prompt);
		return in.nextLine();
	}
	
	public static void main (String[] args)
	{
		BirdName program = new BirdName();
		program.play();
	}
}
