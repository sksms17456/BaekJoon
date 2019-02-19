//
//문제
//e는
//
//이다. 여기서 n은 무한대이다.
//
//매우 작은 n에 대해서, e의 근사값을 구해보자.
//
//출력
//아래 결과와 같은 형식으로 e의 근사값을 n = 0부터 9까지 출력한다. 
package BaekJoon;

public class Main_6376_e계산 {
	static double v;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("n e\n- -----------\n");
		for(int i=0; i<10; i++) {
			v += 1/fac((double)i);
			if(i<2) {
				sb.append(i+" "+(int)v+"\n");
				continue;
			}else if(i==2) {
				sb.append(i+" "+String.format("%.1f", v)+"\n");
			}else {
				sb.append(i+" "+String.format("%.9f", v)+"\n");
			}
		}
		System.out.println(sb);
	}
	public static double fac(double n) {
		if(n<=1) return 1;
		return n*fac(n-1);
	}
}
