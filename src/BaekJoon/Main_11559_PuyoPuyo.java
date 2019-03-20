//문제
//뿌요뿌요의 룰은 다음과 같다.
//
//필드에 여러 가지 색깔의 뿌요를 놓는다. 뿌요는 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다.
//
//뿌요를 놓고 난 후, 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다.
//
//뿌요들이 없어지고 나서 위에 다른 뿌요들이 있다면, 역시 중력의 영향을 받아 차례대로 아래로 떨어지게 된다.
//
//아래로 떨어지고 나서 다시 같은 색의 뿌요들이 4개 이상 모이게 되면 또 터지게 되는데, 터진 후 뿌요들이 내려오고 다시 터짐을 반복할 때마다 1연쇄씩 늘어난다.
//
//터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고 여러 그룹이 터지더라도 한번의 연쇄가 추가된다.
//
//남규는 최근 뿌요뿌요 게임에 푹 빠졌다. 이 게임은 1:1로 붙는 대전게임이라 잘 쌓는 것도 중요하지만, 상대방이 터뜨린다면 연쇄가 몇 번이 될지 바로 파악할 수 있는 능력도 필요하다. 
//
//하지만 아직 실력이 부족하여 남규는 자기 필드에만 신경 쓰기 바쁘다. 상대방의 필드가 주어졌을 때, 연쇄가 몇 번 연속으로 일어날지 계산하여 남규를 도와주자!
//
//입력
//
//12*6의 문자가 주어진다.
//
//이때 .은 빈공간이고 .이 아닌것은 각각의 색깔의 뿌요를 나타낸다.
//
//R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.(모두 대문자로 주어진다.)
//
//입력으로 주어지는 필드는 뿌요들이 전부 아래로 떨어진 뒤의 상태(즉 뿌요 아래에 빈 칸이 있는 경우는 없음) 이다.
//
//출력
//
//현재 주어진 상황에서 몇연쇄가 되는지 출력하라. (하나도 터지지 않는다면 0을 출력하면 된다.)
package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main_11559_PuyoPuyo {
	static class puyo{
		int r;
		int c;
		int color;
		public puyo(int r, int c, int color) {
			super();
			this.r = r;
			this.c = c;
			this.color = color;
		}
		
	}
	static int cnt, ans;
	static char[][] map = new char[12][6];
	static boolean[][] visit = new boolean[12][6];
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean canBreak;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_11559_PuyoPuyo.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		while(true) {
			canBreak = false;
			
			LinkedList<puyo> queue = new LinkedList<>();
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					switch (map[i][j]) {
					case 'R':
						queue.offer(new puyo(i,j,17));
						break;
					case 'G':
						queue.offer(new puyo(i,j,6));
						break;
					case 'B':
						queue.offer(new puyo(i,j,1));
						break;
					case 'P':
						queue.offer(new puyo(i,j,15));
						break;
					case 'Y':
						queue.offer(new puyo(i,j,24));
						break;
					}
				}
			}
			
			while(!queue.isEmpty()) {
				puyo p = queue.poll();
				LinkedList<puyo> bfsq = new LinkedList<>();
				visit[p.r][p.c]= true;
				int cnt=1;
				bfsq.offer(new puyo(p.r,p.c,p.color));
				while(!bfsq.isEmpty()) {
					puyo bfsp = bfsq.poll();
					for(int i=0; i<4; i++) {
						int nr = bfsp.r + pos[i][0];
						int nc = bfsp.c + pos[i][1];
						if(isOk(nr,nc) && !visit[nr][nc] && map[nr][nc]-'A'==bfsp.color) {
							visit[nr][nc] = true;
							bfsq.offer(new puyo(nr,nc,bfsp.color));
							cnt++;
						}
					}
				}
				if(cnt>=4) {
					if(!canBreak) {
						ans++;
						canBreak = true;
					}
					bfsq.offer(new puyo(p.r,p.c,p.color));
					while(!bfsq.isEmpty()) {
						puyo bfsp = bfsq.poll();
						for(int i=0; i<4; i++) {
							int nr = bfsp.r + pos[i][0];
							int nc = bfsp.c + pos[i][1];
							if(isOk(nr,nc) && visit[nr][nc] && map[nr][nc]-'A'==bfsp.color) {
								visit[nr][nc] = false;
								map[nr][nc] = '.';
								bfsq.offer(new puyo(nr,nc,bfsp.color));
							}
						}
					}
				}
			}
			if(!canBreak) {
				break;
			}
			for(int i=0; i<6; i++) {
				int idx=0;
				for(int j=11; j>-1; j--) {
					if(map[j][i]=='.') {
						idx=j;
						break;
					}
				}
				for(int j=idx-1; j>-1; j--) {
					if(Character.isAlphabetic(map[j][i])) {
						map[idx--][i] = map[j][i];
						map[j][i] = '.';
					}
				}
			}
			for(int i=0; i<12; i++) {
				Arrays.fill(visit[i], false);
			}
		}
		System.out.println(ans);
		
	}
	private static boolean isOk(int r, int c) {
		return (r>=0 && c>=0 && r<12 && c<6) ? true:false;
	}
}
