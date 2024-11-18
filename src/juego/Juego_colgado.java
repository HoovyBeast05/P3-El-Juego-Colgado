package juego;

import java.util.Scanner;

public class Juego_colgado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Welcome to the hanged man game!!");
		System.out.println("In this game, you will have 6 tries to guess the word or DIE trying");
		System.out.println("...");
		System.out.println("Good luck!");
		
		//This is for determining how much players are playing.
		System.out.println("How much players are playing?");
			int numOfPlayers = s.nextInt();
			
			//This s.nextLine() is here so that the enter spaces are not read, i used chatgpt to find this solution
			//I had an error before where some lines would come together.
			s.nextLine();
			
			/*Since the number of players can't be lower than 2, we use this while loop to keep asking until we 
			 *have a number higher or equal to 2*/
			while (numOfPlayers < 2) 
			{
				if(numOfPlayers >= 2) 
				{
					break;
				}	
				System.out.println("There must be at least 2 players");
				System.out.println("How much players are playing?");
				numOfPlayers = s.nextInt();
				s.nextLine();
			}
			
			System.out.println("Okay, there are " + numOfPlayers + " players");
			
			//We create an integer array which will serve as our player lives
			int[] playerLives = new int[numOfPlayers];
			
		

	}

}
