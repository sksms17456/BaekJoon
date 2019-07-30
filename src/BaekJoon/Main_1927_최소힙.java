package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main_1927_최소힙 {
	static int N, x;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_1927_최소힙.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Heap h = new Heap();
		for(int n=0; n<N; n++) {
			x = Integer.parseInt(br.readLine());
			if(x==0) {
				System.out.println(h.poll());
			}
			else {
				h.add(x);
			}
		}
	}
	
	public static class Heap{
		List<Integer> heap;
		
		public Heap() {
			heap = new ArrayList<Integer>();
			heap.add(0);
		}
		
		public void add(int n) {
			heap.add(n);
			
			int p = heap.size()-1;
			while(p<1 || heap.get(p/2)>heap.get(p)) {
				int temp = heap.get(p/2);
				heap.set(p/2, heap.get(p));
				heap.set(p, temp);
				p = p/2;
			}
		}
		
		public int poll() {
			if(heap.size()<=1) {
				return 0;
			}
			int item = heap.get(1);
			
			heap.set(1, heap.get(heap.size()-1));
			heap.remove(heap.size()-1);
			
			int pos = 1;
			while((pos*2) < heap.size()) {
				int min = heap.get(pos*2);
				int minpos = pos*2;
				
				if(((pos*2+1)<heap.size()) && min > heap.get(pos*2+1)) {
					min = heap.get(pos*2+1);
					minpos = pos*2+1;
				}
				if(heap.get(pos)<min) {
					break;
				}
				
				int temp = heap.get(pos);
				heap.set(pos, heap.get(minpos));
				heap.set(minpos, temp);
				pos = minpos;
			}
			return item;
		}		
	}
}
