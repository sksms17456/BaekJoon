//문제
//싱기한 네자리 숫자란, [1000,9999]인 10진수 숫자중에서,  다음의 조건을 만족하는 숫자를 말한다.
//
//숫자를 10진수, 12진수, 16진수로 나타낸 다음, 각각의 숫자에 대해, 각 숫자의 자리수를 더했을 때, 세 값이 모두 같아야 한다.
//여러분은 싱기한 네자리 숫자를 모두 출력해야 한다.
//
//입력
//입력은 주어지지 않는다.
//
//출력
//싱기한 네자리 숫자를 오름차순으로 한줄에 하나씩 출력한다.
package BaekJoon;

public class Main_6679_싱기한네자리숫자 {
	static char[] oct, tlv, hex;
	static int o, t, h;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		StringBuilder tlvstr;
		for(int i=1000; i<10000; i++) {
			o = 0; h = 0; t = 0;
			
			oct = Integer.toString(i).toCharArray();
			for(int j=0; j<oct.length; j++) {
				o+=oct[j]-'0';
			}
			
			hex = Integer.toHexString(i).toCharArray();
			for(int j=0; j<hex.length; j++) {
				if(Character.isDigit(hex[j])) {
					h+=hex[j]-'0';
				}
				else {
					h+=hex[j]-'W';
				}
			}
			
			if(o!=h)
				continue;
			
			tlvstr = new StringBuilder();
			int val = 12*12*12;
			int r = i;
			
			for(int j=0; j<4; j++) {
				int q = r/val;
				r = r%val;
				val/=12;
				if(q==10)
					tlvstr.append("a");
				else if(q==11)
					tlvstr.append("b");
				else
					tlvstr.append(q);
			}
			
			tlv = tlvstr.toString().toCharArray();
			
			for(int j=0; j<tlv.length; j++) {
				if(Character.isDigit(tlv[j])) {
					t+=tlv[j]-'0';
				}
				else {
					t+=tlv[j]-'W';
				}
			}
			
			if(o==t)
				sb.append(i+"\n");
		}
		System.out.println(sb);
	}
}
