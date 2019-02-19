//문제
// 
//프로도와 네오는 곧 100일을 맞이한다. 
//
//100일이 되는 날 아무것도 하지 않았을 때 후폭풍을 도저히 감당할 자신이 없었던 프로도는 네오를 위한 작은 이벤트를 준비하기로 했다. 
//
//모든 것은 준비가 되었고 이제 종이를 잘라서 “LOVE” 라는 글자를 만드는 일만 남았다. 
//
//하지만 급하게 준비하는 바람에 ‘O’, ‘V’, ‘E’ 를 잘라낼 때 엉망으로 종이를 사용해버렸고, 남은 종이는 <그림 1>과 같은 히스토그램 모양의 직각다각형이 되어버렸다. 
//
//일이 이렇게 되어버리자 프로도는 이왕이면 자신의 사랑만큼이나 큰 ‘L’자를 잘라내고 싶어졌다. 다음은 종이의 형태에 대한 설명이다.
//
//•남은 종이는 각 변이 x축 또는 y축에 평행한 히스토그램 모양의 직각다각형이다. 이를 잘 잘라서 L-모양 직각다각형을 만들려고 한다.
//
//•L-모양 직각다각형이란 꼭짓점의 수가 4 또는 6이고 각 변이 모두 x축 또는 y축에 평행한 직각다각형을 의미한다. 
//
//◦참고로, 꼭짓점의 수가 4인 직각다각형은 직사각형이다. 직사각형 모서리에서 조그만 직사각형을 오려내면 ‘L’ 자를 만들 수 있다.
//
//예를 들어, 주어진 색종이가 <그림 1>에서 보인 것과 같을 때, <그림 2>. <그림 3>. <그림 4>는 서로 다른 L-모양 직각다각형을 어떻게 만들 수 있는지 보여준다. 물론 이 외에도 훨씬 더 많은 방법이 있다.
//
//이렇게 사용하고 남은 종이가 히스토그램 모양의 직각다각형일 때, 여기서 면적이 가장 큰 L-모양 직각다각형을 구해서 프로도를 도와주자.
//
//입력
// 
//입력의 첫째 줄에는 직각다각형의 꼭짓점의 개수 N(4 ≤ N ≤ 500,000)이 주어진다. 
//
//이어지는 N줄 각각엔 직각다각형 꼭짓점의 좌표를 나타내는 정수 (x, y) (0 ≤ x, y ≤ 109)가 공백을 사이에 두고 주어진다. 
//
//입력 다각형의 시작점은 원점 (0,0)이고, 꼭짓점이 시계방향 순서로 주어진다. 즉, 연속하는 두 개의 꼭짓점은 직각다각형의 한 선분을 이루며, x좌표는 단조증가한다. 
//
//참고로, 시작점과 끝점만 y좌표가 0이다. 연속하는 세 점이 일직선에 있는 경우는 없다.
//
//출력
// 
//주어지는 직각다각형 모양의 종이로부터 만들 수 있는 L-모양 직각다각형 중 면적이 가장 큰 것을 구하여 그것의 면적을 한 줄에 출력한다.

package BaekJoon;

import java.io.*;

public class Main_15958_프로도의100일준비 {
	static int N, x, y;
	static int maxx = Integer.MIN_VALUE, maxy = Integer.MIN_VALUE;
	static int[][] paper;
	static String[] input;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Main_15958_프로도의100일준비.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			x = Integer.parseInt(input[0]);
			y = Integer.parseInt(input[1]);
			maxx = Math.max(maxx, x);
			maxy = Math.max(maxy, y);
		}
		paper = new int[maxx+1][maxy+1];
	}
}
