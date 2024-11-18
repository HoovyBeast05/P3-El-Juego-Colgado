package juego;

import java.util.Arrays;
import java.util.Scanner;

public class HangManTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		String word = s.nextLine();
		String covered = word.replaceAll(".", "_");
		char[] letterOfWord = word.toCharArray();
		char[] coveredWord = covered.toCharArray();
		boolean checker = false;
		
		System.out.println(covered);
		System.out.println("Guess");
		
		for (int i = 0; i < 6; i++) 
		{
			char guessL = s.next().charAt(0);
			
			for (int k = 0; k < word.length(); k++) 
			{
				if(guessL == letterOfWord[k]) 
				{
					coveredWord[k] = letterOfWord[k];
				}
			}
			System.out.println(Arrays.toString(coveredWord));
			
			if(Arrays.equals(letterOfWord, coveredWord)) 
			{
				checker = true;
				break;
			}
		}
		
		if(checker == true) 
		{
			System.out.println("You have found the word!!");
		}
		else if (checker == false)
		{
			System.out.println("You did not find the word in time");
		}

	}

}
