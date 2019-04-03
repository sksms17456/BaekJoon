//문제 
//
//세계적인 도둑 상덕이는 보석점을 털기로 결심했다.
//
//상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 
//
//가방에는 최대 한 개의 보석만 넣을 수 있다.
//
//상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.
//
//입력 
//
//첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)
//
//다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)
//
//다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)
//
//모든 숫자는 양의 정수이다.
//
//출력 
//
//첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.
package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1202_보석도둑 {
	static int N, K;
	static int[] bag;
	static int[][] jewel;
	public static void main(String[] args) throws  Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_1202_보석도둑.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bag = new int[K];
		jewel = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			jewel[i][0] = Integer.parseInt(st.nextToken());
			jewel[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(jewel, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		for(int i=1; i<N; i++) {
			if(jewel[i][1]<jewel[i-1][1]) {
				jewel[i][1]=jewel[i-1][1];
			}
		}
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(jewel[i]));
		}
		for(int i=0; i<K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
	}
}
