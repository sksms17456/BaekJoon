package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int T, N, min;
	static int[][] arr;
	static int[] A;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_14889_스타트와링크.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=  new StringBuilder();
		StringTokenizer st;
        min = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        A = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0,0);
		System.out.println(min);
	}
	private static void comb(int cnt, int idx) {
		if(cnt==N>>1 && A[0]==1) {
			getSum();
			return;
		}
		for(int i=idx; i<N; i++) {
			A[i]=1;
			comb(cnt+1, i+1);
			A[i]=0;
		}
	}
	private static void getSum() {
		int sumA=0, sumB=0;
		for(int i=0; i<N-1; i++) {
			if(A[i]==1) {
				for(int j=i+1; j<N; j++) {
					if(A[j]==1) {
						sumA+=arr[i][j]+arr[j][i];
					}
				}
			}
			else {
				for(int j=i+1; j<N; j++) {
					if(A[j]==0) {
						sumB+=arr[i][j]+arr[j][i];
					}
				}
			}
		}
		min = Math.min(min, Math.abs(sumA-sumB));
	}
}

