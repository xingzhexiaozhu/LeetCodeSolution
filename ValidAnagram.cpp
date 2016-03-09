// ValidAnagram.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"

#include <iostream>
#include <algorithm>  //����sort����
#include <vector>
#include <string>

using namespace std;



//��Ŀ���ж������ַ����Ƿ�Ϊ������Ϸ
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.

//����һ���ȶ��ַ�������Ȼ��Ƚ��������ַ����Ƿ����
bool isAnagram(string s, string t) {
	sort(s.begin(), s.end());
	sort(t.begin(), t.end());
	return s == t;
}

//���������ֱ�ͳ�������ַ���������ĸ�����Ƿ���ȵ�
bool isAnagram1(string s, string t) {
	vector<int> count(26, 0);
	for (int i = 0; i < s.size(); i++)
		count[s[i] - 'a'] ++;
	for (int i = 0; i < t.size(); i++)
		count[t[i] - 'a'] --;
	for (int i = 0; i < 26; i++)
		if (count[i] != 0)
			return false;
	return true;
}


int main()
{
	string s = "helloSpark";
	string t = "Sparkhello";
	
	cout << s << "\t" << t << endl;
	cout << isAnagram(s, t) << endl;

	cout << s << "\t" << t << endl;
	cout << isAnagram1(s, t) << endl;


    return 0;
}