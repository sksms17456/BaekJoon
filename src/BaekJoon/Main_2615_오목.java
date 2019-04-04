package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2615_오목 {
		static int[][] omok = new int[19][19];
		static int cnt1, cnt2, ans;
		public static void main(String[] args) throws  Exception{
			BufferedReader br = new BufferedReader(new FileReader("res/Main_2615_오목.txt"));
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			for(int i=0; i<19; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<19; j++) {
					omok[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<19; i++) {
				for(int j=0; j<15; j++) {
					ans=0;
					cnt1=0;
					cnt2=0;
					for(int k=j; k<j+5; k++) {
						if(omok[i][k]==1) cnt1++;
						else if(omok[i][k]==2) cnt2++;
					}
					if(cnt1==5) {
						ans = 1;
					}else if(cnt2==5) {
						ans = 2;
					}
					if(ans!=0) {
						if(j<14) {
							if(omok[i][j+5]==ans)
								continue;
						}
						if(j>0) {
							if(omok[i][j-1]==ans)
								continue;
						}
						System.out.println(ans);
						System.out.println((i+1)+" "+(j+1));
						System.exit(0);
					}
				}
			}
			for(int i=0; i<15; i++) {
				for(int j=0; j<19; j++) {
					ans=0;
					cnt1=0;
					cnt2=0;
					for(int k=i; k<i+5; k++) {
						if(omok[k][j]==1) cnt1++;
						else if(omok[k][j]==2) cnt2++;
					}
					if(cnt1==5) {
						ans = 1;
					}else if(cnt2==5) {
						ans = 2;
					}
					if(ans!=0) {
						if(i<14) {
							if(omok[i+5][j]==ans)
								continue;
						}
						if(i>0) {
							if(omok[i-1][j]==ans)
								continue;
						}
						System.out.println(ans);
						System.out.println((i+1)+" "+(j+1));
						System.exit(0);
					}
				}
			}
			for(int i=0; i<15; i++) {
				for(int j=0; j<15; j++) {
					ans=0;
					cnt1=0;
					cnt2=0;
					for(int k=0; k<5; k++) {
						if(omok[i+k][j+k]==1) cnt1++;
						else if(omok[i+k][j+k]==2) cnt2++;
					}
					if(cnt1==5) {
						ans = 1;
					}else if(cnt2==5) {
						ans = 2;
					}
					if(ans!=0) {
						if(i<14 && j<14) {
							if(omok[i+5][j+5]==ans)
								continue;
						}
						if(i>0 && j>0) {
							if(omok[i-1][j-1]==ans)
								continue;
						}
						System.out.println(ans);
						System.out.println((i+1)+" "+(j+1));
						System.exit(0);
					}
				}
			}
			for(int i=0; i<15; i++) {
				for(int j=4; j<19; j++) {
					ans=0;
					cnt1=0;
					cnt2=0;
					for(int k=0; k<5; k++) {
						if(omok[i+k][j-k]==1) cnt1++;
						else if(omok[i+k][j-k]==2) cnt2++;
					}
					if(cnt1==5) {
						ans = 1;
					}else if(cnt2==5) {
						ans = 2;
					}
					if(ans!=0) {
						if(i<14 && j>4) {
							if(omok[i+5][j-5]==ans)
								continue;
						}
						if(i>0 && j<18) {
							if(omok[i-1][j+1]==ans)
								continue;
						}
						System.out.println(ans);
						System.out.println((i+5)+" "+(j-3));
						System.exit(0);
					}
				}
			}
			System.out.println(0);
		}
	}