import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        List<String> list = Arrays.asList(friends);
        int n = friends.length;
        int[][] giftCnt = new int[n][n];
        
        int cnt = gifts.length;
        for (int i = 0; i < cnt; i++) {
            String[] str = gifts[i].split(" ");
            giftCnt[list.indexOf(str[0])][list.indexOf(str[1])]++;
        }
        
        int[] giftIdx = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                giftIdx[i] += giftCnt[i][j];
                giftIdx[i] -= giftCnt[j][i];
            }
        }
        
        int[] nextGift = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j) continue;
                
                if (giftCnt[i][j] > giftCnt[j][i]) {
                    nextGift[i]++;
                } else if (giftCnt[i][j] < giftCnt[j][i]) {
                    nextGift[j]++;
                } else if (giftCnt[i][j] == giftCnt[j][i] || (giftCnt[i][j] == 0 && giftCnt[j][i] == 0)) {
                    if (giftIdx[i] > giftIdx[j]) {
                        nextGift[i]++;
                    } else if (giftIdx[i] < giftIdx[j]) {
                        nextGift[j]++;
                    } else continue;
                }
            }
        }
        
        for (int count : nextGift) {
            answer = Math.max(answer, count);
        }
        return answer;
    }
}