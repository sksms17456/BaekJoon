//문제 
//
//전국 자동차 경주 대회가 매년 열리고 있다. 이 대회에서는 출발지점부터 도착지점까지 거리가 워낙 멀기 때문에 경주 도중에 각 자동차는 정비소를 방문하여 정비를 받아야 한다. 
//
//정비소들은 출발지점에서 도착지점으로 가는 길가에 있으며 ①번부터 차례로 번호가 붙어 있다.
//
//이 대회에서는 참가하는 선수의 안전을 위하여 정비를 받지 않고 미리 정한 거리를 초과하여 갈 수 없도록 규칙을 정하였다. 
//
//그리고 정비소마다 정비하는데 걸리는 정비 시간이 서로 다를 수 있다.
//
//정비소에서 정비하는데 걸리는 시간을 가장 적게 하려고 할 때 최소 총 정비시간과 방문하는 정비소들을 구하는 프로그램을 작성하시오.
//
//예를 들어, 아래 그림과 같이 정비소가 5개 있고, 한 번 정비를 받고 최대 140㎞를 갈 수 있는 경우를 생각해 보자. 
//
//출발지점에서 정비소 ①까지의 거리가 100㎞이고, 정비소 ①을 방문하여 정비할 때 걸리는 시간은 5분이다.
//
//자동차가 출발지점에서 대회 규칙을 지키면서 정비소 ①, ③, ⑤를 차례대로 방문하여 도착지점까지 갈 수 있고, 정비소 ②, ④를 방문하여 갈 수도 있다. 
//
//정비소 ①, ③, ⑤를 방문하는 경우에는 16분(=5+4+7분)이 걸리는데, 이것은 정비소 ②, ④를 방문하여 걸리는 21분(=10+11분)보다 총 정비 시간이 적게 걸린다.
//
//입력 
//
//첫째 줄에는 정비를 받지 않고 갈 수 있는 최대 거리가 주어진다. 둘째 줄에는 정비소의 개수가 입력되는데 정비소 수는 100개 이하이다. 
//
//셋째 줄에는 인접한 정비소 사이의 거리가 차례로 주어진다. 넷째 줄에는 정비소별 정비 시간이 차례로 주어진다. 모든 입력은 양의 정수이다.
//
//출력 
//
//첫째 줄에 정비소에서 정비하는데 걸리는 총 정비 시간을 출력한다. 둘째 줄에 방문하는 정비소의 개수를 출력한다. 
//
//셋째 줄에는 방문하는 정비소의 번호를 한 줄에 차례로 출력하며 정비소 번호 사이에 빈칸을 하나씩 넣는다. 
//
//정비소를 전혀 방문하지 않아도 되는 경우에 총 정비 시간은 0이고 정비소 번호는 출력하지 않는다.
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2651_자동차경주대회 {
	static int M, n;
	static int[][] shop;
	static int[] dp;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2651_자동차경주대회.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		shop = new int[2][n+2];
		dp = new int[n+2];
		list = new ArrayList[n+2];
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n+1; i++) {
			shop[1][i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			shop[0][i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 0;
		for(int i=1; i<dp.length; i++) {
			dp[i]=Integer.MAX_VALUE;
			int sum=0;
			int idx=0;
			for(int j=i; j>0; j--) {
				sum+=shop[1][j];
				if(sum<=M) {
					if(dp[i]>shop[0][i]+dp[j-1]) {
						dp[i] = shop[0][i]+dp[j-1];
						idx = j-1;
					}
				}else {
					break;
				}
			}
			list[i].add(i);
			list[i].addAll(list[idx]);
		}
		System.out.println(dp[n+1]);
		System.out.println(list[n+1].size()-1);
		for(int i=list[n+1].size()-1; i>0; i--) {
			System.out.print(list[n+1].get(i)+" ");
		}
	}
}
