package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_5052_전화번호목록 {
	static int t, n;
	static String[] pnumarr;
	static boolean isYes;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_5052_전화번호목록.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			isYes=false;
			n = Integer.parseInt(br.readLine());
			pnumarr = new String[n];
			for(int i=0; i<n; i++) {
				pnumarr[i] = br.readLine();
			}
			Arrays.sort(pnumarr);
			for(int i=0; i<n-1; i++) {
				if(pnumarr[i+1].contains(pnumarr[i])) {
					System.out.println("NO");
					isYes=true;
					break;
				}
			}
			if(!isYes) {
				System.out.println("YES");
			}			
		}
	}
}
