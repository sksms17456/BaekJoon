package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static BufferedReader in;
    private static BufferedWriter out;

    private static int N, L, answer;

    public static void main(String[] args) throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = in.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            input = in.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            boolean isEnd = false;
            for (int j = 0; j < N - 1; j++) {
                if (j == N - 2) {
                    isEnd = true;
                }
                if (map[i][j] == map[i][j + 1]) {
                    count++;
                }
                else if (map[i][j] + 1 == map[i][j + 1] && count >= L) {
                    count = 1;
                }
                else if (map[i][j] - 1 == map[i][j + 1] && count >= 0) {
                    count = 1 - L;
                }
                else {
                    break;
                }

            }

            if (isEnd && count >= 0) {
            	System.out.println(i);
                answer++;
            }

            count = 1;
            isEnd = false;
            for (int j = 0; j < N - 1; j++) {
                if (j == N - 2) {
                    isEnd = true;
                }
                if (map[j][i] == map[j + 1][i]) {
                    count++;
                }
                else if (map[j][i] + 1 == map[j + 1][i] && count >= L) {
                    count = 1;
                }
                else if (map[j][i] - 1 == map[j + 1][i] && count >= 0) {
                    count = 1 - L;
                }
                else {
                    break;
                }

            }
            if (isEnd && count >= 0) {
            	System.out.println(i);
                answer++;
            }
        }

        out.write(answer + "\n");

        out.flush();
        out.close();
        in.close();
    }

}

