//문제
// 
//세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.
//
//말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
//
//좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.
//
//입력
// 
//첫째 줄에 R과 C가 빈칸을 사이에 두고 주어진다. (1<=R,C<=20) 둘째 줄부터 R개의 줄에 걸쳐서 보드에 적혀 있는 C개의 대문자 알파벳들이 빈칸 없이 주어진다.
//
//출력
// 
//첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다.

package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_1987_알파벳 {
	static int R, C, max = Integer.MIN_VALUE;;
	static int[] px = {-1,1,0,0};
	static int[] py = {0,0,-1,1};
	static String[] input;
	static char[] chinput;
	static char[][] Board;
	static boolean[][] visit;
	static boolean[] CheckAlpha;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Main_1987_알파벳.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		Board = new char[R][C];
		visit = new boolean[R][C];
		CheckAlpha = new boolean[26];
		
		for(int i=0; i<R; i++) {
			chinput = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				Board[i][j] = chinput[j];
			}
		}
		dfs(0,0,1);
		System.out.println(max);
		
	}
	public static void dfs(int x, int y, int cnt) {
		visit[x][y] = true;
		CheckAlpha[(int)Board[x][y]-'A']=true;
		
		for(int i=0; i<4; i++) {
			int nx = x+px[i];
			int ny = y+py[i];
			
			if(nx>=0 && ny>=0 && nx<R && ny<C && CheckAlpha[(int)Board[nx][ny]-'A']==false) {
				dfs(nx,ny,++cnt);		
				CheckAlpha[(int)Board[nx][ny]-'A']=false;
				cnt--;
			}
			max = Math.max(max, cnt);
			
		}
		
	}
}

