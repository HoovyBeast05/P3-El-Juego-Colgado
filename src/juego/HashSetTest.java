package juego;

import java.util.HashSet;
import java.util.Scanner;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		HashSet<Character> set = new HashSet<Character>();
		
		for(int i =0; i < 5; i++) 
		{
			System.out.println("insert char");
			char cha = s.next().charAt(0);
			while(set.contains(cha)) 
			{
				System.out.println("insert char again");
				cha = s.next().charAt(0);
			}
			set.add(cha);
		}
		System.out.println(set);

	}

}
