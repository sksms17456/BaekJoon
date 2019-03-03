//문제
//
//현진 치킨에서 판매하는 치킨은 양념 치킨, 후라이드 치킨, 반반 치킨으로 총 세 종류이다. 
//
//반반 치킨은 절반은 양념 치킨, 절반은 후라이드 치킨으로 이루어져있다. 
//
//양념 치킨 한 마리의 가격은 A원, 후라이드 치킨 한 마리의 가격은 B원, 반반 치킨 한 마리의 가격은 C원이다.
//
//상도는 오늘 파티를 위해 양념 치킨 최소 X마리, 후라이드 치킨 최소 Y마리를 구매하려고 한다. 
//
//반반 치킨을 두 마리 구입해 양념 치킨 하나와 후라이드 치킨 하나를 만드는 방법도 가능하다. 상도가 치킨을 구매하는 금액의 최솟값을 구해보자.
//
//입력
//
//첫째 줄에 다섯 정수 A, B, C, X, Y가 주어진다.
//
//출력
//
//양념 치킨 최소 X마리, 후라이드 치킨 최소 Y마리를 구매하는 비용의 최솟값을 출력한다.
//
//제한
//1 ≤ A, B, C ≤ 5,000
//1 ≤ X, Y ≤ 100,000

package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16917_양념반후라이드반 {
	static int A, B, C, X, Y, min=Integer.MAX_VALUE, idx;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16917_양념반후라이드반.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		if(X>=Y) {
			idx = Y;
			min = Math.min(min, C*2*X);
		}
		else {
			idx = X;
			min = Math.min(min, C*2*Y);
		}	
		for(int i=0; i<=idx; i++) {
			min = Math.min(min, (X-i)*A + (Y-i)*B + C*2*i);
		}
		
		System.out.println(min);
	}
}
