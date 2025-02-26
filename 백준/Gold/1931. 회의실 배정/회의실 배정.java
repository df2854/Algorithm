import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static class Meeting implements Comparable<Meeting> {
		int start, end;
		
		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		Meeting[] meetings = new Meeting[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(meetings);
		List<Meeting> result = new ArrayList<>();
		result.add(meetings[0]);
		
		for (int i = 1; i < n; i++) {
			if (result.get(result.size() - 1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		
		System.out.println(result.size());
	}
}
