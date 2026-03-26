import java.util.*;

class Solution {
    private static boolean[] visited;
    private static List<Integer>[] adjList;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            List<Integer> list = new ArrayList<>();
            adjList = new ArrayList[n+1];
            for (int j = 0; j <= n; j++) {
                adjList[j] = new ArrayList<>();
            }
            
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                
                adjList[wires[j][0]].add(wires[j][1]);
                adjList[wires[j][1]].add(wires[j][0]);
            }
            
            visited = new boolean[n+1];
            
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    list.add(bfs(j));
                }
            }
            
            answer = Math.min(answer, Math.abs(list.get(0) - list.get(1)));
        }
        return answer;
    }
    
    private static int bfs(int n) {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(n);
        visited[n] = true;
        
        int count = 0;
        
        while(!que.isEmpty()) {
            int cur = que.poll();
            count++;
            
            for (int num : adjList[cur]) {
                if (!visited[num]) {
                    visited[num] = true;
                    que.offer(num);
                }
            }
        }
        
        return count;
    }
}