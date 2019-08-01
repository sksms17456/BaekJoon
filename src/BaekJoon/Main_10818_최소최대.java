//문제
//N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
//
//출력
//첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10818_최소최대 {
	static int N;
	static int[] num;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_10818_최소최대.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}		
		quicksort(num, 0, num.length-1);
		System.out.println(num[0]+" "+num[N-1]);
	}
	public static void quicksort(int[] arr, int start, int end) {
		if(start>=end) return;
		int pivot = arr[start];
		int left = start+1;
		int right = end;
		while(true) {
			while(arr[left]<=pivot && left<end) {
				left++;
			}
			while(arr[right]>=pivot && right>start) {
				right--;
			}
			if(left>=right) {
				int temp = arr[start];
				arr[start] = arr[right];
				arr[right] = temp;
				break;
			}else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		quicksort(arr, start, right-1);
		quicksort(arr, right+1, end);
	}
}

