// const_define.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

#include<iostream>
using namespace std;

//const与define区别

int main()
{
	int num = 1;

	#define t1 num + num
	#define t2 t1 % t1
	cout << "t2 is " << t2 << endl;

	const int s1 = num + num;
	const int s2 = s1 % s1;
	cout << "s2 is " << s2 << endl;

    return 0;
}

