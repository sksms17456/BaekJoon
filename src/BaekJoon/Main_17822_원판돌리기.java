//문제
//반지름이 1, 2, ..., N인 원판이 크기가 작아지는 순으로 바닥에 놓여있고, 원판의 중심은 모두 같다. 각각의 원판에는 M개의 정수가 적혀있고, i번째 원판에 적힌 j번째 수의 위치는 (i, j)로 표현한다. 수의 위치는 다음을 만족한다.
//
//(i, 1)은 (i, 2), (i, M)과 인접하다.
//(i, M)은 (i, M-1), (i, 1)과 인접하다.
//(i, j)는 (i, j-1), (i, j+1)과 인접하다. (2 ≤ j ≤ M-1)
//(1, j)는 (2, j)와 인접하다.
//(N, j)는 (N-1, j)와 인접하다.
//(i, j)는 (i-1, j), (i+1, j)와 인접하다. (2 ≤ i ≤ N-1)
//아래 그림은 N = 3, M = 4인 경우이다.
//
//
//
//원판의 회전은 독립적으로 이루어진다. 2번 원판을 회전했을 때, 나머지 원판은 회전하지 않는다. 원판을 회전시킬 때는 수의 위치를 기준으로 하며, 회전시킨 후의 수의 위치는 회전시키지 전과 일치해야 한다.
//
//다음 그림은 원판을 회전시킨 예시이다.
//
//		
//1번 원판을 시계 방향으로 1칸 회전	2, 3번 원판을 반시계 방향으로 3칸 회전	1, 3번 원판을 시계 방향으로 2칸 회전
//원판을 아래와 같은 방법으로 총 T번 회전시키려고 한다. 원판의 회전 방법은 미리 정해져 있고, i번째 회전할때 사용하는 변수는 xi, di, ki이다.
//
//번호가 xi의 배수인 원판을 di방향으로 ki칸 회전시킨다. di가 0인 경우는 시계 방향, 1인 경우는 반시계 방향이다.
//인접하면서 수가 같은 것을 모두 찾는다.
//그러한 수가 있는 경우에는 원판에서 인접하면서 같은 수를 모두 지운다.
//없는 경우에는 원판에 적힌 수의 평균을 구하고, 평균보다 큰 수에서 1을 빼고, 작은 수에는 1을 더한다.
//원판을 T번 회전시킨 후 원판에 적힌 수의 합을 구해보자.
//
//입력
//첫째 줄에 N, M, T이 주어진다.
//
//둘째 줄부터 N개의 줄에 원판에 적힌 수가 주어진다. i번째 줄의 j번째 수는 (i, j)에 적힌 수를 의미한다.
//
//다음 T개의 줄에 xi, di, ki가 주어진다.
//
//출력
//원판을 T번 회전시킨 후 원판에 적힌 수의 합을 출력한다.
//
//제한
//2 ≤ N, M, T ≤ 50
//1 ≤ 원판에 적힌 수 ≤ 1,000
//2 ≤ xi ≤ N
//0 ≤ di ≤ 1
//1 ≤ ki < M
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17822_원판돌리기 {
	static int R, C, N, target, dir, count;
	static int[][] circle, pos= {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean isAdj, check;
	static LinkedList<int[]> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_17822_원판돌리기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = toInt(st.nextToken());
		C = toInt(st.nextToken());
		N = toInt(st.nextToken());
		circle = new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				circle[i][j] = toInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			target = toInt(st.nextToken());
			dir = toInt(st.nextToken());
			count = toInt(st.nextToken());
			order();
		}
		int[] res = getSumCnt();
		System.out.println(res[0]);
	}
	static void order() {
		for(int i=0; i<R; i++) {
			if((i+1)%target==0) {
				rotation(i);
			}
		}
		check = false;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(circle[i][j]!=0) {
					isAdj = false;
					checkAdj(i, j, circle[i][j]);
				}
			}
		}
		if(!check) {
			calc();
		}
	}
	static void calc() {
		int[] sumCnt = getSumCnt();
		int avg = sumCnt[0]!=0 ? sumCnt[0]/sumCnt[1] : 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(circle[i][j]>avg) {
					circle[i][j]--;
				}else if(circle[i][j]<avg) {
					circle[i][j]++;
				}
			}
		}
	}
	static int[] getSumCnt() {
		int[] sumCnt = new int[2];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(circle[i][j]!=0) {
					sumCnt[0]+=circle[i][j];
					sumCnt[1]++;
				}
			}
		}
		return sumCnt;
	}
	static void checkAdj(int r, int c, int val) {
		queue.offer(new int[] {r, c});
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int tempr = temp[0];
			int tempc = temp[1];
			checkPoint(tempr, tempc, val);
			for(int i=0; i<4; i++) {
				int nr = tempr+pos[i][0];
				int nc = tempc+pos[i][1];
				if(isOk(nr, nc)) {
					if(circle[nr][nc]==val) {
						isAdj = true;
						circle[nr][nc] = 0;
						queue.offer(new int[] {nr, nc});
					}
				}
			}
			if(isAdj) {
				circle[r][c] = 0;
				check = true;
			}
		}
		
	}
	static void checkPoint(int r, int c, int val) { 
		
		if(c==0 && circle[r][C-1]==val) {
			circle[r][C-1] = 0;
			queue.offer(new int[] {r, C-1});
			isAdj=true;
		}else if(c==C-1 && circle[r][0]==val){
			circle[r][0] = 0;
			queue.offer(new int[] {r, 0});
			isAdj = true;
		}
	}
	static boolean isOk(int r, int c) {
		return (r>=0 && c>=0 && r<R && c<C) ? true:false;
	}
	static void printarr() {
		for(int i=0; i<R; i++) {
			System.out.println(Arrays.toString(circle[i]));
		}
		System.out.println();
	}
	static void rotation(int r) {
		int idx = dir==1 ? count%C : C-count%C;
		int[] tempCircle = new int[C];
		for(int i=idx; i<C; i++) {
			tempCircle[i-idx] = circle[r][i];
		}
		for(int i=0; i<idx; i++) {
			tempCircle[i+C-idx] = circle[r][i];
		}
		for(int i=0; i<C; i++) {
			circle[r][i] = tempCircle[i];
		}
	}
	static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
