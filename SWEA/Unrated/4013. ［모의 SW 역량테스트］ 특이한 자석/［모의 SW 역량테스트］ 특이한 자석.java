import java.io.*;
import java.util.*;

public class Solution {
	static class DoublelyCircleLinkedList<T> {
		class Node {
			T data;
			Node next;
			Node prev;
			
			Node(T data) {
				this.data = data;
			}
		}
		
		Node head;
		
		DoublelyCircleLinkedList() {
			head = null;
		}
		
		void add(T data) {
			Node newNode = new Node(data);
			if (head == null) {
				head = newNode;
				newNode.prev = head;
				newNode.next = head;
			} else {
				Node tail = head.prev;
				tail.next = newNode;
				newNode.prev = tail;
				newNode.next = head;
				head.prev = newNode;
			}
		}
		
		void rotate(int rotate) {
			if (head != null) {
				if (rotate == -1) head = head.next;
				else if (rotate == 1) head = head.prev;
			}
		}
		
		T get(int index) {
			if (head == null || index < 0) return null;
			Node current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
				if (current == head) return null;
			}
			return current.data;
		}
	}
	
	static int k;
	static List<DoublelyCircleLinkedList<Integer>> list;
	static int[] arr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
        	k = Integer.parseInt(br.readLine());
        	
        	list = new ArrayList<>();
        	for (int i = 0; i <= 4; i++) {
        		list.add(new DoublelyCircleLinkedList<>());
        	}
        	
        	for (int i = 1; i <= 4; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < 8; j++) {
        			list.get(i).add(Integer.parseInt(st.nextToken()));
        		}
        	}

        	for (int i = 0; i < k; i++) {
        		arr = new int[5];
        		st = new StringTokenizer(br.readLine());
        		int num = Integer.parseInt(st.nextToken());
        		int rotate = Integer.parseInt(st.nextToken());
        		
        		rotate(num, rotate);
        	}
        	
        	int result = calcScore();
        	
        	bw.write("#" + t + " " + result + "\n");
        }
        bw.close();
    }
    
    static void rotate(int num, int rotate) {
    	arr[num] = rotate;
    	
    	for (int i = num + 1; i <= 4; i++) {
    		if (list.get(i).get(6) == list.get(i - 1).get(2)) break;
    		else arr[i] = -arr[i-1];
    	}
    	
    	for (int i = num - 1; i >= 1; i--) {
    		if (list.get(i+1).get(6) == list.get(i).get(2)) break;
    		else arr[i] = -arr[i+1];
    	}
    	
    	for (int i = 1; i <= 4; i++) {
    		if (arr[i] == 0) continue;
    		else if (arr[i] == 1) {
    			list.get(i).rotate(arr[i]);
    		} else if (arr[i] == -1) {
    			list.get(i).rotate(arr[i]);
    		}
    	}
    }
    
    
    static int calcScore() {
    	int score = 0;
    	for (int i = 1; i <= 4; i++) {
    		score += list.get(i).get(0) * Math.pow(2, i - 1);
    	}
    	
    	return score;
    }
}
