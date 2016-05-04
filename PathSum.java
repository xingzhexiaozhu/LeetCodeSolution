
//��������������һ�ö�������һ�����֣��жϸö������Ƿ����һ���Ӹ���Ҷ����·�������Ϻ͵��ڸ���

public class PathSum {

	int val;
	PathSum left;
	PathSum right;
	PathSum(int x){
		val = x;
	}
	
	//����˼·����������һ�㶼�����õݹ�õ���������ﵽ��ÿ���ڵ����sum-node.val
	//���������ǰ���ΪҶ�ӽ����sum=0ʱ���ҵ����������·��������true;���򷵻�false
	private static boolean hasPathSum(PathSum root, int sum) {
		if(root == null)
			return false;
		if(root.left==null && root.right==null)
			if(sum - root.val == 0)
				return true;
		return (hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val));			
	}
	
	public static void main(String[] args) {
		PathSum node = new PathSum(5);
		PathSum node1 = new PathSum(4);
		PathSum node2 = new PathSum(8);
		PathSum node3 = new PathSum(11);
		PathSum node4 = new PathSum(13);
		PathSum node5 = new PathSum(4);
		PathSum node6 = new PathSum(7);
		PathSum node7 = new PathSum(2);
		PathSum node8 = new PathSum(1);
		
		
		node.left = node1;
		node.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node5.right = node8;
		
		int sum = 22;
		System.out.println(hasPathSum(node, sum));
	}
}
