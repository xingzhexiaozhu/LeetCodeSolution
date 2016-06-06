
//��������������һ�������������ĳԪ���ظ���ɾ�������ظ��Ľ�㣬ֻ����ԭʼ������ֻ������һ�εĽ��
//�磺1->2->3->3->4->4->5������1->2->5
//   1->1->1->2->3������2->3

public class RemoveDuplicatesFromSortedListII {

	int val;
	RemoveDuplicatesFromSortedListII next;
	RemoveDuplicatesFromSortedListII(int x){
		val = x;
	}
	
	//����˼·����������I��ɾ���������ظ��Ľ��ķ�����������ָ��һ��ָ��ǰ��㣬��һ��ָ����һ����㣬���бȽ���ָ�����ݣ�
	//�������ﻹҪ����һ����ָ��ָ����ȷ�����ظ���������һ�����
	public static RemoveDuplicatesFromSortedListII deleteDuplicates(RemoveDuplicatesFromSortedListII head){		
		if(head == null || head.next == null)//�������Ϊ�ջ�������ֻ��һ�����
			return head;		
		
		RemoveDuplicatesFromSortedListII fakeHead = new RemoveDuplicatesFromSortedListII(-1);
		fakeHead.next = head;
		
		RemoveDuplicatesFromSortedListII newList = fakeHead;
		RemoveDuplicatesFromSortedListII pre = head;
		RemoveDuplicatesFromSortedListII cur = head.next;
		
		boolean flag = false;//��Ǳ�������Ƿ����ظ�
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
	
	//��ӡ����
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
