import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import BinaryTree.TreeNode;

//��������������һ�ö���������������������С��磺
//����{1,#,2,3}�������£�
//   1
//    \
//     2
//    /
//   3
//����[1,2,3]

//class TreeNode{
//	int val;
//	TreeNode left;
//	TreeNode rigth;
//	TreeNode(int x){
//		val = x;
//	}
//}

public class BinaryTreePreorderTraversal {

	//����˼·һ������һ��ջ���Ƚ��������ջ����ջ����ʱ��
	//ȡ��ջ��Ԫ�أ�������ӽ�㲻�������ӽ���ջ��������ӽ�㲻�������ӽ���ջ��
	//��ջ��Ԫ��˳��Ϊ����������
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
	
	//����˼·�����ݹ���
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
	
	//����˼·��������
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
