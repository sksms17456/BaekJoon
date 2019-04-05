package BaekJoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {
	static int N, d, k, c, cnt, ans;
	static int[] arr;
	static int[] chobap = new int[3001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_15961_회전초밥.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[N+k-1];
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int idx=0;
		for(int i=N; i<arr.length; i++) {
			arr[i] = arr[idx++];
		}
		for(int i=0; i<k; i++) {
			cnt=0;
			chobap[arr[i]]++;
			set.add(arr[i]);
		}
		if(!set.contains(c)) {
			cnt++;
		}
		cnt+=set.size();
		ans = cnt;
		for(int i=1; i<N; i++) {
			cnt=0;
			if(chobap[arr[i-1]]==1) {
				set.remove(arr[i-1]);
			}
			chobap[arr[i-1]]--;
			set.add(arr[i+k-1]);
			chobap[arr[i+k-1]]++;
			if(!set.contains(c)) {
				cnt++;
			}
			cnt+=set.size();
			ans=Math.max(cnt, ans);
		}
		System.out.println(ans);
	}
}
