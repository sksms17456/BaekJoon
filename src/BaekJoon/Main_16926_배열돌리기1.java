//문제 
//
//크기가 N×M인 배열이 있을 때, 배열을 돌려보려고 한다. 배열은 반시계 방향으로 돌려야 하며, 다음과 같은 방향으로 돌려야 한다.
//
//A[1][1] ← A[1][2] ← A[1][3] ← A[1][4] ← A[1][5]
//   ↓                                       ↑
//A[2][1]   A[2][2] ← A[2][3] ← A[2][4]   A[2][5]
//   ↓         ↓                   ↑         ↑
//A[3][1]   A[3][2] → A[3][3] → A[3][4]   A[3][5]
//   ↓                                       ↑
//A[4][1] → A[4][2] → A[4][3] → A[4][4] → A[4][5]
//		
//예를 들어, 아래와 같은 배열을 2번 회전 시키면 다음과 같이 변하게 된다.
//
//1 2 3 4       2 3 4 8       3 4 8 6
//5 6 7 8       1 7 7 6       2 7 8 2
//9 8 7 6   →   5 6 8 2   →   1 7 6 3
//5 4 3 2       9 5 4 3       5 9 5 4
// <시작>         <회전1>        <회전2>
// 
//배열과 정수 R이 주어졌을 때, 배열을 R번 회전 시킨 결과를 구해보자.
//
//입력 
//
//첫째 줄에 배열의 크기 N, M과 수행해야 하는 회전의 수 R이 주어진다.
//
//둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.
//
//출력 
//
//입력으로 주어진 배열을 R번 회전 시킨 결과를 출력한다.
//
//제한 
//
//2 ≤ N, M ≤ 300
//1 ≤ R ≤ 1,000
//min(N, M) mod 2 = 0
//1 ≤ Aij ≤ 108
package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
	static int N, M, R;
	static int[][] arr, newarr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16926_배열돌리기1.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		newarr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(R>0) {
			int idx = 0;
			while(true) {
				if(idx==N>>1-1 || idx==M>>1-1)
					break;
				for(int i=idx; i<M-1-idx; i++) {
					newarr[idx][i] = arr[idx][i+1];
				}
				for(int i=idx; i<N-1-idx; i++) {
					newarr[i][M-1-idx] = arr[i+1][M-1-idx];
				}
				for(int i=M-1-idx; i>idx; i--) {
					newarr[N-1-idx][i] = arr[N-1-idx][i-1];
				}
				for(int i=N-1-idx; i>idx; i--) {
					newarr[i][idx] = arr[i-1][idx];
				}
				idx++;
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					arr[i][j] = newarr[i][j];
				}
			}
			R--;
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(newarr[i][j]+" ");
			}
			System.out.println();
		}		
		
		
	}
}
