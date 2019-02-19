//문제
// 
//적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 
//
//따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.
//
//크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 
//
//그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
//
//예를 들어, 그림이 아래와 같은 경우에
//RRRBB
//GGBBB
//BBBRR
//BBRRR
//RRRRR
//
//적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
//
//그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
//
//입력
// 
//첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
//
//둘째 줄부터 N개 줄에는 그림이 주어진다.
//
//출력
// 
//적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.

package BaekJoon;

import java.io.*;
import java.util.Arrays;

public class Main_10026_적록색약 {
	static int N, normalcnt = 0, redgreencnt = 0;
	static char[][] Color;
	static char[] input;
	static boolean[][] v;
	static int[] px = {-1,1,0,0};
	static int[] py = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Main_10026_적록색약.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Color = new char[N][N];
		v = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			input = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				Color[i][j] = input[j];
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(v[i][j]==false) {
					normaldfs(i,j);
					normalcnt++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			Arrays.fill(v[i], false);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(v[i][j]==false) {
					redgreendfs(i,j);
					redgreencnt++;
				}
			}
		}
		System.out.print(normalcnt+ " "+ redgreencnt);
		
	}
	public static void normaldfs(int x, int y) {
		v[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+px[i];
			int ny = y+py[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N && Color[nx][ny]==Color[x][y] && v[nx][ny]==false) {
				normaldfs(nx,ny);
			}
		}
	}
	public static void redgreendfs(int x, int y) {
		v[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+px[i];
			int ny = y+py[i];
			
			if(Color[x][y]=='R' || Color[x][y]=='G') {
				if(nx>=0 && ny>=0 && nx<N && ny<N && Color[nx][ny]!='B' && v[nx][ny]==false) {
					redgreendfs(nx,ny);
				}
			}
			else {
				if(nx>=0 && ny>=0 && nx<N && ny<N && Color[nx][ny]==Color[x][y] && v[nx][ny]==false) {
					redgreendfs(nx,ny);
				}
			}	
		}
	}
}
