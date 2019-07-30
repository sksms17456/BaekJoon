package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main_17228_아름다운만영로 {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_17228_아름다운만영로.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
		}
	}

}
