//문제
//
//체스판 위에 한 나이트가 놓여져 있다. 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 
//
//나이트가 이동하려고 하는 칸이 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?
//
//입력
//
//입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.
//
//각 테스트 케이스는 세 줄로 이루어져 있다. 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다.
//
//크기는 l × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 
//
//둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.
//
//출력
//
//각 테스트 케이스마다 나이트가 몇 번만에 이동할 수 있는지 출력한다.
package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_7652_나이트의이동 {
	static int T, I, er, ec;
	static int[][] pos = {{2,-1},{2,1},{1,-2},{1,2},{-1,2},{-1,-2},{-2,1},{-2,-1}};
	static LinkedList<int[]> queue;
	static int[][] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_7652_나이트의이동.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			queue=  new LinkedList<int[]>();
			I = Integer.parseInt(br.readLine());
			v = new int[I][I];
			st = new StringTokenizer(br.readLine());
			queue.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0});
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			top:
			while(!queue.isEmpty()) {
				int size = queue.size();
				for(int j=0; j<size; j++) {
					int temp[] = queue.poll();
					if(temp[0]==er && temp[1]==ec) {
						sb.append(temp[2]).append("\n");
						break top;
					}
					for(int i=0; i<8; i++) {
						int nr = temp[0]+pos[i][0];
						int nc = temp[1]+pos[i][1];
						if(nr>=0 && nc>=0 && nr<I && nc<I && v[nr][nc]==0) {
							v[nr][nc] = 1;
							queue.offer(new int[] {nr,nc,temp[2]+1});
						}
					}
				}
				for(int i=0; i<I; i++) {
					Arrays.fill(v[i], 0);
				}
			}
		}
		System.out.println(sb);
	}
}
