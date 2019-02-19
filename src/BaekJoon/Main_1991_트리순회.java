//문제
//
//이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
//
//예를 들어 위와 같은 이진 트리가 입력되면,
//•전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
//•중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
//•후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
//
//가 된다.
//
//입력
// 
//첫째 줄에는 이진 트리의 노드의 개수 N(1≤N≤26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 
//노드의 이름은 A부터 차례대로 영문자 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현된다.
//
//출력
// 
//첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.

package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main_1991_트리순회 {
	
	static int N;
	static int[][] arr;
	static char ch;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Main_1991_트리순회.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			arr[str[0].charAt(0)-'A'][0] = str[1].charAt(0)-'A';
			arr[str[0].charAt(0)-'A'][1] = str[2].charAt(0)-'A';
		}
			
		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
	}
	
	public static void preorder(int root) {
		ch = (char)(root+'A');
		System.out.print(ch);
		if(arr[root][0] >0)
			preorder(arr[root][0]);
		if(arr[root][1] >0)
			preorder(arr[root][1]);
	}
	public static void inorder(int root) {
		if(arr[root][0]>0) {
			inorder(arr[root][0]);
		}
		ch = (char)(root+'A');
		System.out.print(ch);
		if(arr[root][1] >0)
			inorder(arr[root][1]);
	}
	public static void postorder(int root) {
		if(arr[root][0]>0) {
			postorder(arr[root][0]);
		}
		if(arr[root][1] >0)
			postorder(arr[root][1]);
		ch = (char)(root+'A');
		System.out.print(ch);
	}
}

