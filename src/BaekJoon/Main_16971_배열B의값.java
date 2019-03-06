//문제 
//
//크기가 N×M인 배열 A가 있을 때, 다음과 같은 방법을 이용해서 크기가 (N-1)×(M-1)인 배열 B를 만들 수 있다.
//
//B[i][j] = A[i][j] + A[i+1][j] + A[i+1][j+1] + A[i][j+1] (1 ≤ i < N, 1 ≤ j < M)
//
//배열의 값은 배열의 모든 원소를 합한 값이다.
//
//배열 A에서 임의의 두 행이나 임의의 두 열의 위치를 교환할 수 있다. 배열 A에서 교환을 최대 1번 수행해서 만들 수 있는 배열 B의 값의 최댓값을 구해보자.
//
//입력 
//
//첫째 줄에 배열 A의 크기 N, M이 주어진다. 둘째 줄부터 N개의 줄에 배열의 원소가 주어진다. 배열은 정수로만 이루어져 있다.
//
//출력 
//
//만들 수 있는 배열 B의 값 중 최댓값을 출력한다.
//
//
//제한 
//2 ≤ N, M ≤ 1,000
//
//-1,000 ≤ Ai,j ≤ 1,000

package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_16971_배열B의값 {
	static int N, M, sum, rsum, csum, ans;
	static int[][] A;
	static int[] R, C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16971_배열B의값.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = new int[N];
		C = new int[M];
		A = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(N==2 && M==2) {
			ans = A[0][0]+A[0][1]+A[1][1]+A[1][0];
		}else {
			
			for(int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if(i==0 || i==N-1) {
						if(j==0 || j==M-1) {
							R[i]+=A[i][j];
						}else {
							R[i]+=A[i][j]*2;
						}
					}else {
						if(j==0 || j==M-1) {
							R[i]+=A[i][j]*2;
						}else {
							R[i]+=A[i][j]*4;
						}
					}
				}
			}
			
			for(int i=0; i<M; i++) {
				for (int j=0; j<N; j++) {
					if(j==0 || j==N-1) {
						if(i==0 || i==M-1) {
							C[i]+=A[j][i];
						}else {
							C[i]+=A[j][i]*2;
						}
					}else {
						if(i==0 || i==M-1) {
							C[i]+=A[j][i]*2;
						}else {
							C[i]+=A[j][i]*4;
						}
					}
				}
			}
			for(int i=0; i<N; i++) {
				sum+=R[i];
			}
			int rmax = Math.max(R[0], R[N-1]);
			int rmin = Integer.MAX_VALUE;
			int cmax = Math.max(C[0], C[M-1]);
			int cmin = Integer.MAX_VALUE;
			
			for(int i=1; i<N-1; i++) {
				rmin = Math.min(rmin, R[i]);	
			}
			for(int i=1; i<M-1; i++) {
				cmin = Math.min(cmin, C[i]);
			}		
			rsum = sum+rmax-rmin/2;
			csum = sum+cmax-cmin/2;
			ans = Math.max(rsum, csum);
			ans = Math.max(sum, ans);
		}
		System.out.println(ans);
	}
}
