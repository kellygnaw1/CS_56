//Kelly Wang
//5351010
package lab02;

public class CrapsMetricsMonitor {
	private int playCount;
	private int wonCount; 
	private int lostCount; 
	private int maxRoll; 
	private int naturalCount;
	private int crapsCount;
	private int maxWinningStreak;
	private int maxLosingStreak;
	private int maxBalance;
	private int gameNumBalance;
	
	public int getMaxBalance() {return maxBalance;}
	public int getMaxRoll() { return maxRoll;}
	public int getTotalPlays() { return playCount;}
	
	
	//increments
	
	public void setTotalPlays() {playCount++;}
	public void setTotalWinnings() {wonCount++;}
	public void setTotalLosings() {lostCount++;}
	public void setNaturalCount() {naturalCount++;}
	public void setCrapsCount() {crapsCount++;}
	
	//finding maximum
	public void setMaxRoll(int current) 
	{
		this.maxRoll = current;
	}
	public void setMaxWinningStreak(int current) 
	{
		if(current > maxWinningStreak)
			maxWinningStreak = current;
	}
	public void setMaxLosingStreak(int current) 
	{
		if(current > maxLosingStreak)
			maxLosingStreak = current;
	}
	public void setMaxBalance(int current) 
	{
		this.maxBalance = current;
	}
	
	public void setGameNumBalance(int current)
	{
		this.gameNumBalance = current;
	}
	
	//print 
	public void printStatistics() 
	{
		System.out.println("*****************************");
		System.out.println("*** SIMULATION STATISTICS ***");
		System.out.println("*****************************");
		System.out.println("Games played: " + playCount);
		System.out.println("Games won: " + wonCount);
		System.out.println("Games lost: " + lostCount);
		System.out.println("Maximum Rolls in a single game: " + maxRoll);
		System.out.println("Natural Count: " + naturalCount);
		System.out.println("Craps Count: " + crapsCount);
		System.out.println("Maximum Winning Streak: " + maxWinningStreak);
		System.out.println("Maximum Loosing Streak: " + maxLosingStreak);
		System.out.println("Maximum balance: " + maxBalance + " during game " + gameNumBalance);
	}
	//reset
}
