//문제
//N개의 에너지 구슬이 일렬로 놓여져 있고, 에너지 구슬을 이용해서 에너지를 모으려고 한다.
//
//i번째 에너지 구슬의 무게는 Wi이고, 에너지를 모으는 방법은 다음과 같으며, 반복해서 사용할 수 있다.
//
//에너지 구슬 하나를 고른다. 고른 에너지 구슬의 번호를 x라고 한다. 단, 첫 번째와 마지막 에너지 구슬은 고를 수 없다.
//x번째 에너지 구슬을 제거한다.
//Wx-1 × Wx+1의 에너지를 모을 수 있다.
//N을 1 감소시키고, 에너지 구슬을 1번부터 N번까지로 다시 번호를 매긴다. 번호는 첫 구슬이 1번, 다음 구슬이 2번, ... 과 같이 매겨야 한다.
//N과 에너지 구슬의 무게가 주어졌을 때, 모을 수 있는 에너지 양의 최댓값을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 에너지 구슬의 개수 N(3 ≤ N ≤ 10)이 주어진다.
//
//둘째 줄에는 에너지 구슬의 무게 W1, W2, ..., WN을 공백으로 구분해 주어진다. (1 ≤ Wi ≤ 1,000)
//
//출력
//첫째 줄에 모을 수 있는 에너지의 최댓값을 출력한다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16198_에너지모으기 {
	static int N, max = Integer.MIN_VALUE;
	static List<Integer> marble = new ArrayList<>();;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16198_에너지모으기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = toInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			marble.add(toInt(st.nextToken()));
		}
		marbleComb(0, 0);
		System.out.println(max);
	}

	static void marbleComb(int cnt, int sum) {
		if (N == 3) {
			max = Math.max(max, sum + marble.get(0) * marble.get(2));
			return;
		}
		for (int i = 1; i < N - 1; i++) {
			int mid = marble.get(i);
			marble.remove(i);
			N--;
			marbleComb(cnt + 1, sum + marble.get(i - 1) * marble.get(i));
			marble.add(i, mid);
			N++;
		}
	}

	static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
