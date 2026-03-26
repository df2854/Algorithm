import java.util.*;
class Solution {
    
    public String solution(String s) {
        String[] strArr = s.split(" ", -1);
        int n = strArr.length;
  
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (strArr[i].length() > 0) {
                 sb.append(strArr[i].substring(0, 1).toUpperCase());
            sb.append(strArr[i].substring(1).toLowerCase());
            }
            
            if (i == n-1) break;
            sb.append(" ");
        }
        
        return sb.toString();
    }
}