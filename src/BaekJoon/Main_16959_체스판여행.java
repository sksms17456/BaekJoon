//문제 
//
//크기가 N×N인 체스판이 있고, 체스판의 각 칸에는 1부터 N2까지의 정수가 한 번씩 적혀있다. 지학이는 이 체스판을 이용해서 재미있는 게임을 해보려고 한다.
//
//지학이가 가지고 있는 말은 나이트, 비숍, 룩이다. 가장 먼저 1이 적혀있는 칸에 말 하나를 놓는다. 그 다음, 1, 2, ..., N2 순서로 이동시키려고 한다.
//
//먼저, 1에 나이트, 비숍, 룩 중 하나를 놓는다. 그 다음, 말을 이동시켜서 2가 적힌 칸으로 이동시킨다. 1에서 2로 이동시킬 때, 다른 수가 적힌 칸을 방문할 수도 있다. 
//
//그 다음에는 3이 적힌 칸으로 이동시키고, ..., N2이 적힌 칸으로 이동시킨다. 같은 칸을 여러 번 방문하는 것도 가능하다.
//
//지학이가 1초 동안 할 수 있는 행동은 체스판 위에 놓인 말을 이동시키거나, 다른 말로 바꾸는 것이다.
//
//1에서 출발해서, 2, 3, ..., N2-1을 방문하고, N2까지 도착하는데 걸리는 시간의 최솟값을 구해보자.
//
//입력 
//
//첫째 줄에 체스판의 크기 N(3 ≤ N ≤ 10)이 주어진다.
//
//둘째 줄부터 N개의 줄에 체스판에 적힌 수가 주어진다.
//
//출력 
//
//첫째 줄에 문제에 주어진 대로 방문하는데 필요한 시간의 최솟값을 출력한다. 

package BaekJoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16959_체스판여행 {
	static int N, sr, sc, status=0, cnt;
	static int[][] chess;
	static int[][] knight = {{-2,1},{-2,-1},{-1,2},{-1,-2},{1,2},{1,-2},{2,1},{2,-1}};
	static int[][] bishop = {{1,1},{1,-1},{-1,1},{-1,-1}};
	static int[][] rook = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16959_체스판여행.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N][N];
		StringTokenizer st;
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {		
				return o1[4]>=o2[4] ? 1:-1;
			}
		});
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				chess[i][j] = Integer.parseInt(st.nextToken());
				if(chess[i][j]==1) {
					sr = i;
					sc = j;
				}
			}
		}
		queue.offer(new int[] {chess[sr][sc],sr,sc,0,0});
		queue.offer(new int[] {chess[sr][sc],sr,sc,1,0});
		queue.offer(new int[] {chess[sr][sc],sr,sc,2,0});
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(temp[0]==N*N) {
				System.out.println(temp[4]);
				break;
			}
			int nr=0, nc=0;
			for(int i=0; i<knight.length; i++) {
				nr = temp[1]+knight[i][0];
				nc = temp[2]+knight[i][1];
				if(isOk(nr,nc)) {
					if(temp[3]==0) {
						if(chess[nr][nc]==temp[0]+1) {
							queue.offer(new int[] {temp[0]+1,nr,nc,0,temp[4]+1});
						}else {
							queue.offer(new int[] {temp[0],nr,nc,0,temp[4]+1});
						}
					}else {
						if(chess[nr][nc]==temp[0]+1) {
							queue.offer(new int[] {temp[0]+1,nr,nc,0,temp[4]+2});
						}else {
							queue.offer(new int[] {temp[0],nr,nc,0,temp[4]+2});
						}
					}
				}
			}
			for(int i=0; i<bishop.length; i++) {
				for(int j=1; j<N; j++) {
					nr = temp[1]+bishop[i][0]*j;
					nc = temp[2]+bishop[i][1]*j;
					if(isOk(nr,nc)) {
						if(temp[3]==0) {
							if(chess[nr][nc]==temp[0]+1) {
								queue.offer(new int[] {temp[0]+1,nr,nc,0,temp[4]+1});
							}else {
								queue.offer(new int[] {temp[0],nr,nc,0,temp[4]+1});
							}
						}else {
							if(chess[nr][nc]==temp[0]+1) {
								queue.offer(new int[] {temp[0]+1,nr,nc,0,temp[4]+2});
							}else {
								queue.offer(new int[] {temp[0],nr,nc,0,temp[4]+2});
							}
						}
					}
				}
			}
			for(int i=0; i<rook.length; i++) {
				for(int j=1; j<N; j++) {
					nr = temp[1]+rook[i][0]*j;
					nc = temp[2]+rook[i][1]*j;
					if(isOk(nr,nc)) {
						if(temp[3]==0) {
							if(chess[nr][nc]==temp[0]+1) {
								queue.offer(new int[] {temp[0]+1,nr,nc,0,temp[4]+1});
							}else {
								queue.offer(new int[] {temp[0],nr,nc,0,temp[4]+1});
							}
						}else {
							if(chess[nr][nc]==temp[0]+1) {
								queue.offer(new int[] {temp[0]+1,nr,nc,0,temp[4]+2});
							}else {
								queue.offer(new int[] {temp[0],nr,nc,0,temp[4]+2});
							}
						}
					}
				}
			}
			
		}
	}
	private static boolean isOk(int r, int c) {
		return (r>=0 && r<N && c>=0 && c<N) ? true: false;
	}
}