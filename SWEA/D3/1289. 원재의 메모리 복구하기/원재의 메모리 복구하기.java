import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t < test + 1; t++) {
			String[] strArr = br.readLine().split("");
			
			String[] tmp = new String[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				tmp[i] = "0";
			}
			int cnt = 0;
			for (int i = 0; i < strArr.length; i++) {
				if (!tmp[i].equals(strArr[i])) {
					Arrays.fill(tmp, i, strArr.length, strArr[i]);
					cnt += 1;
				}
				if (Arrays.equals(tmp, strArr)) {
					break;
				}
			}
			
			bw.write("#" + t + " " + cnt + "\n");
		}
		bw.flush();
		bw.close();
	}
}