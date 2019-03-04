//문제
//
//구사과와 친구들이 확장 게임을 하려고 한다. 이 게임은 크기가 N×M인 격자판 위에서 진행되며, 각 칸은 비어있거나 막혀있다. 
//
//각 플레이어는 하나 이상의 성을 가지고 있고, 이 성도 격자판 위에 있다. 한 칸 위에 성이 두 개 이상인 경우는 없다.
//
//게임은 라운드로 이루어져 있고, 각 라운드마다 플레이어는 자기 턴이 돌아올 때마다 성을 확장해야 한다. 
//
//제일 먼저 플레이어 1이 확장을 하고, 그 다음 플레이어 2가 확장을 하고, 이런 식으로 라운드가 진행된다.
//
//각 턴이 돌아왔을 때, 플레이어는 자신이 가지고 성을 비어있는 칸으로 확장한다. 플레이어 i는 자신의 성이 있는 곳에서 Si칸 만큼 이동할 수 있는 모든 칸에 성을 동시에 만든다. 
//
//위, 왼쪽, 오른쪽, 아래로 인접한 칸으로만 이동할 수 있으며, 벽이나 다른 플레이어의 성이 있는 곳으로는 이동할 수 없다. 성을 다 건설한 이후엔 다음 플레이어가 턴을 갖는다.
//
//모든 플레이어가 더 이상 확장을 할 수 없을 때 게임이 끝난다. 게임판의 초기 상태가 주어졌을 때, 최종 상태를 구해보자.
//
//입력
//
//첫째 줄에 격자판의 크기 N, M과 플레이어의 수 P가 주어진다. 둘째 줄에는 S1, S2, ...SP가 주어진다.
//
//다음 N개의 줄에는 게임판의 상태가 주어진다. '.'는 빈 칸, '#'는 벽, '1', '2', ..., '9'는 각 플레이어의 성이다.
//
//모든 플레이어는 적어도 하나의 성을 가지고 있으며, 게임에 참가하지 않는 플레이어의 성이 있는 경우는 없다.
//
//출력
//
//플레이어 1이 가진 성의 수, 2가 가진 성의 수, ..., P가 가진 성의 수를 공백으로 구분해 출력한다.
//
//제한
//1 ≤ N, M ≤ 1,000
//1 ≤ P ≤ 9
//1 ≤ Si ≤ 109
package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16920_확장게임 {
	static int N, M, P, idx=1, breakcnt=0;
	static int[] S, p;
	static int[][] pos = {{-1,0},{1,0},{0,1},{0,-1}};
	static char[][] field;
	static boolean[][] visit;
	static LinkedList<int[]>[] queue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16920_확장게임.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		queue = new LinkedList[P+1];
		for(int i=0; i<P+1; i++) {
			queue[i] = new LinkedList<int[]>();
		}
		p = new int[P+1];
		S = new int[P+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<S.length; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		field = new char[N][M];
		visit = new boolean[N][M];
		for(int i=0 ;i<N; i++) {
			field[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(Character.isDigit(field[i][j])) {
					p[field[i][j]-'0']++;
					queue[field[i][j]-'0'].offer(new int[] {i,j});
				}else if(field[i][j]=='.'){
					breakcnt++;
				}
			}
		}
		while(breakcnt>0) {
			if(idx>P)
				idx=1;
			int cnt = queue[idx].size();
			while(cnt>0) {
				int[] temp = queue[idx].poll();
				extend(temp[0],temp[1],0);
				cnt--;
			}
			idx++;			
		}
		for(int i=1; i<P+1; i++) {
			System.out.print(p[i]+" ");
		}
	}
	private static void extend(int r, int c, int cnt) {
		if(cnt==S[idx]) {
			if(field[r][c]=='.') {
				field[r][c]=(char)(idx+'0');
				queue[idx].offer(new int[] {r,c});
				p[idx]++;
				breakcnt--;
			}	
			return;
		}
		for(int i=0; i<4; i++) {
			int nr = r+pos[i][0];
			int nc = c+pos[i][1];
			if(isOk(nr,nc)&&!visit[nr][nc]) {
				extend(nr,nc,cnt+1);
			}			
		}
	}
	private static boolean isOk(int r, int c) {
		if(r>=0 && c>=0 && r<N && c<M && (field[r][c]=='.' || field[r][c]==(char)(idx+'0'))) {
			return true;
		}
		return false;
	}
}
