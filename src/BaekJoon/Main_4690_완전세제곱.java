//
//문제
//페르마의 마지막 정리는, a, b, c가 0이 아닌 정수이고, n이 2보다 큰 자연수 일 때, an = bn + cn을 만족하는 자연수 a, b, c가 존재하지 않는다는 정리이다. 이 정리는 아직 증명되지 않았다.
//
//하지만, 완전 세제곱 방정식 a3 = b3 + c3 + d3을 만족하는 1보다 큰 자연수를 찾는 것은 어렵지 않다. (123 = 63 + 83 + 103)
//
//이러한 완전 세제곱 방정식과 a ≤ 100을 만족하는 {a, b, c, d}쌍을 모두 찾는 프로그램을 작성하시오.
//
//입력
//이 문제는 입력이 없다.
//
//출력
//a값이 증가하는 순서대로 아래 출력 형식과 같이 출력한다. b, c, d도 증가하는 순서로 이루어져야 한다. a값에 해당하는 b, c, d쌍이 여러 개 존재할 수 있다. 이때는 b 값이 작은 것부터 먼저 출력한다.
//
//아래 출력 예제는 일부분만 나와있다.
package BaekJoon;

public class Main_4690_완전세제곱 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=2; i<101; i++) {
			for(int n1=2; n1<i; n1++) {
				for(int n2=n1+1; n2<i; n2++) {
					for(int n3=n2+1; n3<i; n3++) {
						if(Math.pow(i, 3) == Math.pow(n1, 3)+Math.pow(n2, 3)+Math.pow(n3, 3)) {
							sb.append("Cube = "+i+", Triple = ("+n1+","+n2+","+n3+")\n");
						}
					}
				}
			}
		}
		System.out.println(sb);
	}
}
