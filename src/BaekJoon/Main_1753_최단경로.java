//문제
//
//방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 
//
//, 모든 간선의 가중치는 10 이하의 자연수이다.
//
//입력
//
//첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1≤V≤20,000, 1≤E≤300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 
//
//둘째 줄에는 시작 정점의 번호 K(1≤K≤V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
//
//이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 
//
//서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.
//
//출력
//
//첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다.
//
//자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.

package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
	static class Node implements Comparable<Node>{
		int n;
		int cost;
		
		public Node(int n, int cost) {
			super();
			this.n = n;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost >= o.cost ? 1:-1;
		}	
	}
	static int V, E, K, r, c, cost;
	static int[] dist;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_1753_최단경로.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<V+1; i++) {
			list.add(new ArrayList<Node>());
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, 200000);
		dist[K] = 0;
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			list.get(r).add(new Node(c,cost));
		}
		PriorityQueue<Node> queue = new PriorityQueue<>();
		for(int i=0; i<V+1; i++) {
			queue.offer(new Node(i,dist[i]));
		}
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int start = node.n;
			if(dist[start]>=node.cost) {
				for(int i=0; i<list.get(start).size(); i++) {
					Node newnode = list.get(start).get(i);
					int end = newnode.n;
					if(dist[end]>dist[start]+newnode.cost) {
						dist[end] = dist[start]+newnode.cost;
						queue.offer(new Node(end,dist[end]));
					}
				}
			}
		}
		for(int i=1; i<=V; i++) {
			if(dist[i]==200000) {
				sb.append("INF\n");
			}else {
				sb.append(dist[i]+"\n");
			}
		}
		System.out.println(sb);
	}
}
