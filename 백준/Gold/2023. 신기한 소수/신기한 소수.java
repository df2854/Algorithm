import java.io.*;
import java.util.*;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		dfs(0, 0);
	}
	private static void dfs(int idx, int num) {
		if (!isPrime(num) && num > 0) return;
		
		if (idx == n) {
			System.out.println(num);
			return;
		}
		

		
		for (int i = 1; i <= 9; i++) {
			int tmp = num;
			num = num * 10 + i;
			
			dfs(idx+1, num);
			
			num = tmp;
		}
	}
	
	private static boolean isPrime(int num) {
		if (num <= 1) return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}
		
		return true;
	}
}
