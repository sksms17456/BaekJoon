package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int N, M, ccnt, second=0, last=0;
	static int[][] cheeze;
	static int[][] pos = {{-1,0},{0,-1},{0,1},{1,0}};
	static boolean[][] visit;
	static LinkedList<int[]> queue, cqueue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2636_치즈.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheeze = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0; j<M; j++) {
				cheeze[i][j] = Integer.parseInt(st.nextToken());
				if(cheeze[i][j]==1)
					ccnt++;
			}
		}
		while(ccnt>0) {
			last = ccnt;
			bfs(0,0);
			for(int i=0; i<N; i++) {
				Arrays.fill(visit[i], false);
			}
			if(ccnt>0) {
				last = ccnt;
			}
			second++;
		}
		System.out.println(second+"\n"+last);
	}
	private static void bfs(int r, int c) {
		visit[r][c] = true;
		queue = new LinkedList<>();
		cqueue = new LinkedList<>();
		queue.offer(new int[] {r,c});
		int temp[];
		while(!queue.isEmpty()) {
			temp = queue.poll();
			for(int i=0; i<4; i++) {
				int nr = temp[0]+pos[i][0];
				int nc = temp[1]+pos[i][1];
				if(isOk(nr,nc)) {
					visit[nr][nc] = true;
					if(cheeze[nr][nc]==1) {
						cqueue.offer(new int[] {nr,nc});
					}else {
						queue.offer(new int[] {nr,nc});
					}
				}
			}
		}
		while(!cqueue.isEmpty()) {
			temp = cqueue.poll();
			cheeze[temp[0]][temp[1]]=0;
			ccnt--;
		}
	}
	private static boolean isOk(int r, int c) {
		if(r>=0 && c>=0 && r<N && c<M && !visit[r][c]) {
			return true;
		}
		return false;
	}
}