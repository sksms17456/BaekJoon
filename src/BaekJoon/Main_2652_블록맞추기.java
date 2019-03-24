package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2652_블록맞추기 {
	static int N, u, v, w, x, y;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2652_블록맞추기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
}
