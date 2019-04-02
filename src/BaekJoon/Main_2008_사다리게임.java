//문제 
//사다리 게임을 할 때 사용되는 사다리가 있다. 세로선은 N개가 있고, 가로선은 M개가 있다. 세로선은 맨 왼쪽 것부터 1, 2, …, N의 번호가, 가로선은 맨 위의 것부터 1, 2, …, M으로 번호가 붙어 있다. 
//
//같은 높이에는 가로선이 없다고 생각하자.
//
//위의 그림은 N=4, M=3인 한 사다리이다. 이런 사다리가 있으면 A는 3으로, B는 1로, C는 4로, D는 2로 가게 된다.
//
//우리는 이 사다리를 조작해서 우리가 원하는 모양으로 만들고자 한다. 사다리를 조작할 때에는 가로선을 지우거나 새로 그릴 수 있는데, 지울 때는 X만큼의 비용이, 그릴 때는 Y만큼의 비용이 필요하다. 
//
//예를 들어 B에서 2로 가고자 한다면 1, 3번 가로선을 지우거나 3번 가로선 밑에 1-2의 가로선을 그리는 방법이 있다.
//
//위의 a번째 위치에서 아래의 b번째 위치로 갈 수 있도록 사다리를 조작할 때, 최소비용을 구하시오.
//
//입력 
//
//첫째 줄에 N(1≤N≤100), M(1≤M≤500)이 주어진다. 다음 줄에는 a, b, X, Y(0≤X, Y≤1,000)가 주어진다. 
//
//다음 M개의 줄에는 위에서부터 가로선에 대한 정보를 나타내는 정수 p가 주어진다. 이는 p번, p+1번 세로선을 연결하는 가로선을 의미한다.
//
//출력 
//
//첫째 줄에 최소 비용을 출력한다.

package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2008_사다리게임 {
	static int N, M, a, b, X, Y;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2008_사다리게임.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
	}
}
