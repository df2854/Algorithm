import java.io.*;
import java.util.*;

class Solution {
	static class Customer {
		int id;
		int arriveTime;
		int receptionNo = 0;
		int repairNo = 0;
		int receptionEndTime = -1;
		
		public Customer(int id, int arriveTime) {
			this.id = id;
			this.arriveTime = arriveTime;
		}
	}
	static int tc, n, m, k, a, b, result;
	static int[] aTime, bTime, receptionEndTimes, repairEndTimes;;
	static Customer[] customers, receptions, repairs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			aTime = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				aTime[i] = Integer.parseInt(st.nextToken());
			}
			
			bTime = new int[m+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				bTime[i] = Integer.parseInt(st.nextToken());
			}
			
			customers = new Customer[k+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= k; i++) {
				int time = Integer.parseInt(st.nextToken());
				customers[i] = new Customer(i, time);
			}
			
			result = simulate();
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	private static int simulate() {
		PriorityQueue<Customer> receptionQue = new PriorityQueue<>((o1, o2) -> o1.id - o2.id);
		PriorityQueue<Customer> repairQue = new PriorityQueue<>((o1, o2) -> {
			if (o1.receptionEndTime != o2.receptionEndTime) {
				return o1.receptionEndTime - o2.receptionEndTime;
			}
			return o1.receptionNo - o2.receptionNo;
		});
		
		receptions = new Customer[n+1];
		receptionEndTimes = new int[n+1];
		
		repairs = new Customer[m+1];
		repairEndTimes = new int[m+1];
		
		int time = 0;
		int completeCnt = 0;
		
		while (completeCnt < k) {
			// 정비 종료
			for (int i = 1; i <= m; i++) {
				if (repairs[i] != null && repairEndTimes[i] == time) {
					repairs[i] = null;
					completeCnt++;
				}
			}
			
			// 접수 완료 -> 정비 대기 큐로
			for (int i = 1; i <= n; i++) {
				if (receptions[i] != null && receptionEndTimes[i] == time) {
					Customer c = receptions[i];
					c.receptionNo = i;
					c.receptionEndTime = time;
					receptions[i] = null;
					repairQue.offer(c);
				}
			}
			
			// 접수 대기 큐로
			for (int i = 1; i <= k; i++) {
				if (customers[i].arriveTime == time) {
					receptionQue.offer(customers[i]);
				}
			}
			
			// 접수 창구 배정
			for (int i = 1; i <= n; i++) {
				if (receptions[i] == null && !receptionQue.isEmpty()) {
					Customer c = receptionQue.poll();
					receptions[i] = c;
					receptionEndTimes[i] = time + aTime[i];
				}
			}
			
			// 빈 정비 창구 배정
			while (!repairQue.isEmpty()) {
				boolean assigned = false;
                for (int i = 1; i <= m; i++) {
                    if (repairs[i] == null) {
                        Customer c = repairQue.poll();
                        c.repairNo = i;
                        repairs[i] = c;
                        repairEndTimes[i] = time + bTime[i];
                        assigned = true;
                        break;
                    }
                }
                if (!assigned) break; // 정비 창구가 비어있지 않으면 일단 중단
			}
			
			time++;
		}
		
		int sum = 0;
		
		for (int i = 1; i <= k; i++) {
			if (customers[i].receptionNo == a && customers[i].repairNo == b) {
				sum += customers[i].id;
			}
		}
		
		return sum == 0 ? -1 : sum;
	}
	
}
