//求二叉树挂的最大深度和最小深度
public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
	
	TreeNode(){
		
	}
	
	//创建结点
	static TreeNode CreateTreeNode(int value){
		TreeNode pNode = new TreeNode();
		pNode.val = value;
		pNode.left = null;
		pNode.right = null;
		return pNode;
	}
	
	//连接二叉树
	static void ConnectTreeNode(TreeNode pParent, TreeNode pLeft, TreeNode pRight){
		if(pParent != null){
			pParent.left = pLeft;
			pParent.right = pRight;
		}
	}
	
	//解题思路：深度优先搜索，递归调用
	static int MaxTreeDepth(TreeNode pRoot){
		if(pRoot == null) return 0;
		
		int left = 1;
		int right = 1;
		left += MaxTreeDepth(pRoot.left);
		right += MaxTreeDepth(pRoot.right);
		
		return left>right?left:right;
	}
	
	static int MiniTreeDepth(TreeNode pRoot){
		if((pRoot == null)) 
			return 0;
		if((pRoot.left == null) && (pRoot.right == null))
			return 1;
		
		int left = MiniTreeDepth(pRoot.left);
		int right = MiniTreeDepth(pRoot.right);
		
		if(left == 0) 
			return right + 1;
		else if(right == 0)
			return left + 1;
		else 
			return Math.min(left, right) + 1;
	}
	
	//invert a binary tree
	static TreeNode invertTree(TreeNode root){
		if(root == null) return null;
		TreeNode tempNode = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tempNode);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//      1
		//   /      \
		//  2        3
		// /\         \
		//4  5         6
		//     /
		//  7
		TreeNode pNode1 = CreateTreeNode(1);
		TreeNode pNode2 = CreateTreeNode(2);
		TreeNode pNode3 = CreateTreeNode(3);
		TreeNode pNode4 = CreateTreeNode(4);
		TreeNode pNode5 = CreateTreeNode(5);
		TreeNode pNode6 = CreateTreeNode(6);
		TreeNode pNode7 = CreateTreeNode(7);		
		
		
		ConnectTreeNode(pNode1, pNode2, pNode3);
		ConnectTreeNode(pNode2, pNode4, pNode5);
		ConnectTreeNode(pNode3, null, pNode6);
		ConnectTreeNode(pNode5, pNode7, null);
		
		System.out.println("Tree max depth = " + MaxTreeDepth(pNode1));
		System.out.println("Tree min depth = " + MiniTreeDepth(pNode1));
	}

}
