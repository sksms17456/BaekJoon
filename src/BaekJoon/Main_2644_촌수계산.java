package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2644_촌수계산{
	static int N, x, y, n;
	static boolean[] visit;
	static boolean meet = false;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];

		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
			
		}
		find(x, 0);
		if(!meet) {
			System.out.println(-1);
		}
		
	}
	private static void find(int start, int cnt) {
		visit[start] = true;
		if(start==y) {
			System.out.println(cnt);
			meet = true;
		}
		for(int i=0; i<list.get(start).size(); i++) {
			int k = list.get(start).get(i);
			if(!visit[k]) {
				find(k, cnt+1);
			}
		}
		cnt--;
	}
}
