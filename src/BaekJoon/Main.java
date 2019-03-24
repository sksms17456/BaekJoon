package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	static int N, T, M, start, end, min;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16985_텔레포트.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			min=Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken())-1;
			end = Integer.parseInt(st.nextToken())-1;
			int[] s = list.get(start);
			int[] e = list.get(end);
			if(s[0]==0 && e[0]==1) {
				for(int j=0; j<list.size(); j++) {
					if(list.get(j)[0]==1 && j!=end) {
						min = Math.min(min, T+Math.abs(s[1]-list.get(j)[1])+Math.abs(s[2]-list.get(j)[2]));
					}
				}
				sb.append(min).append("\n");
				continue;
			}
			else if(s[0]==1 && e[0]==0) {
				for(int j=0; j<list.size(); j++) {
					if(list.get(j)[0]==1 && j!=start) {
						min = Math.min(min, T+Math.abs(e[1]-list.get(j)[1])+Math.abs(e[2]-list.get(j)[2]));
					}
				}
				sb.append(min).append("\n");
				continue;
			}
			else if(s[0]==1 && e[0]==1) {
				min = Math.min(T, Math.abs(s[1]-e[1])+Math.abs(s[2]-e[2]));
				sb.append(min).append("\n");
				continue;
			}
			else {
				int smin=Integer.MAX_VALUE;
				int emin=Integer.MAX_VALUE;
				for(int j=0; j<list.size(); j++) {
					if(list.get(j)[0]==1 && j!=end) {
						smin = Math.min(smin, T+Math.abs(s[1]-list.get(j)[1])+Math.abs(s[2]-list.get(j)[2]));
					}
				}
				for(int j=0; j<list.size(); j++) {
					if(list.get(j)[0]==1 && j!=start) {
						emin = Math.min(emin, T+Math.abs(s[1]-list.get(j)[1])+Math.abs(s[2]-list.get(j)[2]));
					}
				}
				min = Math.min(Math.abs(s[1]-e[1])+Math.abs(s[2]-e[2]), T+emin+smin);
				sb.append(min).append("\n");
				continue;
			}
			
		}
		System.out.println(sb);
	}
}