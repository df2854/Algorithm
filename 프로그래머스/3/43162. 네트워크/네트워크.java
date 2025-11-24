class Solution {
    private static int answer;
    private static int[] visited;
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                answer += 1;
                dfs(n, computers, i);
            }
        }
        
        return answer;
    }
    
    private static void dfs(int n, int[][] computers, int start) {
        visited[start] = 1; 
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && computers[start][i] == 1) {
                visited[i] = 1;
                dfs(n, computers, i);
            }
        }
    }
}