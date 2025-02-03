import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			int n = Integer.parseInt(br.readLine());

			int mask = 0;
			int num = 0;
			int i = 0;
			int cnt = 1;

			while (true) {
				num = n * cnt;
				while (num > 0) {
					i = num % 10;
					num /= 10;
	
					mask = mask | (1 << i);
				}

				if ((mask & ((1 << 10) - 1)) == ((1 << 10) - 1)) {
					break;
				}

				cnt++;
			}

			bw.write("#" + t + " " + cnt * n + "\n");
		}

		bw.flush();
		bw.close();
	}
}