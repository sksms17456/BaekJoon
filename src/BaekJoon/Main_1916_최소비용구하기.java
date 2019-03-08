//문제
//
//N의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다. 
//
//우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. 
//
//그러면 A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라. 도시의 번호는 1부터 N까지이다.
//
//입력
//
//첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다. 
//
//그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 
//
//그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.
//
//그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.
//
//출력
//
//첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.
package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {
	static class vertex implements Comparable<vertex>{
		int node;
		int dist;
		
		public vertex(int node, int dist) {
			super();
			this.node = node;
			this.dist = dist;
		}

		@Override
		public int compareTo(vertex o) {
			return this.dist >= o.dist ? 1:-1;
		}		
	}
	static int N, M, start, end, cost, mincost = 1000000000;
	static int[][] costarr;
	static int[] distance;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_1916_최소비용구하기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		costarr = new int[N][N];
		distance = new int[N];
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			Arrays.fill(costarr[i], mincost);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			if(costarr[a][b]>c) {
				costarr[a][b] = c;
			}
			
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken())-1;
		end = Integer.parseInt(st.nextToken())-1;
		
		for(int i=0; i<N; i++) {
			distance[i] = mincost;
		}
		distance[start] = 0;
		
		PriorityQueue<vertex> queue = new PriorityQueue<vertex>();
		for(int i=0; i<N; i++) {
			queue.offer(new vertex(i,distance[i]));
		}
		
		while(!queue.isEmpty()) {
			vertex v = queue.poll();
			if(distance[v.node]>=v.dist) {
				for(int i=0; i<N; i++) {
					if(costarr[v.node][i]!=mincost && distance[i]>distance[v.node]+costarr[v.node][i]) {
						distance[i] = distance[v.node]+costarr[v.node][i];
						queue.offer(new vertex(i,distance[i]));
					}
				}
			}
		}
		System.out.println(distance[end]);
	}
}
