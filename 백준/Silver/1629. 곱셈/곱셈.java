import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());

		long ans = pow(a, b, c);
		ans = ans % c;

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
	}

	public static long pow(long a, long b, long c) {
		if (b == 0) {
			return 1;
		}

		long res = pow(a, b/2, c);

		if (b % 2 == 0) {
			return res * res % c;
		} else {
			return (res * res % c) * a % c;
		}
	}
}