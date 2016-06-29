import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import BinaryTree.TreeNode;

//题意描述：给定一棵二叉树，返回先序遍历序列。如：
//给定{1,#,2,3}，其如下：
//   1
//    \
//     2
//    /
//   3
//返回[1,2,3]

//class TreeNode{
//	int val;
//	TreeNode left;
//	TreeNode rigth;
//	TreeNode(int x){
//		val = x;
//	}
//}

public class BinaryTreePreorderTraversal {

	//解题思路一：借助一个栈。先将根结点入栈，当栈不空时：
	//取出栈顶元素，如果右子结点不空则右子结点进栈，如果左子结点不空则左子结点进栈；
	//出栈的元素顺序即为先序遍历结果
	private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
        	return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
        	TreeNode node = stack.pop();
        	res.add(node.val);
        	
        	if(node.right != null)
        		stack.push(node.right);
        	if(node.left != null)
        		stack.push(node.left);
        }        
        return res;
    }
	
	//解题思路二：递归解决
	private static List<Integer> preorderTraversal2(TreeNode root){
		List<Integer> res = new ArrayList<>();
		traverse(root, res);
		return res;
	}
	private static void traverse(TreeNode root, List<Integer> res){
		if(root == null) 
			return;
		res.add(root.val);
		traverse(root.left, res);
		traverse(root.right,res);
	}
	
	//解题思路三：分治
	private static List<Integer> preorderTraversal3(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root == null)
			return res;
		List<Integer> left = preorderTraversal3(root.left);
		List<Integer> right = preorderTraversal3(root.right);
		
		res.add(root.val);
		res.addAll(left);
		res.addAll(right);
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.right = node1;
		node1.left = node2;
		System.out.println(preorderTraversal(root));
		System.out.println(preorderTraversal2(root));
		System.out.println(preorderTraversal3(root));
	}

}
