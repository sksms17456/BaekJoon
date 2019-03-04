package BaekJoon;

import java.io.*;

public class Main_16922_로마숫자만들기{
	static int N, cnt, sum;
	static int[] arr = new int[1001];
	static int[] roma = {1,5,10,50};
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new FileReader("res/Main_16922_로마숫자만들기.txt"));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		comb(0,0,0);
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>0)
				cnt++;
		}
		
		System.out.println(cnt);
	}
	private static void comb(int cnt, int sum, int k) {
		if(cnt==N) {
			arr[sum]++;
			return;
		}
		for(int i=0; i<4; i++) {
			if(roma[i]>=k) {
				comb(cnt+1, sum+roma[i], roma[i]);
			}
		}
	}
}