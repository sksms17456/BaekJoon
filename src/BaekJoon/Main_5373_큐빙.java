//문제 
//루빅스 큐브는 삼차원 퍼즐이다. 보통 루빅스 큐브는 3×3×3개의 작은 정육면체로 이루어져 있다. 
//
//퍼즐을 풀려면 각 면에 있는 아홉 개의 작은 정육면체의 색이 동일해야 한다.
//
//큐브는 각 면을 양방향으로 90도 만큼 돌릴 수 있도록 만들어져 있다. 회전이 마친 이후에는, 다른 면을 돌릴 수 있다. 이렇게 큐브의 서로 다른 면을 돌리다 보면, 색을 섞을 수 있다.
//
//이 문제에서는 루빅스 큐브가 모두 풀린 상태에서 시작한다. 윗 면은 흰색, 아랫 면은 노란색, 앞 면은 빨간색, 뒷 면은 오렌지색, 왼쪽 면은 초록색, 오른쪽 면은 파란색이다.
//
//루빅스 큐브를 돌린 방법이 순서대로 주어진다. 이때, 모두 돌린 다음에 가장 윗 면의 색상을 구하는 프로그램을 작성하시오.
//
//위의 그림은 루빅스 큐브를 푼 그림이다. 왼쪽 면은 시계방향으로 조금 돌려져 있는 상태이다.
//
//입력 
//
//첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스는 최대 100개이다. 각 테스트 케이스는 다음과 같이 구성되어져 있다.
//
//첫째 줄에 큐브를 돌린 횟수 n이 주어진다. (1 ≤ n ≤ 1000)
//
//둘째 줄에는 큐브를 돌린 방법이 주어진다. 각 방법은 공백으로 구분되어져 있으며, 첫 번째 문자는 돌린 면이다. 
//
//U: 윗 면, D: 아랫 면, F: 앞 면, B: 뒷 면, L: 왼쪽 면, R: 오른쪽 면이다. 두 번째 문자는 돌린 방향이다.
//
//+인 경우에는 시계 방향 (그 면을 바라봤을 때가 기준), -인 경우에는 반시계 방향이다.
//
//출력 
//
//각 테스트 케이스에 대해서 큐브를 모두 돌린 후의 윗 면의 색상을 출력한다.
//
//첫 번째 줄에는 뒷 면과 접하는 칸의 색을 출력하고, 두 번째, 세 번째 줄은 순서대로 출력하면 된다. 
//
//흰색은 w, 노란색은 y, 빨간색은 r, 오렌지색은 o, 초록색은 g, 파란색은 b.
package BaekJoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_5373_큐빙 {
	static int T, N;
	static char[] order;
	static int[][][] cube;
	static Map<Integer,Character> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_5373_큐빙.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map.put(0, 'g');
		map.put(1, 'r');
		map.put(2, 'b');
		map.put(3, 'o');
		map.put(4, 'w');
		map.put(5, 'y');
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			cube = new int[][][]{
					{{0,0,0},{0,0,0},{0,0,0}},
					{{1,1,1},{1,1,1},{1,1,1}},
					{{2,2,2},{2,2,2},{2,2,2}},
					{{3,3,3},{3,3,3},{3,3,3}},
					{{4,4,4},{4,4,4},{4,4,4}},
					{{5,5,5},{5,5,5},{5,5,5}}
			};
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				order = st.nextToken().toCharArray();
				switch (order[0]) {
				case 'L':
					Lturn(order[1]);
					break;
				case 'R':
					Rturn(order[1]);
					break;
				case 'U':
					Uturn(order[1]);
					break;
				case 'D':
					Dturn(order[1]);
					break;
				case 'F':
					Fturn(order[1]);
					break;
				case 'B':
					Bturn(order[1]);
					break;
				}
			}
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					System.out.print(map.get(cube[4][i][j]));
				}
				System.out.println();
			}
		}
	}
	private static void Lturn(char dir) {
		if(dir=='+') {
			int temp[] = {cube[1][0][0],cube[1][1][0],cube[1][2][0]};
			cube[1][0][0]=cube[4][0][0];
			cube[1][1][0]=cube[4][1][0];
			cube[1][2][0]=cube[4][2][0];
			cube[4][0][0]=cube[3][2][2];
			cube[4][1][0]=cube[3][1][2];
			cube[4][2][0]=cube[3][0][2];
			cube[3][2][2]=cube[5][0][0];
			cube[3][1][2]=cube[5][1][0];
			cube[3][0][2]=cube[5][2][0];
			cube[5][0][0]=temp[0];
			cube[5][1][0]=temp[1];
			cube[5][2][0]=temp[2];
			int temparr[][] = {{cube[0][2][0],cube[0][1][0],cube[0][0][0]}
								,{cube[0][2][1],cube[0][1][1],cube[0][0][1]}
								,{cube[0][2][2],cube[0][1][2],cube[0][0][2]}};
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[0][i][j] = temparr[i][j];
				}
			}
		}else {
			int temp[] = {cube[1][0][0],cube[1][1][0],cube[1][2][0]};
			cube[1][0][0]=cube[5][0][0];
			cube[1][1][0]=cube[5][1][0];
			cube[1][2][0]=cube[5][2][0];
			cube[5][0][0]=cube[3][2][2];
			cube[5][1][0]=cube[3][1][2];
			cube[5][2][0]=cube[3][0][2];
			cube[3][2][2]=cube[4][0][0];
			cube[3][1][2]=cube[4][1][0];
			cube[3][0][2]=cube[4][2][0];
			cube[4][0][0]=temp[0];
			cube[4][1][0]=temp[1];
			cube[4][2][0]=temp[2];
			int temparr[][] = {{cube[0][0][2],cube[0][1][2],cube[0][2][2]}
								,{cube[0][0][1],cube[0][1][1],cube[0][2][1]}
								,{cube[0][0][0],cube[0][1][0],cube[0][2][0]}};
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[0][i][j] = temparr[i][j];
				}
			}
		}
	}
	private static void Rturn(char dir) {
		if(dir=='+') {
			int temp[] = {cube[1][0][2],cube[1][1][2],cube[1][2][2]};
			cube[1][0][2]=cube[5][0][2];
			cube[1][1][2]=cube[5][1][2];
			cube[1][2][2]=cube[5][2][2];
			cube[5][0][2]=cube[3][2][0];
			cube[5][1][2]=cube[3][1][0];
			cube[5][2][2]=cube[3][0][0];
			cube[3][2][0]=cube[4][0][2];
			cube[3][1][0]=cube[4][1][2];
			cube[3][0][0]=cube[4][2][2];
			cube[4][0][2]=temp[0];
			cube[4][1][2]=temp[1];
			cube[4][2][2]=temp[2];
			int temparr[][] = {{cube[2][2][0],cube[2][1][0],cube[2][0][0]}
								,{cube[2][2][1],cube[2][1][1],cube[2][0][1]}
								,{cube[2][2][2],cube[2][1][2],cube[2][0][2]}};
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[2][i][j] = temparr[i][j];
				}
			}
		}else {
			int temp[] = {cube[1][0][2],cube[1][1][2],cube[1][2][2]};
			cube[1][0][2]=cube[4][0][2];
			cube[1][1][2]=cube[4][1][2];
			cube[1][2][2]=cube[4][2][2];
			cube[4][0][2]=cube[3][2][0];
			cube[4][1][2]=cube[3][1][0];
			cube[4][2][2]=cube[3][0][0];
			cube[3][2][0]=cube[5][0][2];
			cube[3][1][0]=cube[5][1][2];
			cube[3][0][0]=cube[5][2][2];
			cube[5][0][2]=temp[0];
			cube[5][1][2]=temp[1];
			cube[5][2][2]=temp[2];
			int temparr[][] = {{cube[2][0][2],cube[2][1][2],cube[2][2][2]}
								,{cube[2][0][1],cube[2][1][1],cube[2][2][1]}
								,{cube[2][0][0],cube[2][1][0],cube[2][2][0]}};
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[2][i][j] = temparr[i][j];
				}
			}
		}
	}
	private static void Uturn(char dir) {
		if(dir=='+') {
			int temp[] = {cube[0][0][0],cube[0][0][1],cube[0][0][2]};
			cube[0][0][0] = cube[1][0][0];
			cube[0][0][1] = cube[1][0][1];
			cube[0][0][2] = cube[1][0][2];
			cube[1][0][0] = cube[2][0][0];
			cube[1][0][1] = cube[2][0][1];
			cube[1][0][2] = cube[2][0][2];
			cube[2][0][0] = cube[3][0][0];
			cube[2][0][1] = cube[3][0][1];
			cube[2][0][2] = cube[3][0][2];
			cube[3][0][0] = temp[0];
			cube[3][0][1] = temp[1];
			cube[3][0][2] = temp[2];
			int temparr[][] = {{cube[4][2][0],cube[4][1][0],cube[4][0][0]}
								,{cube[4][2][1],cube[4][1][1],cube[4][0][1]}
								,{cube[4][2][2],cube[4][1][2],cube[4][0][2]}};
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[4][i][j] = temparr[i][j];
				}
			}
		}else {
			int temp[] = {cube[0][0][0],cube[0][0][1],cube[0][0][2]};
			cube[0][0][0] = cube[3][0][0];
			cube[0][0][1] = cube[3][0][1];
			cube[0][0][2] = cube[3][0][2];
			cube[3][0][0] = cube[2][0][0];
			cube[3][0][1] = cube[2][0][1];
			cube[3][0][2] = cube[2][0][2];
			cube[2][0][0] = cube[1][0][0];
			cube[2][0][1] = cube[1][0][1];
			cube[2][0][2] = cube[1][0][2];
			cube[1][0][0] = temp[0];
			cube[1][0][1] = temp[1];
			cube[1][0][2] = temp[2];
			int temparr[][] = {{cube[4][0][2],cube[4][1][2],cube[4][2][2]}
								,{cube[4][0][1],cube[4][1][1],cube[4][2][1]}
								,{cube[4][0][0],cube[4][1][0],cube[4][2][0]}};
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[4][i][j] = temparr[i][j];
				}
			}
		}
	}
	private static void Dturn(char dir) {
		if(dir=='-') {
			int temp[] = {cube[0][2][0],cube[0][2][1],cube[0][2][2]};
			cube[0][2][0] = cube[1][2][0];
			cube[0][2][1] = cube[1][2][1];
			cube[0][2][2] = cube[1][2][2];
			cube[1][2][0] = cube[2][2][0];
			cube[1][2][1] = cube[2][2][1];
			cube[1][2][2] = cube[2][2][2];
			cube[2][2][0] = cube[3][2][0];
			cube[2][2][1] = cube[3][2][1];
			cube[2][2][2] = cube[3][2][2];
			cube[3][2][0] = temp[0];
			cube[3][2][1] = temp[1];
			cube[3][2][2] = temp[2];
			int temparr[][] = {{cube[5][0][2],cube[5][1][2],cube[5][2][2]}
								,{cube[5][0][1],cube[5][1][1],cube[5][2][1]}
								,{cube[5][0][0],cube[5][1][0],cube[5][2][0]}};
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[5][i][j] = temparr[i][j];
				}
			}
		}else {
			int temp[] = {cube[0][2][0],cube[0][2][1],cube[0][2][2]};
			cube[0][2][0] = cube[3][2][0];
			cube[0][2][1] = cube[3][2][1];
			cube[0][2][2] = cube[3][2][2];
			cube[3][2][0] = cube[2][2][0];
			cube[3][2][1] = cube[2][2][1];
			cube[3][2][2] = cube[2][2][2];
			cube[2][2][0] = cube[1][2][0];
			cube[2][2][1] = cube[1][2][1];
			cube[2][2][2] = cube[1][2][2];
			cube[1][2][0] = temp[0];
			cube[1][2][1] = temp[1];
			cube[1][2][2] = temp[2];
			int temparr[][] = {{cube[5][2][0],cube[5][1][0],cube[5][0][0]}
								,{cube[5][2][1],cube[5][1][1],cube[5][0][1]}
								,{cube[5][2][2],cube[5][1][2],cube[5][0][2]}};
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[5][i][j] = temparr[i][j];
				}
			}
		}
	}
	private static void Fturn(char dir) {
		if(dir=='+') {
			int temp[] = {cube[0][0][2],cube[0][1][2],cube[0][2][2]};
			cube[0][0][2]=cube[5][0][0];
			cube[0][1][2]=cube[5][0][1];
			cube[0][2][2]=cube[5][0][2];
			cube[5][0][0]=cube[2][2][0];
			cube[5][0][1]=cube[2][1][0];
			cube[5][0][2]=cube[2][0][0];
			cube[2][2][0]=cube[4][2][2];
			cube[2][1][0]=cube[4][2][1];
			cube[2][0][0]=cube[4][2][0];
			cube[4][2][2]=temp[0];
			cube[4][2][1]=temp[1];
			cube[4][2][0]=temp[2];
			int temparr[][] = {{cube[1][2][0],cube[1][1][0],cube[1][0][0]}
								,{cube[1][2][1],cube[1][1][1],cube[1][0][1]}
								,{cube[1][2][2],cube[1][1][2],cube[1][0][2]}};
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[1][i][j] = temparr[i][j];
				}
			}
		}else {
			int temp[] = {cube[0][2][2],cube[0][1][2],cube[0][0][2]};
			cube[0][2][2]=cube[4][2][0];
			cube[0][1][2]=cube[4][2][1];
			cube[0][0][2]=cube[4][2][2];
			cube[4][2][0]=cube[2][0][0];
			cube[4][2][1]=cube[2][1][0];
			cube[4][2][2]=cube[2][2][0];
			cube[2][0][0]=cube[5][0][2];
			cube[2][1][0]=cube[5][0][1];
			cube[2][2][0]=cube[5][0][0];
			cube[5][0][2]=temp[0];
			cube[5][0][1]=temp[1];
			cube[5][0][0]=temp[2];
			int temparr[][] = {{cube[1][0][2],cube[1][1][2],cube[1][2][2]}
								,{cube[1][0][1],cube[1][1][1],cube[1][2][1]}
								,{cube[1][0][0],cube[1][1][0],cube[1][2][0]}};
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[1][i][j] = temparr[i][j];
				}
			}
		}
	}
	private static void Bturn(char dir) {
		if(dir=='+') {
			int temp[] = {cube[0][2][0],cube[0][1][0],cube[0][0][0]};
			cube[0][2][0]=cube[4][0][0];
			cube[0][1][0]=cube[4][0][1];
			cube[0][0][0]=cube[4][0][2];
			cube[4][0][0]=cube[2][0][2];
			cube[4][0][1]=cube[2][1][2];
			cube[4][0][2]=cube[2][2][2];
			cube[2][0][2]=cube[5][2][2];
			cube[2][1][2]=cube[5][2][1];
			cube[2][2][2]=cube[5][2][0];
			cube[5][2][2]=temp[0];
			cube[5][2][1]=temp[1];
			cube[5][2][0]=temp[2];
			int temparr[][] = {{cube[3][2][0],cube[3][1][0],cube[3][0][0]}
								,{cube[3][2][1],cube[3][1][1],cube[3][0][1]}
								,{cube[3][2][2],cube[3][1][2],cube[3][0][2]}};
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[3][i][j] = temparr[i][j];
				}
			}
		}else {
			int temp[] = {cube[0][0][0],cube[0][1][0],cube[0][2][0]};
			cube[0][0][0]=cube[5][2][0];
			cube[0][1][0]=cube[5][2][1];
			cube[0][2][0]=cube[5][2][2];
			cube[5][2][0]=cube[2][2][2];
			cube[5][2][1]=cube[2][1][2];
			cube[5][2][2]=cube[2][0][2];
			cube[2][2][2]=cube[4][0][2];
			cube[2][1][2]=cube[4][0][1];
			cube[2][0][2]=cube[4][0][0];
			cube[4][0][2]=temp[0];
			cube[4][0][1]=temp[1];
			cube[4][0][0]=temp[2];
			int temparr[][] = {{cube[3][0][2],cube[3][1][2],cube[3][2][2]}
								,{cube[3][0][1],cube[3][1][1],cube[3][2][1]}
								,{cube[3][0][0],cube[3][1][0],cube[3][2][0]}};
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cube[3][i][j] = temparr[i][j];
				}
			}
		}
	}
}
