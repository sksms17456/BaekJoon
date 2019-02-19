package BaekJoon;

import java.util.Scanner;

public class Main_10872_팩토리얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println(go(N));
	}
	
	private static int go(int num) {
		if(num==1)
			return 1;
		else
			return num*go(num-1);
	}
}
