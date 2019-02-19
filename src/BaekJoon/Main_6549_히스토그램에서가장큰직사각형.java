package BaekJoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main_6549_히스토그램에서가장큰직사각형 {
	static String[] line;
	static int[] high;
	static int length, width, start;
	static long max, area;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_6549_히스토그램에서가장큰직사각형.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set;
		
		while(true) {
			line = br.readLine().split(" ");
			
			if(line[0].equals("0")) {
				break;
			}
				
			length = line.length;
			high = new int[length];
			max = Integer.MIN_VALUE;
					
			set = new HashSet<>();
			for(int i=0; i<length; i++) {
				high[i] = Integer.parseInt(line[i]);
				set.add(high[i]);
			}
			
			for(Integer top:set) {
				start = 0;
				boolean isOk = false;
				for(int i=0; i<length; i++) {
					if(!isOk) {
						if(high[i]>=top) {
							start = i;
							area = 0;
							isOk = true;
						}
					}
					else {
						if(i==length-1) 
							width = i-start+1;
						else			
							width = i-start;
						if(high[i]<top) {
							area = top*(width);
							isOk = false;
						}else {
							if(i==length-1) {
								area = top*(width);
							}else
								continue;
						}
						max = Math.max(area, max);
					}
				}
			}
			System.out.println(max);
		}
	}
}
