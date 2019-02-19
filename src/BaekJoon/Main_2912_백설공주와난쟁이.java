//문제
//
//백설 공주와 난쟁이 N명과 함께 숲 속에 살고 있다. 난쟁이는 매일 광산에 일하러가고, 백설 공주는 그동안 페이스북을 하고 있다.
//
//매일 아침 난쟁이는 한 줄로 휘파람을 불면서 광산으로 출근을 한다. 백설 공주는 그 주변을 돌아다니면서 난쟁이들 사진을 찍는다.
//
//난쟁이가 광산에 들어가면, 백설 공주는 다시 집으로 돌아간다. 집으로 돌아가면서 찍은 사진 중에 페이스북에 올릴 예쁜 사진을 고른다. 
//
//각 난쟁이는 모두 모자를 쓰고 있다. 모자의 색상은 총 C가지가 있다. 
//
//사진에 찍힌 난쟁이가 쓰고 있는 모자의 색상 중 절반보다 많은 색이 같은 색이라면 예쁜 사진이다.
//
//즉, 사진에 난쟁이가 K명 찍혀있고, K/2보다 많은 난쟁이의 모자 색이 같다면 예쁜 사진이다.
//
//백설공주가 찍은 사진 M개와 각 사진에 찍힌 난쟁이가 주어졌을 때, 예쁜 사진인지 아닌지를 알아내는 프로그램을 작성하시오.
//
//입력
//
//첫째 줄에 난쟁이의 수 N과 모자 색상의 수 C가 주어진다. (3 ≤ N ≤ 300,000, 1 ≤ C ≤ 10,000)
//
//둘째 줄에는 각 난쟁이가 쓰고 있는 모자의 색상이 줄을 서 있는 순서대로 주어진다.
//
//셋째 줄에는 사진의 수 M이 주어진다. (1 ≤ M ≤ 10,000)
//
//다음 M개 줄에는 두 정수 A와 B가 주어진다. (1 ≤ A ≤ B ≤ N) 이 줄은 사진의 정보를 의미하고, 
//
//A번째 난쟁이부터 B번째 난쟁이까지 사진에 찍혔다는 뜻이다.
//
//출력
//
//출력은 총 M 줄이다. 각 사진이 예쁘지 않다면 "no"를 출력하고, 예쁘다면 "yes X"를 출력한다. 
//
//예쁜 사진인 경우에 X는 사진에 절반이 넘는 모자의 색상이다.

package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2912_백설공주와난쟁이 {
	static int N, C, M, A, B;
	static int[] color, cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_2912_백설공주와난쟁이.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		color = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			color[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			boolean check = false;
			cnt = new int[C+1];
			
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken())-1;
			B = Integer.parseInt(st.nextToken());
			
			for(int j=A; j<B; j++) {
				cnt[color[j]]++;
			}
			
			for(int j=1; j<cnt.length; j++) {
				if(cnt[j]>(B-A)/2) {
					check = true;
					System.out.println("yes "+j);
					break;
				}
			}
			if(!check)
				System.out.println("no");
		}
	}
}
