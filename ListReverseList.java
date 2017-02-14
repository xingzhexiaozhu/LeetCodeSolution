
//Reverse a linked list

public class ListReverseList {

	//Reverse a linked list
	public static ListNode reverseLinkedList(ListNode head){
		if(head == null || head.next == null)
			return head;
		
		ListNode newHead = new ListNode(-1);
		
		while(head != null){
			ListNode cur = head;
			head = head.next;
			
			cur.next = newHead.next;
			newHead.next = cur;
		}

		return newHead.next;
	}

	//Reverse a linked list from position m to n（该方法只是截取了m到n位置的链表，并返回截取的链表）
	public static ListNode reverseBetweenIndexMN(ListNode head, int m, int n) {
		if (head == null || head.next == null || m > n)
			return head;
		
		ListNode startPos = head;
		int index = 1;
		for(; index < m && startPos.next != null; index++)
			startPos = startPos.next;
		ListNode endPos = startPos;
		for(; index < n && endPos.next != null; index++)
			endPos = endPos.next;
		
		ListNode newHead = new ListNode(-1);
		while(startPos != null){
			if(startPos == endPos){
				startPos.next = newHead.next;
				newHead.next = startPos;
				break;
			}
			
			ListNode cur = startPos;
			startPos = startPos.next;
			cur.next = newHead.next;
			newHead.next = cur;
		}
		
		return newHead.next;
	}

	//Reverse a linked list from position m to n（该方法反转m到n位置链表，并返回完整的链表）
	public static ListNode reverseBetweenIndexMN2(ListNode head, int m, int n){
		if (head == null || head.next == null || m > n)
			return head;
		
		ListNode newHead = new ListNode(-1);
		newHead.next = head;
		head = newHead;
		
		int index = 1;
		for(; index<m; index++){
			if(head == null)
				return null;
			head = head.next;
		}
		
		ListNode startNode = head.next;
		ListNode endNode = startNode;
		ListNode tailNode = startNode.next;
		for(; index < n; index++){
			if(tailNode == null)
				return null;			
			ListNode tmp = tailNode.next;
			tailNode.next = endNode;
			endNode = tailNode;
			tailNode = tmp;
		}
		startNode.next = tailNode;
		head.next = endNode;
		
		return newHead.next;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
//		System.out.print("ListNode: ");
//		while(node1 != null){
//			System.out.print(node1.val + " ");
//			node1 = node1.next;
//		}
//		System.out.println();
//		
//		System.out.print("Reverse ListNode: ");
//		ListNode node = reverseLinkedList(node1);
//		while(node != null){
//			System.out.print(node.val + " ");
//			node = node.next;
//		}
//		System.out.println();		
		
		System.out.print("Reverse ListNode from m to n: ");
		ListNode head = reverseBetweenIndexMN2(node1, 3, 5);
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

}
