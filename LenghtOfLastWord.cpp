// LenghtOfLastWord.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

#include<iostream>
#include<string>
using namespace std;

//题意描述：返回字符串中最后一个单词的长度

//解题思路：直接从最后一个非空格字符开始计数，遇到第一个空格时计数结束，返回的长度即为最后一个单词的长度

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

