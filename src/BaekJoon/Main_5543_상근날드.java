//문제
//상근날드에서 가장 잘 팔리는 메뉴는 세트 메뉴이다. 
//주문할 때, 자신이 원하는 햄버거와 음료를 하나씩 골라, 세트로 구매하면, 가격의 합계에서 50원을 뺀 가격이 세트 메뉴의 가격이 된다.
//
//햄버거는 총 3종류 상덕버거, 중덕버거, 하덕버거가 있고, 음료는 콜라와 사이다 두 종류가 있다.
//
//햄버거와 음료의 가격이 주어졌을 때, 가장 싼 세트 메뉴의 가격을 출력하는 프로그램을 작성하시오.
//
//입력
//
//입력은 총 다섯 줄이다. 첫째 줄에는 상덕버거, 둘째 줄에는 중덕버거, 셋째 줄에는 하덕버거의 가격이 주어진다. 
//넷째 줄에는 콜라의 가격, 다섯째 줄에는 사이다의 가격이 주어진다. 모든 가격은 100원 이상, 2000원 이하이다.
//
//출력
//
//첫째 줄에 가장 싼 세트 메뉴의 가격을 출력한다.

package BaekJoon;

import java.util.Scanner;

public class Main_5543_상근날드 {
	static int[] bug=new int[3];
	static int[] drink=new int[2];
	static int sum,min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<3; i++) {
			bug[i] = sc.nextInt();
		}
		for(int i=0; i<2; i++) {
			drink[i]=  sc.nextInt();
		}
		
		int min=Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			for(int j=0;j<2;j++) {
				min=Math.min(min, bug[i]+drink[j]);
			}
		}
		System.out.println(min-50);
		
	}
}
