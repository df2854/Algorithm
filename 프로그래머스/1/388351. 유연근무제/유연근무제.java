class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int n = schedules.length;
        int[] limits = new int[n];
        
        for (int i = 0; i < n; i++) {
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100;
            
            minute += 10;
            
            if (minute >= 60) {
                hour += 1;
                minute -= 60;
            }
            
            limits[i] = hour * 100 + minute;
        }
        
        for (int i = 0 ; i < n; i++) {
            if (isPresent(limits[i], timelogs[i], startday)) answer ++;
        }
            
        return answer;
    }
    
    boolean isPresent(int limit, int[] timelog, int startday) {
        for (int i = 1; i <= 5; i++) {
            int idx = i - startday >= 0 ? i - startday : i - startday + 7;
            
            if (timelog[idx] > limit) return false;
        }
        
        return true;
    }
}