//문제
//정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
//
//2를 곱한다.
//1을 수의 가장 오른쪽에 추가한다. 
//A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
//
//입력
//첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.
//
//출력
//A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16953_AtoB {
	static int A, B;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16953_AtoB.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {A,1});
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(temp[0]==B) {
				System.out.println(temp[1]);
				System.exit(0);
			}
			if(temp[0]<=B/2) {
				queue.offer(new int[] {temp[0]*2, temp[1]+1});
			}
			if(temp[0]<=B/10) {
				queue.offer(new int[] {temp[0]*10+1, temp[1]+1});
			} 
		}
		System.out.println(-1);
	}
}
