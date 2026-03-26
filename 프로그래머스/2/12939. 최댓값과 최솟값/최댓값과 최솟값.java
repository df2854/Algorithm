class Solution {
    public String solution(String s) {
        String[] strArr = s.split(" ");
        int n = strArr.length;
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(strArr[i]);
            if (num > max) max = num;
            if (num < min) min = num;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        
        return sb.toString();
    }
}