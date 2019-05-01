package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_10797_10부제 {
	static int n, cnt;
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_10797_10부제.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<5; i++) {
			if(Integer.parseInt(st.nextToken())==n)
				cnt++;
		}
		System.out.println(cnt);
	}
}
