//문제
//
//서양 장기인 체스에는 대각선 방향으로 움직일 수 있는 비숍(bishop)이 있다. 
//
//<그림 1>과 같은 정사각형 체스판 위에 B라고 표시된 곳에 비숍이 있을 때 비숍은 대각선 방향으로 움직여 O로 표시된 칸에 있는 다른 말을 잡을 수 있다.
//
//그런데 체스판 위에는 비숍이 놓일 수 없는 곳이 있다. <그림 2>에서 체스판에 색칠된 부분은 비숍이 놓일 수 없다고 하자. 
//
//이와 같은 체스판에 서로가 서로를 잡을 수 없도록 하면서 비숍을 놓는다면 <그림 3>과 같이 최대 7개의 비숍을 놓을 수 있다.  색칠된 부분에는 비숍이 놓일 수 없지만 지나갈 수는 있다.
//
//정사각형 체스판의 한 변에 놓인 칸의 개수를 체스판의 크기라고 한다. 
//
//체스판의 크기와 체스판 각 칸에 비숍을 놓을 수 있는지 없는지에 대한 정보가 주어질 때, 서로가 서로를 잡을 수 없는 위치에 놓을 수 있는 비숍의 최대 개수를 구하는 프로그램을 작성하시오.
//
//입력
//
//첫째 줄에 체스판의 크기가 주어진다. 체스판의 크기는 10이하의 자연수이다.
//
//줄부터 아래의 예와 같이 체스판의 각 칸에 비숍을 놓을 수 있는지 없는지에 대한 정보가 체스판 한 줄 단위로 한 줄씩 주어진다. 
//
//비숍을 놓을 수 있는 곳에는 1, 비숍을 놓을 수 없는 곳에는 0이 빈칸을 사이에 두고 주어진다.
//
//출력
//
//첫째 줄에 주어진 체스판 위에 놓을 수 있는 비숍의 최대 개수를 출력한다.
package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1799_비숍 {
	static int N;
	static int[][] chess;
	static int[][] pos = {{-1,-1},{-1,1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_1799_비숍.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N][N];
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				chess[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(chess[i][j]==1) {
				//	draw();
				}
			}
		}
		
		
	}

}
