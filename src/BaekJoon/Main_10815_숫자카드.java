//문제
//숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이가 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다. 두 숫자 카드에 같은 수가 적혀있는 경우는 없다.
//
//셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다
//
//출력
//첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 아니면 0을 공백으로 구분해 출력한다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10815_숫자카드 {
	static int N, M;
	static int[] card, find, sorted;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_10815_숫자카드.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		card = new int[N];
		sorted = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
//		quicksort(card, 0, N-1);
		mergeSort(card, 0, N-1);
		
		
		M = Integer.parseInt(br.readLine());
		find = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			find[i] = Integer.parseInt(st.nextToken());
			sb.append(binarysearch(card, find[i])).append(" ");
		}
		System.out.println(sb);
	}
	public static int binarysearch(int[] arr, int num) {
		int left = 0;
		int right = arr.length-1;
		int mid;
		
		while(left <= right) {
			mid = (left + right)>>1;
			if(arr[mid]==num) {
				return 1;
			}else if(num > arr[mid]) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		return 0;
	}
	
	public static void mergeSort(int[] arr, int start, int len) {
		if (start >= len)
			return;

		int mid = ((len - start)>>1) + start;
		int left = start;
		int right = mid + 1;
		int index = start;

		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, len);

		while (left <= mid && right <= len) {
			if (arr[left] < arr[right]) {
				sorted[index++] = arr[left++];
			} else {
				sorted[index++] = arr[right++];
			}
		}
		while (left <= mid) {
			sorted[index++] = arr[left++];
		}
		while (right <= len) {
			sorted[index++] = arr[right++];
		}
		for(int i=start; i<=len; i++) {
			arr[i] = sorted[i];
		}
	}
	
	public static void quicksort(int[] arr, int start, int end) {
		if(start>=end) {
			return;
		}
		
		int pivot = arr[start];
		int left = start+1;
		int right = end;
		
		while(true) {
			while(arr[left] <= pivot && left < end) {
				left++;
			}
			while(arr[right] >= pivot && right > start) {
				right--;
			}
			if(left >= right) {
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
