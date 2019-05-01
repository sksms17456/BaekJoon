//문제 
//인체에 치명적인 바이러스를 연구하던 연구소에 승원이가 침입했고, 바이러스를 유출하려고 한다. 승원이는 연구소의 특정 위치에 바이러스 M개를 놓을 것이고, 승원이의 신호와 동시에 바이러스는 퍼지게 된다.
//연구소는 크기가 N×N인 정사각형으로 나타낼 수 있으며, 정사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.
//일부 빈 칸은 바이러스를 놓을 수 있는 칸이다. 바이러스는 상하좌우로 인접한 모든 빈 칸으로 모두 복제되며, 1초가 걸린다.
//예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자. 0은 빈 칸, 1은 벽, 2는 바이러스를 놓을 수 있는 곳이다.
//2 0 0 0 1 1 0
//0 0 1 0 1 2 0
//0 1 1 0 1 0 0
//0 1 0 0 0 0 0
//0 0 0 2 0 1 1
//0 1 0 0 0 0 0
//2 1 0 0 0 0 2
//M = 3이고, 바이러스를 아래와 같이 놓은 경우 6초면 모든 칸에 바이러스를 퍼뜨릴 수 있다. 벽은 -, 바이러스를 놓은 위치는 0, 빈 칸은 바이러스가 퍼지는 시간으로 표시했다.
//6 6 5 4 - - 2
//5 6 - 3 - 0 1
//4 - - 2 - 1 2
//3 - 2 1 2 2 3
//2 2 1 0 1 - -
//1 - 2 1 2 3 4
//0 - 3 2 3 4 5
//시간이 최소가 되는 방법은 아래와 같고, 5초만에 모든 칸에 바이러스를 퍼뜨릴 수 있다.
//0 1 2 3 - - 2
//1 2 - 3 - 0 1
//2 - - 2 - 1 2
//3 - 2 1 2 2 3
//3 2 1 0 1 - -
//4 - 2 1 2 3 4
//5 - 3 2 3 4 5
//연구소의 상태가 주어졌을 때, 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간을 구해보자.
//입력 
//첫째 줄에 연구소의 크기 N(5 ≤ N ≤ 50), 놓을 수 있는 바이러스의 개수 M(2 ≤ M ≤ 10)이 주어진다.
//둘째 줄부터 N개의 줄에 연구소의 상태가 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스를 놓을 수 있는 위치이다. 2의 개수는 M보다 크거나 같고, 10보다 작거나 같은 자연수이다.
//출력 
//연구소의 모든 빈 칸에 바이러스가 있게 되는 최소 시간을 출력한다. 바이러스를 어떻게 놓아도 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우에는 -1을 출력한다.
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17141_연구소2 {
	static int N, M, virusSize, minsec=Integer.MAX_VALUE;
	static int[][] laboratory, pos={{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[] virus;
	static boolean[][] visit;
	static ArrayList<int[]> virusList = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_17141_연구소2.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		laboratory = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				laboratory[i][j] = Integer.parseInt(st.nextToken());
				if(laboratory[i][j]==2) {
					virusList.add(new int[] {i,j});
				}
			}
		}
		virusSize = virusList.size();
		virus = new boolean[virusSize];
		selectVirus(0,0);
		System.out.println(minsec);
	}
	private static void selectVirus(int cnt, int idx) {
		if(cnt==M) {
			spreadVirus();
			return;
		}
		for(int i=idx; i<virusSize; i++) {
			if(!virus[i]) {
				virus[i] = true;
				selectVirus(cnt+1,i+1);
				virus[i] = false;
			}
		}
	}
	private static void spreadVirus() {	
		int cnt=0;
		init();
		LinkedList<int[]> vqueue = new LinkedList<>();
		for(int i=0; i<virusSize; i++) {
			if(virus[i]) {
				int[] temp = virusList.get(i);
				visit[temp[0]][temp[1]] = true;
				vqueue.offer(new int[] {temp[0],temp[1],0});
			}
		}
		while(!vqueue.isEmpty()) {
			int size = vqueue.size();
			for(int i=0; i<size; i++) {
				int[] temp = vqueue.poll();
				int r = temp[0];
				int c = temp[1];
				int second = temp[2];
				for(int j=0; j<4; j++) {
					int nr = r+pos[j][0];
					int nc = c+pos[j][1];
					if(isOk(nr,nc)) {
						visit[nr][nc] = true;
						vqueue.offer(new int[] {nr,nc,second+1});
					}
				}
				cnt=second;
			}
		}
		if(findZero()) {
			
		}
		minsec = Math.min(minsec, cnt);
	}
	private static boolean findZero() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(laboratory[i][j]==0 && !visit[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	private static void init() {
		for(int i=0; i<N; i++) {
			Arrays.fill(visit[i], false);
		}
	}
	private static boolean isOk(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N && !visit[r][c] && laboratory[r][c]!=1) ? true:false;
	}
}
