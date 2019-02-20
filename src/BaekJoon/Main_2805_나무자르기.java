package BaekJoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2805_나무자르기{
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 <= o2 ? 1:-1;
			}	
		});
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}

		while(true) {
			if(M==0)
				break;
			queue.offer(queue.poll()-1);
			M--;
		}
		System.out.println(queue.poll());
	}
}