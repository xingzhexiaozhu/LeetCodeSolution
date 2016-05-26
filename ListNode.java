
//关于链表的一些问题

public class ListNode {	
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
	
	//删除重复结点	
	//方法一：先定义一个空对象指向head，再从head开始处理
	ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode cur = head;
        pre.next = cur;
        while(cur != null){
        	if(cur.val == pre.val){
        		cur = cur.next; 
        		pre.next = cur;
        	}else{
        		pre = cur;
            	cur = cur.next;
        	}
        }
        return head;
    }	
	//方法二：先特别处理head
	ListNode deleteDuplicates1(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur != null){
			if(cur.val == pre.val){
				pre.next = cur.next;
				cur = cur.next;
			}else{
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}
		
	
	//Reverse a linked list(反转一个LinkedList).
	//方法一：recursively（递归）
	ListNode reverseList(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode cur = head.next;
		ListNode now = reverseList(cur);
		
		head.next = null;
		cur.next = head;
		return now;
	}
	//方法二：iteratively（迭代）
	ListNode reverseList1(ListNode head){
		if(head == null || head.next == null)
			return head;
		
		ListNode pre = head;
		ListNode cur = head.next;
		pre.next = null;
		ListNode temp;
		while(cur != null){
			temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}
	//方法三：通过循环依次交换各结点值
//	public ListNode reverseList(ListNode head) {
//  if(head == null || head.next == null)
//		return head;
//	
//	ListNode pre = head;
//	ListNode cur = head.next;
//	pre.next = null;
//	ListNode temp;
//	while(cur != null){
//		temp = cur.next;
//		cur.next = pre;
//		pre = cur;
//		cur = temp;
//	}
//	return pre;
//}
	
	//Reverse a linked list from position m to n
//	public ListNode reverseBetween(ListNode head, int m, int n){
//		if(head == null || head.next == null)
//			return head;
//		
//		ListNode pre = head;
//		ListNode start, end;
//		int count = 1;
//		while(count != m){
//			pre = pre.next;
//			count++;
//		}
//		start = pre;
//		
//	}
	
	//交换相邻的结点
	public static ListNode swapPairs(ListNode head){
		if(head==null || head.next == null)
			return head;
		
		ListNode cur,pre,tempPre,tempCur;  
		pre = head;  
		cur = head.next;  
		
		if(cur.next == null || cur.next.next == null){  
            head = cur;  
        } 
		
		boolean flag = false;  
		while(cur.next != null && cur.next.next != null){  
			tempPre = cur.next;  
			pre.next = tempPre;  
			cur.next = pre;  
			tempCur = pre;  
			if(flag == false)  
				head = cur;  
			flag = true;  
			pre = tempPre;  
			cur = pre.next;  
			tempCur.next = cur;  
		}  
		
		tempCur = cur.next;  
		cur.next = pre;  
		pre.next = tempCur; 
		
		return head;  	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode t = new ListNode(11);
        ListNode t1 = new ListNode(12);
        ListNode t2 = new ListNode(13);
        ListNode t3 = new ListNode(14);
        ListNode t4 = new ListNode(15);
        ListNode t5 = new ListNode(16);
        ListNode t6 = new ListNode(17);
        ListNode t7 = new ListNode(18);
        ListNode t8 = new ListNode(19);
        ListNode t9 = new ListNode(21);
        ListNode t10 = new ListNode(31);
        t.next = t1;
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;
        t5.next = t6;
        t6.next = t7;
        t7.next = t8;
        t8.next = t9;
        t9.next = t10;
        
        ListNode p = t;
        while(p != null){
        	System.out.print(p.val + " ");
        	p = p.next;
        }
        System.out.println();
        
        ListNode q = swapPairs(t);
        while(q != null){
        	System.out.print(q.val + " ");
        	q = q.next;
        }
        System.out.println();
	}

}
