package BaekJoon;

import java.util.Scanner;

public class Main_11729_하노이탑 {
	static int cnt=0;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Hanoi(N,1,3,2);
		sb.insert(0, cnt+"\n");
		System.out.println(sb);
		
	}
	
	public static void Hanoi(int n, int now, int next, int mid) {
		cnt++;
		if(n==1) {
			sb.append(now+" "+next+"\n");
//			System.out.println(now+" "+next);
		}
		else {
			Hanoi(n-1, now, mid, next);
			sb.append(now+" "+next+"\n");
//			System.out.println(now+" "+next);
			Hanoi(n-1, mid, next, now);
		}
	}
	
}