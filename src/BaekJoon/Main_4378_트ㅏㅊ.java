//문제 
//
//가끔, 그러나 때때로, 우리들은 키보드에서 양손을 오른쪽으로 한 칸씩 이동한 상태로 두고 타자를 치는 경우가 있다. 
//
//즉, "ACMICPC.NET"을 위와 같은 방법으로 치게 되면 "SV,OV[V/MRY"이라는 이상한 문장을 보게 된다.
//
//교준이는 장문을 쓰는데, 너무 급한 나머지 위와 같은 오류를 범한 채로 글을 완성해 버렸다. 
//
//이 글을 다시 쓰는 것은 교준이에게는 너무 힘든 일이다. 교준이를 대신해서 오류를 고쳐주자.
//
//입력 
//
//입력은 여러 줄로 이루어진다. 각 줄은 숫자나 공백, 알파벳 대문자, 위의 키보드에 표시되어 있는 문장 부호로 이루어져 있다. 
//
//Q, A, Z나 `(back-quote), 단어로 이루어진 키(Tab, BackSp, Control 등)는 입력의 각 줄에 포함되지 않는다. 
//
//예외적으로 공백(' ', SpaceBar)은 입력으로 들어올 수 있는데, 스페이스 바는 너무 길어서 교준이가 위의 오류를 범하지 않는다.
//
//출력 
//
//각 줄마다 오류를 고쳐 출력한다.
//힌트 
//
//교준이는 위의 그림과 동일한 쿼티 키보드를 사용한다.
//
//(셔등ㄹ;ㅇ,ㅇ 르;ㄹ,; ㅅ,ㅎ;ㄴ서ㅣ 걸ㄹ;횡 트ㅏㅊ; ㅌ;적,ㅎ,ㅎ ㅛㅣ려룅기/)

package BaekJoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main_4378_트ㅏㅊ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_4378_트ㅏㅊ.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character,Character> map = new HashMap<>();
		map.put('1', '`');
		map.put('2', '1');
		map.put('3', '2');
		map.put('4', '3');
		map.put('5', '4');
		map.put('6', '5');
		map.put('7', '6');
		map.put('8', '7');
		map.put('9', '8');
		map.put('0', '9');
		map.put('-', '0');
		map.put('=', '-');
		map.put('W', 'Q');
		map.put('E', 'W');
		map.put('R', 'E');
		map.put('T', 'R');
		map.put('Y', 'T');
		map.put('U', 'Y');
		map.put('I', 'U');
		map.put('O', 'I');
		map.put('P', 'O');
		map.put('[', 'P');
		map.put(']', '[');
		map.put('\\', ']');
		map.put('S', 'A');
		map.put('D', 'S');
		map.put('F', 'D');
		map.put('G', 'F');
		map.put('H', 'G');
		map.put('J', 'H');
		map.put('K', 'J');
		map.put('L', 'K');
		map.put(';', 'L');
		map.put('\'', ';');
		map.put('X', 'Z');
		map.put('C', 'X');
		map.put('V', 'C');
		map.put('B', 'V');
		map.put('N', 'B');
		map.put('M', 'N');
		map.put(',', 'M');
		map.put('.', ',');
		map.put('/', '.');
		map.put(' ', ' ');
		
		while(true) {
			String line = br.readLine();
			if(line==null)
				break;
			String newline="";
			for(int i=0; i<line.length(); i++) {
				newline+=map.get(line.charAt(i));
			}
			System.out.println(newline);
		}
		
	}
}
