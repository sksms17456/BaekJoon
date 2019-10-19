//문제
//민혁이는 소셜 네트워크 사이트에서 친구를 만드는 것을 좋아하는 친구이다. 우표를 모으는 취미가 있듯이, 민혁이는 소셜 네트워크 사이트에서 친구를 모으는 것이 취미이다.
//
//어떤 사이트의 친구 관계가 생긴 순서대로 주어졌을 때, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
//
//친구 네트워크란 친구 관계만으로 이동할 수 있는 사이를 말한다.
//
//입력
//첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스의 첫째 줄에는 친구 관계의 수 F가 주어지며, 이 값은 100,000을 넘지 않는다. 다음 F개의 줄에는 친구 관계가 생긴 순서대로 주어진다. 친구 관계는 두 사용자의 아이디로 이루어져 있으며, 알파벳 대문자 또는 소문자로만 이루어진 길이 20 이하의 문자열이다.
//
//출력
//친구 관계가 생길 때마다, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_4195_친구네트워크 {
	static int F, size = 200000, cnt;
	static int[] root = new int[size], rootcnt = new int[size];
	static String parent, child;
	static Map<String, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/Main_4195_친구네트워크.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0, T = toInt(br.readLine()); tc < T; tc++) {
			init();
			F = toInt(br.readLine());
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				parent = st.nextToken();
				child = st.nextToken();
				sb.append(union(getIdx(parent), getIdx(child))).append("\n");
			}
		}
		System.out.println(sb);
	}

	static int getIdx(String name) {
		if (map.containsKey(name)) {
			return map.get(name);
		}
		map.put(name, cnt++);
		return map.get(name);
	}

	static int find(int n) {
		return root[n] == n ? n : (root[n] = find(root[n]));
	}

	static int union(int parent, int child) {
		int rootp = find(parent);
		int rootc = find(child);
		if (rootp != rootc) {
			root[rootc] = rootp;
			rootcnt[rootp] += rootcnt[rootc];
			rootcnt[rootc] = 1;
		}
		return rootcnt[rootp];
	}

	static void init() {
		cnt = 0;
		map = new HashMap<>();
		for (int i = 0; i < size; i++) {
			root[i] = i;
			rootcnt[i] = 1;
		}
	}

	static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
