import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] tree = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
            }

            int max = Arrays.stream(tree).max().getAsInt();

            int oddCnt = 0;
            int evenCnt = 0;
            int[] remain = new int[n];

            for (int i = 0; i < n; i++) {
                remain[i] = max - tree[i];

                oddCnt += remain[i] % 2;
                evenCnt += remain[i] / 2;
            }
            int result = oddCnt + evenCnt;

            if (oddCnt - evenCnt > 1) {
                result += (oddCnt - evenCnt - 1);
            } else if (evenCnt > oddCnt) {
                int gap = (evenCnt - oddCnt) * 2;
                int pres = (gap / 3) * 2;

                if (gap % 3 == 2) {
                    pres += 2;
                } else if (gap % 3 == 1) {
                    pres += 1;
                }

                result = (oddCnt * 2) + pres;
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
