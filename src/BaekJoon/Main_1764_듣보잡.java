package BaekJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class Main_1764_듣보잡{
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		ArrayList<String> arr= new ArrayList<String>();
		for(int i=0; i<N; i++) {
			String s = sc.next();
			arr.add(s);
		}
		
		Collections.sort(arr);
		
		String[] str = new String[arr.size()];
		str = arr.toArray(str);
		
		ArrayList<String> arr2 = new ArrayList<String>();
		for(int i=0; i<M; i++) {
			String s = sc.next();
			int idx=Arrays.binarySearch(str, s);
			if(idx>=0)
				arr2.add(s);
		}
		Collections.sort(arr2);
		System.out.println(arr2.size());
		for(String a : arr2) {
			System.out.println(a);
		}
	}
}