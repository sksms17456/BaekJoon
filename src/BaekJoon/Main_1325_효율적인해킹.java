//문제 
//
//해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다. 이 회사는 N개의 컴퓨터로 이루어져 있다. 
//
//김지민은 귀찮기 때문에, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.
//
//이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.
//
//이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.
//
//입력 
//
//첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다. 
//
//둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다. 컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.
//
//출력 
//
//첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다.
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1325_효율적인해킹 {
	static int N, M, A, B, cnt, max=Integer.MIN_VALUE;
	static int[] hack;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_1325_효율적인해킹.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		hack = new int[N+1];
		visit = new boolean[N+1];
		list = new ArrayList<>();
		
		for(int i = 0; i<=N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			list.get(A).add(B);
		}
		
		for(int i=1; i<=N; i++) {
			cnt=1;
			hacking(i);
			Arrays.fill(visit, false);
		}
		
		for(int i=1; i<=N; i++) {
			max = Math.max(max, hack[i]);
		}
		for(int i=1; i<=N; i++) {
			if(hack[i]==max) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb);
	}
	private static void hacking(int n) {
		visit[n] = true;
		for(int i=0; i<list.get(n).size(); i++) {
			int idx = list.get(n).get(i);			
			if(!visit[idx]) {
				hack[idx]++;
				hacking(idx);	
			}
		}
	}
}
