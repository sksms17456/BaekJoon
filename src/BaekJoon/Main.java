package BaekJoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main{
	static int T, N, ans;
	static int[][] arr, pos= {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visit;
	static String line;
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			ans=0;
			N = Integer.parseInt(br.readLine());
			arr=  new int[N][N];
			visit = new boolean[N][N];
			for(int i=0; i<N; i++) {
				line = br.readLine();
				for(int j=0; j<N; j++) {
					arr[i][j] = line.charAt(j)-'0';
				}
			}			
			bfs();			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
    }
    private static void bfs() {
		visit[0][0] = true;
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] >= o2[2] ? 1:-1;
			}
			
		});
		queue.offer(new int[] {0,0,0});
		int temp[] = new int[3];
		while(!queue.isEmpty()) {
			temp = queue.poll();
			if(temp[0]==N-1 && temp[1]==N-1)
				break;
			for(int i=0; i<4; i++) {
				int nr = temp[0]+pos[i][0];
				int nc = temp[1]+pos[i][1];
				if(isOk(nr,nc)) {
					visit[nr][nc] = true;
					queue.offer(new int[] {nr,nc,temp[2]+arr[nr][nc]});
				}
			}
		}
		ans=temp[2];
	}
    private static boolean isOk(int r, int c) {
    	return (r>=0 && r<N && c>=0 && c<N && !visit[r][c]) ? true:false;
    }
}