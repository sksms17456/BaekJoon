//문제
//3학년인 홍익이는 이번 학기 전공필수 과목인 운영체제(OS) 수업을 들었다. 수업을 마치고, 얼마 후 교수님께서 클래스넷을 통해 전 학생의 중간고사, 기말고사, 과제점 점수를 만점 기준 300점으로 환산하여 클래스넷에 올려주셨다. 물끄러미 점수를 바라보던 홍익이는, 불현듯 장학금을 꼭 받아야 된다는 사실이 떠올랐다.
//
//"운영체제 수업을 A0 이상 받지 못하면, 장학금을 받기 어려운데..."
//
//교수님께서는 운영체제 첫 수업 시간에 학점 분포도를 다음과 같이 설명하셨다.
//
//A+: 1~5등
//A0: 6~15등
//B+: 16~30등
//B0: 31~35등
//C+: 36~45등
//C0: 46~48등
//F: 49~50등
//교수님께서는 클래스넷의 수시정보 페이지에 학생들의 최종 점수를 내림차순으로 정렬하여 점수를 보여주셨다.
//
//10일 뒤면 클래스넷을 통해 학점이 공지되지만, 그때까지 참기 어려웠던 홍익이는 프로그램을 통해 자신의 학점을 알아보고자 한다. 홍익이를 도와 홍익이의 학점을 구해보자!
//
//입력
//첫째 줄에는 홍익이의 점수를 포함한, 학생들의 점수 50개가 띄어쓰기로 구분되어 주어진다. 점수는 내림차순으로 정렬되어있고, 같은 점수는 존재하지 않는다.
//
//둘째 줄에는 홍익이가 받은 점수가 주어진다.
//
//모든 점수는 0 이상 300 이하의 정수이다.
//
//출력
//첫째 줄에 홍익이의 학점을 출력하시오.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17826_나의학점은 {
	static int size = 50, score, myScore, rank;
	static Map<Integer, Integer> scoreMap = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/Main_17826_나의학점은.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= size; i++) {
			score = toInt(st.nextToken());
			scoreMap.put(score, i);
		}
		myScore = toInt(br.readLine());
		rank = getRank();
		System.out.println(getGrade());
	}

	static String getGrade() {
		if (rank <= 5)
			return "A+";
		if (rank <= 15)
			return "A0";
		if (rank <= 30)
			return "B+";
		if (rank <= 35)
			return "B0";
		if (rank <= 45)
			return "C+";
		if (rank <= 48)
			return "C0";
		return "F";
	}

	static int getRank() {
		return scoreMap.get(myScore);
	}

	static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
