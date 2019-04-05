//문제
//크기가 R×C인 체스판이 있고, 체스판의 각 칸에는 정수가 하나씩 적혀있다. 체스판에 적혀있는 정수는 모두 서로 다르다.
//
//체스판의 각 칸 위에 공을 하나씩 놓는다. 이제 공은 다음과 같은 규칙에 의해서 자동으로 움직인다.
//
//인접한 8방향 (가로, 세로, 대각선)에 적힌 모든 정수가 현재 칸에 적힌 수보다 크면 이동을 멈춘다.
//그 외의 경우에는 가장 작은 정수가 있는 칸으로 공이 이동한다.
//공의 크기는 매우 작아서, 체스판의 한 칸 위에 여러 개의 공이 있을 수 있다. 체스판의 상태가 주어진다. 공이 더 이상 움직이지 않을 때, 각 칸에 공이 몇 개 있는지 구해보자.
//
//입력
//첫째 줄에 체스판의 크기 R, C가 주어진다. 둘째 줄부터 R개의 줄에 체스판에 적혀있는 정수가 주어진다.
//
//출력
//총 R개의 줄에 걸쳐서 체스판에 적힌 정수를 출력한다.
//
//제한
//1 ≤ R, C ≤ 500
//0 ≤ 체스판에 적힌 정수 ≤ 300,000

package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_16957_체스판위의공 {
	static int R, C;
	static int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
	static int[][] chess;
	static int[][][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16957_체스판위의공.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		chess = new int[R][C];
		dp = new int[R][C][3];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				dp[i][j][0] = 30001;
				dp[i][j][1] = 30001;
				dp[i][j][2] = 1;
			}
		}
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				chess[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (dp[i][j][2] != 0) {
					dfs(i, j, 0);
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(dp[i][j][2] + " ");
			}
			System.out.println();
		}
	}

	private static void dfs(int r, int c, int ball) {
		int min = Integer.MAX_VALUE;
		int nr = 0, nc = 0;
		for (int i = 0; i < 8; i++) {
			int dr = r + pos[i][0];
			int dc = c + pos[i][1];
			if (isOk(dr, dc) && chess[dr][dc] < min) {
				min = chess[dr][dc];
				nr = dr;
				nc = dc;
			}
		}
		if (min < chess[r][c]) {
			if (dp[nr][nc][0] != 30001 && dp[nr][nc][1] != 30001) {
				dp[r][c][0] = dp[dp[nr][nc][0]][dp[nr][nc][1]][0];
				dp[r][c][1] = dp[dp[nr][nc][0]][dp[nr][nc][1]][1];
				dp[dp[nr][nc][0]][dp[nr][nc][1]][2] += ball + dp[r][c][2];
				dp[r][c][2] = 0;
				return;
			}
			int n = dp[r][c][2];
			dfs(nr, nc, ball + n);
			dp[r][c][0] = dp[dp[nr][nc][0]][dp[nr][nc][1]][0];
			dp[r][c][1] = dp[dp[nr][nc][0]][dp[nr][nc][1]][1];
			dp[r][c][2] = 0;
		} else {
			dp[r][c][0] = r;
			dp[r][c][1] = c;
			dp[r][c][2] += ball;
		}
	}

	private static boolean isOk(int r, int c) {
		return (r >= 0 && c >= 0 && r < R && c < C) ? true : false;
	}
}
