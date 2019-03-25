//김 프로는 수영장을 이용한다.
//김 프로는 지출이 너무 많아 1년 동안 각 달의 이용 계획을 수립하고 가장 적은 비용으로 수영장을 이용할 수 있는 방법을 찾고 있다.
//수영장에서 판매하고 있는 이용권은 아래와 같이 4 종류이다.
//    ① 1일 이용권 : 1일 이용이 가능하다.
//    ② 1달 이용권 : 1달 동안 이용이 가능하다. 1달 이용권은 매달 1일부터 시작한다.
//    ③ 3달 이용권 : 3달 동안 이용이 가능하다. 3달 이용권은 매달 1일부터 시작한다.
//        (11월, 12월에도 3달 이용권을 사용할 수 있다)
//    ④ 1년 이용권 : 1년 동안 이용이 가능하다. 1년 이용권은 매년 1월 1일부터 시작한다.
// 각 달의 이용 계획은 [Table 1]의 형태로 수립된다.
//           1월  2월  3월  4월  5월  6월  7월  8월  9월  10월  11월   12월
// 이용 계획       0일  0일  2일  9일  1일  5일  0일  0일   0일   0일  0일     0일
// 
//[Table 1]
//이용 계획에 나타나는 숫자는 해당 달에 수영장을 이용할 날의 수를 의미한다.
//각 이용권의 요금과 각 달의 이용 계획이 입력으로 주어질 때,
//가장 적은 비용으로 수영장을 이용할 수 있는 방법을 찾고 그 비용을 정답으로 출력하는 프로그램을 작성하라.
//
//[예시]
//수영장에서 판매하는 1일 이용권, 1달 이용권, 3달 이용권, 1년 이용권의 요금은 각각 10원, 40원, 100원, 300원이다.
//이 때 수영장을 이용할 수 있는 방법은 [Table 2]와 같이 다양한 경우를 생각할 수 있다.
//이용하는 방법                                         			이용권                             			비용
//1번 경우)                   			1일 이용권 17개 :      				170원
//모두 1일 이용권으로만 이용한다.     			17 * 10원 = 170원
//2번 경우)                   			1달 이용권 4개 :       				160원
//모두 1달 이용권으로만 이용한다.     			4 * 40원 = 160원
//3번 경우)
//3월은 1일 이용권으로 이용하고			1일 이용권 2개, 3달 이용권 1개 :		120원
//4월, 5월, 6월은 3달 이용권으로 이용한다.		2 * 10원 + 1 * 100원 = 120원
//4번 경우)
//3월과 5월은 1일 이용권으로 이용하고			1일 이용권 3개, 1달 이용권 2개 :		110원
//4월과 6월은 1달 이용권으로 이용한다.			3 * 10원 + 2 * 40원 = 110원
//5번 경우)
//1년 이용권으로 이용한다.				1년 이용권 1개 :				300원
// 						1 * 300원 = 300원
//[Table 2]
//다른 경우도 가능하지만, 가장 적은 비용으로 수영장을 이용한 경우는 4번 경우이다.
//따라서, 정답은 110이 된다.
//
//
//[제약 사항]
//1. 시간 제한 : 최대 50개 테스트 케이스를 모두 통과하는 데 C/C++/Java 모두 3초
//2. 모든 종류의 이용권 요금은 10 이상 3,000 이하의 정수이다.
//3. 각 달의 이용 계획은 각 달의 마지막 일자보다 크지 않다.
//[입력]
//입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고, 그 다음 줄부터 T개의 테스트 케이스가 주어진다.
//각 테스트 케이스의 첫 번째 줄에는 1일 이용권의 요금, 1달 이용권의 요금, 3달 이용권의 요금, 1년 이용권의 요금이 순서대로 한 칸씩 띄고 주어진다.
//그 다음 줄에는 1월부터 12월까지의 이용 계획이 주어진다.
//[출력]
//테스트 케이스 개수만큼 T개의 줄에 각각의 테스트 케이스에 대한 답을 출력한다.
//각 줄은 "#t"로 시작하고 공백을 하나 둔 다음 정답을 출력한다. (t는 1부터 시작하는 테스트 케이스의 번호이다)
//출력해야 할 정답은 이용 계획대로 수영장을 이용하는 경우 중 가장 적게 지출하는 비용이다

package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int T, total;
	static int[] cost, dp;
	static boolean isChange;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int t=1; t<=1; t++) {
			cost = new int[4];
			dp = new int[12];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			total=cost[3];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<12; i++) {
				dp[i] = Math.min(Integer.parseInt(st.nextToken())*cost[0],cost[1]);
			}
			System.out.println(Arrays.toString(dp)+" "+total);
		
			
			
			sb.append("#").append(t).append(" ").append(total).append("\n");
		}
		System.out.println(sb);
	}
}