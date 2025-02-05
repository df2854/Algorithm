import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		int start = 0;

		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(br.readLine());
			
			if (value > start) {
				for (int j = start + 1; j <= value; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				start = value;
			} 
			if (stack.peek() == value) {
				stack.pop();
				sb.append("-\n");
			}
		}

		if (stack.size() > 0) {
			System.out.println("NO");
		} else {
			System.out.println(sb + "\n");
		}
	}
}