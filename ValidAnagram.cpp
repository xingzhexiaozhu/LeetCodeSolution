// ValidAnagram.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

#include <iostream>
#include <algorithm>  //包含sort函数
#include <vector>
#include <string>

using namespace std;



//题目：判断两个字符串是否为字谜游戏
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.

//方法一：先对字符串排序，然后比较排序后的字符串是否相等
bool isAnagram(string s, string t) {
	sort(s.begin(), s.end());
	sort(t.begin(), t.end());
	return s == t;
}

//方法二：分别统计两个字符串各个字母数看是否相等地
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