// RepeatWord.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include<iostream>
using namespace std;
//题意描述：给定一个字符串和一字符常量，在字符串中查与给定字符相同的字符，如果找到
//则在其后插入一个相同的字符，如果找不到相同字符则不做任何处理
//比如：字符串为“baacda”,给定字符为“a” ===>  “baaaacdaa”

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

