package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Main{
    static int N, M, H, day, cnt;
    static int[][][] Box;
    static int[][][] pos = {{{0,-1,0},{0,1,0},{0,0,1},{0,0,-1},{1,0,0},{-1,0,0}}};
    static LinkedList<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception{
    	Scanner s = new Scanner(System.in);
        M = s.nextInt();
        N = s.nextInt();
        H = s.nextInt();
        Box = new int[H][N][M];
         
        for(int h=0; h<H; h++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    Box[h][i][j] = s.nextInt();
                    if(Box[h][i][j]==1) {
                        queue.offer(new int[] {h,i,j,0});
                    }else if(Box[h][i][j]==0) {
                        cnt++;
                    }
                }
            }
        }   
        if(!queue.isEmpty()) {
            bfs();
            if(cnt>0) {
                System.out.println("-1");
            }else {
                System.out.println(day);
            }   
        }else {
            System.out.println(0);
        }   
    }
    private static void bfs() {
        int[] temp=new int[4];
        while(!queue.isEmpty()) {
            temp = queue.poll();
            for(int i=0; i<6; i++) {
                int nh = temp[0]+pos[0][i][0];
                int nr = temp[1]+pos[0][i][1];
                int nc = temp[2]+pos[0][i][2];
                if(isOk(nh,nr,nc)) {
                    Box[nh][nr][nc]=1;
                    cnt--;
                    queue.offer(new int[] {nh,nr,nc,temp[3]+1});
                }
            }
        }
        day = temp[3];
    }
    private static boolean isOk(int h, int r, int c) {
        if(r>=0 && c>=0 && h>=0 && r<N && c<M && h<H && Box[h][r][c]==0) {
            return true;
        }
        return false;
    }
}