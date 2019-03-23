//문제
//
//구사과와 큐브러버는 10×10 크기의 바둑판에서 오목을 하고 있다. 
//
//턴은 구사과가 먼저 갖는다. 바둑판의 상태가 주어진다. 구사과가 턴을 한 번 더 가졌을 때, 이길 수 있는지 구하는 프로그램을 작성하시오.
//
//오목에서 승리했다는 것은 자신의 돌이 5개 이상 연속한다는 것이다. 연속은 가로, 세로, 대각선 방향 모두 가능하다.
//
//입력
//
//총 10개의 줄에 바둑판의 상태가 주어진다. '.'는 빈 칸, 'X'는 구사과의 돌, 'O'는 큐브러버의 돌이다.
//
//입력으로 주어지는 바둑판에서 구사과의 돌의 개수와 큐브러버의 돌의 개수는 항상 일치하며, 아직 승자가 정해지지 않은 상태만 입력으로 주어진다.
//
//출력
//
//구사과가 턴을 한 번 가져서 이길 수 있으면 1, 없으면 0을 출력한다.
package BaekJoon;

import java.io.*;

public class Main_16955_오목이길수있을까 {
	static int cnt, xcnt;
	static char[][] omok = new char[10][10];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16955_오목이길수있을까.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<10; i++) {
			omok[i] = br.readLine().toCharArray();
		}
		for(int i=0; i<10; i++) {
			for(int j=0; j<6; j++) {
				xcnt=0; cnt=0;
				for(int k=j; k<j+5; k++) {
					if(omok[i][k]=='X') xcnt++;
					else if(omok[i][k]=='.') cnt++;
				}
				if(xcnt==4 && cnt==1) {
					System.out.println(1);
					System.exit(0);
				}
			}
		}
		for(int i=0; i<6; i++) {
			for(int j=0; j<10; j++) {
				xcnt=0; cnt=0;
				for(int k=i; k<i+5; k++) {
					if(omok[k][j]=='X') xcnt++;
					else if(omok[k][j]=='.') cnt++;
				}
				if(xcnt==4 && cnt==1) {
					System.out.println(1);
					System.exit(0);
				}
			}
		}
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				xcnt=0; cnt=0;
				for(int k=0; k<5; k++) {
					if(omok[i+k][j+k]=='X') xcnt++;
					else if(omok[i+k][j+k]=='.') cnt++;
				}
				if(xcnt==4 && cnt==1) {
					System.out.println(1);
					System.exit(0);
				}
			}
		}
		for(int i=0; i<6; i++) {
			for(int j=4; j<10; j++) {
				xcnt=0; cnt=0;
				for(int k=0; k<5; k++) {
					if(omok[i+k][j-k]=='X') xcnt++;
					else if(omok[i+k][j-k]=='.') cnt++;
				}
				if(xcnt==4 && cnt==1) {
					System.out.println(1);
					System.exit(0);
				}
			}
		}
		System.out.println(0);
	}
}
