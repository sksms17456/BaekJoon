//문제
//창영이는 강산이의 비밀번호를 훔치기 위해서 강산이가 사용하는 컴퓨터에 키로거를 설치했다. 며칠을 기다린 끝에 창영이는 강산이가 비밀번호 창에 입력하는 글자를 얻어냈다.
//
//키로거는 사용자가 키보드를 누른 명령을 모두 기록한다. 따라서, 강산이가 비밀번호를 입력할 때, 화살표나 백스페이스를 입력해도 정확한 비밀번호를 알아낼 수 있다.
//
//강산이가 비밀번호 창에서 입력한 키가 주어졌을 때, 강산이의 비밀번호를 알아내는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한줄로 이루어져 있고, 강산이가 입력한 순서대로 길이가 L인 문자열이 주어진다. (1 ≤ L의 길이 ≤ 1,000,000) 강산이가 백스페이스를 입력했다면, '-'가 주어진다. 이때 커서의 바로 앞에 글자가 존재한다면, 그 글자를 지운다. 화살표의 입력은 '<'와 '>'로 주어진다. 이때는 커서의 위치를 움직일 수 있다면, 왼쪽 또는 오른쪽으로 1만큼 움직인다. 나머지 문자는 비밀번호의 일부이다. 물론, 나중에 백스페이스를 통해서 지울 수는 있다. 만약 커서의 위치가 줄의 마지막이 아니라면, 그 문자를 입력하고, 커서는 오른쪽으로 한 칸 이동한다.
//
//출력
//각 테스트 케이스에 대해서, 강산이의 비밀번호를 출력한다. 비밀번호의 길이는 항상 0보다 크다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_5397_키로거 {
	static class Stack{
		private int top;
	    private int maxSize;
	    private char[] stackArray;
	    
	    public Stack(int maxSize){	        
	        this.maxSize = maxSize;
	        this.stackArray = new char[maxSize];
	        this.top = -1;
	    }
	    
	    public boolean empty(){
	        return (top == -1);
	    }
	    
	    public boolean full(){
	        return (top == maxSize-1);
	    }
	    
	    public void push(char item){
	        if(full()) throw new ArrayIndexOutOfBoundsException((top+1)+">=" + maxSize);
	        stackArray[++top] = item;
	    }
	    
	    public char peek(){
	        if(empty()) throw new ArrayIndexOutOfBoundsException(top);
	        return stackArray[top];
	    }
	    public char pop(){
	    	char item = peek();
	    	stackArray[top] = ' ';
	        top--;
	        return item;
	    }
	    public String toString() {
	    	String ans = "";
	    	for(int i=0; i<top+1; i++) {
	    		ans+=stackArray[i];
	    	}
	    	return ans;
	    }
	    public String toRevString() {
	    	String ans = "";
	    	for(int i=top; i>=0; i--) {
	    		ans+=stackArray[i];
	    	}
	    	return ans;
	    }
	}
	static int T, cursor, len;
	static String input, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_5397_키로거.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int cursor = 0;
			sb = new StringBuilder();
			input = br.readLine();
			len = input.length();
			
			Stack stack1 = new Stack(len);
			Stack stack2 = new Stack(len);
			
			for(int i=0; i<len; i++) {
				
				char ch = input.charAt(i);
				
				switch (ch) {
				case '>':
					if(stack2.top==-1) {
						continue;
					}else {
						stack1.push(stack2.pop());
					}
					break;
				case '<':
					if(stack1.top==-1) {
						continue;
					}else {
						stack2.push(stack1.pop());
					}
					break;
				case '-':
					if(stack1.top==-1) {
						continue;
					}else {
						stack1.pop();
					}
					break;
				default:
					stack1.push(ch);
					break;
				}
			}
			
			sb.append(stack1.toString());
			sb.append(stack2.toRevString());
			
			bw.write(sb.toString());
			bw.write("\n");
		}
		bw.flush();
	}
}
