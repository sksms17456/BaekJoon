package BaekJoon;
import java.util.Scanner;

public class BJ2846 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int up = 0;
		int max = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<N; i++) {
			if(arr[i]-arr[i-1]>0)
				up+=arr[i]-arr[i-1];
			else 
				up=0;
			if(max<up)
				max=up;
		}
		
		System.out.println(max);
	}
}
