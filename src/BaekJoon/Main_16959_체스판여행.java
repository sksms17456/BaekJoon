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
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16959_체스판여행.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N][N];
		StringTokenizer st;
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {		
				return o1[0]>=o2[0] ? 1:-1;
			}
		});
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				chess[i][j] = Integer.parseInt(st.nextToken());
				queue.offer(new int[] {chess[i][j],i,j});
			}
		}
		
		//status : 0=처음, 1=나이트, 2=비숍, 3=룩
		top:
		while(!queue.isEmpty()) {
			int start[] = queue.poll();
			if(!queue.isEmpty()) {
				int temp[] = queue.peek();
				for(int i=0; i<8; i++) {
					int nr = start[1]+knight[i][0];
					int nc = start[2]+knight[i][1];
					if(isOk(nr,nc) && nr==temp[1] && nc==temp[2]) {
						if(status==0 || status==1) {
							cnt++;
						}else {
							cnt+=2;
						}
						status=1;
						System.out.println(start[0]+" "+status+" "+cnt);
						continue top;
					}
				}
				if(start[1]==temp[1] || start[2]==temp[2]) {
					if(status==0 || status==2) {
						cnt++;
					}else {
						cnt+=2;
					}
					status=2;
					System.out.println(start[0]+" "+status+" "+cnt);
					continue top;
				}
				if(start[1]+start[2]==temp[1]+temp[2] || Math.abs(start[1]-temp[1])==Math.abs(start[2]-temp[2])) {
					if(status==0 || status==3) {
						cnt++;
					}else {
						cnt+=2;
					}
					status=3;
					System.out.println(start[0]+" "+status+" "+cnt);
					continue top;
				}
				cnt+=2;
				status=2;
				System.out.println(start[0]+" "+status+" "+cnt);
				continue top;
			}
			
		}
		System.out.println(cnt);
	}
	private static boolean isOk(int r, int c) {
		return (r>=0 && r<N && c>=0 && c<N) ? true: false;
	}
}
