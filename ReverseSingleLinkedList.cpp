// ReverseSingleLinkedList.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"

//����������������ķ�ת/����

#include<iostream>
using namespace std;

typedef int Status;//Status�Ǻ���������,��ֵ�Ǻ������״̬���룬��OK��
typedef int ElemType;//ElemType���͸���ʵ������������������Ϊint

typedef struct Node {
	ElemType data;//������
	struct Node *next;//ָ����
}Node;

typedef struct Node *LinkList;

//��ʼ��˳�����Ա�
Status InitList(LinkList *L) {
	*L = (LinkList)malloc(sizeof(Node));//����ͷ��㣬��ʹLָ��˽��
	if (!(*L)) {//�洢����ʧ��
		return false;
	}
	(*L)->next = NULL;
	return true;//�ɹ���ʼ��
}

//������ͷָӡ�ģ�����n�����ĵ�����L��ͷ�巨��
void CreateListHead(LinkList *L, int n) {
	*L = (LinkList)malloc(sizeof(Node));
	(*L)->next = NULL;
	LinkList p;
	srand(0);
	for (int i = 0; i < n; i++) {
		p = (LinkList)malloc(sizeof(Node));
		p->data = rand() % 100 + 1;//�������100���ڵ�����
		p->next = (*L)->next;
		(*L)->next = p;
	}
}

//������ͷָӡ�ģ�����n�����ĵ�����L��β�巨��
void CreateListRail(LinkList *L, int n) {
	*L = (LinkList)malloc(sizeof(Node));
	(*L)->next = NULL;
	LinkList p, r = *L;//rָ��ָ������β��
	srand(0);
	for (int i = 0; i < n; i++) {
		p = (LinkList)malloc(sizeof(Node));
		p->data = rand() % 100 + 1;//�������100���ڵ�����
		r->next = p;
		r = p;
	}
	r->next = NULL;
}

//���Ա��Ѵ��ڣ��������Ա�Ԫ�ظ���
int ListLength(LinkList L) {
	int len = 0;
	LinkList p = L->next;
	while(p) {
		len++;
		p = p->next;
	}
	return len;
}

//�������Ա�
Status ClearList(LinkList *L) {
	LinkList p, q;
	p = (*L)->next;
	while (p) {
		q = p->next;//ͷָ�������Ƿ�Ͽ�������
		free(p);
		p = q;
	}
	(*L)->next = NULL;
	return true;
}

//�������Ա�
Status ListTraverse(LinkList L) {
	LinkList p = L->next;
	while (p) {
		cout << p->data << endl;
		p = p->next;
	}
	return true;
}

//�������Ա����Ƿ����ָ��Ԫ��
Status IsExistElem(LinkList L, ElemType e) {
	LinkList p = L->next;
	while (p && p->data != e) {
		p = p->next;
	}
	if (p != NULL) return true;
	else return false;
}

//����ָ��λ�õ�Ԫ��
ElemType GetElem(LinkList L, int index) {
	//int len = ListLength(L);
	//if (index > len) return false;

	LinkList p = L->next;
	int i = 0;
	while (p) {
		i++;
		if (index == i)
			return p->data;		
		p = p->next;
	}
	return false;
}

//����Ԫ��
Status ListInsert(LinkList *L, ElemType e, int i) {
	int j = 1;
	LinkList s, p = *L;
	while (p && j < i) {
		p = p->next;
		j++;
	}
	if (!p || j>i) {
		return false;
	}
	s = (LinkList)malloc(sizeof(Node));
	s->data = e;
	s->next = p->next;
	p->next = s;
	return true;
}

//ɾ��Ԫ��
Status ListDelete(LinkList *L, ElemType e) {
	LinkList pre = *L, cur = pre->next;
	while (cur && cur->data != e) {
		pre = cur;
		cur = cur->next;
	}
	pre->next = cur->next;
	free(cur);
	return true;
}

//��ӡ����
void ShowList(LinkList L) {
	LinkList p = L->next;
	while (p) {
		cout << p->data << " ";
		p = p->next;
	}
	cout << endl;
}

//����ת
Status ListReverse(LinkList L) {	
	cout << "����ת:";
	LinkList preCur = L->next;//ָ�������һ����㣨ͷָ��ָ��Ľ�㣩
	LinkList cur;
	while (preCur->next) {	
		cur = preCur->next;
		preCur->next = cur->next;
		cur->next = L->next;
		L->next = cur;		
	}
	ShowList(L);
	return true;
}

int main()
{
	LinkList L;

	if (InitList(&L)) {
		cout << "�����ʼ�����!" << endl;
		CreateListHead(&L, 10);
		//CreateListRail(&L, 10);
		ShowList(L);
		ListReverse(L);	
	}
	else {
		cout << "�����ʼ��ʧ�ܣ�" << endl;
		exit(-1);
	}

    return 0;
}

