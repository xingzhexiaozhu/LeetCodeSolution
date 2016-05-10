// LenghtOfLastWord.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"

#include<iostream>
#include<string>
using namespace std;

//���������������ַ��������һ�����ʵĳ���

//����˼·��ֱ�Ӵ����һ���ǿո��ַ���ʼ������������һ���ո�ʱ�������������صĳ��ȼ�Ϊ���һ�����ʵĳ���

int lengthOfLastWord(string s) {
	int index = s.length() - 1;
	
	if (index < 0) return 0;
	while (index>=0 && s[index] == ' ') 
		index--;
	int count = 0;
	while (index >= 0 && s[index] != ' ') {
		count++;
		index--;
	}		

	return count;
}

int main()
{
	string str;	
	while (cin >> str) {
		cout << lengthOfLastWord(str) << endl;
	}

    return 0;
}

