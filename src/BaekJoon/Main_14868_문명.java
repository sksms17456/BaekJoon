//문제
//인류의 역사를 돌이켜보면, 문명의 발전은 독자적으로 진행되기도 하지만 서로 다른 문명이 만나 결합되기도 한다. 여러분은 이 가설을 바탕으로, 세계 문명의 발전 과정을 시뮬레이션 해보려고 한다.
//
//세계를 N×N의 2차원 공간으로 생각할 수 있다. 즉, 1×1 크기의 정사각형이 가로, 세로로 각각 N개씩 쌓여있는 형태로 생각할 수 있다. 가장 왼쪽 아래 정사각형은 (1,1), 가장 오른쪽 위 정사각형은 (N,N) 위치에 있다. 두 정사각형 (a,b)와 (a′,b′)은 다음 두 조건 중 하나만 만족할 때 서로 인접해 있다고 하자.
//
//|a-a′| = 1 이고 b = b′.
//|b-b′| = 1 이고 a = a′.
//문명의 최초 발상지는 모두 서로 다른 K곳에 있다. 각 정사각형에 해당하는 공간은 문명 지역이거나, 미개 지역이다. 문명의 최초 발상지는 문명 지역이며, 만약 문명 최초 발상지끼리 인접해 있다면, 이들은 처음부터 하나로 결합된다. 한 해가 지날 때마다, 문명 지역은 자신과 인접한 지역에 문명을 전파한다. 정사각형 (a,b)가 문명 지역이면, 다음 해에는 세계의 경계를 넘지 않는 한 이 정사각형과 인접한 네 정사각형 (a+1,b), (a-1,b), (a,b+1), (a,b-1)에 문명이 전파된다. 만약 두 인접하는 지역에 다른 문명이 전파되었거나, 한 지역에 둘 이상의 다른 문명이 전파된다면 이 문명들은 결합된다.
//
//예를 들어, 다음과 같이 5×5 크기의 세계에 4곳의 정사각형 (1,1), (2,1), (2,5), (5,2)가 문명의 발상지라고 하자. 정사각형 (1,1), (2,1)의 문명은 인접해 있으므로 처음부터 결합되어 있다. 1년후 문명이 전파된 지역은 오른쪽 그림과 같고, 2년 후에 문명이 전파된 지역은 아래 그림과 같다. 이때 모든 문명은 서로 결합되어 하나의 문명이 된다. (2,5)에서 발상한 문명과 (5,2)에서 발상한 문명은 직접적으로 결합되지는 않았지만, (1,1),(2,1)에서 발상한 문명을 통하여 결합됨에 주의하라.
//
//
//
//세계의 크기, 문명 발상지의 수 및 위치를 입력으로 받아 모든 문명이 하나로 결합될 때까지 걸리는 최소 햇수를 구하는 프로그램을 작성하시오.
//
//입력
//표준 입력으로 다음 정보가 주어진다. 첫 번째 줄에는 세계의 크기를 나타내는 정수 N(2 ≤ N ≤ 2,000)과 문명 발상지의 수 K(1 ≤ K ≤ 100,000)가 주어진다. 다음 K줄에는 한 줄에 하나씩 문명 발상지에 해당하는 정사각형의 위치 (x,y)를 나타내는 두 자연수 x와 y가 주어진다. (1 ≤ x,y ≤N)
//
//출력
//표준 출력으로 모든 문명이 하나로 결합되는데 걸리는 최소 햇수를 정수로 출력한다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_14868_문명 {
	static int N, K, r, c, regionNum, year = 0;
	static int[][] world, pos = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static LinkedList<int[]> queue = new LinkedList<int[]>();
	static Set<Integer> union = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/Main_14868_문명.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = toInt(st.nextToken()) + 1;
		K = toInt(st.nextToken());
		world = new int[N][N];
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			r = toInt(st.nextToken());
			c = toInt(st.nextToken());
			world[r][c] = i;
			queue.offer(new int[] { r, c, i });
		}
		spread();
		System.out.println(year == 0 ? 0 : year + 1);
	}
	static void printarr() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(world[i]));
		}
	}
	static void spread() {
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				int[] region = queue.poll();
				r = region[0];
				c = region[1];
				regionNum = region[2];
				checkAdj();
				if (allUnioned()) return;
				size--;
			}
			printarr();
			year++;
		}
	}

	static void checkAdj() {
		for (int i = 0; i < 4; i++) {
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			if (isOk(nr, nc)) {
				if (world[nr][nc] == 0) {
					world[nr][nc] = regionNum;
					queue.offer(new int[] { nr, nc, regionNum });
				} else if(world[nr][nc]!=regionNum){
					union.add(world[nr][nc]);
					union.add(regionNum);
				}
			}
		}
	}

	static boolean allUnioned() {
		return union.size() == K ? true : false;
	}

	static boolean isOk(int r, int c) {
		return (r > 0 && c > 0 && r < N && c < N) ? true : false;
	}

	static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
