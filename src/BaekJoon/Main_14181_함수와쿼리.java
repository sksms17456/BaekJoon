//문제 
//다음과 같은 함수가 있다.
//f(1, j) = a[j], 1 ≤ j ≤ n
//f(i, j) = min(f(i-1, j), f(i-1, j-1)) + a[j], 2 ≤ i ≤ n, i ≤ j ≤ n
//여기서 a는 길이가 n인 배열이다.
//배열 a의 값과 쿼리 xi, yi가 주어졌을 때, f(xi, yi)값을 출력하는 프로그램을 작성하시오.
//입력 
//첫째 줄에 배열 a의 크기 n (1 ≤ n ≤ 105)가 주어지고, 둘째 줄에 배열 a[1], a[2], ..., a[n]이 주어진다. (0 ≤ a[i] ≤ 104)
//다음  줄에는 쿼리의 개수 m (1 ≤ m ≤ 105)가 주어지고, 다음 m개의 줄에는 쿼리 xi, yi가 주어진다. (1 ≤ xi ≤ yi ≤ n)
//출력 
//각각의 쿼리마다 f(xi, yi)를 한 줄에 하나씩 순서대로 출력한다.
package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_14181_함수와쿼리 {
	static int N, n, x, y;
	static int[] arr, qarr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_14181_함수와쿼리.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		qarr = new int[N+1];
		for(int i=1; i<N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
		}
	}
}
