package BaekJoon;

import java.io.*;

public class Main_2740_행렬곱셈 {
	static int N, M, K;
	static String[] line;
	static int[][] matrixA, matrixB;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Main_2740_행렬곱셈.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		
		matrixA = new int[N][M];
		
		for(int i=0; i<N; i++) {
			line = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				matrixA[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		line = br.readLine().split(" ");
		K = Integer.parseInt(line[1]);
		matrixB = new int[M][K];
		
		for(int i=0; i<M; i++) {
			line = br.readLine().split(" ");
			for(int j=0; j<K; j++) {
				matrixB[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<K; j++) {
				sb.append(solve(i,j)+" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
		}		
		System.out.println(sb);
		br.close();
	}
	public static int solve(int x, int y) {
		int sum=0;
		for(int i=0; i<M; i++) {
			sum+=matrixA[x][i]*matrixB[i][y];
		}
		return sum;
	}
}
