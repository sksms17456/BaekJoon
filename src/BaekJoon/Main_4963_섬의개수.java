//문제 
//
//정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.
//
//한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 
//
//두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 지도는 바다로 둘러쌓여 있으며, 지도 밖으로 나갈 수 없다.
//
//입력 
//
//입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.
//
//둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
//
//입력의 마지막 줄에는 0이 두 개 주어진다.
//
//출력 
//
//각 테스트 케이스에 대해서, 섬의 개수를 출력한다.
package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	static int w, h, cnt, nr, nc;
	static int[][] Ground;
	static int[][] pos = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_4963_섬의개수.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0)
				break;
			
			Ground = new int[h][w];
			visit = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					Ground[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cnt=0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!visit[i][j] && Ground[i][j]==1) {
						island(i,j);
						cnt++;
					}
					
				}
			}
			System.out.println(cnt);
			
		}	
	}
	private static void island(int r, int c) {
		visit[r][c] = true;
		
		for(int i=0; i<pos.length; i++) {
			nr = r+pos[i][0];
			nc = c+pos[i][1];
			
			if(isOk(nr,nc)) {
				if(!visit[nr][nc] && Ground[nr][nc]==1) {
					island(nr,nc);
				}
			}
		}
	}
	private static boolean isOk(int x, int y) {
		if(x>=0 && y>=0 && x<h && y<w)
			return true;
		return false;
	}
}

