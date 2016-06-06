
//题意描述：给定一个单向链表，如果某元素重复则删除所有重复的结点，只保留原始链表中只出现了一次的结点
//如：1->2->3->3->4->4->5，返回1->2->5
//   1->1->1->2->3，返回2->3

public class RemoveDuplicatesFromSortedListII {

	int val;
	RemoveDuplicatesFromSortedListII next;
	RemoveDuplicatesFromSortedListII(int x){
		val = x;
	}
	
	//解题思路：还是利用I中删除链表中重复的结点的方法，引用又指针一个指向当前结点，另一个指向下一个结点，进行比较两指针内容；
	//并且这里还要增加一个新指针指向已确定无重复链表的最后一个结点
	public static RemoveDuplicatesFromSortedListII deleteDuplicates(RemoveDuplicatesFromSortedListII head){		
		if(head == null || head.next == null)//如果链表为空或者链表只有一个结点
			return head;		
		
		RemoveDuplicatesFromSortedListII fakeHead = new RemoveDuplicatesFromSortedListII(-1);
		fakeHead.next = head;
		
		RemoveDuplicatesFromSortedListII newList = fakeHead;
		RemoveDuplicatesFromSortedListII pre = head;
		RemoveDuplicatesFromSortedListII cur = head.next;
		
		boolean flag = false;//标记变量标记是否有重复
		while(cur != null){
			if(pre.val == cur.val){
				flag = true;
				cur = cur.next;
				if(cur == null)
					newList.next = null;
			}else{
				if(flag){
					newList.next = cur;
					flag = false;
				}else{
					newList = pre;
				}
				pre = cur;
				cur = cur.next;
			}
		}
		
		return fakeHead.next;
	}
	
	//打印链表
	public static void PrintList(RemoveDuplicatesFromSortedListII head){
		RemoveDuplicatesFromSortedListII pNode = head;
		while(pNode != null){
			System.out.print(pNode.val + "\t");
			pNode = pNode.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII node1 = new RemoveDuplicatesFromSortedListII(1);
		RemoveDuplicatesFromSortedListII node2 = new RemoveDuplicatesFromSortedListII(2);
		RemoveDuplicatesFromSortedListII node3 = new RemoveDuplicatesFromSortedListII(3);
		RemoveDuplicatesFromSortedListII node4 = new RemoveDuplicatesFromSortedListII(3);
		RemoveDuplicatesFromSortedListII node5 = new RemoveDuplicatesFromSortedListII(4);
		RemoveDuplicatesFromSortedListII node6 = new RemoveDuplicatesFromSortedListII(4);
		RemoveDuplicatesFromSortedListII node7 = new RemoveDuplicatesFromSortedListII(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		PrintList(node1);
		
		RemoveDuplicatesFromSortedListII pNode = deleteDuplicates(node1);
		PrintList(pNode);
		
//		RemoveDuplicatesFromSortedListII node11 = new RemoveDuplicatesFromSortedListII(1);
//		RemoveDuplicatesFromSortedListII node12 = new RemoveDuplicatesFromSortedListII(1);
//		RemoveDuplicatesFromSortedListII node13 = new RemoveDuplicatesFromSortedListII(1);
//		RemoveDuplicatesFromSortedListII node14 = new RemoveDuplicatesFromSortedListII(2);
//		RemoveDuplicatesFromSortedListII node15 = new RemoveDuplicatesFromSortedListII(3);
//		node11.next = node12;
//		node12.next = node13;
//		node13.next = node14;
//		node14.next = node15;
//		PrintList(node11);		
		
//		RemoveDuplicatesFromSortedListII pNode1 = deleteDuplicates(node1);
//		PrintList(pNode1);
	}

}
