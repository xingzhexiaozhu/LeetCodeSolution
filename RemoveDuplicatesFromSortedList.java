
//文件ListNode.java中

//题意描述：给定一个单向已排序的链表，删除链表中重复的元素使每个元素只出现一次
//如：1->1->1->2，返回1->2
//   1->1->2->3->3->，返回1->2->3

public class RemoveDuplicatesFromSortedList {

	int val;
	RemoveDuplicatesFromSortedList next;
	RemoveDuplicatesFromSortedList(int x){
		val = x;
	}
	
	//删除重复的结点
	public static RemoveDuplicatesFromSortedList deleteDuplicates(RemoveDuplicatesFromSortedList head){
		RemoveDuplicatesFromSortedList pre = new RemoveDuplicatesFromSortedList(-1);
		RemoveDuplicatesFromSortedList cur = head;
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
	
	//打印链表
	public static void PrintList(RemoveDuplicatesFromSortedList head){
		RemoveDuplicatesFromSortedList pNode = head;
		while(pNode != null){
			System.out.print(pNode.val + "\t");
			pNode = pNode.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList node1 = new RemoveDuplicatesFromSortedList(1);
		RemoveDuplicatesFromSortedList node2 = new RemoveDuplicatesFromSortedList(1);
		RemoveDuplicatesFromSortedList node3 = new RemoveDuplicatesFromSortedList(2);
		RemoveDuplicatesFromSortedList node4 = new RemoveDuplicatesFromSortedList(3);
		RemoveDuplicatesFromSortedList node5 = new RemoveDuplicatesFromSortedList(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;		
		PrintList(node1);
		
		RemoveDuplicatesFromSortedList node = deleteDuplicates(node1);
		PrintList(node);
	}
}
