//문제 
//
//나3곱2 게임은 정수 하나를 이용한다. 가장 먼저, 정수 x로 시작하고, 연산을 N-1번 적용한다. 적용할 수 있는 연산은 두 가지 있고, 아래와 같다.
//
//나3: x를 3으로 나눈다. x는 3으로 나누어 떨어져야 한다.
//
//곱2: x에 2를 곱한다.
//
//나3곱2 게임을 진행하면서, 만든 수를 모두 기록하면 수열 A를 만들 수 있다. 
//
//예를 들어, x = 9, N = 6이고, 적용한 연산이 곱2, 곱2, 나3, 곱2, 나3인 경우에 A = [9, 18, 36, 12, 24, 8] 이다.
//
//수열 A의 순서를 섞은 수열 B가 주어졌을 때, 수열 A를 구해보자.
//
//입력 
//
//첫째 줄에 수열의 크기 N(2 ≤ N ≤ 100)이 주어진다. 둘째 줄에는 수열 B가 주어진다. B에 포함된 원소는 1018 보다 작거나 같은 자연수이다.
//
//출력 
//
//나3곱2 게임의 결과 수열 A를 출력한다. 항상 정답이 존재하는 경우에만 입력으로 주어지며, 가능한 정답이 여러가지인 경우에는 아무거나 출력한다.

package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16936_나3곱2 {
	static int N, cnt, start;
	static ArrayList<ArrayList<Long>> list = new ArrayList<>();
	static long[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16936_나3곱2.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());	
		arr = new long[N];
		for(int i=0; i<N; i++) {
			list.add(new ArrayList<>());
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());	
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			list.get(i).add(arr[i]);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i]%2==0 && arr[j]==arr[i]/2) {
					list.get(i).add(0, arr[j]);
				}
				if(arr[j]==arr[i]*3) {
					list.get(i).add(0, arr[j]);
				}
				if(arr[j]==arr[i]*2) {
					list.get(i).add(list.get(i).size(), arr[j]);
				}
				if(arr[i]%3==0 && arr[j]==arr[i]/3) {
					list.get(i).add(list.get(i).size(), arr[j]);
				}
			}	
		}
		
		for(int i=0; i<N; i++) {
			if(list.get(i).get(0)==arr[i]) {
				sb.append(arr[i]);
				start = i;
				cnt++;
				break;
			}
		}
		while(cnt<N) {
			for(int i=0; i<N; i++) {
				if(list.get(i).get(0)==arr[start]) {
					sb.append(" "+list.get(i).get(1));
					start = i;
					break;
				}
			}
			cnt++;
		}
		System.out.println(sb);
	}
}
