//문제
//2차원 좌표 평면 위에 두 개의 박스(직 사각형) P, Q가 놓여 있다. 각 박스의 변은 x축이나 y축에 평행하다. 박스를 연구하는 학수는 이 두 박스의 교차 상태를 파악하여 내부가 겹쳐 있는지 (FACE), 그렇지 않고 선분에서 만나는 지(LINE), 그렇지 않고 한 점에서 만나는지(POINT), 아예 만나지 않는지 (NULL) 구별하려고 한다.
//
//다음 그림은 두 박스의 여러 가지 교차 상태의 예를 보여준다.
//
//				
//(a) POINT	(b) LINE	(c) FACE	(d) FACE	(e) NULL
//FACE인 경우에는 (d)처럼 어느 한 박스가 다른 박스에 포함될 수도 있다는 점에 유의해야 한다.
//
//두 박스의 정보가 주어졌을 때, 두 박스의 교차 상태를 출력하는 프로그램을 작성하시오.
//
//입력
//표준 입력으로 두 박스의 정보가 한 줄에 하나씩 주어진다. 각 박스의 정보는 왼쪽 아래 꼭짓점 좌표 (x1, y1)과 오른쪽 위 꼭짓점 좌표 (x2, y2)로 구성되는데 이들 좌푯값 x1, y1, x2, y2 (x1 < x2, y1 < y2)가 공백을 사이에 두고 주어진다.
//
//출력
//표준 출력으로 두 박스의 교차 상태를 POINT, LINE, FACE, NULL 중의 하나로 출력한다. 두 박스의 교차 상태는 모두 대문자로 출력한다.
//
//제한
//모든 서브태스크에서 x좌표와 y좌표는 모두 -109 이상 109 이하인 정수이다.
//
//서브태스크 1 (33점)
//POINT나 LINE인 경우만 있다.
//
//서브태스크 2 (30점)
//모든 좌푯값이 0 이상 1,000 이하이다.
//
//서브태스크 3 (37점)
//원래의 제약조건 이외에 아무 제약조건이 없다.

package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_15973_두박스 {
	static class Box{
		int x1;
		int x2;
		int y1;
		int y2;
		public Box(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
	}
	static Box[] box = new Box[2];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_15973_두박스.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0; i<2; i++) {
			 st = new StringTokenizer(br.readLine());
			 box[i] = new Box(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		
	}
}
