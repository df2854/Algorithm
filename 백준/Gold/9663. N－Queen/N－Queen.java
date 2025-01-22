import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static int[] arr;
	public static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		cnt = 0;
		
		nQueen(0);
		
		bw.write(cnt + "\n");
		
		bw.flush();
		bw.close();
	}
	
	public static void nQueen(int depth) {
		if (depth == n) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			arr[depth] = i;
			if (posible(depth)) {
				nQueen(depth + 1);
			}
		}
	}
	
	public static boolean posible(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) {
				return false;
			}
			
			if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}