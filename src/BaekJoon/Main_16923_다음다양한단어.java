package BaekJoon;

import java.io.*;

public class Main_16923_다음다양한단어 {
	static String line, ans;
	static boolean isAppend;
	static int len, idx;
	static char c;
	static int[] arr = new int[26];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16923_다음다양한단어.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine();
		len = line.length();
		for(int i=0; i<len; i++) {
			arr[line.charAt(i)-'a']++;
		}
		if(len==26) {
			String newline = "";
			int cnt=25;
			top:
			while(cnt>0) {
				newline = line.substring(0,cnt);
				c = line.charAt(cnt);
				arr[c-'a']--;		
				if(cnt<25) {
					for(int i=c-'a'+1; i<len; i++) {
						if(arr[i]==0) {
							newline+=(char)(i+'a');
							isAppend=true;
							ans=newline;
							break top;
						}
					}
				}
				cnt--;
			}	
		}
		else {
			for(int i=0; i<arr.length; i++) {
				if(arr[i]==0) {
					line = line+(char)(i+'a');
					isAppend=true;
					break;
				}
			}
			ans = line;
		}
		if(isAppend) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}
	}
}
