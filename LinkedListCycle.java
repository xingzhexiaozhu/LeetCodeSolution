
//�����������ж�һ�������Ƿ���ڻ�·
//��������������һ�ʵĻ���������л��ҳ���·

public class LinkedListCycle {
	int val;
	LinkedListCycle next;
	LinkedListCycle(int x){
		val = x;
		next = null;
	}	
	
	//����취��������ָ�룬ͬʱ��ͷ��㿪ʼ��һ��һ�ι�һ����㣬��һ��һ�ι��������
	//��������������л�·����֮���޻�·
	public static boolean hasCycle(LinkedListCycle head){
		LinkedListCycle p,q;
		p = head;
		q = head;
		while(q != null && q.next != null){
			p = p.next;
			q = q.next.next;
			if(q == p)
				 return true;
		}				
		return false;		
	}
	
	public static LinkedListCycle detectCycle(LinkedListCycle head){
		LinkedListCycle p,q;
		p = head;
		q = head;
		while(q != null && q.next != null){
			p = p.next;
			q = q.next.next;
			if(p == q)//��һ������
				break;
		}
		
		if(q==null || q.next==null)
		    return null;
		
		p = head;
		while(p != q){
			p = p.next;
			q = q.next;
		}
		return q;
		
	}
	
	public static void main(String[] args) {
		LinkedListCycle node = new LinkedListCycle(0);
		LinkedListCycle node1 = new LinkedListCycle(1);
		LinkedListCycle node2 = new LinkedListCycle(2);
		LinkedListCycle node3 = new LinkedListCycle(3);
		LinkedListCycle node4 = new LinkedListCycle(4);
		LinkedListCycle node5 = new LinkedListCycle(5);
		
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node2;
		
		if(hasCycle(node)){
			System.out.println(detectCycle(node).val);
		}else{
			System.out.println("There is no cycle.");
		}

	}

}
