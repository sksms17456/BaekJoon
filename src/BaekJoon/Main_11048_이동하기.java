//문제
//준규는 N×M 크기의 미로에 갇혀있다. 미로는 1×1크기의 방으로 나누어져 있고, 각 방에는 사탕이 놓여져 있다. 미로의 가장 왼쪽 윗 방은 (1, 1)이고, 가장 오른쪽 아랫 방은 (N, M)이다.
//
//준규는 현재 (1, 1)에 있고, (N, M)으로 이동하려고 한다. 준규가 (r, c)에 있으면, (r+1, c), (r, c+1), (r+1, c+1)로 이동할 수 있고, 각 방을 방문할 때마다 방에 놓여져있는 사탕을 모두 가져갈 수 있다. 또, 미로 밖으로 나갈 수는 없다.
//
//준규가 (N, M)으로 이동할 때, 가져올 수 있는 사탕 개수의 최댓값을 구하시오.
//
//입력
//첫째 줄에 미로의 크기 N, M이 주어진다. (1 ≤ N, M ≤ 1,000)
//
//둘째 줄부터 N개 줄에는 총 M개의 숫자가 주어지며, r번째 줄의 c번째 수는 (r, c)에 놓여져 있는 사탕의 개수이다. 사탕의 개수는 0보다 크거나 같고, 100보다 작거나 같다.
//
//출력
//첫째 줄에 준규가 (N, M)으로 이동할 때, 가져올 수 있는 사탕 개수를 출력한다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11048_이동하기 {
	static int N, M;
	static int[] maze;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/Main_11048_이동하기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = toInt(st.nextToken());
		M = toInt(st.nextToken());
		maze = new int[M];

		st = new StringTokenizer(br.readLine());
		maze[0] = toInt(st.nextToken());
		for (int i = 1; i < M; i++) {
			maze[i] = maze[i - 1] + toInt(st.nextToken());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			maze[0] += toInt(st.nextToken());
			for (int j = 1; j < M; j++) {
				maze[j] = getMax(toInt(st.nextToken()), j);
			}
		}
		System.out.println(maze[M - 1]);
	}

	static int getMax(int candy, int idx) {
		return maze[idx - 1] > maze[idx] ? maze[idx - 1] + candy : maze[idx] + candy;
	}

	static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
