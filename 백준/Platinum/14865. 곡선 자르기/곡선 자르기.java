import java.util.*;
import java.io.*;

public class Main {
	static int n, map[][], result1, result2;
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Peak implements Comparable<Peak> {
		int start;
		boolean isUp;

		Peak (int start, boolean isUp) {
			this.start = start;
			this.isUp = isUp;
		}

		@Override
		public int compareTo(Peak o) {
			return this.start - o.start;
		}
	}
	public static void main(String[] args) throws IOException {
		//--------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int startX = Integer.MAX_VALUE;
		int startY = Integer.MAX_VALUE;
		int index = 0;
		List<Point> pointArr = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x < startX && y < 0) {
				startX = x;
				startY = y;
				index = i;
			}

			Point point = new Point(x, y);
			pointArr.add(point);
		}
		
		int preX = startX;
		int preY = startY;
		int len = pointArr.size();
		List<Peak> peakArr = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			Point cur = pointArr.get((index + i) % len);
			if (preY < 0 && cur.y > 0) {
				preX = cur.x;
				preY = cur.y;
			} else if (preY > 0 && cur.y < 0) {
				int minX = Math.min(preX, cur.x);
				int maxX = Math.max(preX, cur.x);
				
				preX = cur.x;
				preY = cur.y;
				
				Peak left = new Peak(minX, true);
				Peak right = new Peak(maxX, false);
				peakArr.add(left);
				peakArr.add(right);
			}
		}
		
		Collections.sort(peakArr);
		
		result1 = 0;
		result2 = 0;
		Stack<Integer> stack = new Stack<>();
		int peakLen = peakArr.size();
		int cnt = 0;
		for (int i = 0; i < peakLen; i++) {
			boolean check = peakArr.get(i).isUp;
			if (check) {
				stack.add(cnt);
			} else {
				int num = stack.pop();
				if (stack.isEmpty()) {
					result1++;
				}
				
				if (num == cnt) {
					result2++;
				}
				
				cnt++;
			}
		}
		
		bw.write(result1 + " " + result2 + "\n");
		bw.flush();
		bw.close();
	}
}
