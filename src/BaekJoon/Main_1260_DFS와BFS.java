//
//문제
// 
//그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
//
//단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
//
//정점 번호는 1번부터 N번까지이다.
//
//입력
// 
//첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
//
//다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
//
//입력으로 주어지는 간선은 양방향이다.
//
//출력
// 
//첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. 
//
//V부터 방문된 점을 순서대로 출력하면 된다.


package BaekJoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_1260_DFS와BFS {
	static int N,M,V;
	static int[][] arr;
	static boolean[] v;
	static LinkedList<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		arr = new int[N+1][N+1];
		v = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		
		dfs(V);
		Arrays.fill(v, false);
		System.out.println();
		bfs(V);
		
		sc.close();
	}
	
	public static void dfs(int n) {
		v[n] = true;
		System.out.print(n+" ");
		
		for(int i=1; i<=N; i++) {
			if(arr[n][i]==1 && v[i]==false) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int n) {
		queue.offer(n);
		v[n] = true;
		System.out.print(n+" ");
		
		int temp;
		while(!queue.isEmpty()){
			temp = queue.poll();
			for(int j=0; j<N+1; j++){
				if(arr[temp][j]==1&&v[j]==false){
					queue.offer(j);
					v[j]=true;
					System.out.print(j+" ");
				}
			}                       
		}
	}
}


