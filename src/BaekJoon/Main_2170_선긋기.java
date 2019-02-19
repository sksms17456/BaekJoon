//문제
//
//매우 큰 도화지에 자를 대고 선을 그으려고 한다. 
//
//선을 그을 때에는 자의 한 점에서 다른 한 점까지 긋게 된다. 
//
//선을 그을 때에는 이미 선이 있는 위치에 겹쳐서 그릴 수도 있는데, 
//
//여러 번 그은 곳과 한 번 그은 곳의 차이를 구별할 수 없다고 하자.
//
//이와 같은 식으로 선을 그었을 때, 그려진 선(들)의 총 길이를 구하는 프로그램을 작성하시오. 
//
//선이 여러 번 그려진 곳은 한 번씩만 계산한다.
//
//입력
//
//첫째 줄에 선을 그은 횟수 N(1≤N≤1,000,000)이 주어진다. 
//
//다음 N개의 줄에는 선을 그을 때 선택한 두 점이 주어진다. 
//
//선택한 지점은 -1,000,000,000 이상 1,000,000,000 이하의 정수이다.
//
//출력
//
//첫째 줄에 그은 선의 총 길이를 출력한다.

package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2170_선긋기 {
	static int N, start, end, length;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2170_선긋기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		line[] linearr = new line[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());	
			
			linearr[i] = new line(start, end);			
		}
		Arrays.sort(linearr);
		
		int min = linearr[0].start;
		int max = linearr[0].end;
		
		for(int i=1; i<N; i++) {
			if(linearr[i].start<=max) {
				if(linearr[i].end<=max) {
					continue;
				}
				max = linearr[i].end;
				continue;
			}else {
				length += max-min;
				min = linearr[i].start;
				max = linearr[i].end;
			}
		}
		
		length += max-min;
		System.out.println(length);
		
	}
	
	static class line implements Comparable<line>{
		private int start, end;
		
		public line(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(line o) {
			if(this.start < o.start)return -1;
			else if(this.start > o.start) return 1;
			else if(this.end < o.end)return -1;
			else if(this.end > o.end)return 1;
			else return 0;
		}
		
	}
}
