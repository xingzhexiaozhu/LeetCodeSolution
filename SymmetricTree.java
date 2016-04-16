
//题意描述：判断一颗二叉树是否为对称二叉树

public class SymmetricTree {	
	int val;
	SymmetricTree left;
	SymmetricTree right;
	SymmetricTree(int x){
		val = x;
	}
	
	public static boolean isSymmetric(SymmetricTree root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    public static boolean isSymmetric(SymmetricTree leftNode, SymmetricTree rightNode){
        if(leftNode == null && rightNode == null ) return true;
        if(leftNode == null || rightNode == null) return false;
        if(leftNode.val != rightNode.val) return  false;
        boolean isLeft = isSymmetric(leftNode.left, rightNode.right);
        boolean isRight = isSymmetric(leftNode.right, rightNode.left);
        return isLeft && isRight;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymmetricTree node = new SymmetricTree(1);
		SymmetricTree node1 = new SymmetricTree(2);
		SymmetricTree node2 = new SymmetricTree(2);
		SymmetricTree node3 = new SymmetricTree(3);
		SymmetricTree node4 = new SymmetricTree(4);
		SymmetricTree node5 = new SymmetricTree(4);
		SymmetricTree node6 = new SymmetricTree(3);
		node.left = node1;
		node.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		System.out.println(isSymmetric(node));
	}
}
