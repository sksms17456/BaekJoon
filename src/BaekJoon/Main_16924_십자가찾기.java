//문제
//
//십자가는 가운데에 '*'가 있고, 상하좌우 방향으로 모두 같은 길이의 '*'가 있는 모양이다.
//
//십자가의 크기는 가운데를 중심으로 상하좌우 방향으로 있는 '*'의 개수이다. 십자가의 크기는 1보다 크거나 같아야 한다.
//
//아래 그림은 크기가 1, 2, 3인 십자가이고, 빈 칸은 '.'이다.
//
//              ...*...
//      ..*..   ...*...
//.*.   ..*..   ...*...
//***   *****   *******
//.*.   ..*..   ...*...
//      ..*..   ...*...
//              ...*...
//크기가 N×M이고, '.'과 '*'로 이루어진 격자판이 주어진다. 이때, 십자가만을 이용해서 격자판과 같은 모양을 만들 수 있는지 구해보자. 
//
//십자가는 서로 겹쳐도 된다. 사용할 수 있는 십자가의 개수는 N×M이하이어야 한다. 격자판의 행은 위에서부터 1번, 열은 왼쪽에서부터 1번으로 번호가 매겨져 있다.
//
//입력
//
//첫째 줄에 격자판의 크기 N, M (3 ≤ N, M ≤ 100)이 주어진다. 둘째 줄부터 N개의 줄에 격자판의 상태가 주어진다.
//
//출력
//
//십자가만 이용해서 입력으로 주어진 격자판을 만들 수 없으면 -1을 출력한다.
//
//만들 수 있는 경우에는 필요한 십자가의 수 k(0 ≤ k ≤ N×M)를 출력한다. 다음 k개의 줄에는 그려야 하는 십자가의 정보 x, y, s를 한 줄에 하나씩 출력한다. 
//
//x는 십자가 중심의 행의 번호, y는 열의 번호, s는 십자가의 크기이다.
//
//가능한 답이 여러가지인 경우에는 아무거나 출력한다.
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16924_십자가찾기 {
	static class Cross{
		int r;
		int c;
		public Cross(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int N, M, star;
	static char[][] map;
	static boolean[][] visit;
	static int[][] pos = {{-1,0},{1,0},{0,1},{0,-1}};
	static ArrayList<int[]> ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16924_십자가찾기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M];
		ArrayList<Cross> list = new ArrayList<>();
		ans = new ArrayList<int[]>();
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(map[i][j]=='*') {
					list.add(new Cross(i,j));
					star++;
				}
			}
		}		
		for(int i=0; i<list.size(); i++) {
			Cross c = list.get(i);
			find(c.r,c.c);
		}
		if(star>0) {
			System.out.println(-1);
		}else {
			System.out.println(ans.size());
			for(int i=0; i<ans.size(); i++) {
				int[] temp = ans.get(i);
				System.out.println(temp[0]+" "+temp[1]+" "+temp[2]);
			}
		}
	}
	private static void find(int r, int c) {
		int cnt=1;
		top:
		while(true) {
			for(int i=0; i<4; i++) {
				int nr = r+pos[i][0]*cnt;
				int nc = c+pos[i][1]*cnt;
				if(!isOk(nr,nc)) {
					break top;
				}		
			}
			ans.add(new int[] {r+1,c+1,cnt});
			if(!visit[r][c] ){
				visit[r][c] = true;
				star--;
			}
			for(int i=0; i<4; i++) {
				int nr = r+pos[i][0]*cnt;
				int nc = c+pos[i][1]*cnt;
				if(!visit[nr][nc]) {
					visit[nr][nc] = true;
					star--;
				}		
			}
			cnt++;
		}
	}
	private static boolean isOk(int r, int c) {
		if(r>=0 && c>=0 && r<N && c<M && map[r][c]=='*') {
			return true;
		}
		return false;
	}
}
