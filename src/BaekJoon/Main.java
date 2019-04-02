package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int N, x, count;
	static int[][] map;
	static boolean ok;
	static int[] check;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/etc_4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		String[] input;

		for (int t = 1; t <= 1; t++) {
			input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]); // 맵의 크기
			x = Integer.parseInt(input[1]); // 경사로의 길이. 높이는 항상 1
			map = new int[N][N];
			check = new int[N];
			count = 0;

			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}

			Arrays.fill(check, -1);
			int cnt;
//			가로 탐색
			for (int i = 0; i < N; i++) {
				ok = true;
				top: for (int j = 0; j < N - 1; j++) {
					if (Math.abs(map[i][j] - map[i][j + 1]) > 1) {
						ok = false;
						break;
					}
					if (map[i][j] < map[i][j + 1]) {
						cnt = 0;
						for (int k = j; k >= 0; k--) {
							if (check[k] != i && map[i][j] == map[i][k]) {
								check[k] = i;
								cnt++;
							} else {
								if (check[k] == i) {
									ok = false;
									break top;
								} else if (cnt >= x) {
									j = k - 1;
									break;
								} else {
									ok = false;
									break top;
								}
							}
						}
					} else if (map[i][j] > map[i][j + 1]) {
						cnt = 0;
						for (int k = j + 1; k < N; k++) {
							if (check[k] != i && map[i][j + 1] == map[i][k]) {
								check[k] = i;
								cnt++;
							} else {
								if (check[k] == i) {
									ok = false;
									break top;
								} else if (cnt >= x) {
									j = k - 1;
									break;
								} else {
									ok = false;
									break top;
								}
							}
						}
					}
				}
				if (ok) {
					System.out.println(i);
					count++;
				}
			}

			Arrays.fill(check, -1);
//			세로 탐색
			for (int j = 0; j < N; j++) {
				ok = true;
				top: for (int i = 0; i < N - 1; i++) {
					if (Math.abs(map[i][j] - map[i + 1][j]) > 1) {
						ok = false;
						break;
					}
					if (map[i][j] < map[i + 1][j]) {
						cnt = 0;
						for (int k = i; k >= 0; k--) {
							if (check[k] != j && map[i][j] == map[k][j]) {
								check[k] = j;
								cnt++;
							} else {
								if (check[k] == j) {
									ok = false;
									break top;
								} else if (cnt >= x) {
									i = k - 1;
									break;
								} else {
									ok = false;
									break top;
								}
							}
						}
					} else if (map[i][j] > map[i + 1][j]) {
						cnt = 0;
						for (int k = i + 1; k < N; k++) {
							if (check[k] != j && map[i + 1][j] == map[k][j]) {
								check[k] = j;
								cnt++;
							} else {
								if (check[k] == j) {
									ok = false;
									break top;
								} else if (cnt >= x) {
									i = k - 1;
									break;
								} else {
									ok = false;
									break top;
								}
							}
						}
					}
				}
				if (ok) {
					System.out.println(j);
					count++;
				}
			}
			bw.write("#" + t + " " + count + "\n");
		}
		bw.close();
	}
}

