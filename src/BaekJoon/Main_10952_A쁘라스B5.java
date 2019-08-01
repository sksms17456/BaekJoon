package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main_10952_A쁘라스B5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_10952_A쁘라스B5.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	    while(true){
	    	String line = br.readLine();
	    	if(line.charAt(0)-'0'==0) {
	    		break;
	    	}
	    	sb.append((line.charAt(0)-'0')+(line.charAt(2)-'0')).append("\n");
	    }
	    System.out.println(sb);
	}
}
