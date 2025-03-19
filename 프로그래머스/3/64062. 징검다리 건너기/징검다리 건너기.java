/*
접근 방법 : 완탐 생각했으나 stones 배열 크기가 1 이상 20만 이하 -> 슬라이딩 윈도우 생각 -> k가 건너뛸 수 있는 최대 칸수이므로 k크기의 슬라이딩 윈도우의 값이 전부 0이 되려면 윈도우의 최댓값의 사람만큼 건너야함 -> 슬라이딩 하면서 최댓값을 갱신하고 그 최댓값들의 최솟값이 징검다리를 건널 수 있는 사람 수 최댓값 -> 시간초과
시간 복잡도를 줄이자 -> 이분탐색
*/
import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 0;
        int right = 0;
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            right = Math.max(right, stones[i]);
        }
        
        while(left < right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            int maxCnt = 0;
            for (int s : stones) {
                int diff = s - mid;
                if (diff <= 0) {
                    cnt++;
                    maxCnt = Math.max(maxCnt, cnt);
                } else {
                    cnt = 0;
                }
            }
            
            if (maxCnt < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        answer = left;
        
        return answer;
    }
}