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
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16971_배열B의값 {
	static int N, M, cnt=2, max=Integer.MIN_VALUE, rowi, rowj, sum;
	static int[][] A, B;
	static int[] arr = {0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16971_배열B의값.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		B = new int[N-1][M-1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0,0);
		
		
		
	}
	private static void sum(int i, int j) {
		sum=0;
		for(int r=0; r<N-1; r++) {
			
		}
	}
	private static void perm(int start, int idx) {
		if(cnt==idx) {
			System.out.println(Arrays.toString(arr));
			rowi = arr[0];
			rowj = arr[1];
			return;
		}
		for(int i=start; i<M; i++) {	
			arr[idx] = i;
			perm(i+1, idx+1);
		}
	}
}
