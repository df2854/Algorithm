import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] sortedArr = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = sortedArr[i] =Integer.parseInt(input[i]);
		}
		
		Arrays.sort(sortedArr);
		
		int rank = 0;
		for (int value : sortedArr) {
			if (!map.containsKey(value)) {
				map.put(value, rank);
				rank++;
			}
		}
		
		StringBuilder st = new StringBuilder();
		for (int value : arr) {
			st.append(map.get(value)).append(" ");
		}
		bw.write(st + "\n");
		bw.flush();
		bw.close();
	}
}