//문제
//
//2차원 평면상에 n개의 점이 주어졌을 때, 이 점들 중 가장 가까운 두 점을 구하는 프로그램을 작성하시오.
//
//입력
//
//첫째 줄에 자연수 n(2 ≤ n ≤ 100,000)이 주어진다. 다음 n개의 줄에는 차례로 각 점의 x, y좌표가 주어진다. 
//
//각각의 좌표는 절댓값이 10,000을 넘지 않는 정수이다. 같은 점이 여러 번 주어질 수도 있다.
//
//출력
//
//첫째 줄에 가장 가까운 두 점의 거리의 제곱을 출력한다.

package BaekJoon;

import java.io.*;

public class Main_2261_가장가까운두점2 {
	static class Dot{
		int x, y;
		
		public Dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int N, x, y, answer;
	static int minans = Integer.MAX_VALUE;
	static int mx = Integer.MAX_VALUE;
	static int my = Integer.MAX_VALUE;
	static String[] line;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Main_2261_가장가까운두점.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		Dot[] dotarr = new Dot[N];
		
		for(int i=0; i<N; i++) {
			line = br.readLine().split(" ");
			x = Integer.parseInt(line[0]);
			y = Integer.parseInt(line[1]);
			dotarr[i] = new Dot(x,y);
		}
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				x = Math.abs(dotarr[i].x-dotarr[j].x);
				y = Math.abs(dotarr[i].y-dotarr[j].y);
				if(x>=mx && y>=my) {
					continue;
				}
				answer = x*x + y*y;
				if(answer<minans) {
					minans = answer;
					mx = x;
					my = y;
				}
			}
		}
		System.out.println(minans);	
	}
}
