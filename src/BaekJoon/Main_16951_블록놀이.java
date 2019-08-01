//문제
//욱제는 높이가 1인 블록을 매우 많이 가지고 있고, 블록을 쌓아서 탑 N개를 만들었다. 탑은 일렬로 배열했고, 왼쪽에서부터 i번째 탑의 높이는 Ai이다.
//
//욱제가 가장 좋아하는 정수는 K이다. 따라서, 인접한 두 탑의 높이 차이를 K로 만들려고 한다. 즉, Ai+1 - Ai = K를 만족해야 한다.
//
//욱제가 1분 동안 할 수 있는 작업은 탑 하나를 고르고, 탑에 블록을 더 놓아서 높이를 크게 만드는 것 또는 탑에서 블록을 빼서 높이를 작게 만드는 것이다. 인접한 두 탑의 높이 차이를 K로 만드는데 필요한 시간을 구해보자. 욱제는 손이 매우 빠르기 때문에, 1분 동안 놓을 수 있는 블록 또는 뺄 수 있는 블록의 개수는 무한대이다.
//
//탑의 높이는 항상 1보다 크거나 같아야 한다.
//
//입력
//첫째 줄에 탑의 수 N, 욱제가 가장 좋아하는 정수 K가 주어진다.
//
//둘째 줄에는 탑의 높이 A1, A2, ..., AN이 주어진다.
//
//출력
//첫째 줄에 모든 인접한 두 탑의 높이 차이를 K로 만드는 최소 시간을 출력한다.
//
//제한
//1 ≤ N, K ≤ 1,000
//1 ≤ Ai ≤ 1,000
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16951_블록놀이 {
	static int N, k, ans, cnt, high;
	static int[] block, set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16951_블록놀이.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		block = new int[N];
		set = new int[N];
		ans=N-1;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			block[i] = Integer.parseInt(st.nextToken());
			set[i] = i*k;
		}
		top:
		for(int i=1; i<1001; i++) {
			cnt=0;
			for(int curblock=0; curblock<N; curblock++) {
				high = i+set[curblock];
				if(high!=block[curblock]) {			
					cnt++;	
				}
				if(i!=1 && cnt>=ans) {
					continue top;
				}
			}
			ans=cnt;
		}
		System.out.println(ans);
	}
}
