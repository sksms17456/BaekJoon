//
// 
//크기가 3×3인 배열 A가 있다. 1초가 지날때마다 배열에 연산이 적용된다.
//R 연산: 배열 A의 모든 행에 대해서 정렬을 수행한다. 행의 개수 ≥ 열의 개수인 경우에 적용된다.
//C 연산: 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수인 경우에 적용된다.
//한 행 또는 열에 있는 수를 정렬하려면, 각각의 수가 몇 번 나왔는지 알아야 한다. 그 다음, 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬한다. 그 다음에는 배열 A에 정렬된 결과를 다시 넣어야 한다. 정렬된 결과를 배열에 넣을 때는, 수와 등장 횟수를 모두 넣으며, 순서는 수가 먼저이다.
//예를 들어, [3, 1, 1]에는 3이 1번, 1가 2번 등장한다. 따라서, 정렬된 결과는 [3, 1, 1, 2]가 된다. 다시 이 배열에는 3이 1번, 1이 2번, 2가 1번 등장한다. 다시 정렬하면 [2, 1, 3, 1, 1, 2]가 된다.
//정렬된 결과를 배열에 다시 넣으면 행 또는 열의 크기가 커질 수 있다. R 연산이 적용된 경우에는 행의 크기가 가장 큰 행을 기준으로 모든 행의 크기가 커지고, C 연산이 적용된 경우에는 열의 크기가 가장 큰 열을 기준으로 모든 열의 크기가 커진다. 행 또는 열의 크기가 커진 곳에는 0이 채워진다. 수를 정렬할 때 0은 무시해야 한다. 예를 들어, [3, 2, 0, 0]을 정렬한 결과는 [3, 2]를 정렬한 결과와 같다.
//행 또는 열의 크기가 100을 넘어가는 경우에는 처음 100개를 제외한 나머지는 버린다.
//배열 A에 들어있는 수와 r, c, k가 주어졌을 때, A[r][c]에 들어있는 값이 k가 되기 위한 최소 시간을 구해보자.
//입력 
//첫째 줄에 r, c, k가 주어진다. (1 ≤ r, c, k ≤ 100)
//둘째 줄부터 3개의 줄에 배열 A에 들어있는 수가 주어진다. 배열 A에 들어있는 수는 100보다 작거나 같은 자연수이다.
//출력 
//A[r][c]에 들어있는 값이 k가 되기 위한 연산의 최소 시간을 출력한다. 이 값이 100을 넘어가는 경우에는 -1을 출력한다.
package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산 {
	static int r, c, k, R=3, C=3, ans=0;
	static int[][] arr = new int[100][100];
	static int[] count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_17140_이차원배열과연산.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(arr[r][c]==k) {
			System.out.println(ans);
			System.exit(0);
		}
		while(ans++<=100) {
			if(R>=C) {
				int maxlen=0;
				for(int i=0; i<R; i++) {
					count = new int[101];
					ArrayList<int[]> list = new ArrayList<>();
					for(int j=0; j<C; j++) {
						count[arr[i][j]]++;
					}
					for(int j=1; j<=100; j++) {
						if(count[j]!=0) {
							list.add(new int[] {j,count[j]});
						}
					}
					Collections.sort(list, new Comparator<int[]>() {
						@Override
						public int compare(int[] o1, int[] o2) {
							if(o1[1]==o2[1]) {
								return o1[0]-o2[0];
							}
							return o1[1]-o2[1];
						}
					});
					int len = 0;
					if(list.size()*2>=100) {
						len = 50;
						for(int j=0; j<len; j++) {
							arr[i][j*2] = list.get(j)[0];
							arr[i][j*2+1] = list.get(j)[1];
						}
					}else {
						len = list.size();
						for(int j=0; j<len; j++) {
							arr[i][j*2] = list.get(j)[0];
							arr[i][j*2+1] = list.get(j)[1];
						}
						for(int j=len*2; j<100; j++) {
							arr[i][j] = 0;
						}
					}
					
					maxlen = Math.max(maxlen, len*2);
				}
				if(arr[r][c]==k) {
					System.out.println(ans);
					System.exit(0);
				}
				C = maxlen;
			}else {
				int maxlen=0;
				for(int i=0; i<C; i++) {
					count = new int[101];
					ArrayList<int[]> list = new ArrayList<>();
					for(int j=0; j<R; j++) {
						count[arr[j][i]]++;
					}
					for(int j=1; j<=100; j++) {
						if(count[j]!=0) {
							list.add(new int[] {j,count[j]});
						}
					}
					Collections.sort(list, new Comparator<int[]>() {
						@Override
						public int compare(int[] o1, int[] o2) {
							if(o1[1]==o2[1]) {
								return o1[0]-o2[0];
							}
							return o1[1]-o2[1];
						}
					});
					int len = 0;
					if(list.size()*2>=100) {
						len = 50;
						for(int j=0; j<len; j++) {
							arr[j*2][i] = list.get(j)[0];
							arr[j*2+1][i] = list.get(j)[1];
						}
					}else {
						len = list.size();
						for(int j=0; j<len; j++) {
							arr[j*2][i] = list.get(j)[0];
							arr[j*2+1][i] = list.get(j)[1];
						}
						for(int j=len*2; j<100; j++) {
							arr[j][i] = 0;
						}
					}
					maxlen = Math.max(maxlen, len*2);
				}
				if(arr[r][c]==k) {
					System.out.println(ans);
					System.exit(0);
				}
				R = maxlen;
			}
		}
		System.out.println(-1);
	}
}
