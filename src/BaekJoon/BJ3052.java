package BaekJoon;
import java.util.Scanner;

public class BJ3052 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int[] arr=new int[42];
		
		for(int i=0;i<10;i++) {
			int input = sc.nextInt();
			arr[input%42]=1;
		}
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		System.out.println(sum);
	}
}
