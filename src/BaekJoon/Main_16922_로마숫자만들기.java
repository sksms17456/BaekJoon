//문제
//로마 숫자에서는 수를 나타내기 위해서 I, V, X, L을 사용한다. 각 문자는 1, 5, 10, 50을 의미하고, 이 문제에서 다른 문자는 사용하지 않는다.
//
//하나 또는 그 이상의 문자를 이용해서 수를 나타낼 수 있다. 문자열이 나타내는 값은, 각 문자가 의미하는 수를 모두 합한 값이다. 예를 들어, XXXV는 35, IXI는 12를 의미한다.
//
//실제 로마 숫자에서는 문자의 순서가 중요하지만, 이 문제에서는 순서는 신경쓰지 않는다. 예를 들어, 실제 로마 숫자에서 IX는 9를 의미하지만, 이 문제에서는 11을 의미한다.
//
//로마 숫자를 N개 사용해서 만들 수 있는 서로 다른 수의 개수를 구해보자.
//
//입력
//첫째 줄에 사용할 수 있는 문자의 개수 N (1 ≤ N ≤ 20)이 주어진다.
//
//출력
//첫째 줄에 로마 숫자 N개를 사용해서 만들 수 있는 서로 다른 수의 개수를 출력한다.

package BaekJoon;

import java.io.*;

public class Main_16922_로마숫자만들기 {
	static int N, cnt;
	static int[] arr = new int[1001];
	static int[] roma = {1,5,10,50};
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new FileReader("res/Main_16922_로마숫자만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		comb(0,0);
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>0)
				cnt++;
		}
		System.out.println(cnt);
	}
	private static void comb(int cnt, int sum) {
		
		if(cnt==N) {
			if(arr[sum]!=0) {
				return;
			}
			arr[sum]++;
			return;
		}
		for(int i=0; i<4; i++) {
			comb(cnt+1,sum+roma[i]);
		}
	}
}
