package BaekJoon;
//5
//1 1
//12 34
//5 500
//40 60
//1000 1000
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ2558 {
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			String[] s = input.readLine().split(" ");
			int sum=Integer.parseInt(s[0])+Integer.parseInt(s[1]);
			output.write(sum+"\n");
		}
		output.flush();

	}
}
