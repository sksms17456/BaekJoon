//
//입력
//첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.
//
//출력
//첫째 줄에 다음 세 가지 중 하나를 출력한다.
//
//A가 B보다 큰 경우에는 '>'를 출력한다.
//A가 B보다 작은 경우에는 '<'를 출력한다.
//A와 B가 같은 경우에는 '=='를 출력한다.
//제한
//-10,000 ≤ A, B ≤ 10,000
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1330_두수비교하기 {
	static int n1, n2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Main_1330_두수비교하기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n1 = Integer.parseInt(st.nextToken());
		n2 = Integer.parseInt(st.nextToken());
		if(n1>n2) {
			System.out.println(">");
		}else if(n1<n2) {
			System.out.println("<");
		}else {
			System.out.println("==");
		}
	}
}
