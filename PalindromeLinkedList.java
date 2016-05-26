
//��������������һ����������O(n)ʱ�临�Ӷȡ�O(1)�ռ临�Ӷ����ж����Ƿ���һ����������

public class PalindromeLinkedList {

	int val;
	PalindromeLinkedList next;
	PalindromeLinkedList(int x){
		val = x;
	}
	
	//����˼·һ���Ƚ������н���ֵȡ��������ַ�����Ȼ���ж��ַ����Ƿ�Ϊ���Ĵ�
	private static boolean isPalindrome(PalindromeLinkedList head) {
		PalindromeLinkedList p = head;
		String str = "";
		while(p != null){
			str += p.val;
			p = p.next;			
		}		
		
		return str.equals(new StringBuilder(str).reverse().toString());
	}

	//����˼·��������Ľⷨʱ�临�Ӷ�ΪO(n)ͬʱ�ռ临�Ӷ�ҲΪO(n)���ύʱ��������г�ʱ
	//����취������ж������Ƿ��л��Ŀ���ָ�뷨�ҵ������е㣬Ȼ��һ������벿�־͵ط�ת���ֱ��ٴ�ͷ���е�����ж��Ƿ����
	//�÷���ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
	private static PalindromeLinkedList reverseList(PalindromeLinkedList head){
		PalindromeLinkedList prev = null;//����ԭ�ط�ת
		while(head != null){
			PalindromeLinkedList temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
	private static PalindromeLinkedList findMinddle(PalindromeLinkedList head){
		if(head == null || head.next == null)//�ҵ������е�
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
