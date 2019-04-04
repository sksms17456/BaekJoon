//문제 
//
//온 나라가 고통받았던 전쟁이 끝났습니다. 전쟁을 교훈삼아, Ardenia의 수도의 방어선을 탄탄하게 할 때가 되었습니다. 
//
//방어선 중 가장 핵심적인 부분은 수도에서 북쪽 숲으로 뻗어나가는 메이지 타워입니다. 
//
//메이지 타워에서 Ardenia를 지키는 마법사들은 Ardenia의 왕인 당신에게 방어에 대한 한 가지 조언을 하였습니다. 
//
//적군에게 에너지 볼트를 쓰는 것에 관한 긴 설명을 하긴 했지만, 결국 당신이 이해하기로는 도시의 방어의 질은 높이가 증가하는 순서대로의 연속된 타워들 중 가장 길이가 긴 것에 의해 결정된다는 것입니다
//
//새로운 타워를 짓는 것은 불가능한 것으로 보이고, 일단은 몇 개의 타워를 없애서 도시의 방어의 질을 높이려고 합니다. (타워를 없애지 않아도 됩니다.) 
//
//타워를 없애는 일이 복잡하기 때문에, 마법사들이 한 가지 조건을 걸었습니다: 없애는 타워들은 연속해야 합니다.
//
//예를 들어, 타워들의 높이가 5, 3, 4, 9, 2, 8, 6, 7, 1 이었다고 합시다. 
//
//밑줄 친 (연속한) 타워들을 없애면, 높이가 5, 3, 4, 6, 7, 1인 타워들이 남고, 여기서 가장 긴 연속한 증가하는 부분은 굵게 표시한 3, 4, 6, 7이 됩니다.
//
//입력 
//
//입력은 여러 개의 테스트 케이스로 이루어져 있습니다.
//
//첫째 줄에는 테스트 케이스의 개수 Z ≤ 25 가 주어집니다.
//
//이후 두 줄씩 입력이 주어지는데, 첫째 줄은 타워의 수를 나타내는 양의 정수 n ≤ 2 · 105 이 주어집니다.
//
//둘째 줄에는 109 이하인 양의 정수 n개가 공백으로 구분되어 주어집니다.
//
//출력 
//
//각각의 테스트 케이스에 대해, 몇 개의 연속한 타워를 없애서 만들 수 있는 가장 긴 연속한 증가하는 타워들의 길이를 출력하세요.
package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3429_방어선 {
	static int T, N, idx;
	static int[] dp;
	public static void main(String[] args) throws  Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_3429_방어선.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc=0; tc<T; tc++) {
			idx=0;
			N = Integer.parseInt(br.readLine());
			dp = new int[N+1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<N+1; i++) {
				int num = Integer.parseInt(st.nextToken());
				int n = binarySearch(num);
				dp[n] = num;
				if(idx<n) idx=n;
			}
			sb.append(idx).append("\n");
		}
		System.out.println(sb);
	}
	private static int binarySearch(int num) {
		int start=0;
		int end=dp.length-1;
		while(start<=end) {
			int middle = (start+end)/2;
			if(dp[middle]<num) {
				if(dp[middle+1]>num) {
					return middle+1;
				}else {
					start = middle+1;
				}
			}
			else if(dp[middle]>num) {
				end=middle-1;
			}
		}
		return -1;
	}
}

