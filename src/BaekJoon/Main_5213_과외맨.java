//문제
//과외맨은 평소에 서강대학교 학생 이민혁으로 위장하고 있는 한국의 대표적인 영웅이다. 그는 슈퍼 히어로가 너무 미국에 집중되어 있는 현실을 안타까워했고, 그의 절친한 친구인 스파이더맨과 아이언맨에게 한국으로 와서 같이 영웅 활동을 하자는 제안을 했으나 거절당했다.
//
//얼마 전, 오랜 잠에서 깨어난 고대 마야인들이 과외맨이 수업을 듣는 동안 과외 노트를 훔쳐갔다. 과외맨은 빼앗긴 노트를 찾아오기 위해 인천 공항으로 가서 과테말라로 가는 비행기를 탔다.
//
//일단 언어가 통하지 않기 때문에, 과외맨은 자신의 특기를 살려서 일주일간 과테말라에서 스페인어를 과외 받았다.
//
//오랜 고서에 의하면, 고대 마야인은 하늘을 날아다니는 재주가 있었다고 한다. 과외맨은 매일 밤 하늘을 바라보며 마야인들의 흔적을 찾으려고 애를 썼다.
//
//그렇게 한 달이 지났을까... 한국에선 이민혁 실종 사건이 연일 대서특필 되고 있고, 사람들은 사라진 과외맨을 찾으며 시청 광장에서 촛불 집회를 했다. 과외맨도 이런 사실에 안타까움을 느꼈다. 하지만, 과외 노트 없는 과외맨은 평범한 대학생과 같기 때문에 아직 돌아갈 수 없었다.
//
//과외 노트의 단서는 뜻하지 않게 스페인어 과외를 받던 중에 알게 되었다. 과외맨의 과외 선생님이 주말을 이용해서 등산을 하던 사이에 고대 마야의 사원으로 보이는 것을 발견했고, 민혁이에게 과외 노트가 거기에 있는 것 같다고 알려주었다.
//
//과외맨은 즉시 과외 노트를 찾으러 고대 마야의 사원으로 여행을 떠났다.
//
//고대 마야의 사원의 입구로 들어간 과외맨은 매우 놀랐다. 바로 과외 노트가 자신의 눈 앞에 있는 것 이었다. 과외맨은 이적의 다행이다를 부르면서 과외 노트를 집으려고 했지만, 그것은 노트의 홀로그램이었다. 이어서 고대 마야인의 목소리가 사원을 가득 채우기 시작했다. 하지만, 고대 마야인은 스페인어를 사용하지 않았다. 과외맨은 닥터후에게 전화를 걸어서 자신에게 타디스의 번역 프로토콜을 제공해 줄 수 있는지를 물어 보았다. 닥터는 흔쾌히 요청을 받아들였고, 민혁이는 마야인의 메시지를 듣기 위해 밖으로 나갔다가 다시 들어왔다.
//
//"하하하. 과외 노트를 돌려 받고 싶나? 그럼 여기로 와서 가져가 보시지. 하하하하"
//
//과외맨의 과외 노트는 입구의 반대편에 있고, 그 사이에는 절벽이 있었다. 갑자기 하늘에서 거대한 도미노 타일이 떨어졌고, 그 사이를 연결하는 다리를 만들었다.
//
//도미노 타일은 두 조각으로 나누어져 있었고, 각 조각은 정사각형이다. 조각에는 1과 6사이의 숫자가 써져 있다.
//
//타일은 N줄로 놓여져 있고, 홀수 줄에는 N개의 타일이, 짝수 줄에는 N-1개의 타일이 놓여져 있다. 아래 그림은 (N=5)일 때 타일이 놓여져 있는 형태이다.
//
//
//
//한 타일에서 다른 타일로 넘어가려면, 두 타일이 인접해야 한다. 또, 같은 변을 공유하는 조각에 쓰여 있는 숫자가 같아야 한다.
//
//과외맨은 반대편으로 넘어가기 위해서 첫 줄의 가장 첫 타일에서 마지막 줄의 가장 마지막 타일로 이동하는 가장 짧은 경로를 찾으려고 한다.
//
//타일은 row-major order에 의해서 번호가 매겨져 있으며, 첫 번째 줄의 첫 타일의 번호는 1, 마지막 타일의 번호는 N이다. 두 번째 줄에서 첫 타일의 번호는 N+1이고, 마지막 타일의 번호는 2*N-1이다.
//
//첫 줄의 첫 타일로만 과외맨이 들어갈 수 있고, 마지막 줄의 마지막 타일위에 과외 노트가 놓여져 있다.
//
//마지막 줄의 마지막 타일로 이동할 수 없는 경우가 존재할 수 있다. 이 경우에는 번호가 가장 큰 타일로 이동하면 된다.
//
//입력
//첫째 줄에 N이 주어진다. (1 ≤ N ≤ 500) 다음 줄부터 N*N-N/2줄(/는 정수 나눗셈이다)에는 두 양의 Ai와 Bi가 주어진다. (1 ≤ Ai, Bi ≤ 6, 1 ≤ i ≤ N * N - N / 2) 타일 i의 왼쪽에 쓰여 있는 숫자는 Ai, 오른쪽에 쓰여 있는 숫자는 Bi이다.
//
//출력
//첫째 줄에 가장 짧은 경로의 길이 (타일의 개수)를 출력한다.
//
//둘째 줄에는 경로 상의 타일의 번호를 공백으로 구분하여 순서대로 출력한다. 만약, 가장 짧은 경로가 여러 가지라면, 아무거나 출력하면 된다.
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_5213_과외맨 {
	static class lessonMan{
		int r;
		int c;
		String moveLog;
		int cnt;
		public lessonMan() {}
		public lessonMan(int r, int c, String moveLog, int cnt) {
			this.r = r;
			this.c = c;
			this.moveLog = moveLog;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("lessonMan [r=");
			builder.append(r);
			builder.append(", c=");
			builder.append(c);
			builder.append(", moveLog=");
			builder.append(moveLog);
			builder.append(", cnt=");
			builder.append(cnt);
			builder.append("]");
			return builder.toString();
		}
		
	}
	static int N, num=1;
	static int[][] tile, tilenum, pos= {{-1,0},{1,0},{0,-1},{0,1}}, v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("res/Main_5213_과외맨.txt"));
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tile = new int[N][2*N];
		tilenum = new int[N][2*N];
		v = new int[N][2*N];
		ArrayList<String[]> loglist = new ArrayList<>();
		int c=0;
		int r=0;
		while(true) {			
			if(c<N) {
				if(r%2==1) {
					if(c==N-1) {
						c++;
						continue;
					}
					String input = br.readLine();
					if(input==null) break;
					StringTokenizer st = new StringTokenizer(input);
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					tile[r][2*c+1] = left;
					tile[r][2*c+2] = right;
					tilenum[r][2*c+1] = num;
					tilenum[r][2*c+2] = num++;
				}else {
					String input = br.readLine();
					if(input==null) break;
					StringTokenizer st = new StringTokenizer(input);
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					tile[r][2*c] = left;
					tile[r][2*c+1] = right;					
					tilenum[r][2*c] = num;
					tilenum[r][2*c+1] = num++;					
				}
				c++;
			}else {
				r++;
				c=0;
			}
		}
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(tile[i]));
//		}
//		System.out.println();
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(tilenum[i]));
//		}
		
//		
		//0,1에서 bfs시작하기
		//위아래로 같은 숫자일때만 넘어가기 가능
		//기록해야하는것 x,y,지금까지 지나온 길
		//방문처리 해줘 bfs니깐
		//도착지에 도착 못하면 번호가 가장 큰 타일로 이동
		LinkedList<lessonMan> list = new LinkedList<>();
		list.offer(new lessonMan(0,1,String.valueOf(tilenum[0][1]),1));
		v[0][1] = 1;
		v[0][0] = 1;
		int check = Integer.MAX_VALUE;
		int idx = 0;
		lessonMan temp = new lessonMan();
		
		while(!list.isEmpty()) {
			boolean isEnd = false;
			temp = list.poll();
			int tr = temp.r;
			int tc = temp.c;
			String tlog = temp.moveLog;
			int tcnt = temp.cnt;
			for(int i=0; i<4; i++) {
				int nr = tr + pos[i][0];
				int nc = tc + pos[i][1];
				if(nr==N-1 && nc==2*N-2) {
					System.out.println(tcnt+1);
					System.out.println(tlog+" "+23);
					System.exit(0);
				}
				if(isOk(nr,nc)) {
					if(tilenum[nr][nc]!=tilenum[tr][tc] && tile[nr][nc]==tile[tr][tc]) {
						isEnd = true;
						v[nr][nc]++;
						list.offer(new lessonMan(nr,nc,new String(tlog+" "+String.valueOf(tilenum[nr][nc])),tcnt+1));
					}else if(tilenum[nr][nc]==tilenum[tr][tc]){
						isEnd = true;
						v[nr][nc]++;
						list.offer(new lessonMan(nr,nc,new String(tlog), tcnt));
					}
				}
			}
			if(!isEnd) {
				boolean bcheck = false;
				String[] stemp=new String[2];
				for(int i=0; i<loglist.size(); i++) {
					stemp = loglist.get(i);
					if(tlog.contains(stemp[0])) {
						bcheck=true;
						loglist.add(new String[] {tlog, String.valueOf(tcnt)});
						break;
					}
				}
				if(bcheck)loglist.remove(stemp);
				else loglist.add(new String[] {tlog, String.valueOf(tcnt)});	
			}
			
		}
		for(int i=0; i<loglist.size(); i++) {
			if(check > Integer.parseInt(loglist.get(i)[1])) {
				check = Integer.parseInt(loglist.get(i)[1]);
				idx = i;
			}
		}
		System.out.println(check+1);
		System.out.println(loglist.get(idx)[0]+" "+23);
	}
	static boolean isOk(int r, int c) {
		if(r%2==1) {
			return (r>=0 && r<N && c>=1 && c<2*N-1 && v[r][c]==0) ? true:false;
		}else {
			return (r>=0 && r<N && c>=0 && c<2*N && v[r][c]==0) ? true:false;
		}
	}
}
