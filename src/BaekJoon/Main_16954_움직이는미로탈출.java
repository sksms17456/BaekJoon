//문제 
//
//욱제는 학교 숙제로 크기가 8×8인 체스판에서 탈출하는 게임을 만들었다. 
//
//체스판의 모든 칸은 빈 칸 또는 벽 중 하나이다. 욱제의 캐릭터는 가장 왼쪽 아랫 칸에 있고, 이 캐릭터는 가장 오른쪽 윗 칸으로 이동해야 한다.
//
//이 게임의 특징은 벽이 움직인다는 점이다. 1초마다 모든 벽이 아래에 있는 행으로 한 칸씩 내려가고, 가장 아래에 있어서 아래에 행이 없다면 벽이 사라지게 된다. 
//
//욱제의 캐릭터는 1초에 인접한 한 칸 또는 대각선 방향으로 인접한 한 칸으로 이동하거나, 현재 위치에 서 있을 수 있다. 이동할 때는 빈 칸으로만 이동할 수 있다.
//
//1초 동안 욱제의 캐릭터가 먼저 이동하고, 그 다음 벽이 이동한다. 벽이 캐릭터가 있는 칸으로 이동하면 더 이상 캐릭터는 이동할 수 없다.
//
//욱제의 캐릭터가 가장 오른쪽 윗 칸으로 이동할 수 있는지 없는지 구해보자.
//
//입력 
//
//8개 줄에 걸쳐서 체스판의 상태가 주어진다. '.'은 빈 칸, '#'는 벽이다.
//
//출력 
//
//욱제의 캐릭터가 가장 오른쪽 윗 칸에 도착할 수 있으면 1, 없으면 0을 출력한다.
package BaekJoon;

import java.io.*;
import java.util.LinkedList;

public class Main_16954_움직이는미로탈출 {
	static char[][] map = new char[8][8];
	static int[][] pos= {{0,0},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
	static boolean isWin;
	static int cnt;
	static boolean[][] visit = new boolean[8][8];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16954_움직이는미로탈출.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<8; i++) {
			map[i] = br.readLine().toCharArray();
		}
		LinkedList<int[]> q = new LinkedList<>();
		q.offer(new int[] {7,0});
		
		while(cnt<7) {
			int size = q.size();
			for(int k=0; k<size; k++) {
				int[] temp = q.poll();
				for(int i=0; i<9; i++) {
					int nr = temp[0]+pos[i][0];
					int nc = temp[1]+pos[i][1];
					if(isOk(nr,nc)) {
						q.offer(new int[] {nr,nc});		
					}
				}
			}
			
			for(int i=6; i>=0; i--) {
				for(int j=0; j<8; j++) {
					map[i+1][j] = map[i][j];
				}
			}
			size = q.size();
			for(int i=0; i<size; i++) {
				int[] temp = q.poll();
				if(map[temp[0]][temp[1]]=='.') {
					q.offer(new int[] {temp[0],temp[1]});
				}
			}
			if(q.isEmpty()) {
				isWin=true;
				break;
			}
			cnt++;
		}
		if(!isWin) {
			System.out.println(1);
		}else
			System.out.println(0);
		
	}
	private static boolean isOk(int r, int c) {
		if(r>=0 && c>=0 && r<8 && c<8 && map[r][c]=='.') {
			return true;
		}
		return false;
	}
}
