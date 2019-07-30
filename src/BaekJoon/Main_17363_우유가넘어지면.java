//문제
//유머 감각이 뛰어난 성원이는 매일 재미있는 농담을 준비한다. 오늘 준비한 농담은 바로 이것이다.
//
//우유가 넘어질 때 뭐라고 하게? 답은 "아야"! 깔깔!
//
//친구들의 반응이 심드렁하자, 성원이는 해설을 덧붙였다.
//
//"우유"가 세로로 적혀 있는 상자를 왼쪽으로 툭 넘어뜨리면 "아야"가 되잖아? 이게 마치 우유가 넘어져서 아파하는 것 같다는 점이 웃음 포인트야!
//
//milk
//
//그럼에도 불구하고 친구들이 웃지 않자, 성원이는 친구들이 공간지각력이 부족해 상자를 넘어뜨리는 모습을 상상하지 못한다고 생각했다. 그래서 상자를 넘어뜨리는 프로그램을 만들어 친구들에게 결과를 보여주기로 했다.
//
//성원이는 상자에 "우유"가 아니라 다른 그림이 그려져 있어도 프로그램이 잘 동작하기를 원한다. 성원이는 상자의 면을 격자로 나누고 각 칸에 아래 문자들 중 하나를 그려넣는 방식으로 그림을 그린다.
//
//문자	이름	ASCII	돌린 뒤
//.	온점	46	.
//O	대문자 O	79	O
//-	하이픈	45	|
//|	세로 바	124	-
///	슬래시	47	\
//\	역슬래시	92	/
//^	캐럿	94	<
//<	왼쪽 부등호	60	v
//v	소문자 V	118	>
//>	오른쪽 부등호	62	^
//그러나 성원이는 내일의 농담을 생각하느라 프로그램을 만들 시간이 없다. 성원이 대신 프로그램을 만들어 주자.
//
//입력
//첫 줄에 그림의 세로 길이와 가로 길이를 의미하는 정수 N과 M(1 ≤ N, M ≤ 100)이 주어진다.
//
//다음 N개의 줄에 걸쳐 그림의 각 줄을 의미하는 M글자의 문자열이 하나씩 주어진다. 문자열은 공백을 포함하지 않으며 위의 표에 주어진 문자로만 이루어져 있음이 보장된다.
//
//출력
//M개의 줄에 걸쳐 입력된 그림을 왼쪽으로 넘어뜨렸을 때의 결과를 출력한다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17363_우유가넘어지면 {
	static int r, c;
	static char[] temp;
	static char[][] milk;
	static Map<Character, Character> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
		map.put('.', '.');
		map.put('O', 'O');
		map.put('-', '|');
		map.put('|', '-');
		map.put('/', '\\');
		map.put('\\', '/');
		map.put('^', '<');
		map.put('<', 'v');
		map.put('v', '>');
		map.put('>', '^');
		BufferedReader br = new BufferedReader(new FileReader("res/Main_17363_우유가넘어지면.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		milk = new char[c][r];
		temp = new char[c];
		for(int i=0; i<r; i++) {
			temp = br.readLine().toCharArray();
			for(int j=0; j<c; j++) {
				milk[j][i] = map.get(temp[c-j-1]);
			}
		}
		for(int i=0; i<c; i++) {
			for(int j=0; j<r; j++) {
				sb.append(milk[i][j]);
			}
			sb.append("\n");
		}		
		System.out.println(sb);
	}
}
