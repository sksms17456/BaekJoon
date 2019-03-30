package BaekJoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{
	static int R, C;
	static char[][] map;
	static int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};
	static char[][] dir = {{'|','+','1','4'}
							,{'|','+','2','3'}
							,{'-','+','1','2'}
							,{'-','+','3','4'}};
	static Map<String,Character> block = new HashMap<>();
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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