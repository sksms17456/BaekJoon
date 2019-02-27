//문제
//
//보물섬 지도를 발견한 후크 선장은 보물을 찾아나섰다. 
//
//보물섬 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 각 칸은 육지(L)나 바다(W)로 표시되어 있다. 
//
//이 지도에서 이동은 상하좌우로 이웃한 육지로만 가능하며, 한 칸 이동하는데 한 시간이 걸린다. 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다. 
//
//육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안된다.
//
//예를 들어 위와 같이 지도가 주어졌다면 보물은 아래 표시된 두 곳에 묻혀 있게 되고, 이 둘 사이의 최단 거리로 이동하는 시간은 8시간이 된다.
//
//보물 지도가 주어질 때, 보물이 묻혀 있는 두 곳 간의 최단 거리로 이동하는 시간을 구하는 프로그램을 작성하시오.
//
//입력
//
//첫째 줄에는 보물 지도의 세로의 크기와 가로의 크기가 빈칸을 사이에 두고 주어진다. 
//
//이어 L과 W로 표시된 보물 지도가 아래의 예와 같이 주어지며, 각 문자 사이에는 빈 칸이 없다. 보물 지도의 가로, 세로의 크기는 각각 50이하이다.
//
//출력
//
//첫째 줄에 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 출력한다.

package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Main_2589_보물섬 {
	static int R, C, max=Integer.MIN_VALUE, cnt;
	static int[][] pos = {{-1,0},{1,0},{0,1},{0,-1}};
	static char[][] island;
	static boolean[][] check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2589_보물섬.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		island = new char[R][C];
		check = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			island[i] = br.readLine().toCharArray();
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(island[i][j]=='L') {
					bfs(i,j);
				}
				for(int k=0; k<R; k++) {
					Arrays.fill(check[k], false);
				}
			}
		}
		System.out.println(max);
	}
	private static void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c,0});
		while(!queue.isEmpty()) {
			int[] n = queue.poll();
			cnt = n[2];		
			
			for(int i=0; i<4; i++) {
				int nr = n[0]+pos[i][0];
				int nc = n[1]+pos[i][1];
				if(isOk(nr,nc)) {
					queue.offer(new int[] {nr,nc,n[2]+1});
					check[nr][nc] = true;
				}
			}
			
		}
		max = Math.max(max, cnt);
	}
	private static boolean isOk(int x, int y) {
		if(x>=0 && y>=0 && x<R && y<C && island[x][y]=='L' && !check[x][y]) {
			return true;
		}
		return false;
	}
}
