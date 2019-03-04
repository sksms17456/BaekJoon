package BaekJoon;

import java.io.*;

public class Main_16923_다음다양한단어 {
	static String line, ans;
	static boolean isAppend;
	static int len, idx;
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
			if(line.charAt(0)!='z') {
				idx = line.indexOf("z");
				String subline = line.substring(idx,len);
				String newline = line.substring(0,idx-1);
				for(int i=0; i<subline.length(); i++) {
					arr[subline.charAt(i)-'a']--;
				}
				for(int i=0; i<arr.length; i++) {
					if(arr[i]==0) {
						newline = newline+(char)(i+'a');
						isAppend=true;
						break;
					}
				}
				ans = newline;
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
