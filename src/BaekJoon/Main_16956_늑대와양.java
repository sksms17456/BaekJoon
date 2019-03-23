//문제
//
//크기가 R×C인 목장이 있고, 목장은 1×1 크기의 칸으로 나누어져 있다. 각각의 칸에는 비어있거나, 양 또는 늑대가 있다. 
//
//양은 이동하지 않고 위치를 지키고 있고, 늑대는 인접한 칸을 자유롭게 이동할 수 있다. 두 칸이 인접하다는 것은 두 칸이 변을 공유하는 경우이다.
//
//목장에 울타리를 설치해 늑대가 양이 있는 칸으로 갈 수 없게 하려고 한다. 늑대는 울타리가 있는 칸으로는 이동할 수 없다. 울타리를 설치해보자.
//
//입력
//
//첫째 줄에 목장의 크기 R, C가 주어진다.
//
//둘째 줄부터 R개의 줄에 목장의 상태가 주어진다. '.'는 빈 칸, 'S'는 양, 'W'는 늑대이다.
//
//출력
//
//늑대가 양이 있는 칸으로 갈 수 없게 할 수 있다면 첫째 줄에 1을 출력하고, 둘째 줄부터 R개의 줄에 목장의 상태를 출력한다. 
//
//울타리는 'D'로 출력한다. 울타리를 어떻게 설치해도 늑대가 양이 있는 칸으로 갈 수 있다면 첫째 줄에 0을 출력한다.

package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16956_늑대와양 {
	static int R, C;
	static int[][] pos = {{-1,0},{1,0},{0,1},{0,-1}};
	static char[][] pasture;
	static String line;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16956_늑대와양.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pasture = new char[R][C];
		for(int i=0; i<R; i++) {
			Arrays.fill(pasture[i], '.');
		}
		for(int i=0; i<R; i++) {
			line = br.readLine();
			for(int j=0; j<C; j++) {
				if(pasture[i][j]=='.') {
					pasture[i][j]=line.charAt(j);
				}
			}
			for(int j=0; j<C; j++) {
				if(pasture[i][j]=='W') {
					for(int k=0; k<4; k++) {
						int nr = i+pos[k][0];
						int nc = j+pos[k][1];
						if(nr>=0 && nc>=0 && nr<R && nc<C) {
							if(pasture[nr][nc]=='S') {
								System.out.println(0);
								System.exit(0);
							}else if(pasture[nr][nc]=='.') {
								pasture[nr][nc]='D';
							}
						}
					}
				}
			}
		}
		System.out.println(1);
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(pasture[i][j]);
			}
			System.out.println();
		}
	}
}
