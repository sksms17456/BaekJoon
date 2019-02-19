//문제
//N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1의 세 값 중 하나가 저장되어 있다. 우리는 이 행렬을 적절한 크기로 자르려고 하는데, 이때 다음의 규칙에 따라 자르려고 한다.
//
//만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
//(1)이 아닌 경우에는 종이를 같은 크기의 9개의 종이로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
//이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N(1≤N≤3^7, N은 3^k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.
//
//출력
//첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.

package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main_1780_종이의개수 {
	static int N;
	static int[][] paper;
	static int zerocnt=0, cnt=0, mcnt=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Main_1780_종이의개수.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String str[] = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		slicepaper(paper,0,0,N);
		System.out.println(mcnt+"\n"+zerocnt+"\n"+cnt);
		
	}
	
	public static void slicepaper(int[][] paper, int row, int col, int N) {
		boolean isSame=true;
		top:
		for(int i=row; i<row+N; i++) {
			for(int j=col; j<col+N; j++) {
				if(paper[row][col]!=paper[i][j]) {
					isSame=false;
					break top;
				}
			}
		}
		if(isSame) {
			if(paper[row][col]==0)
				zerocnt++;
			else if(paper[row][col]==1)
				cnt++;
			else
				mcnt++;
			return;
		}
		
		N/=3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				slicepaper(paper,row+N*i,col+N*j,N);
			}
		}
	}
}
