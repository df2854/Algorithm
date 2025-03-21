class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int i = n - 1;
        while(i >= 0) {
            if (deliveries[i] == 0 && pickups[i] == 0) {
                i--;
                continue;
            }
            cnt(i, deliveries, cap);
            cnt(i, pickups, cap);
            
            answer += 2 * (i + 1);
        }
        return answer;
    }
    
    public void cnt(int i, int[] arr, int cap) {
        while (i >= 0) {
            if (arr[i] <= cap) {
                cap -= arr[i];
                arr[i] = 0;
            } else {
                arr[i] -= cap;
                break;
            }
            i--;
        }
    } 
}