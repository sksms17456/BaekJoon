package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_16939_2x2x2큐브 {
	static int[] cube=new int[25];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_16939_2x2x2큐브.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<cube.length; i++) {
			cube[i] = Integer.parseInt(st.nextToken());
		}
		if(cube[1]==cube[3] && cube[3]==cube[6] && cube[6]==cube[8]
				&& cube[5]==cube[7] && cube[7]==cube[10] && cube[10]==cube[12]
				&& cube[9]==cube[11] && cube[11]==cube[23] && cube[23]==cube[21]
				&& cube[24]==cube[22] && cube[22]==cube[2] && cube[2]==cube[4]
				&& cube[13]==cube[14] && cube[14]==cube[15] && cube[15]==cube[16]
				&& cube[17]==cube[18] && cube[18]==cube[19] && cube[19]==cube[20]) {
			System.out.println(1);
		}
		else if(cube[1]==cube[3] && cube[3]==cube[23] && cube[23]==cube[21]
				&& cube[5]==cube[7] && cube[7]==cube[2] && cube[2]==cube[4]
				&& cube[9]==cube[11] && cube[11]==cube[8] && cube[8]==cube[6]
				&& cube[24]==cube[22] && cube[22]==cube[12] && cube[12]==cube[10]
				&& cube[13]==cube[14] && cube[14]==cube[15] && cube[15]==cube[16]
				&& cube[17]==cube[18] && cube[18]==cube[19] && cube[19]==cube[20]) {
			System.out.println(1);
		}else if(cube[13]==cube[14] && cube[14]==cube[7] && cube[7]==cube[8]
				&& cube[5]==cube[6] && cube[6]==cube[19] && cube[19]==cube[20]
				&& cube[17]==cube[18] && cube[18]==cube[23] && cube[23]==cube[24]
				&& cube[21]==cube[22] && cube[22]==cube[15] && cube[15]==cube[16]
				&& cube[1]==cube[2] && cube[2]==cube[3] && cube[3]==cube[4]
				&& cube[9]==cube[10] && cube[10]==cube[11] && cube[11]==cube[12]) {
			System.out.println(1);
		}else if(cube[13]==cube[14] && cube[14]==cube[23] && cube[23]==cube[24]
				&& cube[5]==cube[6] && cube[6]==cube[15] && cube[15]==cube[16]
				&& cube[17]==cube[18] && cube[18]==cube[7] && cube[7]==cube[8]
				&& cube[21]==cube[22] && cube[22]==cube[19] && cube[19]==cube[20]
				&& cube[1]==cube[2] && cube[2]==cube[3] && cube[3]==cube[4]
				&& cube[9]==cube[10] && cube[10]==cube[11] && cube[11]==cube[12]) {
			System.out.println(1);
		}else if(cube[21]==cube[22] && cube[22]==cube[23] && cube[23]==cube[24]
				&& cube[5]==cube[6] && cube[6]==cube[7] && cube[7]==cube[8]
				&& cube[3]==cube[4] && cube[4]==cube[18] && cube[18]==cube[20]
				&& cube[17]==cube[19] && cube[19]==cube[12] && cube[12]==cube[11]
				&& cube[10]==cube[9] && cube[9]==cube[15] && cube[15]==cube[13]
				&& cube[1]==cube[2] && cube[2]==cube[16] && cube[16]==cube[14]) {
			System.out.println(1);
		}else if(cube[21]==cube[22] && cube[22]==cube[23] && cube[23]==cube[24]
				&& cube[5]==cube[6] && cube[6]==cube[7] && cube[7]==cube[8]
				&& cube[1]==cube[2] && cube[2]==cube[17] && cube[17]==cube[19]
				&& cube[18]==cube[20] && cube[20]==cube[10] && cube[10]==cube[9]
				&& cube[12]==cube[11] && cube[11]==cube[16] && cube[16]==cube[14]
				&& cube[15]==cube[13] && cube[13]==cube[3] && cube[3]==cube[4]) {
			System.out.println(1);
		}else
			System.out.println(0);
	}
}
