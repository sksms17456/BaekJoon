//문제
//재현이는 주변을 살펴보던 중 체스판과 말을 이용해서 새로운 게임을 만들기로 했다. 새로운 게임은 크기가 N×N인 체스판에서 진행되고, 사용하는 말의 개수는 K개이다. 말은 원판모양이고, 하나의 말 위에 다른 말을 올릴 수 있다. 체스판의 각 칸은 흰색, 빨간색, 파란색 중 하나로 색칠되어있다.
//
//게임은 체스판 위에 말 K개를 놓고 시작한다. 말은 1번부터 K번까지 번호가 매겨져 있고, 이동 방향도 미리 정해져 있다. 이동 방향은 위, 아래, 왼쪽, 오른쪽 4가지 중 하나이다.
//
//턴 한 번은 1번 말부터 K번 말까지 순서대로 이동시키는 것이다. 한 말이 이동할 때 위에 올려져 있는 말도 함께 이동한다. 말의 이동 방향에 있는 칸에 따라서 말의 이동이 다르며 아래와 같다. 
//
//A번 말이 이동하려는 칸이
//흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
//A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동한다.
//예를 들어, A, B, C로 쌓여있고, 이동하려는 칸에 D, E가 있는 경우에는 A번 말이 이동한 후에는 D, E, A, B, C가 된다.
//빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다.
//A, B, C가 이동하고, 이동하려는 칸에 말이 없는 경우에는 C, B, A가 된다.
//A, D, F, G가 이동하고, 이동하려는 칸에 말이 E, C, B로 있는 경우에는 E, C, B, G, F, D, A가 된다.
//파란색인 경우에는 A번 말의 이동 방향을 반대로 하고 한 칸 이동한다. 방향을 반대로 한 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 방향만 반대로 바꾼다.
//체스판을 벗어나는 경우에는 파란색과 같은 경우이다.
//다음은 크기가 4×4인 체스판 위에 말이 4개 있는 경우이다.
//
//
//
//첫 번째 턴은 다음과 같이 진행된다.
//
//			
//두 번째 턴은 다음과 같이 진행된다.
//
//			
//체스판의 크기와 말의 위치, 이동 방향이 모두 주어졌을 때, 말 4개 이상이 쌓인 가장 첫 턴을 구해보자.
//
//입력
//첫째 줄에 체스판의 크기 N, 말의 개수 K가 주어진다. 둘째 줄부터 N개의 줄에 체스판의 정보가 주어진다. 체스판의 정보는 정수로 이루어져 있고, 각 정수는 칸의 색을 의미한다. 0은 흰색, 1은 빨간색, 2는 파란색이다.
//
//다음 K개의 줄에 말의 정보가 1번 말부터 순서대로 주어진다. 말의 정보는 세 개의 정수로 이루어져 있고, 순서대로 행, 열의 번호, 이동 방향이다. 행과 열의 번호는 1부터 시작하고, 이동 방향은 4보다 작거나 같은 자연수이고 1부터 순서대로 →, ←, ↑, ↓의 의미를 갖는다.
//
//같은 칸에 말이 두 개 이상 있는 경우는 입력으로 주어지지 않는다.
//
//출력
//말 4개 이상이 쌓인 가장 첫 턴을 출력한다. 그 값이 1,000보다 크거나 절대로 말 4개 이상이 쌓이지 않는 경우에는 -1을 출력한다.
//
//제한
//4 ≤ N ≤ 12
//4 ≤ K ≤ 10
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17837_새로운게임2 {
	static int N, K, r, c, dir, turn = 1, idx;
	static int[][] color, pos = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static ArrayList<int[]>[][] chess;
	static Map<Integer, int[]> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/Main_17837_새로운게임2.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = toInt(st.nextToken());
		K = toInt(st.nextToken());
		color = new int[N][N];
		chess = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				color[i][j] = toInt(st.nextToken());
				chess[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			r = toInt(st.nextToken()) - 1;
			c = toInt(st.nextToken()) - 1;
			dir = toInt(st.nextToken());
			chess[r][c].add(new int[] { i, dir });
			map.put(i, new int[] { r, c });
		}
		System.out.println(move());
	}

	static int move() {
		while (turn <= 1000) {
			for (int i = 0; i < K; i++) {
				int[] location = map.get(i);
				r = location[0];
				c = location[1];
				for (int j = 0; j < chess[r][c].size(); j++) {
					if (chess[r][c].get(j)[0] == i) {
						idx = j;
						dir = chess[r][c].get(idx)[1];
						int nr = r + pos[dir][0];
						int nc = c + pos[dir][1];
						if (isBlue(nr, nc)) {
							dir = newDir();
							int revNr = r + pos[dir][0];
							int revNc = c + pos[dir][1];
							horseToRev();
							if (!isBlue(revNr, revNc)) {
								if (isOverFour(revNr, revNc)) {
									return turn;
								}
								whiteOrRed(color[revNr][revNc], revNr, revNc);
							}
						} else {
							if (isOverFour(nr, nc)) {
								return turn;
							}
							whiteOrRed(color[nr][nc], nr, nc);
						}
					}
				}
			}
			turn++;
		}
		return -1;
	}

	static void horseToRev() {
		chess[r][c].set(idx, new int[] { chess[r][c].get(idx)[0], dir });
	}

	static void whiteOrRed(int color, int nr, int nc) {
		int size = chess[r][c].size();
		for (int i = idx; i < size; i++) {
			chess[nr][nc].add(chess[r][c].get(color == 0 ? i : size - 1 - i + idx));
			map.replace(chess[r][c].get(i)[0], new int[] { nr, nc });
		}
		removeAfterMove(size);
	}

	static void removeAfterMove(int size) {
		for (int i = size - 1; i >= idx; i--) {
			chess[r][c].remove(i);
		}
	}

	static boolean isOverFour(int nr, int nc) {
		return chess[r][c].size() - idx + chess[nr][nc].size() >= 4 ? true : false;
	}

	static boolean isBlue(int r, int c) {
		return (r < 0 || c < 0 || r >= N || c >= N || color[r][c] == 2) ? true : false;
	}

	static int newDir() {
		return dir % 2 == 0 ? dir - 1 : dir + 1;
	}

	static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
