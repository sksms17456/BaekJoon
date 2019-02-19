package BaekJoon;
import java.util.Scanner;

public class BJ2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int cnt=0;
		
		while(N%5!=0 && N>=0) {
			N-=3;
			cnt++;
		}
		if(N<0) {
			System.out.println(-1);
		}
		else {
			cnt+=N/5;
			System.out.println(cnt);
		}
	}
}
