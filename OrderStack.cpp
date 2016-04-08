// OrderStack.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"

#include<stdio.h>

#define MaxSize 50

//����������ջ�Ĳ���

typedef struct {
	int data[MaxSize];
	int top;
}SqStack;

void InitStack(SqStack &s) {//��ʼ��ջ��ָ��
	s.top = -1;
}

bool StackEmpty(SqStack &s) {//�ж�ջ�Ƿ�Ϊ��
	if (s.top == -1)
		return true;
	else return false;
}

bool Push(SqStack &s, int x) {//��ջ����
	if (s.top == MaxSize - 1)
		return false;
	s.data[++s.top] = x;//ջ��ָ���ȼ�1���ٴ���Ԫ��
	return true;
}

bool Pop(SqStack &s, int &x) {
	if (s.top == -1)
		return false;
	x = s.data[s.top--];
	return true;
}

bool GetTop(SqStack &s, int &x) {
	if (s.top == -1)
		return false;
	x = s.data[s.top];
	return true;
}

int main()
{
	SqStack sqStack;
	InitStack(sqStack);
	printf("stack is empty --- %d\n", StackEmpty(sqStack));
	for (int i = 0; i < 5; i++) {
		Push(sqStack, i);
		int test;
		Pop(sqStack, test);
		printf("%d\t", test);
	}

    return 0;
}

