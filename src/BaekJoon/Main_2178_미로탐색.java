//문제 
//
//N×M크기의 배열로 표현되는 미로가 있다.
//
//미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
//
//이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
//
//한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
//
//위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
//
//입력 
//
//첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 
//
//각각의 수들은 붙어서 입력으로 주어진다.
//
//출력 
//
//첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Main_2178_미로탐색 {
	static int N, M, cnt, nr, nc, min=Integer.MAX_VALUE;
	static int[][] arr;
	static int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2178_미로탐색.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				arr[i][j] = line[j]-'0';
			}
		}
		
		bfs(0,0);
		System.out.println(arr[N-1][M-1]);
	}
	
	private static void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		arr[r][c] = 1;
		queue.offer(new int[] {r,c});
		int dist;
		int[] cur;
		
		L:
		while(!queue.isEmpty()) {
			cur = queue.poll();
			r = cur[0];
			c = cur[1];
			dist = arr[r][c];
			for(int i=0; i<4; i++) {
				nr = r+pos[i][0];
				nc = c+pos[i][1];
				if(nr>=0 && nr<N && nc>=0 && nc<M && arr[nr][nc]==1) {
					arr[nr][nc] = dist+1;
					if(nr==N-1 && nc==M-1) {
						break L;
					}
					queue.offer(new int[] {nr,nc});
				}
			}
		}
	}
}
