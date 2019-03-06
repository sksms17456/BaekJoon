package BaekJoon;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int[][] A = new int[N][M];
		int[] Col = new int[M];
		int[] Row = new int[N];
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(line[j]);
				
				if(i==0 || j==0 || i==N-1 || j==M-1) {
					if((i==0 && j==0) || (i==0 && j==M-1) || (j==0 && i==N-1) || (i==N-1 && j==M-1)) {
						Col[j] += A[i][j];
						Row[i] += A[i][j];
					}
					else {
						Col[j] += A[i][j] * 2;
						Row[i] += A[i][j] * 2;
					}
				}
				else {
					Col[j] += A[i][j] * 4;
					Row[i] += A[i][j] * 4;
				}
			}
		}
		
		int Sum = 0;
		for(int i=0; i<N; i++) {
			Sum += Row[i];
		}
		
		/** 세로 */
		int Mosery = Math.max(Col[0], Col[M-1]);
		int Min = Integer.MAX_VALUE;
		for(int j=1; j<M-1; j++) {
			Min = Math.min(Min, Col[j]);
		}
		int Answer = Sum;
		Answer = Math.max(Answer, Sum - Min/2 + Mosery);
		
		/** 가로 */
		Mosery = Math.max(Row[0], Row[N-1]);
		Min = Integer.MAX_VALUE;
		for(int i=1; i<N-1; i++) {
			Min = Math.min(Min, Row[i]);
		}
		Answer = Math.max(Answer, Sum - Min/2 + Mosery);
		
		System.out.println(Answer);
	}
}