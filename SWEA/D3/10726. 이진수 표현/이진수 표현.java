import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int mask = (1 << n) - 1;

			if ((mask & m) == mask) {
				bw.write("#" + t + " " + "ON" + "\n");
			} else {
				bw.write("#" + t + " " + "OFF" + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}