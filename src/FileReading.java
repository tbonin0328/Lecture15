import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReading 
{
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
		Scanner fileIn = getFileReader("input/groceries.txt");
		//loop through the file and display its contents
		while(fileIn.hasNextLine())
		{
			String line = fileIn.nextLine();
			System.out.println(line);
		}
		
		fileIn.close();
	}
		
	public static void main(String[] args)
	{
		FileReading program = new FileReading();
		program.play();
	}
}
