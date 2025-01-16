import java.io.*;
import java.util.*;
 
class Solution
{
    static int N, L;
    static int[][] food;
    static int result;
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int test = Integer.parseInt(br.readLine());
        for (int t = 1; t < test + 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
             
            food = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                food[i][0] = Integer.parseInt(st.nextToken());
                food[i][1] = Integer.parseInt(st.nextToken());
            }
            result = 0;
             
            bt(0, 0, 0);
             
            bw.write("#" + t + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }
     
    public static void bt(int n, int score, int cal) {
        if (n == N) {
            result = Math.max(score, result);
            return;
        }
         
        if (cal + food[n][1] <= L) {
            bt(n + 1, score + food[n][0], cal + food[n][1]);
        }
         
        if (cal <= L) {
            bt(n + 1, score, cal);
        }
    }
}