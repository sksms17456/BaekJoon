//어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다. 
//
//등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. 
//
//N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
//
//입력
// 
//첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
//
//출력
// 
//첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.


package BaekJoon;

import java.util.Scanner;

public class Main_1065_한수 {
	static int N,cnt;
	static String n="";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		
		if(N<100) {
			cnt=N;
		}else {
			cnt=99;
			for(int i=100; i<=N; i++) {
				boolean isOk=true;
				n+=i;

				int diff = n.charAt(0)-n.charAt(1);
				int diff2 = n.charAt(1)-n.charAt(2);
				
				if(diff!=diff2)
					isOk=false;
				
				if(isOk)
					cnt++;
				
				n="";
				isOk=true;
			}
			
		}
		System.out.println(cnt);
		
	}
}
