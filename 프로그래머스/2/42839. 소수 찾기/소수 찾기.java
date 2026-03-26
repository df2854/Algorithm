import java.util.*;

class Solution {
    private static boolean[] visited;
    private static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        int numLen = numbers.length();

        int[] arr = new int[numLen];
        visited = new boolean[numLen];
        String[] strArr = numbers.split("");
        for (int i = 0; i < numLen; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        
        for (int i = 1; i <= numLen; i++) {
            dfs(arr, "", i);
        }
        
        for (int n : set) {
            if (isPrime(n)) answer++;
        }
        
        return answer;
    }
    
    private static void dfs(int[] arr, String str, int len) {
        if (str.length() == len) {
            int num = Integer.parseInt(str);
            set.add(num);
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(arr, str + arr[i], len);
                visited[i] = false;
            }
        }
    }
    
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}