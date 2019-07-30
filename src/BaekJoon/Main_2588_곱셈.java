//문제
//(세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
//
//
//
//(1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.
//
//출력
//첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main_2588_곱셈 {
	static int n1, n2, n21, n22, n23, ans1, ans2, ans3;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2588_곱셈.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n1 = Integer.parseInt(br.readLine());
		n2 = Integer.parseInt(br.readLine());
		ans1 = n1*(n2%10);
		ans2 = n1*(n2%100/10);
		ans3 = n1*(n2/100);
		sb.append(ans1).append("\n").append(ans2).append("\n").append(ans3).append("\n").append(ans1+ans2*10+ans3*100);
		System.out.println(sb);
	}
}
