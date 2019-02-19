//문제
// 
//수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
//
//수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
//
//수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
//
//입력
// 
//첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
//
//출력
// 
//수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
//
//힌트
// 
//수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.

package BaekJoon;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_1697_숨바꼭질 {
	static int N, K, Answer;
	static boolean[] check = new boolean[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		bfs();
	}
	private static void bfs() {
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {N, 0});
		
		while(!queue.isEmpty()) {
			int[] n = queue.poll();
			check[n[0]] = true;
			
			if(n[0]==K) {
				System.out.println(n[1]);
				break;
			}
			
			if(n[0]+1>=0 && n[0]+1<=100000 && !check[n[0]+1])
				queue.offer(new int[] {n[0]+1, n[1]+1});				
			if(n[0]-1>=0 && n[0]-1<=100000 && !check[n[0]-1])
				queue.offer(new int[] {n[0]-1, n[1]+1});
			if(n[0]*2>=0 && n[0]*2<=100000 && !check[n[0]*2])
				queue.offer(new int[] {n[0]*2, n[1]+1});
		}
	}
}


