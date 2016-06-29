import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import BinaryTree.TreeNode;

//��������������һ�ö���������������������С��磺
//����{1,null,2,3}�������£�
//   1
//    \
//     2
//    /
//   3
//����[1,3,2]

//class TreeNode{
//	int val;
//	TreeNode left;
//	TreeNode rigth;
//	TreeNode(int x){
//		val = x;
//	}
//}

public class BinaryTreeInorderTraversal {

	//����˼·һ������һ��һ�����ݹ�������������뵽��
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
	
	//����˼·�������η�
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
	
	//����˼·��������ջ�������ָ�����㣬���ջ���ջ��㲻Ϊnull:
	//����㲻Ϊnullʱ���ý���ջ���ҽ���Ϊָ��ǰ������������㣻
	//�����Ϊnullʱ��ջ������ջ���ҽ���Ϊָ��ǰ������������㣻
	//��ջ˳��Ϊ����������
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
