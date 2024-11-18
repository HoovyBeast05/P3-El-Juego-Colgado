package juego;

import java.util.Arrays;
import java.util.Scanner;

public class CreatePlayerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int numOfPlayers = s.nextInt();
		
		int[] playerLives = new int[numOfPlayers];
		
		for (int i = 0; i < playerLives.length; i++)
	    {
			playerLives[i] = 6;
	    }
		
		System.out.println(Arrays.toString(playerLives));

	}

}
