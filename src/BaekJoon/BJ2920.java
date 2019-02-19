package BaekJoon;

import java.util.Scanner;

public class BJ2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr= {{1,2,3,4,5,6,7,8},{8,7,6,5,4,3,2,1}};
		int[] input = new int[arr[0].length];
		int ac=0, dc=0;
		
		for(int i=0; i<8; i++) {
			int n = sc.nextInt();
			input[i] = n;
			
			if(input[i]==arr[0][i])
				ac++;
			else if(input[i]==arr[1][i])
				dc++;
		}	
		if(ac==8)
			System.out.println("ascending");
		else if(dc==8)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
