//문제
//초기에 {0}, {1}, {2}, ... {n} 이 각각 n+1개의 집합을 이루고 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
//
//집합을 표현하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 n(1≤n≤1,000,000), m(1≤m≤100,000)이 주어진다. m은 입력으로 주어지는 연산의 개수이다. 다음 m개의 줄에는 각각의 연산이 주어진다. 합집합은 0 a b의 형태로 입력이 주어진다. 이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다. 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다. 이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다. a와 b는 n 이하의 자연수또는 0이며 같을 수도 있다.
//
//출력
//1로 시작하는 입력에 대해서 한 줄에 하나씩 YES/NO로 결과를 출력한다. (yes/no 를 출력해도 된다)
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717_집합의표현 {
	static int n, m, a, b, order;
	static int[] root;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_1717_집합의표현.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = toInt(st.nextToken());
		m = toInt(st.nextToken());
		root = new int[n+1];
		init();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			order = toInt(st.nextToken());
			a = toInt(st.nextToken());
			b = toInt(st.nextToken());
			switch (order) {
			case 0:
				union(a, b);
				break;
			default:
				sb.append(hasSameRoot(a, b));
				break;
			}
		}
		System.out.println(sb);
	}
	static String hasSameRoot(int a, int b) {
		return find(a)==find(b) ? "YES\n":"NO\n";
	}
	static int find(int n) {
		if(root[n] == n) {
			return n;
		}else {
			return root[n] = find(root[n]);
		}
	}
	static void union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		if(roota!=rootb) {
			root[rootb]=roota;
		}
	}
	static void init() {
		for(int i=0; i<=n; i++) {
			root[i] = i;
		}
	}
	static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
