//문제
//
//크기가 H×W인 모눈종이와 스티커 N개가 있다. i번째 스티커의 크기는 Ri×Ci이다. 모눈종이는 크기가 1×1인 칸으로 나누어져 있으며, 간격 1을 두고 선이 그어져 있다.
//
//오늘은 모눈종이에 스티커 2개를 붙이려고 한다. 스티커의 변은 격자의 선과 일치하게 붙여야 하고, 두 스티커가 서로 겹치면 안된다. 
//
//단, 스티커가 접하는 것은 가능하다. 스티커를 90도 회전시키는 것은 가능하다. 스티커가 모눈종이를 벗어나는 것은 불가능하다.
//
//두 스티커가 붙여진 넓이의 최댓값을 구해보자.
//
//입력
//
//첫째 줄에 모눈종이의 크기 H, W, 둘째 줄에 스티커의 수 N이 주어진다. 다음 N개의 줄에는 스티커의 크기 Ri, Ci가 주어진다.
//
//출력
//
//첫째 줄에 두 스티커가 붙여진 넓이의 최댓값을 출력한다. 두 스티커를 붙일 수 없는 경우에는 0을 출력한다.
//
//제한
//1 ≤ H, W, N ≤ 100
//1 ≤ Ri, Ci ≤ 100
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16937_두스티커 {
	static class Sticker{
		int h;
		int w;
		int area;
		public Sticker(int h, int w) {
			super();
			this.h = h;
			this.w = w;
			this.area = h*w;
		}
	}
	static int H, W, N, h, w, ans=0, n;
	static ArrayList<Sticker> list;
	static Sticker s1, s2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16937_두스티커.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		if(H>=W)
			n = H;
		else
			n = W;
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			if(h>n || w>n)
				continue;
			list.add(new Sticker(h,w));
		}
		for(int i=0; i<list.size(); i++) {
			s1 = list.get(i);
			for(int j=i+1; j<list.size(); j++) {
				s2 = list.get(j);
				if(s1.h+s2.h<=H || s1.w+s2.w<=W || s1.h+s2.h<=W || s1.w+s2.w<=H || 
						s1.h+s2.w<=H || s1.h+s2.w<=W || s1.w+s2.h<=H || s1.w+s2.h<=W) {
					ans = Math.max(ans, s1.area+s2.area);
				}
			}
		}
		System.out.println(ans);
	}
}
