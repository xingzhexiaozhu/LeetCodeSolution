
//题意描述：给定一个单链表，在O(n)时间复杂度、O(1)空间复杂度内判断其是否是一个回文链表

public class PalindromeLinkedList {

	int val;
	PalindromeLinkedList next;
	PalindromeLinkedList(int x){
		val = x;
	}
	
	//解题思路一：先将链表中结点的值取出来组成字符串，然后判断字符串是否为回文串
	private static boolean isPalindrome(PalindromeLinkedList head) {
		PalindromeLinkedList p = head;
		String str = "";
		while(p != null){
			str += p.val;
			p = p.next;			
		}		
		
		return str.equals(new StringBuilder(str).reverse().toString());
	}

	//解题思路二：上面的解法时间复杂度为O(n)同时空间复杂度也为O(n)，提交时程序会运行超时
	//另想办法，借鉴判断链表是否有环的快慢指针法找到链表中点，然后一个将后半部分就地反转，分别再从头、中点遍历判断是否相等
	//该方法时间复杂度O(n)、空间复杂度O(1)
	private static PalindromeLinkedList reverseList(PalindromeLinkedList head){
		PalindromeLinkedList prev = null;//链表原地反转
		while(head != null){
			PalindromeLinkedList temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
	private static PalindromeLinkedList findMinddle(PalindromeLinkedList head){
		if(head == null || head.next == null)//找到链表中点
			return head;
		
		PalindromeLinkedList p = head, q = head.next;
		while(q != null && q.next != null){
			p = p.next;
			q = q.next;
		}
		
		return p;
	}
	private static boolean isPalindrome1(PalindromeLinkedList head) {
		if(head == null || head.next == null)
			return true;
		
		PalindromeLinkedList middle = findMinddle(head);
		middle.next = reverseList(middle.next);
		
		PalindromeLinkedList p = head, q = middle.next;
		while(p!=null && q!=null && p.val==q.val){
			p = p.next;
			q = q.next;
		}
		
		return q==null;
	}
	
	
	public static void main(String[] args) {
		PalindromeLinkedList node = new PalindromeLinkedList(11);
		PalindromeLinkedList node1 = new PalindromeLinkedList(12);
		PalindromeLinkedList node2 = new PalindromeLinkedList(13);
//		PalindromeLinkedList node3 = new PalindromeLinkedList(14);
//        PalindromeLinkedList node4 = new PalindromeLinkedList(15);
//        PalindromeLinkedList node5 = new PalindromeLinkedList(15);
//        PalindromeLinkedList node6 = new PalindromeLinkedList(14);
//        PalindromeLinkedList node7 = new PalindromeLinkedList(13);
//        PalindromeLinkedList node8 = new PalindromeLinkedList(12);
//        PalindromeLinkedList node9 = new PalindromeLinkedList(11);

        node.next = node1;
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;

        
        System.out.println(isPalindrome1(node));
	}
	
}
