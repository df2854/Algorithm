import java.util.*;
import java.io.*;

class Solution {
	static int n, m;
    static int[] conflict;  
    static long count; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            conflict = new int[n];
            
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                conflict[a] |= (1 << b);
                conflict[b] |= (1 << a);
            }
            
            count = 0;
            dfs(0, 0);
            bw.write("#" + t + " " + count + "\n");
		}
		bw.flush();
		bw.close();
	}
	private static void dfs(int idx, int selected) {
		if (idx == n) {
            count++;
            return;
        }
        
        dfs(idx + 1, selected);
        
        if ((selected & conflict[idx]) == 0) {
            dfs(idx + 1, selected | (1 << idx));
        }
	}
}
