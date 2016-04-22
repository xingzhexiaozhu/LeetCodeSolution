// Pointer.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

//题意描述：数组与指针

#include<stdio.h>

int main()
{
	int a[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	int *p = &(a + 1)[3];
	printf("a[0]=%d\n", a[0]);
	printf("a=%d\n", a);
	printf("&a=%d\n", &a);
	printf("&a+1=%d\n", &a + 1);
	printf("*p=%d\n", *p);
    return 0;
}

