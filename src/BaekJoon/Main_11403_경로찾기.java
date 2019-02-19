//문제
// 
//가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성하시오.
//
//입력
// 
//첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄부터 N개 줄에는 그래프의 인접 행렬이 주어진다. 
//
//i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고, 0인 경우는 없다는 뜻이다. i번째 줄의 i번째 숫자는 항상 0이다.
//
//출력
// 
//총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력한다. 정점 i에서 j로 가는 경로가 있으면 i번째 줄의 j번째 숫자를 1로, 없으면 0으로 출력해야 한다.

package BaekJoon;

import java.io.*;
import java.util.Arrays;

public class Main_11403_경로찾기 {
	static int N;
	static int[][] Graph, Root;
	static boolean[] v;
	static String[] input;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Main_11403_경로찾기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Graph = new int[N][N];
		Root = new int[N][N];
		v = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				Graph[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for(int i=0; i<N; i++) {
			dfs(i);
			for(int j=0; j<N; j++) {
				if(v[j])
					Root[i][j] = 1;
			}
			Arrays.fill(v, false);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(Root[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void dfs(int x) {
		for(int i=0; i<N; i++) {
			if(Graph[x][i]==1 && !v[i]) {
				v[i] = true;
				dfs(i);
			}
		}
	}
}
