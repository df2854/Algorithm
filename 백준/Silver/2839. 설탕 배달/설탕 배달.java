import java.io.*;
import java.util.*;

public class Main {
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		int cnt = 0;
		while (n > 0) {
			if (n % 5 == 0) {
				cnt += n / 5;
				break;
			} else {
				n -= 3;
				cnt++;
			}
			
			if (n < 0) {
				cnt = -1;
			}
		}
		
		System.out.println(cnt);
	}
}
