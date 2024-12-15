import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			String[] input = br.readLine().split(" ");
			int k = Integer.parseInt(input[0]);
			switch (k) {
			case 1:
				int num = Integer.parseInt(input[1]);
				stack.push(num);
				break;
			case 2:
				if (!stack.isEmpty()) {
					bw.write(stack.pop() + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case 3:
				bw.write(stack.size() + "\n");
				break;
			case 4:
				if (!stack.isEmpty()) {
					bw.write("0\n");
				} else {
					bw.write("1\n");
				}
				break;
			case 5:
				if (!stack.isEmpty()) {
					bw.write(stack.peek() + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			}
		}
		bw.close();
	}
}