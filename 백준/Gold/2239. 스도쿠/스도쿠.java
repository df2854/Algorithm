import java.io.*;
import java.util.*;

public class Main {
	static int[][] board;
	static List<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new ArrayList<>();
		
		board = new int[10][10];
		for (int i = 1; i <= 9; i++) {
			String input = br.readLine();
			for (int j = 1; j <= 9; j++) {
				board[i][j] = input.charAt(j-1) - '0';
				
				if (board[i][j] == 0) list.add(new int[] {i, j});
			}
		}
			
		bt(0);
		
	}
	private static void bt(int size) {
		if (list.size() == size) {
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		boolean[] check = new boolean[10];
		
		int[] cur = list.get(size);
		int cy = cur[0];
		int cx = cur[1];
		
		for (int i = 1; i <= 9; i++	) {
			if (board[cur[0]][i] != 0) {
				check[board[cur[0]][i]] = true;
			}
		}
		
		for (int i = 1; i <= 9; i++	) {
			if (board[i][cur[1]] != 0) {
				check[board[i][cur[1]]] = true;
			}
		}
		
		int startY = ((cur[0] - 1) / 3) * 3 + 1;
		int startX = ((cur[1] - 1) / 3) * 3 + 1;
		for (int i = startY; i < startY + 3; i++) {
			for (int j = startX; j < startX + 3; j++) {
				if (board[i][j] != 0) {
					check[board[i][j]] = true;
				}
			}
		}
		
		for (int i = 1; i <= 9; i++) {
			if (!check[i]) {
				board[cur[0]][cur[1]] = i;
				bt(size+1);
				board[cur[0]][cur[1]] = 0;
			}
		}
	}
}
