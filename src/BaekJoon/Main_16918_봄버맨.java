//문제
//
//봄버맨은 크기가 R×C인 직사각형 격자판 위에서 살고 있다. 격자의 각 칸은 비어있거나 폭탄이 들어있다.
//
//폭탄이 있는 칸은 3초가 지난 후에 폭발하고, 폭탄이 폭발한 이후에는 폭탄이 있던 칸이 파괴되어 빈 칸이 되며, 인접한 네 칸도 함께 파괴된다. 
//
//즉, 폭탄이 있던 칸이 (i, j)인 경우에 (i+1, j), (i-1, j), (i, j+1), (i, j-1)도 함께 파괴된다. 
//
//만약, 폭탄이 폭발했을 때, 인접한 칸에 폭탄이 있는 경우에는 인접한 폭탄은 폭발 없이 파괴된다. 따라서, 연쇄 반응은 없다.
//
//봄버맨은 폭탄에 면역력을 가지고 있어서, 격자판의 모든 칸을 자유롭게 이동할 수 있다. 봄버맨은 다음과 같이 행동한다.
//
//가장 처음에 봄버맨은 일부 칸에 폭탄을 설치해 놓는다. 모든 폭탄이 설치된 시간은 같다.
//
//다음 1초 동안 봄버맨은 아무것도 하지 않는다.
//
//다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다. 즉, 모든 칸은 폭탄을 가지고 있게 된다. 폭탄은 모두 동시에 설치했다고 가정한다.
//
//1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다.
//
//3과 4를 반복한다.
//
//폭탄을 설치해놓은 초기 상태가 주어졌을 때, N초가 흐른 후의 격자판 상태를 구하려고 한다.
//
//예를 들어, 초기 상태가 아래와 같은 경우를 보자.
//
//...
//.O.
//...
//1초가 지난 후에는 아무 일도 벌어지지 않기 때문에, 위와 같다고 볼 수 있다. 1초가 더 흐른 후에 격자판의 상태는 아래와 같아진다.
//
//OOO
//OOO
//OOO
//1초가 지난 후엔 가운데에 있는 폭탄이 폭발해 가운데 칸과 인접한 네 칸이 빈 칸이 된다.
//
//O.O
//...
//O.O
//입력
//첫째 줄에 R, C, N (1 ≤ R, C, N ≤ 200)이 주어진다. 둘째 줄부터 R개의 줄에 격자판의 초기 상태가 주어진다. 빈 칸은 '.'로, 폭탄은 'O'로 주어진다.
//
//출력
//총 R개의 줄에 N초가 지난 후의 격자판 상태를 출력한다.
package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16918_봄버맨 {
	static class Bomb{
		int r;
		int c;
		public Bomb(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int R, C, N, cnt=2;
	static char[][] bomb;
	static int[][] pos = {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16918_봄버맨.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		bomb = new char[R][C];
		
		LinkedList<Bomb> bqueue = new LinkedList<>();
		LinkedList<Bomb> queue = new LinkedList<>();

		for(int i=0; i<R; i++) {
			bomb[i] = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				if(bomb[i][j]=='.') {
					queue.offer(new Bomb(i,j));
				}
				else {
					bqueue.offer(new Bomb(i,j));
				}
			}
		}
		int qsize = queue.size();
		int bqsize = bqueue.size();
		while(cnt<N) {
			for(int i=0; i<qsize; i++) {
				Bomb b = queue.poll();
				bomb[b.r][b.c] = 'O';
				bqueue.offer(new Bomb(b.r,b.c));
			}
			
			for(int i=0; i<bqsize; i++) {
				Bomb b = bqueue.poll();
				bomb[b.r][b.c] = '.';
				queue.offer(new Bomb(b.r,b.c));
				for(int k=0; k<4; k++) {
					int nr = b.r+pos[k][0];
					int nc = b.c+pos[k][1];
					if(isOk(nr,nc)) {
						bomb[nr][nc] = '.';
						queue.offer(new Bomb(b.r,b.c));
					}
				}
			}
			
			cnt++;
		}
		
		
	}
	
	private static boolean isOk(int x, int y) {
		if(x>=0 && y>=0 && x<R && y<C) {
			return true;
		}
		return false;
	}
}
