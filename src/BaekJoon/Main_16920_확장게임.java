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
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16920_확장게임 {
	static int N, M, P, turn=1;
	static int[] S ,q;
	static int[][] pos = {{0,-1},{0,1},{1,0},{-1,0}};
	static char[][] map;
	static boolean[] qempty;
	static boolean[][] visit;
	static LinkedList<int[]>[] queue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16920_확장게임.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
			
		q = new int[P+1];
		S = new int[P+1];
		queue = new LinkedList[P+1];
		qempty = new boolean[P+1];
		visit = new boolean[N][M];
		map = new char[N][M];
			
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=P; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}	
		
		for(int i=0; i<queue.length; i++) {
			queue[i] = new LinkedList<>();
		}		
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(Character.isDigit(map[i][j])) {
					queue[map[i][j]-'0'].offer(new int[] {i,j});
					q[map[i][j]-'0']++;
				}
			}
		}	
		
		while(true) {
			boolean isBreak = true;
			if(turn>P) {
				turn=1;
			}			
			if(!qempty[turn]) {
				extend();
			}
			
			if(queue[turn].size()==0) {
				qempty[turn] = true;
			}
			for(int i=1; i<=P; i++) {
				if(!qempty[i]) {
					isBreak = false;
					break;
				}
			}
			if(isBreak) {
				break;
			}
			turn++;
		}
		
		
		for(int i=1; i<=P; i++) {
			System.out.print(q[i]+" ");
		}
	}
	
	private static void extend() {
		LinkedList<int[]> list = new LinkedList<>();
		while(!queue[turn].isEmpty()){
			int temp[] = queue[turn].poll();
			visit[temp[0]][temp[1]]=true;
			list.offer(new int[] {temp[0],temp[1],0});
		}
		while(!list.isEmpty()) {
			int temp[] = list.poll();
			for(int i=0; i<4; i++) {
				int nr = temp[0]+pos[i][0];
				int nc = temp[1]+pos[i][1];
				if(isOk(nr,nc)&&temp[2]<S[turn]) {
					map[nr][nc] = (char)(turn+'0');
					q[turn]++;
					list.offer(new int[] {nr,nc,temp[2]+1});
					if(!visit[nr][nc]) {
						visit[nr][nc]=true;
						queue[turn].offer(new int[] {nr,nc});
					}
					
				}
			}
		}
	}
	
	private static boolean isOk(int r, int c) {
		if(r>=0 && c>=0 && r<N && c<M && map[r][c]=='.') {
			return true;
		}
		return false;
	}
}
