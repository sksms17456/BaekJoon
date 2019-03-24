//문제
//2차원 평면 위에 N개의 도시가 있다. 일부 도시는 특별한 도시이다. 
//
//(r1, c1)에 있는 도시에서 (r2, c2)에 있는 도시로 가는 이동 시간은 |r1 - r2| + |c1 - c2|와 같다. 만약, 두 도시가 특별한 도시라면, 텔레포트를 이용해서 이동할 수도 있다.
//
//텔레포트에 걸리는 시간은 T이다.
//
//두 도시의 쌍 M개가 주어졌을 때, 최소 이동 시간을 구해보자.
//
//입력
//
//첫째 줄에 도시의 수 N, 텔레포트하는데 걸리는 시간 T가 주어진다.
//
//둘째 줄부터 N개의 줄에 도시의 정보를 의미하는 세 정수 s, x, y가 1번 도시부터 N번 도시까지 순서대로 주어진다. 
//
//1인 경우에는 특별한 도시라는 의미이고, 0인 경우는 특별한 도시가 아니라는 의미이다. (x, y)는 도시의 좌표이다.
//
//다음 줄에는 M이 주어지고, 다음 M개의 줄에는 두 도시 A와 B가 주어진다. 
//
//출력
//
//총 M개의 줄에 걸쳐서 A에서 B에 가는 최소 이동 시간을 출력한다.
//
//제한
//2 ≤ N ≤ 1,000
//1 ≤ T ≤ 2,000
//1 ≤ M ≤ 1,000
//0 ≤ x, y ≤ 1,000
//A ≠ B
//두 도시의 좌표가 같은 경우는 없다.

package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16985_텔레포트 {
	static int N, T, M, start, end, min;
	static int[][] arr;
	static int[] dist;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16985_텔레포트.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		for(int i=0; i<N-1; i++) {
			int[] start = list.get(i);
			for(int j=i+1; j<N; j++) {
				int[] end = list.get(j);
				if(start[0]==1 && end[0]==1) {
					arr[i][j]=arr[j][i]=Math.min(T, Math.abs(start[1]-end[1])+Math.abs(start[2]-end[2]));
				}else {
					arr[i][j]=arr[j][i]=Math.abs(start[1]-end[1])+Math.abs(start[2]-end[2]);
				}
			}
		}
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken())-1;
			end = Integer.parseInt(st.nextToken())-1;
			dist = new int[N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[start]=0;
			PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1]>=o2[1] ? 1:-1;
				}
			});
			for(int j=0; j<N; j++) {
				queue.offer(new int[] {j,dist[j]});
			}
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				if(dist[temp[0]]>=temp[1]) {
					for(int j=0; j<N; j++) {
						if(arr[temp[0]][j]!=Integer.MAX_VALUE && dist[j]>dist[temp[0]]+arr[temp[0]][j]) {
							dist[j]=dist[temp[0]]+arr[temp[0]][j];
							queue.offer(new int[] {j,dist[j]});
						}
					}
				}
			}
			System.out.println(dist[end]);
		}
	}
}
