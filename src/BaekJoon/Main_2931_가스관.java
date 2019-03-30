//문제
//러시아 가스를 크로아티아로 운반하기 위해 자그레브와 모스코바는 파이프라인을 디자인하고 있다. 두 사람은 실제 디자인을 하기 전에 파이프 매니아 게임을 이용해서 설계를 해보려고 한다.
//
//이 게임에서 유럽은 R행 C열로 나누어져 있다. 각 칸은 비어있거나, 아래 그림과 같은 일곱가지 기본 블록으로 이루어져 있다.
//
//
//
//가스는 모스크바에서 자그레브로 흐른다. 가스는 블록을 통해 양방향으로 흐를 수 있다. '+'는 특별한 블록으로, 아래 예시처럼 두 방향 (수직, 수평)으로 흘러야 한다.
//
//
//
//파이프 라인의 설계를 마친 후 두 사람은 잠시 저녁을 먹으러 갔다. 그 사이 해커가 침임해 블록 하나를 지웠다. 지운 블록은 빈 칸이 되어있다.
//
//해커가 어떤 칸을 지웠고, 그 칸에는 원래 어떤 블록이 있었는지 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 유럽의 크기 R과 C가 주어진다. (1 ≤ R, C ≤ 25)
//
//다음 R개 줄에는 C개 글자가 주어지며, 다음과 같은 글자로 이루어져 있다.
//
//빈칸을 나타내는 '.'
//블록을 나타내는 '|'(아스키 124), '-','+','1','2','3','4'
//모스크바의 위치를 나타내는 'M'과 자그레브를 나타내는 'Z'. 두 글자는 한 번만 주어진다.
//항상 답이 존재하고, 가스의 흐름이 유일한 경우만 입력으로 주어진다, 또, 모스크바와 자그레브가 하나의 블록과 인접해 있는 입력만 주어진다. 또, 불필요한 블록이 존재하지 않는다. 즉, 없어진 블록을 추가하면, 모든 블록에 가스가 흐르게 된다.
//
//출력
//지워진 블록의 행과 열 위치를 출력하고, 어떤 블록이었는지를 출력한다.
package BaekJoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2931_가스관 {
	static int R, C;
	static char[][] map;
	static int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};
	static char[][] dir = {{'|','+','1','4'}
							,{'|','+','2','3'}
							,{'-','+','1','2'}
							,{'-','+','3','4'}};
	static Map<String,Character> block = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2931_가스관.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		block.put("1100", '|');
		block.put("0011", '-');
		block.put("1111", '+');
		block.put("0101", '1');
		block.put("1001", '2');
		block.put("1010", '3');
		block.put("0110", '4');
		StringTokenizer st;
        st = new StringTokenizer(br.readLine().trim());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j]=='.') {
                    find(i,j);
                }					
            }
        }			
	}
	private static void find(int r, int c) {
		String str = "";
		top:
		for(int i=0; i<4; i++) {
			int nr = r+pos[i][0];
			int nc = c+pos[i][1];
			if(isOk(nr,nc)) {
				for(int j=0; j<4; j++) {
					if(map[nr][nc]==dir[i][j]) {
						str+=1;
						continue top;
					}
				}
				str+=0;
			}else {
				str+=0;
			}
		}
		if(block.containsKey(str)) {
            System.out.println((r+1)+" "+(c+1)+" "+block.get(str));
            System.exit(0);
		}
	}
	private static boolean isOk(int r, int c) {
		return (r>=0 && c>=0 && r<R && c<C) ? true:false;
	}
}

