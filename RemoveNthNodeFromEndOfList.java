
//��������������һ�����������N���Ƴ������е���ôN�����
//���磺1->2->3->4->5, n = 2.
//�Ƴ������ڶ�������1->2->3->5

public class RemoveNthNodeFromEndOfList {

	int val;
	RemoveNthNodeFromEndOfList next;
	RemoveNthNodeFromEndOfList(int x){
		val = x;
	}
	
	//����˼·��ģ���ҵ�������K�����һ������ָ�룬p1����n-1����p2�ٴ�ͷ��ʼ�ߣ���p1�ߵ�����βʱ��p2��Ӧ���Ǳ�ɾ�����Ǹ����
	private static RemoveNthNodeFromEndOfList removeNthFromEnd(RemoveNthNodeFromEndOfList head, int n) {
		if(head == null || n <= 0)//������Ϊ�ջ�n<=0��ɾ���κν��
			return head;
		if(n==1 && head.next == null)//ֻ��һ�������n=1��ɾ���ý��
			return null;
		
		RemoveNthNodeFromEndOfList p1 = head;
		RemoveNthNodeFromEndOfList p2 = head;
		for(int i=0; i<n; i++){
			if(p1 != null)
				p1 = p1.next;
			else //n����������
				return head;
		}
		
		if(p1 == null){//ɾ������ͷ���
			head = head.next;
			return head;
		}
		
		//����͸���p1.next�Ƿ�Ϊ���ҵ���Ҫ��ɾ������ǰһ�����
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
