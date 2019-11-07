//문제
//작곡가 철수는 피보나치 수열을 이용하여 만든 피아노 곡을 우연히 유튜브에서 보게 되었다. 피보나치 수열이란 f1 = 1, f2 = 1, fn+2 = fn+1 + fn (모든 n ≥ 1에 대해)을 만족하는 수열이다.
//
//이 곡은 피보나치 수열의 각 자리 숫자에 해당하는 건반을 눌러서 만들어졌다.
//피보나치 수열의 첫 8개 항을 사용해 곡을 만든다면, 다음과 같이 건반을 총 10번 누르게 될 것이다.
//
//1 → 1 → 2 → 3 → 5 → 8 → 1 → 3 → 2 → 1
//
//철수는 자신도 이 방법을 사용해 보기로 마음먹었다. 그런데 피보나치 수열은 너무 빠르게 증가해서, 덧셈에 약한 철수가 계산하기에는 어려웠다.
//
//그래서 철수는 방법을 조금 바꾸기로 했다. 철수는 어떤 수 M을 정한 후, 피보나치 수열의 각 항을 M으로 나눈 나머지로 새로운 수열 을 만들고, 그 수열의 각 자리 숫자로 새 피아노 곡을 쓰려고 한다.
//
//예를 들어 M=10일 때, 새로운 수열 은 다음과 같다.
//
//{1, 1, 2, 3, 5, 8, 3, 1, …}
//
//따라서 철수는 1 →1 → 2 → 3 → 5 → 8 → 3 → 1 → 4 → … 순으로 건반을 누르게 된다.
//
//이때, 철수는 어떤 N에 대해 N번째로 누르게 되는 건반의 번호(i.e. 새로운 수열 의 N번째 항)가 궁금해졌다.
//
//Q개의 N이 질의로 주어졌을 때, 각각의 질의에 대해 N번째로 누르게 되는 건반의 번호를 출력하는 프로그램을 작성하여라.
//
//입력
//첫 번째 줄에는 정수 Q와 M이 공백을 사이에 두고 주어진다.
//
//두 번째 줄부터 Q개의 줄에 각각의 질의를 나타내는 정수 N이 주어진다.
//
//출력
//각각의 N에 대해, N번째로 누르게 되는 건반의 번호(새로운 수열의 N 번째 항)를 입력에 주어진 순서대로 총 Q개의 줄에 출력한다.
//
//제한
//1 ≤ N ≤ 1015
//2 ≤ M ≤ 1,000
//1 ≤ Q ≤ 100,000 
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17840_피보나치음악 {
	static int T, mod, pressIdx;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/Main_17840_피보나치음악.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = toInt(st.nextToken());
		mod = toInt(st.nextToken());
		for(int i=0; i<T; i++) {
			pressIdx = toInt(br.readLine());
		}
		int k = 1, j=1;
		for(int i=3; i<1000; i++) {
			int ans = (k+j)%mod;
			System.out.println(i + " " + ans);
			k = j;
			j = ans;
		}
	}
	static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
