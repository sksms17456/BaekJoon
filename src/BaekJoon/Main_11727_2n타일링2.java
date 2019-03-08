//문제 
//
//2×n 직사각형을 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
//
//아래 그림은 2×17 직사각형을 채운 한가지 예이다.
//
//입력 
//
//첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
//
//출력 
//
//첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
package BaekJoon;

import java.io.*;

public class Main_11727_2n타일링2 {
	static int N;
	static int[] tile = new int[1001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_11727_2n타일링2.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tile[1] = 1;
		tile[2] = 3;
		for(int i=3; i<tile.length; i++) {
			tile[i] = (tile[i-1]+tile[i-2]*2)%10007;
		}
		System.out.println(tile[N]);
	}
}
