class Solution {
    private static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    private static void dfs(int[] numbers, int target, int n, int i) {
        if (i == numbers.length) {
            if (target == n) {
                answer += 1;
                return;
            }
            
            return;
        }
        
        dfs(numbers, target, n - numbers[i], i+1);
        dfs(numbers, target, n + numbers[i], i+1);
    }
}