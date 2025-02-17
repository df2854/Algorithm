import java.io.*;
import java.util.*;

public class Solution {
    static int n, ans;
    static int[] arr, tmp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            tmp = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[n];

            ans = 0;
            permute(0);

            bw.write("#" + t + " " + ans + "\n");
        }

        bw.close();
    }

    public static void permute(int k) {
        if (k == n) {
            scale(0, 0, 0);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[k] = arr[i];

                permute(k + 1);
                visited[i] = false;
            }
        }
    }

    public static void scale(int k, int left, int right) {
        if (left < right) return;
        if (k == n) {
            ans++;
            return;
        }

        scale(k + 1, left + tmp[k], right);
        scale(k + 1, left, right + tmp[k]);
    }
}
