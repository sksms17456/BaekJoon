//문제
//조이는 2012년의 핫도그 먹기 대회에서 10분 동안 68개의 핫도그를 먹어치우면서 2011년에 달성한 본인의 기록 62개를 넘어 새로운 신기록을 달성했다.
//
//수학에 소질이 없는 핫도그 먹기 대회 주최자 측은 고민에 빠졌다. 기네스북에 대회의 신기록을 등록하고 싶은데 기네스북 측에서는 참가자당 소비한 핫도그의 개수를 알고 싶어 하기 때문이다.
//
//그들을 도울 수 있을까? 그들은 대가로 맛있는 핫도그를 제시했다. 총 소비된 핫도그의 개수와 총 참가자의 수가 주어질 때, 참가자당 소비한 핫도그의 개수를 구하는 프로그램을 작성하라.
//
//입력
//한 줄에 하나의 테스트 케이스가 주어진다.
//
//입력 값 H는 소비된 모든 핫도그의 숫자를 나타내고, P는 대회에 참가한 모든 참석자수의 수를 나타낸다. (1 ≤ H, P ≤ 1000)
//
//출력
//각 줄에 각 입력에 대한 결과값을 출력하라.
//
//결과값은 소수점 2번째 자리까지 표시하고, 필요하다면 반올림해서 출력하라.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5666_핫도그 {
	static float hotDog, people;
	static String input;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("res/Main_5666_핫도그.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			input = br.readLine();
			if (input == null)
				break;
			st = new StringTokenizer(input);
			hotDog = toFloat(st.nextToken());
			people = toFloat(st.nextToken());
			System.out.println(hotDogPerPerson(hotDog, people));
		}
	}

	static String hotDogPerPerson(float hotDog, float people) {
		return String.format("%.2f", hotDog / people);
	}

	static float toFloat(String input) {
		return Float.parseFloat(input);
	}
}
