// ReverseSingleLinkedList.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

//题意描述：单链表的反转/逆序

#include<iostream>
using namespace std;

typedef int Status;//Status是函数的类型,其值是函数结果状态代码，如OK等
typedef int ElemType;//ElemType类型根据实际情况而定，这里假设为int

typedef struct Node {
	ElemType data;//数据域
	struct Node *next;//指针域
}Node;

typedef struct Node *LinkList;

//初始化顺序线性表
Status InitList(LinkList *L) {
	*L = (LinkList)malloc(sizeof(Node));//产生头结点，并使L指向此结点
	if (!(*L)) {//存储分配失败
		return false;
	}
	(*L)->next = NULL;
	return true;//成功初始化
}

//建立带头指印的，含有n个结点的单链表L（头插法）
void CreateListHead(LinkList *L, int n) {
	*L = (LinkList)malloc(sizeof(Node));
	(*L)->next = NULL;
	LinkList p;
	srand(0);
	for (int i = 0; i < n; i++) {
		p = (LinkList)malloc(sizeof(Node));
		p->data = rand() % 100 + 1;//随机生成100以内的数字
		p->next = (*L)->next;
		(*L)->next = p;
	}
}

//建立带头指印的，含有n个结点的单链表L（尾插法）
void CreateListRail(LinkList *L, int n) {
	*L = (LinkList)malloc(sizeof(Node));
	(*L)->next = NULL;
	LinkList p, r = *L;//r指针指向链表尾部
	srand(0);
	for (int i = 0; i < n; i++) {
		p = (LinkList)malloc(sizeof(Node));
		p->data = rand() % 100 + 1;//随机生成100以内的数字
		r->next = p;
		r = p;
	}
	r->next = NULL;
}

//线性表已存在，返回线性表元素个数
int ListLength(LinkList L) {
	int len = 0;
	LinkList p = L->next;
	while(p) {
		len++;
		p = p->next;
	}
	return len;
}

//重置线性表
Status ClearList(LinkList *L) {
	LinkList p, q;
	p = (*L)->next;
	while (p) {
		q = p->next;//头指针与结点是否断开？？？
		free(p);
		p = q;
	}
	(*L)->next = NULL;
	return true;
}

//遍历线性表
Status ListTraverse(LinkList L) {
	LinkList p = L->next;
	while (p) {
		cout << p->data << endl;
		p = p->next;
	}
	return true;
}

//查找线性表中是否存在指定元素
Status IsExistElem(LinkList L, ElemType e) {
	LinkList p = L->next;
	while (p && p->data != e) {
		p = p->next;
	}
	if (p != NULL) return true;
	else return false;
}

//返回指定位置的元素
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

//插入元素
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

//删除元素
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

//打印链表
void ShowList(LinkList L) {
	LinkList p = L->next;
	while (p) {
		cout << p->data << " ";
		p = p->next;
	}
	cout << endl;
}

//链表反转
Status ListReverse(LinkList L) {	
	cout << "链表反转:";
	LinkList preCur = L->next;//指向链表第一个结点（头指针指向的结点）
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
		cout << "链表初始化完毕!" << endl;
		CreateListHead(&L, 10);
		//CreateListRail(&L, 10);
		ShowList(L);
		ListReverse(L);	
	}
	else {
		cout << "链表初始化失败！" << endl;
		exit(-1);
	}

    return 0;
}

