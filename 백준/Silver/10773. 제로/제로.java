import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        Stack<Integer> stack = new Stack<>();
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
        	int input = Integer.parseInt(br.readLine());
        	if (input > 0) {
        		stack.push(input);
        	} else if (input == 0) {
        		stack.pop();
        	}
        }
        int result = stack.stream().mapToInt(Integer::intValue).sum();
        bw.write(result + "\n");
        bw.close();
	}
}