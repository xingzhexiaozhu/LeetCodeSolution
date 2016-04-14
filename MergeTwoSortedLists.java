
public class MergeTwoSortedLists {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
	
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		ListNode head = null;
		ListNode end = null;
		
		ListNode p1 = l1;
		ListNode p2 = l2;
		while((p1!=null)&&(p2!=null)){
			if(p1.val <= p2.val){
				if(head == null){
					head = p1;
					end = head;
				}else{
					end.next = p1;
					end = end.next;
				}
				p1 = p1.next;
			}else{
				if(head == null){
					head = p2;
					end = head;
				}else{
					end.next = p2;
					end = end.next;
				}
				p2 = p2.next;
			}
		}
		
		if(p1 != null){
			end.next = p1;
		}
		if(p2 != null){
			end.next = p2;
		}
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(9);	
		
		node1.next = node2;
		node2.next = null;
		node3.next = node4;
		node4.next = null;
		
		ListNode l = mergeTwoLists(node1, node3);
		while(l != null){
			System.out.println(l.val);
		}
	}

}
