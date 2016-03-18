// CheckCPU.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

//写程序判断，若处理器是BigEndian则返回0，若为LittleEndian则返回1

#include<stdio.h>

//解释：
//由于联合体union的存放顺序是所有成员都从低地址开始存放，利用该特
//性就可以国松地获得CPU对内存采用LittleEndian还是BigEndian模式读写
int checkFunction() {
	union {
		int a;
		char b;
	}c;
	c.a = 1;
	return (c.b == 1);
}

int main()
{
	int flag = checkFunction();
	if(flag == 0)
		printf("CPU is BigEndian!\n");
	else printf("CPU is LittleEndian!\n");

    return 0;
}

