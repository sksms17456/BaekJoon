//문제
// 
//N개의 정수로 이루어진 집합이 있을 때, 이 집합의 공집합이 아닌 부분집합 중에서 그 집합의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
//
//입력
//
//첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1≤N≤20, |S|≤1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 
//주어지는 정수의 절댓값은 100,000을 넘지 않는다. 같은 수가 여러 번 주어질 수도 있다.
//
//출력
//
//첫째 줄에 합이 S가 되는 부분집합의 개수를 출력한다.

package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_1182_부분집합의합 {
	static int N;
	static int S;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Main_1182_부분집합의합.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] ns = br.readLine().split(" ");
		
		N=Integer.parseInt(ns[0]);
		S=Integer.parseInt(ns[1]);
		String[] number = br.readLine().split(" ");
		
		int n=number.length;
		int sum=0;
		int cnt;
		if(S==0)
			cnt=-1;
		else
			cnt=0;
		for (int i = 0, size = 1<<n; i < size; i++) {
			for (int j = 0; j < n; j++) {
				if((i & 1<<j)!=0) {
					sum+=Integer.parseInt(number[j]);
				}
			}
			if(sum==S)
				cnt++;
			
			sum=0;
		}
		System.out.println(cnt);
	}
}
