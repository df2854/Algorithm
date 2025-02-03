import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());

			LinkedList<Integer> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int cnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int x, y;

			for (int i = 0; i < cnt; i++) {
				String keyword = st.nextToken();
				if (keyword.equals("I")) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					List<Integer> crypt = new ArrayList<>();
					for (int j = 0; j < y; j++) {
						crypt.add(Integer.parseInt(st.nextToken()));
					}

					list.addAll(x, crypt);
				} else if (keyword.equals("D")) {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());

					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
				} else if (keyword.equals("A")) {
					y = Integer.parseInt(st.nextToken());
					List<Integer> crypt = new ArrayList<>();
					for (int j = 0; j < y; j++) {
						crypt.add(Integer.parseInt(st.nextToken()));
					}

					list.addAll(crypt);
				}
			}

			bw.write("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				bw.write(list.get(i) + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}