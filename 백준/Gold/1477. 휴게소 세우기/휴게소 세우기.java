import java.io.*;
import java.util.*;

public class Main {
    static int n, m, l;
    static int[] arr, dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 기존 휴게소 개수
        m = Integer.parseInt(st.nextToken()); // 추가로 세울 수 있는 휴게소 개수
        l = Integer.parseInt(st.nextToken()); // 도로 길이

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 휴게소 위치 정렬

        // 각 구간 거리 계산
        dist = new int[n + 1];
        dist[0] = arr.length > 0 ? arr[0] : l; // 출발점부터 첫 휴게소 거리
        for (int i = 1; i < n; i++) {
            dist[i] = arr[i] - arr[i - 1];
        }
        dist[n] = l - (n > 0 ? arr[n - 1] : 0); // 마지막 휴게소부터 종점까지 거리

        int answer = l; // 가능한 최대 거리로 초기화

        // 구간 최대 길이 1부터 L까지 순회 (브루트포스)
        for (int maxDist = 1; maxDist <= l; maxDist++) {
            int cnt = 0; // 필요한 휴게소 개수

            for (int d : dist) {
                if (d > maxDist) {
                    cnt += (d - 1) / maxDist; // 필요한 휴게소 수 (주의: (d-1)/maxDist)
                }
            }

            if (cnt <= m) { // 설치 가능한 범위 내라면
                answer = maxDist; // 최소 거리 갱신
                break; // 최소값 찾았으므로 바로 종료 (더 이상 볼 필요 없음)
            }
        }

        System.out.println(answer); // 정답 출력
    }
}
