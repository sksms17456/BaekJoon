//문제 
//
//KSG 편의점에서는 과일우유, 드링킹요구르트 등의 유제품을 '2+1 세일'하는 행사를 하고 있습니다. 
//
//KSG 편의점에서 유제품 3개를 한 번에 산다면 그중에서 가장 싼 것은 무료로 지불하고 나머지 두 개의 제품 가격만 지불하면 됩니다. 
//
//한 번에 3개의 유제품을 사지 않는다면 할인 없이 정가를 지불해야 합니다.
//
//예를 들어, 7개의 유제품이 있어서 각 제품의 가격이 10, 9, 4, 2, 6, 4, 3이고 재현이가 (10, 3, 2), (4, 6, 4), (9)로 총 3번에 걸쳐서 물건을 산다면 첫 번째 꾸러미에서는 13원을, 
//
//두 번째 꾸러미에서는 10원을, 세 번째 꾸러미에서는 9원을 지불해야 합니다.
//
//재현이는 KSG 편의점에서 친구들과 같이 먹을 총 N팩의 유제품을 구입하려고 합니다. 재현이를 도와 최소비용으로 유제품을 구입할 수 있도록 도와주세요!
//
//입력 
//
//첫 번째 줄에는 유제품의 수 N (1 ≤ N ≤ 100,000)이 주어집니다.
//
//두 번째 줄부터 N개의 줄에는 각 유제품의 가격 Ci (1 ≤ Ci ≤ 100,000)가 주어집니다.
//
//출력 
//
//재현이가 N개의 유제품을 모두 살 때 필요한 최소비용을 출력합니다. 정답은 231-1보다 작거나 같다.

package BaekJoon;

import java.io.*;
import java.util.Arrays;

public class Main_11508_2쁘라스1세일 {
	static int N, sum;
	static int[] cost;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_11508_2쁘라스1세일.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N];
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(cost);
		int i = N-1;
		while(i>0) {
			sum+=cost[i-1]+cost[i];
			i -= 3;
		}
		for(int j=0; j<=i; j++) {
			sum+=cost[i];
		}
		System.out.println(sum);
	}
}
