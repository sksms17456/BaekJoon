package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	static int N, M, x, y, K, dir;
	static int[] val;
	static int[][] map, pos= {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_14499_주사위굴리기.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		val = new int[6];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check(x,y);
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			dir = Integer.parseInt(st.nextToken());
			switch (dir) {
			case 1:
				int nr = x+pos[dir][0];
				int nc = y+pos[dir][1];
				if(!isOk(nr,nc)) break;
				x=nr;
				y=nc;
				int temp = val[0];
				val[0] = val[3];
				val[3] = val[5];
				val[5] = val[2];
				val[2] = temp;
				check(x,y);
				System.out.println(val[0]);
				break;
			case 2:
				nr = x+pos[dir][0];
				nc = y+pos[dir][1];
				if(!isOk(nr,nc)) break;
				x=nr;
				y=nc;
				temp = val[0];
				val[0] = val[2];
				val[2] = val[5];
				val[5] = val[3];
				val[3] = temp;
				check(x,y);
				System.out.println(val[0]);
				break;
			case 3:
				nr = x+pos[dir][0];
				nc = y+pos[dir][1];
				if(!isOk(nr,nc)) break;
				x=nr;
				y=nc;
				temp = val[0];
				val[0] = val[4];
				val[4] = val[5];
				val[5] = val[1];
				val[1] = temp;
				check(x,y);
				System.out.println(val[0]);
				break;
			case 4:
				nr = x+pos[dir][0];
				nc = y+pos[dir][1];
				if(!isOk(nr,nc)) break;
				x=nr;
				y=nc;
				temp = val[0];
				val[0] = val[1];
				val[1] = val[5];
				val[5] = val[4];
				val[4] = temp;
				check(x,y);
				System.out.println(val[0]);
				break;
			}
		}
		System.out.println();
	}
	private static boolean isOk(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M) ? true:false;
	}
	private static void check(int r, int c) {
		if(map[r][c]==0) {
			map[r][c] = val[5];
		}else {
			val[5] = map[r][c];
			map[r][c] = 0;
		}
	}
}
