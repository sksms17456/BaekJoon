package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

   static int N , K;
   static int top[];
   static int seq[];
   static boolean flag[];
   static int makeSeq() {
      
      flag = new boolean[N];
      for(int i=1; i<N; i++) {
         seq[i] = (i)*K;
      }
      int temp =0;
      
      for(int a1=0; a1<=1000; a1++) {
         int cpy =0;
         boolean comp = true;
         for(int j=0; j<N; j++) {
            if(a1+seq[j]!=top[j]) {
               cpy++;
            }
            if(a1!=1 && cpy >=temp) {
               comp =false;
               break;
            }
         }
         if(comp) {
            temp = cpy;
         }
         
      }
      return temp;
      
   }
   public static void main(String[] args)throws Exception {
      // TODO Auto-generated method stub
      BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      st= new StringTokenizer(br.readLine());
      top = new int[N];
      seq = new int[N];
      for(int i=0; i<N; i++) {
         top[i] = Integer.parseInt(st.nextToken());
      }
      bw.write( makeSeq()+"\n");
      bw.flush();
   }

}