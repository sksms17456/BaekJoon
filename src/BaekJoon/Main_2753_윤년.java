//
//문제
//연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.
//
//윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때 이다.
//
//예를들어, 2012년은 4의 배수라서 윤년이지만, 1900년은 4의 배수이지만, 100의 배수이기 때문에 윤년이 아니다.
//
//하지만, 2000년은 400의 배수이기 때문에 윤년이다.
//
//입력
//첫째 줄에 연도가 주어진다. 연도는 1보다 크거나 같고, 4000보다 작거나 같은 자연수이다.
//
//출력
//첫째 줄에 윤년이면 1, 아니면 0을 출력한다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main_2753_윤년 {
	static int n, ans=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2753_윤년.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		if(n%4==0) {
			if(n%100!=0) {
				ans=1;
			}else if(n%400==0){
				ans=1;
			}
		}
		System.out.println(ans);
	}
}
