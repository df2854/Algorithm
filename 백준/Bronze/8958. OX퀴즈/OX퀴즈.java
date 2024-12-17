import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i ++) {
        	String input = br.readLine();
        	int cnt = 0, score = 0;
        	for (int j = 0; j < input.length(); j++) {
        		if (input.charAt(j) == 'X') {
        			cnt = 0;
        		} else if (input.charAt(j) == 'O') {
        			cnt++;
        			score += cnt;
        		}
        	}
        	System.out.println(score);
        }
	}
}