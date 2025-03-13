import java.io.*;
import java.util.*;

public class Main {
	static String S;
	static int q, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		S = br.readLine();
		q = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			result = 0;
			for (int j = start; j < end+1; j++) {
				if (S.charAt(j) == c) {
					result++;
				}
			}
			System.out.println(result);
		}
	}
}
