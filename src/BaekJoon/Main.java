package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, M, sr, sc, sd;
	static int[][] map;
	static boolean[][] visit;
	static int count;
	static int[][] pos = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]); // row
		M = Integer.parseInt(input[1]); // col
		map = new int[N][M];
		visit = new boolean[N][M];

		input = br.readLine().split(" ");
		sr = Integer.parseInt(input[0]);
		sc = Integer.parseInt(input[1]);
		sd = Integer.parseInt(input[2]);
		visit[sr][sc] = true;
		count = 1;

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		search(sr, sc, sd);

		System.out.println(count);
	}

	private static void search(int row, int col, int dir) {
		int nr, nc, nextDir = dir;

		for (int i = 0; i < 4; i++) {
			nextDir = (nextDir + 3) % 4;
			nr = row + pos[nextDir][0];
			nc = col + pos[nextDir][1];

			if (map[nr][nc] != 1) {
				if (!visit[nr][nc]) {
					visit[nr][nc] = true;
					count++;
					search(nr, nc, nextDir);
				}
			}
		}

		if (dir == 0) {
			nr = row + 1;
			nc = col;
		} else if (dir == 1) {
			nr = row;
			nc = col - 1;
		} else if (dir == 2) {
			nr = row - 1;
			nc = col;
		} else {
			nr = row;
			nc = col + 1;
		}

		if (map[nr][nc] != 1) {
			search(nr, nc, dir);
		} else {
			return;
		}
	}
}
