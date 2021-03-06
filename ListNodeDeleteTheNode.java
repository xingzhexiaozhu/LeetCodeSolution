
//删除链表中指定的结点

//ListNode{//定义参见ListNode文件
//	int val;
//	ListNode next;
//	ListNode(int x){
//		val = x;
//	}
//}

public class ListNodeDeleteTheNode {

	public static ListNode deleteNode(ListNode root, int num){
		if(root == null)//如果链表为空
			return root;
		
		if(root.val == num){//删除的是头结点
			root = root.next;
			return root;
		}
		
		ListNode preNode = root;
		ListNode curNode = preNode.next;
		while(curNode != null && curNode.val != num){
			preNode = curNode;
			curNode = curNode.next;
		}
		
		if(curNode.val == num){
			preNode.next = curNode.next;			
		}
		
		return root;		
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        
        ListNode node = deleteNode(node1, 1);
        while(node != null){
        	System.out.print(node.val);
        	node = node.next;
        }
        System.out.println();
	}

}
