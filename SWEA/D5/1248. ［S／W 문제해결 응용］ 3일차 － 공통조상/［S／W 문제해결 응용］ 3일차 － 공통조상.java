import java.io.*;
import java.util.*;

public class Solution {
	static int v, e, a1, a2, result, cnt;
	static List<List<Integer>> firstList, lastList;
	static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
        	st = new StringTokenizer(br.readLine());
        	
        	v = Integer.parseInt(st.nextToken());
        	e = Integer.parseInt(st.nextToken());
        	a1 = Integer.parseInt(st.nextToken());
        	a2 =Integer.parseInt(st.nextToken());
        	
        	firstList = new ArrayList<>();
        	lastList = new ArrayList<>();
        	
        	for (int i = 0; i < v+1; i++) {
        		firstList.add(new ArrayList<>());
        		lastList.add(new ArrayList<>());
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < e; i++) {
        		int start = Integer.parseInt(st.nextToken());
        		int end = Integer.parseInt(st.nextToken());
        		
        		firstList.get(end).add(start);
        		lastList.get(start).add(end);
        	}
        	
        	visited = new boolean[v+1];
        	
        	visited[a1] = true;
        	dfs1(a1);
        	
        	visited[a2] = true;
        	dfs1(a2);
        	
        	visited = new boolean[v+1];
        	cnt = 0;
        	dfs2(result);
        	
        	bw.write("#" + t + " " + result + " " + cnt + "\n");
        	
        }
        bw.close();
    }
    
    public static void dfs1(int n) {
    	if (n == 1) {
    		visited[1] = true;
    		return;
    	}
    	
    	for (int d : firstList.get(n)) {
    		if (!visited[d]) {
    			visited[d] = true;
    			dfs1(d);
    		} else {
    			result = d;
    			return;
    		}
    	}
    }
    
    public static void dfs2(int n) {
    	if (!visited[n]) visited[n] = true;
    	cnt++;
    	for (int d : lastList.get(n)) {
    		dfs2(d);
    	}
    	return;
    }
}
