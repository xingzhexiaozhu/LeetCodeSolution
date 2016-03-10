// BinaryTree.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"

#include<iostream>
using namespace std;

struct BinaryTreeNode {
	int m_nValue;
	BinaryTreeNode* m_pLeft;
	BinaryTreeNode* m_pRight;
};

//�������������
BinaryTreeNode* CreateBinaryTreeNode(int value) {
	BinaryTreeNode* pNode = new BinaryTreeNode();
	pNode->m_nValue = value;
	pNode->m_pLeft = NULL;
	pNode->m_pRight = NULL;
	return pNode;
}

//���Ӷ��������
void ConnectionTreeNodes(BinaryTreeNode* pParent, BinaryTreeNode* pLeft, BinaryTreeNode* pRight) {
	if (pParent != NULL) {
		pParent->m_pLeft = pLeft;
		pParent->m_pRight = pRight;
	}
}

//����������
int TreeDepth(BinaryTreeNode* pRoot) {
	if(pRoot == NULL){//���pRootΪNULL�����Ϊ0���ݹ鷵�ص�����
		return 0;
	}
	//���pRoot��ΪNULL����ô�������Ϊ1������left��rightΪ1
	int left = 1;
	int right = 1;
	left += TreeDepth(pRoot->m_pLeft);//���������
	right += TreeDepth(pRoot->m_pRight);//���������

	return left > right ? left : right;//������Ƚϴ���һ��
}

//��ת������
BinaryTreeNode* InvertedTree(BinaryTreeNode* pRoot) {
	if (pRoot == NULL) return 0;
	BinaryTreeNode* tempNode = pRoot->m_pLeft;
	pRoot->m_pLeft = InvertedTree(pRoot->m_pRight);
	pRoot->m_pRight = InvertedTree(tempNode);
	return pRoot;
}

//�ж������������Ƿ���ͬ
//����һ
bool isSameTree1(BinaryTreeNode* p, BinaryTreeNode* q) {
	if ((p == NULL) && (q == NULL)) return true;
	if ((p == NULL) || (q == NULL)) return false;
	if (p->m_nValue != q->m_nValue) return false;
	bool left = isSameTree(p->m_pLeft, q->m_pLeft);
	bool right = isSameTree(p->m_pRight, q->m_pRight);
	return (left == true) && (right == true);
}
//������
bool isSameTree(BinaryTreeNode* p, BinaryTreeNode* q) {
	if ((p == NULL) && (q == NULL)) return true;
	else if (p == NULL || q == NULL) return false;
	return p->m_nValue==q->m_nValue && isSameTree(p->m_pLeft, q->m_pRight) && isSameTree(p->m_pRight, q->m_pRight);
}

int main()
{
	//            1
	//         /      \
	//        2        3
	//       /\         \
	//      4  5         6
	//           /
	//        7


	//���������
	BinaryTreeNode* pNode1 = CreateBinaryTreeNode(1);
	BinaryTreeNode* pNode2 = CreateBinaryTreeNode(2);
	BinaryTreeNode* pNode3 = CreateBinaryTreeNode(3);
	BinaryTreeNode* pNode4 = CreateBinaryTreeNode(4);
	BinaryTreeNode* pNode5 = CreateBinaryTreeNode(5);
	BinaryTreeNode* pNode6 = CreateBinaryTreeNode(6);
	BinaryTreeNode* pNode7 = CreateBinaryTreeNode(7);

	//���������
	ConnectionTreeNodes(pNode1, pNode2, pNode3);
	ConnectionTreeNodes(pNode2, pNode4, pNode5);
	ConnectionTreeNodes(pNode3, NULL, pNode6);
	ConnectionTreeNodes(pNode5, pNode7, NULL);

	int depth = TreeDepth(pNode1);
	cout << depth << endl;

	system("pause");

    return 0;
}

