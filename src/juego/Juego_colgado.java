package juego;

import java.util.Arrays;
import java.util.HashSet;
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
			
			
		//This is for determining how many rounds will be played
		System.out.println("How much rounds do you wish to play?");
			int numOfRounds = s.nextInt();
			s.nextLine();
				
			//I put a limit on 20 as that's too far
			while (numOfRounds > 20) 
			{
				if(numOfRounds <= 19) 
				{
					break;
				}	
				System.out.println("20 rounds of hanged man sounds insane, don't you think?");
				System.out.println("How much rounds do you wish to play?");
				numOfRounds = s.nextInt();
				s.nextLine();
			}
				
			
		//I make an integer called "initialise", this integer is for acting as a round
		//If "initialise" is lower than the number of rounds, then the game will be begin.
		for (int initialise = 0; initialise < numOfRounds; initialise++) 
		{
			//I initialize the array for player lives and set it at 6. After the game ends, the player lives are reseted to 6
			for (int i = 0; i < playerLives.length; i++)
		    {
				playerLives[i] = 6;
		    }
			
			/*The reason I am using a hashSet is so that letters inputted are entered into a list where there are only distinct values
			 *The letters that will be inputted will not be repeated again into the list*/
			HashSet<Character> wordsUsed = new HashSet<Character>();
			
			//The hashset list will be empty and after the round ends, it will be cleared and empty again
			wordsUsed.clear();
				
			System.out.println("Now.. What's the secret word?");
			System.out.print("Secret word: ");
			String word = s.nextLine();
				
			/*By inputting space between the words, the game becomes unbeatable
			 *I found a solution by just replacing the space between words with a "_"
			 *This makes that when all the letters are guessed, the game ends as it detects spaces as _ and
			 *the covered form which has every value replaced with "_" will be equal in terms of value*/
			String noSpace = word.replaceAll(" ", "_");
				
			/*Here the word will be copied with every value (represented by ".")
			 *being replaced by _ */
			String covered = noSpace.replaceAll(".", "_");
				
			//The char array of the word is then made with every value being in the array
			char[] letterOfWord = noSpace.toCharArray();
				
			//The covered word is also converted to a char array. This is done so I can then show off the covered word after guessing
			char[] coveredWord = covered.toCharArray();
				
			boolean checker = false; //This boolean is for if the word is found or not
			boolean infinity = true; //This boolean is for letting the while loop last forever until it's set to false
				
			/*outerloop:
			 *for (double i = 0; i < Double.POSITIVE_INFINITY; i++)
			 *
			 *what the fuck was i thinking*/
				
			while(infinity == true)
			{
				//This makes so every player has a turn to guess
				for(int j = 0; j < numOfPlayers; j++) 
				{
					//If the taker is false, it will subtract 1 from the lives of the players
					boolean taker = false;
						
					//The value of lives is set to 0, so I had to add one so I can get "Player1"
					System.out.println("Player" + (j + 1) + "'s lives: " + playerLives[j]);
					System.out.print("Player" + (j + 1) + "'s turn:");
						
					//This is to scan only the first letter of whatever is inputted
					char guessL = s.next().charAt(0);
					s.nextLine();
						
					//If the hashset list already contains the letter that's inputted, it will ask for another letter
					while(wordsUsed.contains(guessL)) 
					{
						System.out.println("Letter already used");
						System.out.println("Player" + (j + 1) + "'s lives: " + playerLives[j]);
						System.out.print("Player" + (j + 1) + "'s turn:");
						guessL = s.next().charAt(0);
					}
						
					//If it goes past the while loop, it will add the letter to the hashset list
					wordsUsed.add(guessL);
					
					/*This for loop is here to check if the letter inputted is equal to one or more of the letters in the secret word
					 *I create a new value that will count up until it reaches the length of the word*/
					for (int k = 0; k < word.length(); k++) 
					{
						//If the guessed letter is equal to the letter of secret word in the position where k is
						if(guessL == letterOfWord[k]) 
						{
							//Then the covered word reveals gains the letter of the secret word you guessed
							coveredWord[k] = letterOfWord[k];
							taker = true;
						}
					}
						
					//Then we print the word to show the progress of the players
					System.out.println(Arrays.toString(coveredWord));
						
					//When the covered word and the secret word are equal, the for loop breaks and checker is set to true
					if(Arrays.equals(letterOfWord, coveredWord)) 
					{
						System.out.println("Player" + (j+1) + " has found the word!");
						checker = true;
						break;
					}
						
					/*If the first if condition from earlier isn't met, then it passes to here and if the taker is false,
					 *then a life is subtracted from the current player*/
					if(taker == false) 
					{
						playerLives[j]--;
					}
		
					//And if the player lives is 0, then it breaks the for loop
					if(playerLives[j] == 0) 
					{
						break;
					}
						
					//The reason to use 3 different if conditions instead of "if.. else if.." is because they are 3 unconnected conditions
				}
					
				//We do the check again, to end the while loop
				if(Arrays.equals(letterOfWord, coveredWord)) 
				{
					checker = true;
					break;
				}
					
				/*Because it can't check for the individual player lives with if(playerLives[j] == 0), I have to use a for each loop.
				 *If the condition is met, the while loop is broken. I break the while loop with infinity = false because
				 *if I do a break in a for each loop, it breaks the for each loop*/
				for (int lives : playerLives) 
				{
					if(lives == 0) 
					{
						infinity = false;
						//break outerloop;
					}
				}
			}
				
			//if checker is set to true, you have found the word and won the game
			if(checker == true) 
			{
				System.out.println("\nYou have found the word!!");
				System.out.println("( ◡̀_◡́)ᕤ\n");
			}
				
			//if else, then you haven't and you have died
			else if (checker == false)
			{
				System.out.println("You did not find the word in time");
				System.out.println("      _       ");
				System.out.println("     (_)      ");
				System.out.println(" _ __ _ _ __  ");
				System.out.println("| '__| | '_ \\");
				System.out.println("| |  | | |_) |");
				System.out.println("|_|  |_| .__/ ");
				System.out.println("       | |    ");
				System.out.println("       |_|    ");
			}
		}
		System.out.println("\nYou have ran out of rounds. Goodbye");
	}
}