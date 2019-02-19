//문제
//
//트리에서 리프 노드란, 자식의 개수가 0인 노드를 말한다.
//
//트리가 주어졌을 때, 노드 중 하나를 제거할 것이다. 그 때, 남은 트리에서 리프 노드의 개수를 구하는 프로그램을 작성하시오.
//
//예를 들어, 다음과 같은 트리가 있다고 하자.
//
//현재 리프 노드의 개수는 3개이다. (초록색 색칠된 노드) 이때, 1번을 제거한다고 하면, 다음과 같이 된다.
//
//이제 리프 노드의 개수는 1개이다.
//
//입력
//
//첫째 줄에 트리의 노드의 개수 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 
//
//둘째 줄에는 0번 노드부터 N-1번 노드까지, 각 노드의 부모가 주어진다. 만약 부모가 없다면 (루트) -1이 주어진다. 셋째 줄에는 지울 노드의 번호가 주어진다.
//
//출력
//
//첫째 줄에 입력으로 주어진 트리에서 입력으로 주어진 노드를 지웠을 때, 리프 노드의 개수를 출력한다.
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

class Tree1068{
	private class Tree{
		int data;
		Tree left, right;
	}
}
public class Main_1068_트리 {
	static int N, p;
	static String[] line;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Main_1068_트리.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		line = br.readLine().split(" ");
		
	}
}
