package BaekJoon;

import java.util.Scanner;

public class Main_1107 {
	static String N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=i;
		}
		N=sc.next();
		M=sc.nextInt();
		
		for(int i=0; i<M; i++) {
			int n = sc.nextInt();
			arr[n] = 0;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
		
		
	}
}
