//문제
//
//자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
//
//입력
//
//첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.
//
//출력
//
//첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
package BaekJoon;

import java.io.*;

public class Main_1629_곱셈 {
	static int A, B, C;
	static String[] line;
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Main_1629_곱셈.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().split(" ");
		A = Integer.parseInt(line[0]);
		B = Integer.parseInt(line[1]);
		C = Integer.parseInt(line[2]);
		
		System.out.println(power((long)A, (long)B));
	}
	public static long power(long a, long b) {
		long ans = 1;
		while(b>0) {
			if(b%2==1) {
				ans *= a;
				ans %= C;
//				ans = (ans%C)*(a%C)%C;
			}
//			a = (a%C)*(a%C)%C;
//			b /= 2;
			a *= a;
			a %= C;
			b /= 2;
		}
		return ans;
	}
}
