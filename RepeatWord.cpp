// RepeatWord.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"
#include<iostream>
using namespace std;
//��������������һ���ַ�����һ�ַ����������ַ����в�������ַ���ͬ���ַ�������ҵ�
//����������һ����ͬ���ַ�������Ҳ�����ͬ�ַ������κδ���
//���磺�ַ���Ϊ��baacda��,�����ַ�Ϊ��a�� ===>  ��baaaacdaa��

void fun(char* s, char c) {
	for (int i = 0; s[i] != '\0'; i++) {
		if (s[i] == c) {
			int n = 0;
			while (s[i + 1 + n] != '\0')
				n++;
			int j = i + 1 + n;
			while (j > i) {
				s[j + 1] = s[j];
				j--;
			}
			s[j + 1] = c;
			i = i + 1;
		}
	}
}

int main()
{
	char s[80] = "baacda", c;
	cout << "The origin string is " << s << endl;
	cout << "Input the char: ";
	cin >> c;
	fun(s, c);
	cout << "The new string is " << s << endl;

    return 0;
}

