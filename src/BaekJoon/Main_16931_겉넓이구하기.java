//문제 
//
//크기가 N×M인 종이가 있고, 종이는 1×1크기의 칸으로 나누어져 있다. 이 종이의 각 칸 위에 1×1×1 크기의 정육면체를 놓아 3차원 도형을 만들었다.
//
//종이의 각 칸에 놓인 정육면체의 개수가 주어졌을 때, 이 도형의 겉넓이를 구하는 프로그램을 작성하시오.
//
//위의 그림은 3×3 크기의 종이 위에 정육면체를 놓은 것이고, 겉넓이는 60이다. 종이의 각 칸에 놓인 정육면체의 수가 주어졌을 때, 겉넓이를 구하는 프로그램을 작성하시오.
//
//입력 
//
//첫째 줄에 종이의 크기 N, M이 주어진다. 둘째 줄부터 N개의 줄에는 종이의 각 칸에 놓인 정육면체의 수가 주어진다.
//
//출력 
//
//첫째 줄에 도형의 겉넓이를 출력한다.
//
//제한 
//1 ≤ N, M ≤ 100
//1 ≤ 종이의 한 칸에 놓인 정육면체의 수 ≤ 100

package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_16931_겉넓이구하기 {
	static int N, M, ans;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16931_겉넓이구하기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]!=0) {
					ans++;
				}
			}
		}
		ans<<=1;
		for(int i=0; i<N; i++) {
			ans+=arr[i][0];
			ans+=arr[i][M-1];
			for(int j=0; j<M-1; j++) {
				ans+=Math.abs(arr[i][j]-arr[i][j+1]);
			}
		}
		for(int i=0; i<M; i++) {
			ans+=arr[0][i];
			ans+=arr[N-1][i];
			for(int j=0; j<N-1; j++) {
				ans+=Math.abs(arr[j][i]-arr[j+1][i]);
			}
		}
		System.out.println(ans);
	}
}
