import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();
        
        for (String str : participant) {
            if (hash.containsKey(str)) {
                hash.put(str, hash.get(str) + 1);
            } else {
                hash.put(str, 1);
            }
        }
        
        for (String str : completion) {
            if (hash.get(str) == 1) {
                hash.remove(str);
            } else {
                hash.put(str, hash.get(str) - 1);
            }
        }
        
        for (String name : hash.keySet()) {
            return name;
        }
        return "";
    }
}