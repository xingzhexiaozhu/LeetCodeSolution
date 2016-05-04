
//题意描述：给定一棵二叉树和一个数字，判断该二叉树是否存在一条从根到叶结点的路径满足上和等于给定

public class PathSum {

	int val;
	PathSum left;
	PathSum right;
	PathSum(int x){
		val = x;
	}
	
	//解题思路：树的问题一般都可以用递归得到解决，这里到达每个节点就用sum-node.val
	//最终如果当前结点为叶子结点且sum=0时即找到符合题意的路径，返回true;否则返回false
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
