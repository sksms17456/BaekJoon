package BaekJoon;

import java.io.*;

public class Main_1475_방번호 {
	static int cnt;
	static char[] line;
	static int[] arr = {0,1,2,3,4,5,6,7,8,9};
	static boolean[] linev, arrv = new boolean[10];
	static boolean isStop=false;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_1475_방번호.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().trim().toCharArray();
		linev = new boolean[line.length];
		while(!isStop) {
			isStop=true;
			for(int i=0; i<line.length; i++) {
				if(!linev[i]) {
					isStop=false;
					int n = line[i]-'0';
					if(n==6 || n==9) {
						if(!arrv[6]) {
							arrv[6] = true;
							linev[i] = true;
						}else if(!arrv[9]) {
							arrv[9] = true;
							linev[i] = true;
						}
					}
					else {
						if(!arrv[n]) {
							arrv[n] = true;
							linev[i] = true;
						}
					}
				}
			}		
			if(isStop)
				break;
			cnt++;
		}	
		System.out.println(cnt);
	}
}
