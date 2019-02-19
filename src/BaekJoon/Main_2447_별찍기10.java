package BaekJoon;

import java.io.*;
import java.util.Arrays;

public class Main_2447_별찍기10 {
	static int N;
	static char[][] star;
	static boolean[][] check;
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new FileReader("Main_2447_별찍기10.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		star = new char[N][N];
		check = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(star[i], '*');
		}
		
		fuckingStar(N, 0, 0);
		
		for(int i=0; i<N; i++) {
			System.out.println(star[i]);
		}
	}
	
	public static void fuckingStar(int n, int r, int c) {
		int div=n/3;
		if(n!=1) {
			for(int i=r+div; i<r+div*2; i++) {
				for(int j=c+div; j<c+div*2; j++) {
					if(!check[i][j]) {
						star[i][j] = ' ';
						check[i][j] = true;
					}
				}
			}
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++)
				fuckingStar(div, r+div*i, c+div*j);
			}
		}		
	}
}
