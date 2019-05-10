//Kelly Wang
//5351010
package lab02;

public class CrapsGame {
	private int roll; 
	private CrapsMetricsMonitor monitor; 
	
	//constructor
	public CrapsGame(CrapsMetricsMonitor monitor) 
	{
		this.monitor = monitor; 
	}
	
	//getter and setter for roll
	public int getRoll() {return roll;}
	public void resetRoll() {roll = 0;}
	
	//logic for each game
	public boolean playGame()
	{	
		boolean stillRolling = true;
		int roll1 = (int)(Math.random()*6 + 1);
		int roll2 = (int)(Math.random()*6 + 1);
		int sum = roll1 + roll2;
		roll++;
		System.out.println("Rolled a " + sum);
		
		if(sum == 7 || sum == 11)
		{
			System.out.println("*****Natural! You win!*****");
			monitor.setNaturalCount();
			return true;
		}
		
		else if(sum == 2 || sum == 3 || sum == 12)
		{
			System.out.println("*****Craps! You loose.*****");
			monitor.setCrapsCount();
			return false; 
		}
		
		while(stillRolling)
		{
			int rollX = (int)(Math.random()*6 + 1);
			int rollY = (int)(Math.random()*6 + 1);
			int sumZ = rollX + rollY;
			roll++;
			System.out.println("Rolled a " + sumZ);
			
			if(sumZ == sum)
			{
				System.out.println("*****Rolled the point! You win!*****");
				return true;
			}
			
			else if(sumZ == 7) 
			{
				System.out.println("*****Crap out! You loose.*****"); 
				return false; 
			}
		}
		return true;
	}
}
