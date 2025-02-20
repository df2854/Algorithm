import java.util.*;
import java.io.*;

class Solution {
	static int n, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			n = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<>();
			
			result = 1;
			String str = br.readLine();
			char ch;
			for (int i = 0; i < n; i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '<') {
					stack.push(str.charAt(i));
				} else {
					if (str.charAt(i) == ')' && !stack.isEmpty()) {
						ch = stack.pop();
						if (ch != '(') {
							result = 0;
						}
					} else if (str.charAt(i) == ']' && !stack.isEmpty()) {
						ch = stack.pop();
						if (ch != '[') {
							result = 0;
						}
					} else if (str.charAt(i) == '}' && !stack.isEmpty()) {
						ch = stack.pop();
						if (ch != '{') {
							result = 0;
						}
					} else if (str.charAt(i) == '>' && !stack.isEmpty()) {
						ch = stack.pop();
						if (ch != '<') {
							result = 0;
						}
					} else {
						result = 0;
					}
				}
				
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
