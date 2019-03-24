//문제
//
//모눈종이에 다각형을 그리려고 한다. 그리는 방법은 모양수열로 표시된다.
//
//모양수열은 1과 4사이의 숫자가 연속되어 나열된 것으로 1은 오른쪽으로, 2는 위쪽으로, 3은 왼쪽으로, 4는 아래쪽으로 한 칸씩 그리는 것을 말한다.
//
//예를 들어 아래 그림의 다각형 (2)는 점 A에서 시작하여 화살표 방향으로 모양수열 1411433322를 따라서 그린 것이다. 
//
//다각형 (3)은 점 B에서 시작하여 화살표 방향으로 모양수열 3221411433을 따라서 그린 것이다. 
//
//또한 다각형(4)는 점 C에서 시작하여 화살표 방향으로 모양수열 4411123323을 따라서 그린 것이다. 
//
//다각형 (2), (3), (4)는 다각형 (1)과 같으므로 모양수열들 1411433322, 3221411433, 4411123323은 모두 같은 다각형을 그릴 수 있다. 
//
//단, 다각형이 회전된 것이나 뒤집어진 것은 같은 다각형이 아니다. 그러므로 아래 그림의 다각형 (5)와 (6)은 다각형 (1)과 다르다.
//
//
//한 개의 표본 모양수열과 여러 모양수열들이 주어졌을 때 표본 모양수열과 같은 다각형을 그릴 수 있는 모양수열들을 모두 찾는 프로그램을 작성하시오.
//
//입력
//
//첫째 줄에는 표본 모양수열의 길이(숫자의 개수)가 주어지고, 둘째 줄에는 표본 모양수열이 주어진다. 
//
//셋째 줄에는 모양수열의 개수가 주어지고 넷째 줄부터는 각 줄에 표본 모양수열과 같은 길이의 모양수열이 하나씩 주어진다. 
//
//단, 모양수열들의 개수는 최대 100 개이고 모양수열의 길이는 최대 50 이다. 모양수열의 각 숫자 사이에는 빈칸이 하나 있다.
//
//출력
//
//첫째 줄에는 입력된 표본 모양수열과 같은 다각형을 그리는 모양수열들의 개수를 출력한다. 
//
//둘째 줄부터는 각 줄에 표본 모양수열과 같은 다각형을 그릴 수 있는 모양수열을 출력한다. 출력되는 모양수열의 숫자들은 한 칸 띄고 출력한다.

package BaekJoon;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_2641_다각형그리기 {
	static int L, N, cnt;
	static String line, rev="", input;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2641_다각형그리기.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		L = Integer.parseInt(br.readLine());
		line = br.readLine()+" ";
		for(int i=line.length()-2; i>=0;) {
			if(line.charAt(i)-'0'>2) {
				rev += line.charAt(i)-'0'-2;
			}else {
				rev += line.charAt(i)-'0'+2;
			}
			rev+=" ";
			i-=2;
		}
		line += line;
		rev += rev;
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			input = br.readLine();
			Pattern p = Pattern.compile(input);
			Matcher mline = p.matcher(line);
			if(mline.find()) {
				cnt++;
				sb.append(input).append("\n");
				continue;
			}
			Matcher mrev = p.matcher(rev);
			if(mrev.find()) {
				cnt++;
				sb.append(input).append("\n");
				continue;
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}
}
