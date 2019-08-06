//문제
//N×M인 배열에서 모양을 찾으려고 한다. 배열의 각 칸에는 0과 1 중의 하나가 들어있다. 두 칸이 서로 변을 공유할때, 두 칸을 인접하다고 한다.
//
//1이 들어 있는 인접한 칸끼리 연결했을 때, 각각의 연결 요소를 모양이라고 부르자. 모양의 크기는 모양에 포함되어 있는 1의 개수이다.
//
//배열의 칸 하나에 들어있는 수를 변경해서 만들 수 있는 모양의 최대 크기를 구해보자.
//
//입력
//첫째 줄에 배열의 크기 N과 M이 주어진다. 둘째 줄부터 N개의 줄에는 배열에 들어있는 수가 주어진다.
//
//출력
//첫째 줄에 수 하나를 변경해서 만들 수 있는 모양의 최대 크기를 출력한다.
//
//제한
//2 ≤ N, M ≤ 1,000
//0과 1의 개수는 하나 이상이다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_16932_모양만들기 {
	static int N, M, ans=1, shapeNum=0;
	static int[][] v;
	static int[][][] board;
	static int[][] pos = {{0,-1}, {0,1}, {-1,0}, {1,0}};
	static Set<Integer> set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16932_모양만들기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M][2];
		v = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				board[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j][0]!=0 && v[i][j]==0) {
					shapeNum++;
					makeShape(i,j);
				}				
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j][0]==0) {
					isConnect(i,j);
				}
			}
		}
		System.out.println(ans);
	}
	public static void isConnect(int r, int c){
		set = new HashSet<>();
		int sum=1;
		for(int i=0; i<4; i++) {
			int nr = r+pos[i][0];
			int nc = c+pos[i][1];
			if(nr>=0 && nc>=0 && nr<N && nc<M && board[nr][nc][0]!=0) {
				int idx = board[nr][nc][1]-1;
				if(!set.contains(idx)) {
					set.add(idx);
					sum+=board[nr][nc][0];
				}
			}
		}
		ans = Math.max(ans, sum);
	}
	public static void makeShape(int r, int c){
		int size=1;
		v[r][c] = 1;
		LinkedList<int[]> list = new LinkedList<int[]>();
		LinkedList<int[]> visit = new LinkedList<int[]>();
		list.offer(new int[] {r,c});
		visit.offer(new int[] {r,c});
		while(!list.isEmpty()) {
			int[] temp = list.poll();
			for(int i=0; i<4; i++) {
				int nr = temp[0]+pos[i][0];
				int nc = temp[1]+pos[i][1];
				if(isOk(nr,nc)) {
					size++;
					v[nr][nc] = 1;
					list.offer(new int[] {nr,nc});
					visit.offer(new int[] {nr,nc});
				}
			}
		}
		ans = Math.max(ans, size);
		while(!visit.isEmpty()) {
			int[] temp = visit.poll();
			int tr = temp[0];
			int tc = temp[1];
			board[tr][tc][0] = size;
			board[tr][tc][1] = shapeNum;
		}
	}
	public static boolean isOk(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M && board[r][c][0]==1 && v[r][c]==0) ? true:false;
	}
}
