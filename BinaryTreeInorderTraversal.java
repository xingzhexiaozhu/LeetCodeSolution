import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import BinaryTree.TreeNode;

//题意描述：给定一棵二叉树，返回中序遍历序列。如：
//给定{1,null,2,3}，其如下：
//   1
//    \
//     2
//    /
//   3
//返回[1,3,2]

//class TreeNode{
//	int val;
//	TreeNode left;
//	TreeNode rigth;
//	TreeNode(int x){
//		val = x;
//	}
//}

public class BinaryTreeInorderTraversal {

	//解题思路一：跟上一题一样，递归遍历是最容易想到的
	private static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		traverse(root, res);
		return res;
	}
	private static void traverse(TreeNode root, List<Integer> res){
		if(root == null)
			return;		
		if(root.left != null)
			traverse(root.left, res);
		res.add(root.val);
		if(root.right != null)
			traverse(root.right, res);			
	}
	
	//解题思路二：分治法
	private static List<Integer> inorderTraversal2(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root == null)
			return res;
		List<Integer> left = inorderTraversal2(root.left);
		List<Integer> right = inorderTraversal2(root.right);
		
		res.addAll(left);
		res.add(root.val);
		res.addAll(right);
		
		return res;
	}
	
	//解题思路三：借助栈。树结点指向根结点，如果栈不空或结点不为null:
	//当结点不为null时，该结点进栈，且结点改为指向当前结点的左子树结点；
	//当结点为null时，栈顶结点出栈，且结点改为指向当前结点的右子树结点；
	//出栈顺序即为中序遍历结果
	private static List<Integer> inorderTraversal3(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root == null)
			return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while(!stack.empty() || node != null){
			if(node != null){
				stack.push(node);
				node = node.left;
			}else{
				TreeNode n = stack.pop();
				res.add(n.val);
				node = n.right;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.right = node1;
		node1.left = node2;
		System.out.println(inorderTraversal(root));
		System.out.println(inorderTraversal2(root));
		System.out.println(inorderTraversal3(root));
	}

}
