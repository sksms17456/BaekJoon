//문제
//
//세준이는 성형수술을 한 후에 병원에 너무 오래 입원해 있었다. 이제 세준이가 병원에 입원한 동안 자기를 생각해준 사람들에게 감사하다고 말할 차례이다.
//
//세준이를 생각해준 사람은 총 N명이 있다. 사람의 번호는 1번부터 N번까지 있다. 세준이가 i번 사람에게 인사를 하면 L[i]만큼의 체력을 잃고, J[i]만큼의 기쁨을 얻는다. 
//세준이는 각각의 사람에게 최대 1번만 말할 수 있다.
//
//세준이의 목표는 주어진 체력내에서 최대한의 기쁨을 느끼는 것이다. 세준이의 체력은 100이고, 기쁨은 0이다. 
//만약 세준이의 체력이 0이나 음수가 되면, 죽어서 아무런 기쁨을 못 느낀 것이 된다. 세준이가 얻을 수 있는 최대 기쁨을 출력하는 프로그램을 작성하시오.
//
//입력
// 
//첫째 줄에 사람의 수 N(<=20)이 들어온다. 
//둘째 줄에는 각각의 사람에게 인사를 할 때, 잃는 체력이 1번 사람부터 순서대로 들어오고, 셋째 줄에는 각각의 사람에게 인사를 할 때, 얻는 기쁨이 1번 사람부터 순서대로 들어온다. 
//체력과 기쁨은 100보다 작거나 같은 자연수 또는 0이다.
//
//출력
//
//첫째 줄에 세준이가 얻을 수 있는 최대 기쁨을 출력한다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main_1535_안녕by재귀 {
	static int N;
	static int HP;
	static int HAPPY;
	static String[] hp, happy;
	static int max;
	public static void main(String[] args) throws Exception{
		double start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader("Main_1535_안녕.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		hp = br.readLine().split(" ");
		happy = br.readLine().split(" ");
		
		System.out.println(hidie(0));
		double end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	public static int hidie(int val) {
		if(val>=(1<<N)) {
			return 0;
		}
		HP=100;
		HAPPY=0;
		for(int j=0; j<N; j++) {
			if((val & 1<<j)!=0) {
				HP-=Integer.parseInt(hp[j]);
				HAPPY+=Integer.parseInt(happy[j]);
			}
		}
		if(HP>0) {
			max=HAPPY;
		}	
		return Math.max(max, hidie(val+1));
	}
	

}
