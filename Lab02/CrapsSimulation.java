//Kelly Wang
//5351010

package lab02;
import java.util.Scanner;

public class CrapsSimulation {
	private String name; 
	private int balance; 
	private int betAmount; 
	private CrapsGame crapsGame;
	private CrapsMetricsMonitor monitor;
	private Scanner s;
	
	//constructor
	public CrapsSimulation() {
		monitor = new CrapsMetricsMonitor();
		crapsGame = new CrapsGame(monitor);
		s = new Scanner(System.in);
	}
	
	//start game 
	public void start() {
		int winStreak = 0;
		int loseStreak = 0;
		boolean x; 
		
		/*
		 * -------------------------------------------------------------------------------------
		 * ------------------Prompting user for name, balance, bet amount-----------------------
		 * ------------------Check for white spaces and valid bet amount------------------------
		 * -------------------------------------------------------------------------------------
		 */
		System.out.print("Welcome to SimCraps! Enter your user name: ");
		name = s.nextLine();
		while(true) 
		{
			if(!name.contains(" "))
				break;
			System.out.println("Invalid, please enter username without whitespaces");
			name = s.nextLine();
		}

		System.out.println("Hello " + name + "!");
		
		System.out.print("Enter the amount of money you will bring to the table: ");
		balance = s.nextInt();
		while(balance <= 0) {
			System.out.print("Invalid amount! Please enter an amount greater than 0: ");
			balance = s.nextInt();
		} 

		System.out.print("Enter the bet amount between $1 and $" + balance + ":");
		betAmount = s.nextInt();
		
		while(betAmount > balance || betAmount < 1) {
			System.out.print("Invalid bet! Please enter a bet between $1 and " + balance + ".");
			betAmount = s.nextInt();
		} 
		
		/*
		 * ---------------------------------------------------------------------------------
		 * ---------------------------start to play game------------------------------------
		 * ---------------------------------------------------------------------------------
		 */
		monitor.setMaxBalance(balance);
			//after 1st round
		monitor.setGameNumBalance(1);
		while(balance > 0) {
			System.out.println(name + " bets $" + betAmount);
			x = crapsGame.playGame();
			monitor.setTotalPlays();
			
			if(betAmount > balance && balance > 0)
				betAmount = balance;
			if(balance > monitor.getMaxBalance()) {
				monitor.setMaxBalance(balance);
				int count = monitor.getTotalPlays();
				monitor.setGameNumBalance(count);
			}
			if(crapsGame.getRoll() > monitor.getMaxRoll())
				monitor.setMaxRoll(crapsGame.getRoll());
			
			if(x == true) 
			{
				monitor.setTotalWinnings();
				winStreak++;
				monitor.setMaxWinningStreak(winStreak);
				loseStreak = 0;
				balance += betAmount;
				crapsGame.resetRoll();
			}

			else if(x == false) 
			{	
				monitor.setTotalLosings();
				loseStreak++; 
				monitor.setMaxLosingStreak(loseStreak);
				winStreak = 0;
				balance -= betAmount;
				crapsGame.resetRoll();
			}
			if(balance > 0)
				System.out.println(name + "'s balance: " + balance + ". Playing a new game...");
			else
				System.out.println(name + "'s balance: " + balance + ". End of game");
			
				
		}
		
		monitor.printStatistics();
		
		/*
		 * -------------------------------------------
		 * -------------Asking user to replay---------
		 * -------------------------------------------
		 */
		boolean response = true;
		s = new Scanner(System.in);
		System.out.print("Replay? Enter 'y' or 'n': ");
		String replay = s.nextLine();
		
		while(response) {
			if(replay.charAt(0) == 'y') 
			{
				response = false; 
				monitor = new CrapsMetricsMonitor();
				start();
			}
			else if(replay.charAt(0) == 'n')
			{
				System.out.println("Thanks for playing!");
				response = false;
			}
			else 
			{
				System.out.println("Please enter a valid response.");
				replay = s.nextLine();
				response = true;
			}
		}
		s.close();
	}
}


