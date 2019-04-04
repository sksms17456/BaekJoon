package BaekJoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C=sc.nextInt();
		for(int c=0; c<C; c++) {
			int sum=0;
			int N=sc.nextInt();
			int[] arr = new int[N];
			for(int n=0; n<N; n++) {
				arr[n]=sc.nextInt();
				sum+=arr[n];
			}
			float cnt=0;
			for(int n=0; n<N; n++) {
				if(arr[n]>(double)sum/N)
					cnt++;
			}
			
			double avg = (double)cnt/N;
			System.out.println(String.format("%.3f", avg*100)+"%");
		}
		
	}
}
