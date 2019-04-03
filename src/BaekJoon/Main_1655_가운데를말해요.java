//문제 
//
//수빈이는 동생에게 "가운데를 말해요" 게임을 가르쳐주고 있다. 
//
//수빈이가 정수를 하나씩 외칠때마다 동생은 지금까지 수빈이가 말한 수 중에서 중간값을 말해야 한다. 
//
//만약, 그동안 수빈이가 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.
//
//예를 들어 수빈이가 동생에게 1, 5, 2, 10, -99, 7, 5를 순서대로 외쳤다고 하면, 동생은 1, 1, 2, 2, 2, 2, 5를 차례대로 말해야 한다. 
//
//수빈이가 외치는 수가 주어졌을 때, 동생이 말해야 하는 수를 구하는 프로그램을 작성하시오.
//
//입력 
//
//첫째 줄에는 수빈이가 외치는 정수의 개수 N이 주어진다. N은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수이다. 
//
//그 다음 N줄에 걸쳐서 수빈이가 외치는 정수가 차례대로 주어진다. 정수는 -10,000보다 크거나 같고, 10,000보다 작거나 같다.
//
//출력 
//
//한 줄에 하나씩 N줄에 걸쳐 수빈이의 동생이 말해야하는 수를 순서대로 출력한다.
package BaekJoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1655_가운데를말해요 {
	static int N, n;
	static PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	});	
	static PriorityQueue<Integer> right = new PriorityQueue<>();
	public static void main(String[] args) throws  Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_1655_가운데를말해요.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			n = Integer.parseInt(br.readLine());
			if(left.size()!=right.size()) {
				right.add(n);
			}else {
				left.add(n);
			}
			if(left.size()>0 && right.size()>0) {
				if(left.peek()>right.peek()) {
					int ltemp = left.poll();
					int rtemp = right.poll();
					right.add(ltemp);
					left.add(rtemp);
				}
			}			
			System.out.println(left.peek());
		}	
	}
}

