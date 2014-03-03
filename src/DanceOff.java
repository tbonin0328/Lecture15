import java.util.Scanner;

public class DanceOff 
{
	Scanner in = new Scanner(System.in);
	
	public void play()
	{
		System.out.println("Dance Party!!!");
		int numLeads = getInt("Leads: ");
		int numFollows = getInt("Follows: ");
		
		try
		{
			if(numLeads == 0 && numFollows == 0)
			{
				throw new Exception("No one showed up.");
			}
			else if (numLeads == 0)
			{
				throw new Exception("No leads showed up.");
			}
			else if (numFollows == 0)
			{
				throw new Exception("No follows showed up.");
			}
		
			//test to see if we can have a dance party
			
			System.out.println("Having a dance party :)");
		}
		catch(Exception e)
		{
			System.out.println("Sorry no party today :(");
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		
		System.out.println("putting on my dancing shoes");
	}
	
	public int getInt(String prompt)
	{
		System.out.println(prompt);
		int answer = in.nextInt();
		in.nextLine();
		return answer;
	}
	
	public static void main(String[] args)
	{
		DanceOff myDance = new DanceOff();
		myDance.play();
	}
	
}
