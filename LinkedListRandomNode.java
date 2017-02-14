import java.util.Random;
import java.util.Scanner;

//题意描述：给定一个链表，要求返回链表中任意一个结点的概率相等
class Solution{
	ListNode head;
	
	public Solution(ListNode head){
		this.head = head;
	}
	
	public int getRandom(){		
		ListNode res = head;
		int count = 0;
		while(res != null){
			count++;
			res = res.next;
		}
		
		Random random = new Random();
		int index = random.nextInt(count);
		res = head;
		for(int i=0; i<index; i++)
			res = res.next;
		
		return res.val;
	}
}

public class LinkedListRandomNode {	
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		Solution obj = new Solution(node1);
		while(true)
			System.out.println(obj.getRandom());
	}
}
