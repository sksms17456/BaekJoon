//
//문제
//두 마리의 백조가 호수에서 살고 있었다. 그렇지만 두 마리는 호수를 덮고 있는 빙판으로 만나지 못한다.
//
//호수는 가로로 R, 세로로 C만큼의 직사각형 모양이다. 어떤 칸은 얼음으로 덮여있다.
//
//호수는 차례로 녹는데, 매일 물 공간과 접촉한 모든 빙판 공간은 녹는다. 두 개의 공간이 접촉하려면 가로나 세로로 닿아 있는 것만 (대각선은 고려하지 않는다) 생각한다.
//
//아래에는 세 가지 예가 있다.
//
//...XXXXXX..XX.XXX ....XXXX.......XX .....XX.......... 
//....XXXXXXXXX.XXX .....XXXX..X..... ......X.......... 
//...XXXXXXXXXXXX.. ....XXX..XXXX.... .....X.....X..... 
//..XXXXX..XXXXXX.. ...XXX....XXXX... ....X......XX.... 
//.XXXXXX..XXXXXX.. ..XXXX....XXXX... ...XX......XX.... 
//XXXXXXX...XXXX... ..XXXX.....XX.... ....X............ 
//..XXXXX...XXX.... ....XX.....X..... ................. 
//....XXXXX.XXX.... .....XX....X..... ................. 
//in the beginning   after first day   after second day 
//백조는 오직 물 공간에서 세로나 가로로만(대각선은 제외한다) 움직일 수 있다.
//
//며칠이 지나야 백조들이 만날 수 있는 지 계산하는 프로그램을 작성한다.
//
//입력
//입력의 첫째 줄에는 R과 C가 주어진다. 단, 1 ≤ R, C ≤ 1500.
//
//각 R줄 동안 C만큼의 문자열이 주어진다.
//
//'.'은 물 공간, 'X'는 빙판 공간, 'L'은 백조가 있는 공간으로 나타낸다.
//
//출력
//첫째 줄에 문제에서 주어진 걸리는 날을 출력한다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_3197_백조의호수 {
	static int R, C, day=1;
	static int[][] meltingDay, pos = {{-1,0},{1,0},{0,-1},{0,1}};
	static char[][] lake;
	static ArrayList<int[]> swan = new ArrayList<>();
	static LinkedList<int[]> ice = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_3197_백조의호수.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		lake = new char[R][C];
		meltingDay = new int[R][C];
		for(int i=0; i<R; i++) {
			lake[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(lake[i][j]=='.') {
					melting(i,j);
				}else if(lake[i][j]=='L') {
					swan.add(new int[] {i,j});
				}
			}
		}
		while(true) {
			day++;
			int size = ice.size();
			for(int i=0; i<size; i++) {
				int[] temp = ice.poll();
				for(int j=0; j<4; j++) {
					int nr = temp[0]+pos[j][0];
					int nc = temp[1]+pos[j][1];
					if(isOk(nr,nc) && meltingDay[nr][nc]==0) {
						meltingDay[nr][nc] = day;
						ice.offer(new int[] {nr,nc});
					}
				}
			}
			for(int i=0; i<R; i++) {
				System.out.println(Arrays.toString(meltingDay[i]));
			}
			System.out.println();
			if(ice.isEmpty()) break;
		}
		
		day = 1;
		for(int i=0; i<2; i++) {
			LinkedList<int[]> swanQ = new LinkedList<>();
			swanQ.offer(new int[] {swan.get(i)[0], swan.get(i)[1]});
			while(!swanQ.isEmpty()) {
				int[] temp = swanQ.poll();
				for(int j=0; j<4; j++) {
					int nr = temp[0] + pos[j][0];
					int nc = temp[1] + pos[j][1];
					if(isOk(nr,nc)) {
						if(meltingDay[nr][nc]==day) {
							meltingDay[nr][nc] = 0;
							swanQ.offer(new int[] {nr,nc});
						}else if(meltingDay[nr][nc] == day+1) {
							ice.offer(new int[] {nr,nc});
						}
					}
				}
			}
		}
	}
	
	static void melting(int r, int c) {
		LinkedList<int[]> meltingArea = new LinkedList<>();
		meltingDay[r][c] = day;
		meltingArea.offer(new int[] {r,c});
		while(!meltingArea.isEmpty()) {
			int[] temp = meltingArea.poll();
			for(int i=0; i<4; i++) {
				int nr = temp[0]+pos[i][0];
				int nc = temp[1]+pos[i][1];
				if(isOk(nr,nc) && meltingDay[nr][nc]==0) {
					if(lake[nr][nc]=='X') {
						meltingDay[nr][nc] = day;
						ice.offer(new int[] {nr,nc});
					}else {
						meltingDay[nr][nc] = day;
						meltingArea.offer(new int[] {nr,nc});
					}
				}
			}
		}
	}
	
	static boolean isOk(int r, int c) {
		return (r>=0 && r<R && c<C && c>=0) ? true:false;
	}
	
}
