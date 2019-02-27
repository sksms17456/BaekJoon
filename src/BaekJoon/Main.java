package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import java.util.Arrays;

public class Main {
	static int[][] pos = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static boolean[][] visited;
	static int L, W, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		L = Integer.parseInt(input[0]);
		W = Integer.parseInt(input[1]);
		map = new char[L][W];
		visited = new boolean[L][W];

		for (int i = 0; i < L; i++) {
			map[i] = br.readLine().toCharArray();
		}

//		for (int i = 0; i < L; i++) {
//			for (int j = 0; j < W; j++) {
//				if (map[i][j] == 'L') {
//					bfs(i, j);
//                    for(int k=0; k<L; k++){
//                        Arrays.fill(visited[k],false);
//                    }
//				}
//			}
//		}
		bfs(3,0);
		System.out.println(max);
	}

	private static void bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { row, col, 0 });

		int[] temp;
		int nr, nc, dist = 0;

		while (!queue.isEmpty()) {
			temp = queue.poll();
			
			nr = temp[0];
			nc = temp[1];
			dist = temp[2];

			if (visited[nr][nc]) {
				continue;
			}
			
			visited[nr][nc] = true;

			for (int i = 0; i < pos.length; i++) {
				nr = temp[0] + pos[i][0];
				nc = temp[1] + pos[i][1];

				if (nr >= 0 && nr < L && nc >= 0 && nc < W) {
					if (map[nr][nc] == 'L'&&!visited[nr][nc]) {
						queue.offer(new int[] { nr, nc, temp[2] + 1 });
					}
				}
			}
		}
		System.out.println(row+" "+col+" "+dist);
		max = Math.max(max, dist);
	}
}