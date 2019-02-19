//문제
//'2001: 스페이스 오디세이'는 아서 C. 클라크의 소설이자 스탠리 큐브릭 감독의 영화이다.
//
//이 작품에서 우주선은 토성으로 가고 있다. 긴 여행동안 선원들은 모두 정체 상태에 빠져있고, 두 선원은 깨어나 있다. 
//
//우주선은 인공지능 컴퓨터 HAL이 조정하고 있다. HAL은 점점 이상하게 행동하더니 선원들을 죽이기 시작했다. 자세한 이야기는 소설을 읽거나 영화를 보면 알 수 있다.
//
//영화가 유명해지고 난 이후에 사람들은 '2001: 스페이스 오디세이'에 나오는 인공지능 컴퓨터인 HAL의 뜻에 관심을 가졌다. 
//
//HAL은 휴리스틱 알고리즘 (Heuristic ALgorithm)의 약자이다. 하지만, HAL의 각 글자를 알파벳 다음 순서로 쓰면 IBM이 되기 때문에, IBM과 연관이 있다고 믿는 사람이 매우 많다.
//
//컴퓨터의 이름이 주어졌을 때, 각 글자를 알파벳 다음 순서로 써서 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 컴퓨터의 개수 n이 주어진다. 다음 줄부터 n개의 줄에는 컴퓨터의 이름이 주어진다. 컴퓨터의 이름은 최대 50글자이며, 알파벳 대문자로만 이루어져 있다.
//
//출력
//입력으로 주어진 컴퓨터 이름에 대해서, 한 줄에 하나씩 각 글자를 알파벳 다음 순서로 써서 출력한다. 각각의 컴퓨터 이름 사이에는 빈 줄을 하나씩 출력한다.
//
//알파벳 Z의 다음 순서는 A이다.

package BaekJoon;

import java.io.*;

public class Main_6321_IBM빼기1 {
	static int N;
	static char[] hal;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("Main_6321_IBM빼기1.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			sb = new StringBuilder();
			hal = br.readLine().toCharArray();
			for(int j=0; j<hal.length; j++) {
				if(hal[j]=='Z') {
					sb.append("A");
				}else {
					hal[j] = (char) (hal[j]-'A'+'B');
					sb.append(String.valueOf(hal[j]));
				}
			}
			sb.insert(0, "String #"+i+"\n");
			System.out.println(sb+"\n");
		}
	}
}
