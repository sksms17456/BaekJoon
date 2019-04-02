package BaekJoon;

import java.io.*;

public class Main_4811_알약 {
	static int N;
	static long[] eggdrug= {1,1,2,5,14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190, 6564120420L, 24466267020L, 91482563640L, 343059613650L, 1289904147324L, 4861946401452L, 18367353072152L, 69533550916004L, 263747951750360L, 1002242216651368L, 3814986502092304L};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_4811_알약.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			System.out.println(eggdrug[N]);
		}
	}
}
