//
//문제
//
//방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 
//
//둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
//
//출력
//
//첫째 줄에 연결 요소의 개수를 출력한다.

package BaekJoon;

import java.util.Scanner;

public class Main_11724_연결요소의갯수 {
	static int N, M, u, v, cnt=0;
	static int[][] arr;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			
			arr[u][v] = arr[v][u] = 1;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visit[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int n) {
		visit[n] = true;
		
		for(int i=1; i<=N; i++) {
			if(arr[n][i]==1 && visit[i]==false) {
				dfs(i);
			}
		}
	}
}
