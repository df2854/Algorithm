import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String keyword = st.nextToken();
            int num;

            if (keyword.equals("add")) {
                num = Integer.parseInt(st.nextToken());
                if (list.indexOf(num) == -1) {
                    list.add(num);
                } else continue;
            } else if (keyword.equals("remove")) {
                num = Integer.parseInt(st.nextToken());
                if (list.indexOf(num) >= 0) {
                    list.remove(list.indexOf(num));
                } else continue;
            } else if (keyword.equals("check")) {
                num = Integer.parseInt(st.nextToken());
                if (list.indexOf(num) >= 0) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            } else if (keyword.equals("toggle")) {
                num = Integer.parseInt(st.nextToken());
                if (list.indexOf(num) >= 0) {
                    list.remove(list.indexOf(num));
                }
                else list.add(num);
            } else if (keyword.equals("all")) {
                list.clear();
                for (int j = 1; j <= 20; j++) {
                    list.add(j);
                }
            } else if (keyword.equals("empty")) {
                list.clear();
            }
        }
        bw.close();
    }
}
