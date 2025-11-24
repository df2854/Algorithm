import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long low = 1;
        long high = (long) times[times.length - 1] * n;
        
        while (low < high) {
            long mid = (low + high) / 2;
            
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            
            if (sum < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
            
        }
        return low;
    }
}