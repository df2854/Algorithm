import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 1; t < test + 1; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];

            String[] input = new String[n];
            for (int i = 0; i < n; i++) {
                input = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            int h = n / 2;
            int value = 0;
            for (int i = 0; i < n; i++) {
                if (h >= i) {
                    for (int j = h - i; j < h + i + 1; j++) {
                        value += map[i][j];
                    }
                } else {
                    for (int j = i - h; j < n - (i - h); j++) {
                        value += map[i][j];
                    }
                }
            }
            System.out.println("#" + t + " " + value);
        }
	}
}
