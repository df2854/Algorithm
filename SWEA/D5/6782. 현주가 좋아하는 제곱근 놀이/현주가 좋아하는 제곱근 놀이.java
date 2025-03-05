import java.io.*;
import java.util.*;

class Solution {
	static int tc, cnt;
	static long n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Long.parseLong(br.readLine());
			cnt = 0;
			while (n != 2) {
				long sqrtN = (long) Math.sqrt(n);
				if (sqrtN * sqrtN == n) {
					n = sqrtN;
					cnt++;
				} else {
					long nextSquare = (sqrtN + 1) * (sqrtN + 1);
                    cnt += (nextSquare - n);
                    n = nextSquare;
				}
			}
			
			bw.write("#" + t + " " + cnt + "\n");
		}
		bw.flush();
		bw.close();
	}
}
