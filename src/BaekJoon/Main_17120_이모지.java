package BaekJoon;

import java.io.*;

public class Main_17120_이모지 {
	static String emoji = ":cat:", line;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_17120_이모지.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			line = br.readLine();
			if(line == null) {
				break;
			}
			if(line.contains(emoji)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
