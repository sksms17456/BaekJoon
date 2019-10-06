//문제
//길이가 N인 수식이 있다. 수식은 0보다 크거나 같고, 9보다 작거나 같은 정수와 연산자(+, -, ×)로 이루어져 있다. 연산자 우선순위는 모두 동일하기 때문에, 수식을 계산할 때는 왼쪽에서부터 순서대로 계산해야 한다. 예를 들어, 3+8×7-9×2의 결과는 136이다.
//
//수식에 괄호를 추가하면, 괄호 안에 들어있는 식은 먼저 계산해야 한다. 단, 괄호 안에는 연산자가 하나만 들어 있어야 한다. 예를 들어, 3+8×7-9×2에 괄호를 3+(8×7)-(9×2)와 같이 추가했으면, 식의 결과는 41이 된다. 하지만, 중첩된 괄호는 사용할 수 없다. 즉, 3+((8×7)-9)×2, 3+((8×7)-(9×2))은 모두 괄호 안에 괄호가 있기 때문에, 올바른 식이 아니다.
//
//수식이 주어졌을 때, 괄호를 적절히 추가해 만들 수 있는 식의 결과의 최댓값을 구하는 프로그램을 작성하시오. 추가하는 괄호 개수의 제한은 없으며, 추가하지 않아도 된다.
//
//입력
//첫째 줄에 수식의 길이 N(1 ≤ N ≤ 19)가 주어진다. 둘째 줄에는 수식이 주어진다. 수식에 포함된 정수는 모두 0보다 크거나 같고, 9보다 작거나 같다. 문자열은 정수로 시작하고, 연산자와 정수가 번갈아가면서 나온다. 연산자는 +, -, * 중 하나이다. 여기서 *는 곱하기 연산을 나타내는 × 연산이다. 항상 올바른 수식만 주어지기 때문에, N은 홀수이다.
//
//출력
//첫째 줄에 괄호를 적절히 추가해서 얻을 수 있는 결과의 최댓값을 출력한다. 정답은 231보다 작고, -231보다 크다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main_16637_괄호추가하기 {
	static int N, len, max = Integer.MIN_VALUE;
	static int[] v;
	static String expression;
	static ArrayList<String> calclist = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16637_괄호추가하기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		expression = br.readLine();
		for (int i = 0; i < N - 2;) {
			calclist.add(calc(new String[] { String.valueOf(expression.charAt(i)),
					String.valueOf(expression.charAt(i + 1)), String.valueOf(expression.charAt(i + 2)) }));
			i += 2;
		}
		len = calclist.size();
		v = new int[len + 1];
		calcAns();
		for (int i = 1; i <= len / 2; i++) {
			selectBracket(0, 0, i);
		}
		System.out.println(max);
	}

	static void selectBracket(int idx, int nowcnt, int cnt) {
		if (nowcnt == cnt) {
			calcAns();
			return;
		}
		for (int i = idx; i < len; i++) {
			if (i == 0 && v[i] == 0) {
				v[i] = 1;
				selectBracket(i + 1, nowcnt + 1, cnt);
				v[i] = 0;
			} else if (v[i - 1] == 0) {
				v[i] = 1;
				selectBracket(i + 1, nowcnt + 1, cnt);
				v[i] = 0;
			}
		}

	}

	static void calcAns() {
		Stack<String> newExpstack = new Stack<>();
		for (int i = 0; i < N; i++) {
			if (v[i / 2] == 1) {
				newExpstack.add(0, calclist.get(i / 2));
				i += 2;
			} else {
				newExpstack.add(0, String.valueOf(expression.charAt(i)));
			}
		}
		while (newExpstack.size() != 1) {
			newExpstack.push(
					calc(new String[] { newExpstack.pop(), newExpstack.pop(), newExpstack.pop() }));
		}
		max = Math.max(max, Integer.parseInt(newExpstack.pop()));
	}

	static String calc(String[] calcarr) {
		switch (calcarr[1]) {
		case "+":
			return String.valueOf(Integer.parseInt(calcarr[0]) + Integer.parseInt(calcarr[2]));
		case "-":
			return String.valueOf(Integer.parseInt(calcarr[0]) - Integer.parseInt(calcarr[2]));
		case "*":
			return String.valueOf(Integer.parseInt(calcarr[0]) * Integer.parseInt(calcarr[2]));
		}
		return "";
	}
}
