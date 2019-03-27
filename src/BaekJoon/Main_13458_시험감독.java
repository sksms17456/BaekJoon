//문제 
//총 N개의 시험장이 있고, 각각의 시험장마다 응시자들이 있다. i번 시험장에 있는 응시자의 수는 Ai명이다.
//감독관은 총감독관과 부감독관으로 두 종류가 있다. 총감독관은 한 방에서 감시할 수 있는 응시자의 수가 B명이고, 부감독관은 한 방에서 감시할 수 있는 응시자의 수가 C명이다.
//각각의 시험장에 총감독관은 오직 1명만 있어야 하고, 부감독관은 여러 명 있어도 된다.
//각 시험장마다 응시생들을 모두 감시해야 한다. 이때, 필요한 감독관 수의 최솟값을 구하는 프로그램을 작성하시오.
//입력 
//첫째 줄에 시험장의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
//둘째 줄에는 각 시험장에 있는 응시자의 수 Ai (1 ≤ Ai ≤ 1,000,000)가 주어진다.
//셋째 줄에는 B와 C가 주어진다. (1 ≤ B, C ≤ 1,000,000)
//출력 
//각 시험장마다 응시생을 모두 감독하기 위해 필요한 감독관의 최소 수를 출력한다.
package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {
	static int N, master, sub;
	static long cnt;
	static int[] room, mem = new int[1000001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_13458_시험감독.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		room = new int[N];		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		master = Integer.parseInt(st.nextToken());
		sub = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<1000001; i++) {
			int n = i-master;
			if(n<=0) {
				mem[i] = 1;
				continue;
			}
			if(n%sub==0) {
				mem[i] = n/sub+1;
			}else {
				mem[i] = n/sub+2;
			}
		}
		for(int i=0; i<N; i++) {
			cnt+=mem[room[i]];
		}
		System.out.println(cnt);
	}
}
