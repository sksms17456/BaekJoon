//문제
//주사위 윷놀이는 다음과 같은 게임판에서 하는 게임이다.
//
//
//
//가장 처음에는 시작에 말 4개가 있다. 말은 게임판에 적힌 화살표의 방향대로만 이동할 수 있다. 파란색 칸에서 말이 이동을 시작하는 경우에는 파란색 화살표의 방향으로 이동해야 하며 파란색 칸을 지나가는 경우에는 빨간 화살표의 방향대로 이동해야 한다.
//
//게임은 1부터 5까지 한 면에 하나씩 적혀있는 5면 주사위를 굴려서 나온 수만큼 이동하는 방식으로 진행한다. 이동하려고 하는 칸에 말이 이미 있는 경우에는 그 칸으로 이동할 수 없다. 시작과 도착칸은 말이 이미 있어도 이동할 수 있다. 말이 이동을 마칠때마다 칸에 적혀있는 수가 점수에 추가된다. 
//
//말이 도착으로 이미 이동한 경우에는 더 이상 이동할 수 없고, 말이 이동하려고 하는 칸이 도착을 넘어가는 경우에는 도착에서 이동을 마친다.
//
//주사위에서 나올 수 10개를 미리 알고있을때, 얻을 수 있는 점수의 최댓값을 구해보자.
//
//입력
//첫째 줄에 주사위에서 나올 수 10개가 순서대로 주어진다.
//
//출력
//얻을 수 있는 점수의 최댓값을 출력한다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17825_주사위윷놀이 {
	static int max = Integer.MIN_VALUE;
	static int[] num = new int[10], score = {};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/Main_17825_주사위윷놀이.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<10; i++) {
			num[i] =toInt(st.nextToken()); 
		}
	
	}
	static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
