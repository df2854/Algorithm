import java.io.*;
import java.util.*;

public class Main {
	static String str;
	static String[] strArray;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		strArray = new String[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			strArray[i] = "";
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < str.length(); j++) {
				sb.append(str.charAt(j));
			}
			strArray[i] += sb;
		}
		
		Arrays.sort(strArray);
		
		StringBuilder sb = new StringBuilder();
		for (String string : strArray) {
			sb.append(string).append("\n");
		}
		
		System.out.println(sb);
	}
} 
