//문제
//이 모든 사건의 시작은 2주 전이었다. 그 날 상근이는 복도에 누워서 잠을 자고 있었다. 커다란 돌을 들고 그 옆을 지나가던 민혁이는 복도에서 잠을 자는 사람을 처음봐서 신기하게 쳐다보고 있었다. 그 때였다. 들고 있던 돌을 상근이의 왼 발에 떨어뜨렸다. 상근이는 응급실로 실려갔고, 한 달 동안 침대에 누워서 휴식을 취해야 한다는 진단을 받았다. 민혁이는 미안한 마음에 하던 일을 모두 중단하고 상근이를 간호하기로 했다.
//
//상근이는 2주 동안 온라인 저지 문제를 풀었다. 2주 동안 문제를 풀다보니 게임을 하고 싶어졌고, 마침 민혁이를 이용해서 게임을 하기로 했다.
//
//상근이의 게임은 R×C 보드를 세워놓은 상태에서 진행한다. 맨 처음에 각 정사각형 칸은 비어있거나 벽으로 막혀있다. 상근이는 민혁이에게 돌을 떨어놓을 열을 지시하고, 민혁이는 가장 윗 행의 그 열에 돌을 놓는다. 돌을 놓은 이후에는 중력에 의해서 돌이 떨어지게 된다.
//
//돌에 작용하는 중력은 다음과 같다.
//
//돌의 아랫칸이 벽으로 막혀있거나 가장 아랫줄이라면, 돌은 그 자리에 그대로 멈춰 있는다.
//돌의 아랫칸이 비어있다면, 돌은 아랫칸으로 이동한다.
//돌의 아랫칸에 돌이 있다면, 돌은 다음과 같이 미끄러진다.
//만약 돌의 왼쪽 칸과 왼쪽-아래 칸이 비어있다면, 돌은 왼쪽으로 미끄러진다.
//만약 돌이 왼쪽으로 미끄러지지 않았고, 오른쪽 칸과 오른쪽-아래 칸이 비어있다면, 돌은 오른쪽으로 미끄러진다.
//위의 두 경욱 아니라면 돌은 그 자리에 멈추고, 다시는 움직이지 않는다.
//민혁이는 돌의 이동이 멈춘 이후에 다른 돌을 던지기 시작한다.
//
//보드의 초기 상태와 민혁이가 돌을 놓은 열의 번호가 순서대로 가 주어졌을 때, 모든 돌을 던진 이후에 보드의 상태를 구하는 프로그램을 작성하시오.
//
//민혁이는 항상 제일 윗 칸이 비어있는 칸에만 돌을 던진다. 
//
//입력
//첫째 줄에 보드의 크기 R과 C가 주어진다. (1 ≤ R ≤ 30,000, 1 ≤ C ≤ 30)
//
//다음 R개 줄에는 C개의 문자가 주어지며, 보드의 초기 상태이다. '.'는 빈 칸, 'X'는 벽으로 막힌 곳을 나타낸다.
//
//다음 줄에는 돌을 던친 횟수 N이 주어진다. (1 ≤ N ≤ 100,000)
//
//다음 N개 줄에는 돌을 던진 열의 위치가 순서대로 주어진다. (가장 왼쪽 열의 번호는 1번)
//
//출력
//총 R개 줄에 걸쳐서 보드의 게임이 모두 끝난 후의 상태를 출력한다. 돌은 'O'로 출력한다.
package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3025_돌던지기 {
	static int R, C, N, n;
	static char[][] map;
	static int[] high;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_3025_돌던지기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		high = new int[C];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i=0; i<R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		N = Integer.parseInt(br.readLine().trim());
		for(int i=0; i<N; i++) {
			n = Integer.parseInt(br.readLine().trim());
			
		}
	}
}
