package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args)throws Exception {
      // TODO Auto-generated method stub
      int[] arr = {1,2,3};
      System.out.println(Arrays.toString(arr));
      change(arr);
      System.out.println(Arrays.toString(arr));
   }
   static void change(int[] arr) {
	   arr[0] = 1;
	   arr[1] = 1;
	   arr[2] = 1;
   }

}