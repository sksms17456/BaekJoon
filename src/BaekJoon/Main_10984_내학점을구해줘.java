//문제
//게으른 근우는 열심히 놀다가 문득, 자신의 학점 평균이 얼마일지 궁금해졌다. 학사시스템도 들어가기 귀찮아하는 근우를 위해 구해주도록 하자. 
//
//입력
//첫 번째 줄에 학기의 수 T가 주어진다. 두 번째 줄부터 T개 학기에 대한 정보가 주어진다.
//
//각 학기에 대한 정보는 다음과 같이 구성되어 있다. 첫 번째 줄에 들었던 과목의 수 N이 주어지고, 
//다음 N개 줄에 걸쳐서 N개 과목들의 학점 C와 성적 G가 주어진다. (1 ≤ N ≤ 10, 1 ≤ C ≤ 6의 정수) 
//G는 {0, 0.7, 1, 1.3, 1,7, 2, 2.3, 2.7, 3, 3.3, 3.7, 4, 4.3} 중 하나이며 소수 부분은 최대 한 자리까지 주어진다.
//
//출력
//각 학기에 대해 근우의 총 학점과 평점(GPA)을 출력한다. 평점은 소수점 아래 두 번째 자리에서 반올림한다. 
package BaekJoon;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main_10984_내학점을구해줘 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Main_10984_내학점을구해줘.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int N = sc.nextInt();
			int csum=0;
			float sum = 0;
			for(int i=0; i<N; i++) {
				int C = sc.nextInt();
				float G = sc.nextFloat();
				csum+=C;
				sum+=C*G;
			}
			System.out.println(csum+" "+Math.round(sum/csum*10)/10.0);
		}
		
		
	}
}
