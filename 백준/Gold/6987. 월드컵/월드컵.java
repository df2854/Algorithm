import java.io.*;
import java.util.*;

public class Main {
	static int arr[][], matches[][];
	static boolean isPossible, isPossible2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		matches = new int[15][2];
		int index = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				matches[index][0] = i;
				matches[index][1] = j;
				index++;
			}
		}
		
		for (int t = 0; t < 4; t++) {
			isPossible = true;
			isPossible2 = false;
			arr = new int[6][3];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());
				
				arr[i][0] = win;
				arr[i][1] = draw;
				arr[i][2] = lose;
				
				if (win + draw + lose != 5) {
					isPossible = false;
					break;
				}
			}
			
			if (isPossible) {
				dfs(0);
				if (isPossible2) {
					sb.append(1).append(" ");
				} else {
					sb.append(0).append(" ");
				}
				
			} else {
				sb.append(0).append(" ");
			}
			
		}
		System.out.println(sb);
	}
	private static void dfs(int depth) {
		if (depth == 15) {
			isPossible2 = true;
			return;
		}
		
		if (isPossible2) return;
		
		int my = matches[depth][0];
		int your = matches[depth][1];
		
		if (arr[my][0] > 0 && arr[your][2] > 0) {
			arr[my][0]--;
			arr[your][2]--;
			dfs(depth+1);
			arr[my][0]++;
			arr[your][2]++;
		}
		
		if (arr[my][1] > 0 && arr[your][1] > 0) {
			arr[my][1]--;
			arr[your][1]--;
			dfs(depth+1);
			arr[my][1]++;
			arr[your][1]++;
		}
		
		if (arr[my][2] > 0 && arr[your][0] > 0) {
			arr[my][2]--;
			arr[your][0]--;
			dfs(depth+1);
			arr[my][2]++;
			arr[your][0]++;
		}
	}
}