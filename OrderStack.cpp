// OrderStack.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

#include<stdio.h>

#define MaxSize 50

//题意描述：栈的操作

typedef struct {
	int data[MaxSize];
	int top;
}SqStack;

void InitStack(SqStack &s) {//初始化栈顶指针
	s.top = -1;
}

bool StackEmpty(SqStack &s) {//判断栈是否为空
	if (s.top == -1)
		return true;
	else return false;
}

bool Push(SqStack &s, int x) {//进栈操作
	if (s.top == MaxSize - 1)
		return false;
	s.data[++s.top] = x;//栈顶指针先加1，再存入元素
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

