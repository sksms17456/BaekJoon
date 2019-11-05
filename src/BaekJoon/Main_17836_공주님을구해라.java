//문제
//용사는 마왕이 숨겨놓은 공주님을 구하기 위해 (N, M) 크기의 성 입구 (1,1)으로 들어왔다. 마왕은 용사가 공주를 찾지 못하도록 성의 여러 군데 마법 벽을 세워놓았다. 용사는 현재의 가지고 있는 무기로는 마법 벽을 통과할 수 없으며, 마법 벽을 피해 (N, M) 위치에 있는 공주님을 구출해야만 한다.
//
//마왕은 용사가 괴롭히기 위해 공주에게 저주를 걸었다. 저주에 걸린 공주는 T시간 이내로 용사를 만나지 못한다면 영원히 돌로 변하게 된다. 공주님을 구출하고 프러포즈를 반드시 하고 싶은 용사는 T시간 내에 반드시 공주님이 있는 곳으로 도달해야 한다. 용사는 한 칸을 이동하는 데 한 시간이 걸리며, 공주님이 있는 곳에 정확히 T초만에 도달하는 경우도, 구출 할 수 있다.
//
//
//
//성에는 이전 용사가 사용하던 전설의 명검 "그람"이 숨겨져 있다. 용사가 그람을 구하면 마법의 벽이 있는 칸일지라도, 단숨에 벽을 부수고 그 공간으로 갈 수 있다. "그람"은 성의 어딘가에 반드시 한 개 존재하고, 용사는 그람이 있는 곳에 도착하면 바로 사용할 수 있다. 그람이 부술 수 있는 벽의 개수는 제한이 없다.
//
//우리 모두 용사가 공주님을 안전하게 구출 할 수 있는지, 있다면 얼마나 빨리 구할 수 있는지 알아보자.
//
//입력
//첫 번째 줄에는 성의 크기인 N, M 그리고 공주에게 걸린 저주의 제한 시간인 정수 T가 주어진다. 첫 줄의 세 개의 수는 띄어쓰기로 구분된다. (3 ≤ N, M ≤ 100, 1 ≤ T ≤ 5000)
//
//두 번째 줄부터 N+1번째 줄까지 성의 구조를 나타내는 M개의 수가 띄어쓰기로 구분되어 주어진다. 0은 빈 공간, 1은 마법의 벽, 2는 그람이 놓여있는 공간을 의미한다. (1,1)과 (N,M)은 0이다.
//
//출력
//용사가 제한 시간 T시간 이내에 공주에게 도달할 수 있다면, 공주에게 도달할 수 있는 최단 시간을 출력한다.
//
//만약 용사가 공주를 T시간 이내에 구출할 수 없다면, "Fail"을 출력한다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17836_공주님을구해라 {
	static int R, C, limit, count = 0, ans = Integer.MAX_VALUE;
	static int[][] castle, pos = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static LinkedList<int[]> routeList = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/Main_17836_공주님을구해라.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = toInt(st.nextToken());
		C = toInt(st.nextToken());
		limit = toInt(st.nextToken());
		castle = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				castle[i][j] = toInt(st.nextToken());
			}
		}
		System.out.println(moveToRescuePrincess() <= limit ? ans : "Fail");
	}

	static int moveToRescuePrincess() {
		int gramRoute = 0;
		int end = 0;
		moveToNextRoute(0, 0);
		while (!routeList.isEmpty()) {
			int size = routeList.size();
			for (int k = 0; k < size; k++) {
				int[] currentRoute = routeList.poll();
				int currentR = currentRoute[0];
				int currentC = currentRoute[1];
				for (int i = 0; i < 4; i++) {
					int nextR = currentR + pos[i][0];
					int nextC = currentC + pos[i][1];
					if (isNextRoute(nextR, nextC)) {
						if (arriveAtThePrincess(nextR, nextC)) {
							end = count + 1;
						}
						if (castle[nextR][nextC] == 2) {
							gramRoute = count + getManhattanDistance(nextR, nextC) + 1;
							castle[nextR][nextC] = -1;
						} else {
							moveToNextRoute(nextR, nextC);
						}
					}
				}
			}
			count++;
		}
		return ans = end != 0 ? (gramRoute != 0 ? Math.min(end, gramRoute) : end) : (gramRoute != 0 ? gramRoute : ans);

	}

	static boolean isNextRoute(int r, int c) {
		return (r >= 0 && c >= 0 && r < R && c < C && Math.abs(castle[r][c]) != 1) ? true : false;
	}

	static void moveToNextRoute(int r, int c) {
		routeList.offer(new int[] { r, c });
		castle[r][c] = -1;
	}

	static int getManhattanDistance(int r, int c) {
		return R - r + C - c - 2;
	}

	static boolean arriveAtThePrincess(int r, int c) {
		return (r == R - 1 && c == C - 1) ? true : false;
	}

	static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
