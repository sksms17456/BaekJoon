package BaekJoon;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main_8979_올림픽 {
	static int N;//국가의 수
	static int K;//등수를 알고 싶은 국가
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Main_8979_올림픽.txt"));
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		int[][] arr = new int[N][4];
		
		int n=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<4; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			if(arr[i][0] == K) {
				n=i;
				break;
			}
		}
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			if(arr[i][1]>arr[n][1]) {
				cnt++;
			}
			else if(arr[i][1]==arr[n][1]) {
				if(arr[i][2]>arr[n][2]) {
					cnt++;
				}
				else if(arr[i][2]==arr[n][2]) {
					if(arr[i][3]>arr[n][3]) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt+1);
	}
}
