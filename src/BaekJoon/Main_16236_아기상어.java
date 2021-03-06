//문제 
//N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 물고기가 최대 1마리 존재한다.
//아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.
//아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
//아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.
//더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
//먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
//먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다. 
//거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최소값이다.
//거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
//아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.
//아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.
//공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.
//입력 
//첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.
//둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.
//0: 빈 칸
//1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
//9: 아기 상어의 위치
//아기 상어는 공간에 한 마리 있다.
//출력 
//첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.

package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	static int N, ans, sharkr, sharkc, size, eatcnt;
	static int[][] aquarium;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] v;
	static boolean callMom;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16236_아기상어.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


//		하나를 먹어 먹을때마다 카운트세는데 카운트 상어 크기만큼 먹으면 사이즈1늘려줘
//		먹으러갈때는 자기보다 같거나작은애들로만 갈수있다
		
//		입력받아
//		받으면서 아기상어위치찾아
		N = Integer.parseInt(br.readLine());
		aquarium = new int[N][N];
		v = new boolean[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				aquarium[i][j] = Integer.parseInt(st.nextToken());
				if(aquarium[i][j]==9) {
					sharkr=i;
					sharkc=j;
					size = 2;
				}
			}
		}
		eatcnt=0;
//		아기상어로부터 먹을수있는애들 찾아서 가장 가까운애기준 정렬(거리같으면 맨위왼쪽부터)
		while(true) {
			callMom=false;
			findFood();
			if(callMom) {
				System.out.println(ans);
				System.exit(0);
			}
			if(eatcnt==size) {
				size+=1;
				eatcnt=0;
			}
		}
		
	}
	private static void findFood() {
		LinkedList<int[]> queue = new LinkedList<>();
		PriorityQueue<int[]> fishes = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2]==o2[2]) {
					if(o1[0]==o2[0]) {
						return o1[1]-o2[1];
					}
					return o1[0]-o2[0];
				}
				return o1[2]-o2[2];
			}
		});
		v[sharkr][sharkc] = true;
		aquarium[sharkr][sharkc]=0;
		queue.offer(new int[] {sharkr, sharkc});
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int r = tmp[0];
			int c = tmp[1];
			for(int i=0; i<4; i++) {
				int nr = r+pos[i][0];
				int nc = c+pos[i][1];
				if(isOk(nr,nc)) {
					v[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
					if(aquarium[nr][nc]!=0 && aquarium[nr][nc]<size) {
						fishes.offer(new int[] {nr,nc,(Math.abs(sharkr-nr)+Math.abs(sharkc-nc))});
					}
				}
			}
		}
		
		if(fishes.size()==0) {
			callMom=true;
			return;
		}
		int[] target = fishes.poll();
		init();
		findRoad(target[0],target[1]);
		
	}
	private static void findRoad(int tr, int tc) {
		LinkedList<int[]> queue = new LinkedList<>();
		v[sharkr][sharkc] = true;
		queue.offer(new int[] {sharkr, sharkc,0});
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int r = tmp[0];
			int c = tmp[1];
			int cnt = tmp[2];
			for(int i=0; i<4; i++) {
				int nr = r+pos[i][0];
				int nc = c+pos[i][1];
				if(nr==tr && nc==tc) {
					sharkr = tr;
					sharkc = tc;
					aquarium[tr][tc]=0;
					ans+=cnt+1;
					eatcnt++;
					System.out.println(tr+" "+tc+" "+cnt);
					init();
					return;
				}
				if(isOk(nr,nc) && aquarium[nr][nc]<= size) {
					v[nr][nc] = true;
					queue.offer(new int[] {nr,nc,cnt+1});
				}
			}
		}
	}
	
	private static void init() {
		for(int i=0; i<N; i++) {
			Arrays.fill(v[i], false);
		}
	}
	
	private static boolean isOk(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N && !v[r][c]) ? true:false;
	}
}