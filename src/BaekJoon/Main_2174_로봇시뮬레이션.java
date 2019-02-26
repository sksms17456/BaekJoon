//문제
//
//가로 A(1≤A≤100), 세로 B(1≤B≤100) 크기의 땅이 있다. 이 땅 위에 로봇들이 N(1≤N≤100)개 있다.
//
//로봇들의 초기 위치는 x좌표와 y좌표로 나타난다. 위의 그림에서 보듯 x좌표는 왼쪽부터, y좌표는 아래쪽부터 순서가 매겨진다. 
//
//또한 각 로봇은 맨 처음에 NWES 중 하나의 방향을 향해 서 있다. 초기에 서 있는 로봇들의 위치는 서로 다르다.
//
//이러한 로봇들에 M(1≤M≤100)개의 명령을 내리려고 한다. 각각의 명령은 순차적으로 실행된다. 
//
//즉, 하나의 명령을 한 로봇에서 내렸으면, 그 명령이 완수될 때까지 그 로봇과 다른 모든 로봇에게 다른 명령을 내릴 수 없다. 

//각각의 로봇에 대해 수행하는 명령은 다음의 세 가지가 있다.
//
//L: 로봇이 향하고 있는 방향을 기준으로 왼쪽으로 90도 회전한다.
//R: 로봇이 향하고 있는 방향을 기준으로 오른쪽으로 90도 회전한다.
//F: 로봇이 향하고 있는 방향을 기준으로 앞으로 한 칸 움직인다.
//
//간혹 로봇들에게 내리는 명령이 잘못될 수도 있기 때문에, 당신은 로봇들에게 명령을 내리기 전에 한 번 시뮬레이션을 해 보면서 안전성을 검증하려 한다.
//
//이를 도와주는 프로그램을 작성하시오.
//
//잘못된 명령에는 다음의 두 가지가 있을 수 있다.
//
//Robot X crashes into the wall: X번 로봇이 벽에 충돌하는 경우이다. 즉, 주어진 땅의 밖으로 벗어나는 경우가 된다.
//
//Robot X crashes into robot Y: X번 로봇이 움직이다가 Y번 로봇에 충돌하는 경우이다.
//
//입력
//
//첫째 줄에 두 정수 A, B가 주어진다. 다음 줄에는 두 정수 N, M이 주어진다. 
//
//다음 N개의 줄에는 각 로봇의 초기 위치(x, y좌표 순) 및 방향이 주어진다. 다음 M개의 줄에는 각 명령이 명령을 내리는 순서대로 주어진다. 
//
//각각의 명령은 명령을 내리는 로봇, 명령의 종류(위에 나와 있는), 명령의 반복 회수로 나타낸다. 각 명령의 반복 회수는 1이상 100이하이다.
//
//출력
//
//첫째 줄에 시뮬레이션 결과를 출력한다. 문제가 없는 경우에는 OK를, 그 외의 경우에는 위의 형식대로 출력을 한다. 
//
//만약 충돌이 여러 번 발생하는 경우에는 가장 먼저 발생하는 충돌을 출력하면 된다
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2174_로봇시뮬레이션 {
	static class Robot{
		int n;
		int x;
		int y;
		int direc;
		public Robot(int n, int x, int y, int direc) {
			super();
			this.n = n;
			this.x = x;
			this.y = y;
			this.direc = direc;
		}
		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}
		public void setDirec(int direc) {
			this.direc = direc;
		}
		
		
	}
	static int A, B, N, M;
	static int[][] Ground;
	static int[][] pos = {{1,0},{0,-1},{-1,0},{0,1}};//북 서 남 동
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2174_로봇시뮬레이션.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		Ground = new int[B+1][A+1];
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<Robot> list = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			if(c=='N') {
				list.add(new Robot(i,y,x,0));
			}else if(c=='W') {
				list.add(new Robot(i,y,x,1));
			}else if(c=='S') {
				list.add(new Robot(i,y,x,2));
			}else {
				list.add(new Robot(i,y,x,3));
			}
			
			Ground[y][x] = i;
		}
		
		boolean isNo = false;
		top:
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			char order = st.nextToken().charAt(0);
			int cnt = Integer.parseInt(st.nextToken());
			
			switch (order) {
			case 'L':
				int newd = list.get(num).direc+cnt%4;
				if(newd>3) {
					list.get(num).setDirec(newd-4);
				}else {
					list.get(num).setDirec(newd);
				}
				break;
			case 'R':
				newd = list.get(num).direc-cnt%4;
				if(newd<0) {
					list.get(num).setDirec(newd+4);
				}else {
					list.get(num).setDirec(newd);
				}
				break;
			case 'F':
				int r = list.get(num).x;
				int c = list.get(num).y;
				int d = list.get(num).direc;
				Ground[r][c] = 0;
				while(cnt>0) {
					int nr = r+pos[d][0];
					int nc = c+pos[d][1];
					if(nr>B || nc>A || nr<=0 || nc<=0) {
						System.out.println("Robot "+list.get(num).n+" crashes into the wall");
						isNo = true;
						break top;
					}else if(Ground[nr][nc]!=0) {
						System.out.println("Robot "+list.get(num).n+" crashes into robot "+Ground[nr][nc]);
						isNo = true;
						break top;
					}
					r = nr;
					c = nc;
					cnt--;
				}
				list.get(num).setX(r);
				list.get(num).setY(c);
				Ground[r][c] = list.get(num).n;
				break;
			default:
				break;
			}
		}
		if(!isNo) {
			System.out.println("OK");
		}
	}
}
