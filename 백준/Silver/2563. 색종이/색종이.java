import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int n = Integer.parseInt(br.readLine());
        int[][] m = new int[n][2];
        boolean[][] arr = new boolean[101][101];
        int result = 0;
        for (int i = 0; i < n; i++) {
        	String[] input = br.readLine().split(" ");
        	m[i][0] = Integer.parseInt(input[0]);
        	m[i][1] = Integer.parseInt(input[1]);
        	for (int y = m[i][1]; y <= m[i][1] + 9; y++) {
        		for (int x = m[i][0]; x <= m[i][0] + 9; x++) {
        			if (!arr[y][x]) {
        				arr[y][x] = true;
        				result++;
        			}
        		}
        	}
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
	}
}