package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int k, w, h, map[][], ans;
	static boolean visit[][][];
	static int hx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int hy[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int mx[] = { -1, 1, 0, 0 };
	static int my[] = { 0, 0, -1, 1 };

	public static boolean isMove(int x, int y, int k) {
		if (x < 0 || y < 0 || x >= h || y >= w || visit[x][y][k] || map[x][y] == 1)
			return false;
		return true;
	}

	public static void solve() {
		LinkedList<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0, 0, 0 }); // x, y, num, cnt
		visit[0][0][0] = true;
		while (!q.isEmpty()) {
			int tmp[] = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			int num = tmp[2];
			int cnt = tmp[3];

			if (x == h - 1 && y == w - 1) {
				System.out.println(cnt);
				return;
			}

			if (num < k) {
				for (int i = 0; i < 8; i++) {
					int nx = x + hx[i];
					int ny = y + hy[i];

					if (isMove(nx, ny, num + 1)) {
						visit[nx][ny][num + 1] = true;
						q.offer(new int[] { nx, ny, num + 1, cnt + 1 });
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + mx[i];
				int ny = y + my[i];

				if (isMove(nx, ny, num)) {
					visit[nx][ny][num] = true;
					q.offer(new int[] { nx, ny, num, cnt + 1 });
				}
			}
		}
		
		System.out.println("-1");
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_1600_말이되고픈원숭이.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		String line[] = br.readLine().split(" ");
		w = Integer.parseInt(line[0]);
		h = Integer.parseInt(line[1]);

		map = new int[w][h];
		for (int i = 0; i < h; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		visit = new boolean[w][h][k + 1];
		solve();
	}
}