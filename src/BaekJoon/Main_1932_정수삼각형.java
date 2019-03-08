//문제 
//        7
//      3   8
//    8   1   0
//  2   7   4   4
//4   5   2   6   5
//위 그림은 크기가 5인 정수 삼각형의 한 모습이다.
//
//맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 
//
//아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
//
//삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.
//
//입력 
//
//첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.
//
//출력 
//
//첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.


package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {
	static int N, max=Integer.MIN_VALUE;
	static int[] triangle, dp, dp2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_1932_정수삼각형.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		dp = new int[N];
		dp2 = new int[N];
		dp[0] = Integer.parseInt(br.readLine());
		dp2[0] = dp[0];
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<i+1; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(j==0) {
					dp2[j] = dp[j]+num;
					continue;
				}
				dp2[j] = Math.max(dp[j]+num, dp[j-1]+num);
			}
			for(int j=0; j<N; j++) {
				dp[j] = dp2[j];
			}
		}
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
