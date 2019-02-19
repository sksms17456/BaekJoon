//문제
//예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
//
//입력
//첫째 줄에 N이 주어진다. N은 항상 3×2k 수이다. (3, 6, 12, 24, 48, ...) (k ≤ 10)
//
//출력
//첫째 줄부터 N번째 줄까지 별을 출력한다.
package BaekJoon;

import java.io.*;
import java.util.Arrays;

public class Main_2448_별찍기11 {
	static int N;
	static char[][] star;
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new FileReader("Main_2448_별찍기11.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		star = new char[N][N*2-1];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(star[i], ' ');
		}
		int n=1;
		for(int i=0; i<N; i++) {
			for(int j=N-i-1; j<N-i-1+n; j++) {
				star[i][j] = '*';
			}
			n+=2;
		}
		fuckingStar(N, 0, 0);
		for(int i=0; i<N; i++) {
			System.out.println(star[i]);
		}
	}
	public static void fuckingStar(int n, int r, int c) {
		int div = n/2;
		if(n==3) {
			star[r+1][c+2]=' ';
		}
		if(n!=3) {
			for(int i=r+div; i<r+div*2; i++) {
				for(int j=c+i-r; j<c+n*2-1-i+r; j++) {
					star[i][j] = ' ';
				}
			}
			for(int i=0; i<2; i++) {
				for(int j=1-i; j<2; j++) {
					if(i==0) {
						fuckingStar(div, r+div*i, c+div*j);
					}else {
						fuckingStar(div, r+div*i, c+div*j*2);
					}
					
				}
			}
		}
	}
}
