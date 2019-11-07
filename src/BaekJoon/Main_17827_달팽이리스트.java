package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17827_달팽이리스트 {
	static int node, question, pointNode;
	static int[] snail;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/Main_17827_달팽이리스트.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		node = toInt(st.nextToken());
		question = toInt(st.nextToken());
		pointNode = toInt(st.nextToken());
		snail = new int[node+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<node+1; i++) {
			int value = toInt(st.nextToken());
			snail[i] = value;
		}
		for(int i=0; i<question; i++) {
			int idx = toInt(br.readLine());
			sb.append(getValue(idx)).append("\n");
		}
		System.out.println(sb);
		
	}
	static int getValue(int idx) {
		return idx;
	}
	static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
