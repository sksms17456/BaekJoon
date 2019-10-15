//문제
//2020 년 우주 IT 인재들을 발굴, 육성하고 IT 인재들의 중요성을 인식하는 분위기 조성을 위하여 태양계의 지구 전산학 학회인 ACM(Association for Computing Machinery)에서는 대학생들을 대상으로 프로그래밍 경시대회 ACM-UCPC(Universal Collegiate Programming Contest)를 개최한다. 시간과 장소의 제약으로 인터넷 예선을 치르게 되었다.
//
//예선을 치른 후 각 팀의 성적이 푼 문제 수와 페널티로 주어지는데, 더 많은 문제를 푼 팀이 성적 순위에서 앞서고 같은 수의 문제를 풀었을 때에는 페널티가 적은 팀이 순위에서 앞선다. 순위대로 정렬된 대회 결과가 주어졌을 때 총 60 팀을 선발하는 프로그램을 작성하시오. 단, 어떤 두 팀도 같은 순위가 없다.
//
//성적이 우수한 팀을 뽑되 각 학교의 참여도를 높이고, 한 학교에서 너무 많은 수의 팀이 선발되는 것을 피하기 위해서 성적이 우수한 순서대로 아래 1~5 의 규칙을 적용하여 선발 혹은 탈락을 결정한다.
//
//현재 고려하는 팀이 속한 학교에서 M 개의 팀이 참여했다면 최대 ⌈M/2⌉ (올림)개 팀이 선발된다. 예를 들어 2 개 팀이 참여했다면 최대 1 팀이, 3 개 팀이 참여했다면 최대 2 팀이 선발된다.
//현재 고려하는 팀이 전체 성적이 1 위 ~ 10 위이면, 같은 학교에서 지금까지 3 개 이하의 팀이 선발되었을 경우에만 선발된다.
//현재 고려하는 팀이 전체 성적이 11 위 ~ 20 위이면, 같은 학교에서 지금까지 2 개 이하의 팀이 선발되었을 경우에만 선발된다.
//현재 고려하는 팀이 전체 성적이 21 위 ~ 30 위이면, 같은 학교에서 지금까지 1 개 이하의 팀이 선발되었을 경우에만 선발된다.
//현재 고려하는 팀이 전체 성적 31 위 이하이면, 같은 학교에서 지금까지 한 팀도 선발되지 않았을 경우에만 선발된다.
//단, 위의 규칙대로 선발해서 60 팀을 채우지 못할 경우에는 선발되지 못한 팀들 중 성적 순위가 앞선 팀을 차례대로 선발해서 60 팀을 채운다. 참가 팀의 수가 60 팀이 안 될 때에는 모든 팀을 선발한다. 
//
//입력
// 입력은 표준입력(standard input)을 통해 받아들인다. 입력의 첫 줄에는 테스트 케이스의 개수 T (1 ≤ T ≤ 20)가 주어진다. 각 테스트 케이스 첫 줄에는 참가 팀의 수 N 이 주어지고 두 번째 줄부터 N 줄에는 팀 이름(team), 학교 이름(school), 문제를 푼 수(solved), 페널티(penalty)가 공백을 하나 사이에 두고 주어진다(1 ≤ N ≤ 1000, 1 ≤ solved ≤ 10, 1 ≤ penalty ≤ 10000, team 과 school 은 공백을 포함하지 않은 길이 20 이하의 문자열)
//
//출력
//출력은 표준출력(standard output)을 통하여 출력한다. 각 테스트 케이스에 대해서 선발된 팀 중 전체 성적이 최하위인 팀의 이름을 한 줄에 하나씩 출력하시오. 
package BaekJoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_9057_ACMUCPC {
	static class Team {
		String name;
		String school;
		int solve;
		int penalty;

		public Team(String name, String school, int solve, int penalty) {
			this.name = name;
			this.school = school;
			this.solve = solve;
			this.penalty = penalty;
		}
	}

	static int T, N, rank, maxSize = 60, solve, penalty;
	static String name, school;
	static Map<String, Integer> schoolCount;
	static Map<String, Integer> selectCount;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("res/Main_9057_ACMUCPC.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = toInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Comparator<Team> comp = new Comparator<Team>() {
			@Override
			public int compare(Team team1, Team team2) {
				// TODO Auto-generated method stub
				if (team1.solve == team2.solve) {
					return team1.penalty - team2.penalty;
				}
				return team2.solve - team1.solve;
			}
		};
		for (int tc = 1; tc <= T; tc++) {
			N = toInt(br.readLine());
			schoolCount = new HashMap<>();
			selectCount = new HashMap<>();
			LinkedList<Team> teamList = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				name = st.nextToken();
				school = st.nextToken();
				teamList.offer(new Team(name, school, toInt(st.nextToken()), toInt(st.nextToken())));
				pushSchoolCount(school);
			}
			teamList.sort(comp);
			if (N < maxSize) {
				sb.append(teamList.getLast().name).append("\n");
				continue;
			}
			rank = 0;
			LinkedList<Team> selectList = new LinkedList<>();
			while (rank < N) {
				Team checkTeam = teamList.poll();
				school = checkTeam.school;
				if (checkSchoolCount(school)) {
					if (checkRankCount(school)) {
						selectList.offer(new Team(checkTeam.name, school, checkTeam.solve, checkTeam.penalty));
						pushSelectCount(school);
					}
				} else {
					teamList.offer(new Team(checkTeam.name, school, checkTeam.solve, checkTeam.penalty));
				}
				rank++;
			}

			int selectSize = selectList.size();

			if (selectSize < maxSize) {
				int diff = maxSize - selectSize;
				while (diff > 0) {
					selectList.offer(teamList.poll());
					diff--;
				}
			} else if (selectSize > maxSize) {
				int diff = selectSize - maxSize;
				while (diff > 0) {
					selectList.removeLast();
					diff--;
				}
			}
			selectList.sort(comp);
			sb.append(selectList.getLast().name).append("\n");

		}
		System.out.println(sb);

	}

	static boolean checkRankCount(String school) {
		int selected = getSelectCnt(school);
		switch (rank / 10) {
		case 0:
			return (selected <= 3) ? true : false;
		case 1:
			return (selected <= 2) ? true : false;
		case 2:
			return (selected <= 1) ? true : false;
		default:
			return (selected == 0) ? true : false;
		}
	}

	static boolean checkSchoolCount(String school) {
		return ((schoolCount.get(school) + 1) >> 1) > getSelectCnt(school) ? true : false;
	}

	static void pushSelectCount(String school) {
		if (selectCount.containsKey(school)) {
			int cnt = selectCount.get(school);
			selectCount.replace(school, cnt + 1);
		} else {
			selectCount.put(school, 1);
		}
	}

	static void pushSchoolCount(String school) {
		if (schoolCount.containsKey(school)) {
			int cnt = schoolCount.get(school);
			schoolCount.replace(school, cnt + 1);
		} else {
			schoolCount.put(school, 1);
		}
	}

	static int getSelectCnt(String school) {
		return selectCount.containsKey(school) ? selectCount.get(school) : 0;
	}

	static int toInt(String input) {
		return Integer.parseInt(input);
	}
}
