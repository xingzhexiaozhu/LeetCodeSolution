
//题意描述：给定一个链表和数字N，移除链表中倒数么N个结点
//比如：1->2->3->4->5, n = 2.
//移除倒数第二个结点后，1->2->3->5

public class RemoveNthNodeFromEndOfList {

	int val;
	RemoveNthNodeFromEndOfList next;
	RemoveNthNodeFromEndOfList(int x){
		val = x;
	}
	
	//解题思路：模仿找到倒数第K个结点一样，两指针，p1先走n-1步，p2再从头开始走；当p1走到链表尾时，p2是应该是被删除的那个结点
	private static RemoveNthNodeFromEndOfList removeNthFromEnd(RemoveNthNodeFromEndOfList head, int n) {
		if(head == null || n <= 0)//当链表为空或n<=0则不删除任何结点
			return head;
		if(n==1 && head.next == null)//只有一个结点且n=1，删除该结点
			return null;
		
		RemoveNthNodeFromEndOfList p1 = head;
		RemoveNthNodeFromEndOfList p2 = head;
		for(int i=0; i<n; i++){
			if(p1 != null)
				p1 = p1.next;
			else //n大于链表长度
				return head;
		}
		
		if(p1 == null){//删除的是头结点
			head = head.next;
			return head;
		}
		
		//否则就根据p1.next是否为空找到需要被删除结点的前一个结点
		while(p1.next != null){
			p2 = p2.next;
			p1 = p1.next;			
		}		
		p2.next = p2.next.next;	
		
		return head;
	}
	
	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList node1 = new RemoveNthNodeFromEndOfList(1);
		RemoveNthNodeFromEndOfList node2 = new RemoveNthNodeFromEndOfList(2);
		RemoveNthNodeFromEndOfList node3 = new RemoveNthNodeFromEndOfList(3);
		RemoveNthNodeFromEndOfList node4 = new RemoveNthNodeFromEndOfList(4);
		RemoveNthNodeFromEndOfList node5 = new RemoveNthNodeFromEndOfList(5);
		
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		RemoveNthNodeFromEndOfList node = node1;
		while(node != null){
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		
		removeNthFromEnd(node1, 5);
	}	

}
