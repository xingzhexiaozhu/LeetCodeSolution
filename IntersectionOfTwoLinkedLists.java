
//������������������������Ĺ������ֵĵ�һ����㣬���£�
//A:          a1 �� a2
//                   �K
//                     c1 �� c2 �� c3
//                   �J            
//B:     b1 �� b2 �� b3
//����c1

public class IntersectionOfTwoLinkedLists {

	int val;
	IntersectionOfTwoLinkedLists next;
	IntersectionOfTwoLinkedLists(int x){
		val = x;
		next = null;
	}
	
	//����˼·������Ŀ����Ҫ����˼·�������ϳ������ǰ�沿�֣���Ϊ������Ĺ�������������β�������Գ��Ƚϳ�������ǰ�沿�ֲ��ñȽ�
	private static IntersectionOfTwoLinkedLists getIntersectionNode(IntersectionOfTwoLinkedLists headA, IntersectionOfTwoLinkedLists headB) {
		if(headA == null || headB == null)
			return null;
		
		int lenA = 0, lenB = 0;
		IntersectionOfTwoLinkedLists p = headA, q = headB;
		while(p != null){
			++lenA;//����headA�ĳ���
			p = p.next;			
		}
		while(q != null){
			++lenB;//����headB�ĳ���
			q = q.next;			
		}
		
		int uselessLength = Math.abs(lenA - lenB);
		while(uselessLength > 0){//�����ϳ������ǰ�沿��
			if(lenA > lenB)
				headA = headA.next;
			else headB = headB.next;
			--uselessLength;
		}
		
		while(headA != null && headB != null){
			if(headA.val == headB.val)
				return headA;
			headA = headA.next;
			headB = headB.next;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists node1 = new IntersectionOfTwoLinkedLists(1);
		IntersectionOfTwoLinkedLists node2 = new IntersectionOfTwoLinkedLists(2);
		IntersectionOfTwoLinkedLists node3 = new IntersectionOfTwoLinkedLists(3);
		IntersectionOfTwoLinkedLists node4 = new IntersectionOfTwoLinkedLists(4);
		IntersectionOfTwoLinkedLists node5 = new IntersectionOfTwoLinkedLists(5);
		
		IntersectionOfTwoLinkedLists node6 = new IntersectionOfTwoLinkedLists(6);
		IntersectionOfTwoLinkedLists node7 = new IntersectionOfTwoLinkedLists(1);
		IntersectionOfTwoLinkedLists node8 = new IntersectionOfTwoLinkedLists(2);
		IntersectionOfTwoLinkedLists node9 = new IntersectionOfTwoLinkedLists(3);
		IntersectionOfTwoLinkedLists node10 = new IntersectionOfTwoLinkedLists(4);
		IntersectionOfTwoLinkedLists node11 = new IntersectionOfTwoLinkedLists(5);
		
		node1.next = node2;		
		node2.next = node3;		
		node3.next = node4;
		node4.next = node5;
		
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
		
		IntersectionOfTwoLinkedLists node = getIntersectionNode(node1, node6);
		if(node != null)
			System.out.println(node.val);
		else System.out.println("No common rail");
		
		IntersectionOfTwoLinkedLists node21 = new IntersectionOfTwoLinkedLists(10);
		IntersectionOfTwoLinkedLists node22 = new IntersectionOfTwoLinkedLists(10);
		IntersectionOfTwoLinkedLists node23 = getIntersectionNode(node21, node22);
		if(node23 != null)
			System.out.println(node23.val);
		else System.out.println("No common rail");
	}

}
