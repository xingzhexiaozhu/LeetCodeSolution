// StrToInt.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"

//���ַ���ת��Ϊ����

#include<iostream>
#include<string>
using namespace std;

int strToInt(char* str) {
	int num = 0;
	while (*str != 0) {
		num = num * 10 + *str - '0';
		++str;
	}
	return num;
}

int main()
{
	char* str = "123";
	//cin >> str;
	cout << strToInt(str) << endl;

    return 0;
}

