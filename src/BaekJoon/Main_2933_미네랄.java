//문제 
//
//창영과 상근은 한 동굴을 놓고 소유권을 주장하고 있다. 두 사람은 막대기를 서로에게 던지는 방법을 이용해 누구의 소유인지를 결정하기로 했다. 
//
//싸움은 동굴에서 벌어진다. 동굴에는 미네랄이 저장되어 있으며, 던진 막대기가 미네랄을 파괴할 수도 있다.
//
//동굴은 R행 C열로 나타낼 수 있으며, R×C칸으로 이루어져 있다. 각 칸은 비어있거나 미네랄을 포함하고 있으며, 네 방향 중 하나로 인접한 미네랄이 포함된 두 칸은 같은 클러스터이다.
//
//창영은 동굴의 왼쪽에 서있고, 상근은 오른쪽에 서있다. 두 사람은 턴을 번갈아가며 막대기를 던진다. 막대를 던지기 전에 던질 높이를 정해야 한다. 막대는 땅과 수평을 이루며 날아간다.
//
//막대가 날아가다가 미네랄을 만나면, 그 칸에 있는 미네랄은 모두 파괴되고 막대는 그 자리에서 이동을 멈춘다.
//
//미네랄이 파괴된 이후에 남은 클러스터가 분리될 수도 있다. 새롭게 생성된 클러스터가 떠 있는 경우에는 중력에 의해서 바닥으로 떨어지게 된다. 
//
//떨어지는 동안 클러스터의 모양은 변하지 않는다. 클러스터는 다른 클러스터나 땅을 만나기 전까지 게속해서 떨어진다. 클러스터는 다른 클러스터 위에 떨어질 수 있고, 그 이후에는 합쳐지게 된다.
//
//동굴에 있는 미네랄의 모양과 두 사람이 던진 막대의 높이가 주어진다. 모든 막대를 던지고 난 이후에 미네랄 모양을 구하는 프로그램을 작성하시오.
//
//입력 
//
//첫째 줄에 동굴의 크기 R과 C가 주어진다. (1 ≤ R,C ≤ 100)
//
//다음 R개 줄에는 C개의 문자가 주어지며, '.'는 빈 칸, 'x'는 미네랄을 나타낸다.
//
//다음 줄에는 막대를 던진 횟수 N이 주어진다. (1 ≤ N ≤ 100)
//
//마지막 줄에는 막대를 던진 높이가 주어지며, 공백으로 구분되어져 있다. 모든 높이는 1과 R사이이며, 높이 1은 행렬의 가장 바닥, R은 가장 위를 의미한다. 
//
//첫 번째 막대는 왼쪽에서 오른쪽으로 던졌으며, 두 번째는 오른쪽에서 왼쪽으로, 이와 같은 식으로 번갈아가며 던진다.
//
//공중에 떠 있는 미네랄 클러스터는 없으며, 두 개 또는 그 이상의 클러스터가 동시에 떨어지는 경우도 없다.
//
//출력 
//
//입력 형식과 같은 형식으로 미네랄 모양을 출력한다
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2933_미네랄 {
	static int R, C, N;
	static char[][] map;
	static boolean[][] v;
	static int[][] visit, pos = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2933_미네랄.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new int[R][C];
		v = new boolean[R][C];
		for(int i=0; i<R; i++) {
			Arrays.fill(visit[i], -1);
		}
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				if(map[i][j]=='x') {
					v[i][j]=true;
				}
			}
		}
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int r = R-Integer.parseInt(st.nextToken());
			if(i%2==0) {
				for(int j=0; j<C; j++) {
					if(map[r][j]=='x') {
						map[r][j]='.';
						v[r][j]=false;
						break;
					}
				}
			}else {
				for(int j=C-1; j>=0; j--) {
					if(map[r][j]=='x') {
						map[r][j]='.';
						v[r][j]=false;
						break;
					}
				}
			}
			for(int j=0; j<R; j++) {
				for(int k=0; k<C; k++) {
					if(map[j][k]=='x' && visit[j][k]!=i) {
						cluster(j,k,i);
					}
				}
			}
		}
		for(int i=0; i<R; i++) {
			System.out.println(map[i]);
		}
	}
	private static void cluster(int r, int c, int vidx) {
		boolean isDrop = true;
		ArrayList<int[]> list = new ArrayList<>();		
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c});
		list.add(new int[] {r,c});
		v[r][c] = false;
		top:
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int cr = temp[0];
			int cc = temp[1];
			for(int i=0; i<4; i++) {
				int nr = cr+pos[i][0];
				int nc = cc+pos[i][1];
				if(isOk(nr,nc)) {
					if(nr==R-1) {
						isDrop=false;
						break top;
					}
					v[nr][nc]=false;
					visit[nr][nc] = vidx;
					queue.offer(new int[] {nr,nc});
					list.add(new int[] {nr,nc});
				}
			}
		}
		if(isDrop) {
			for(int i=0; i<list.size(); i++) {
				int[] temp = list.get(i);
				map[temp[0]][temp[1]] = '.';
			}
			int idx = 0;
			top:
			while(true) {
				for(int i=0; i<list.size(); i++) {
					int[] temp = list.get(i);
					if(temp[0]+idx>R-1 || v[temp[0]+idx][temp[1]]) {
						break top;
					}
				}
				idx++;
			} 
			for(int i=0; i<list.size(); i++) {
				int[] temp = list.get(i);
				v[temp[0]+idx-1][temp[1]] = true;
				map[temp[0]+idx-1][temp[1]] = 'x';
			}
		}else {
			for(int i=0; i<list.size(); i++) {
				int[] temp = list.get(i);
				v[temp[0]][temp[1]] = true;
			}
		}
	}
	private static boolean isOk(int r, int c) {
		return (r>=0 && c>=0 && r<R && c<C && map[r][c]=='x' && v[r][c]) ? true:false;
	}
}