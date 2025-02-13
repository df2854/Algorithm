import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Queue<Integer> window = new LinkedList<>();

        int maxCnt = 0;

        for (int i = 0; i < k; i++) {
            window.offer(arr[i]);
        }

        Set<Integer> set = new HashSet<>(window);
        set.add(c);
        maxCnt = set.size();
        

        for (int i = 0; i < N - 1; i++) {
            window.offer(arr[(i + k) % N]);
            window.poll();
            
            set = new HashSet<>(window);
            set.add(c);
            maxCnt = Math.max(maxCnt, set.size());
        }

        System.out.println(maxCnt);
    }
}
