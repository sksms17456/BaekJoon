package BaekJoon;
import java.util.Scanner;

public class BJ2593 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[5][4];
		int max=0;
		int index=0;
		
		for(int i=0;i<arr.length;i++) {
			int sum=0;
			
			for(int j=0;j<arr[i].length;j++) {
				int score=sc.nextInt();
				sum+=score;
			}
			if(max<sum) {
				max=sum;
				index=i+1;
			}
		}
		System.out.println(index+" "+max);
	}
}
