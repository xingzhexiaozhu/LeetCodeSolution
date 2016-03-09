// romanToInt.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

#include<iostream>
using namespace std;

//从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。
//反之，减去前一个数的两倍然后加上该数

//解法一：
int romanToInt(string s) {
	int val[10];
	val['I'] = 1;
	val['V'] = 5;
	val['X'] = 10;
	val['L'] = 50;
	val['C'] = 100;
	val['D'] = 500;
	val['M'] = 1000;

	int result = 0;
	for (int i = 0; i < s.size(); i++) {
		if (i > 0 && val[s[i]] > val[s[i - 1]]) {
			result += val[s[i]] - 2 * val[s[i - 1]];
		}
		else {
			result += val[s[i]];
		}
	}

	return result;
}

//解法二：
//int romanToInt1(const string &s) {
//	int result = 0;
//	for (size_t i = 0; i < s.size(); i++){
//		if (i > 0 && map(s[i]) > map(s[i - 1])) {
//			result += (map(s[i]) - 2 * map(s[i - 1]));
//		}
//		else {
//			result += map(s[i]);
//		}
//	}
//	return result;
//}
//
//inline int map(const char c) {
//	switch (c) {
//	case 'I': return 1;
//	case 'V': return 5;
//	case 'X': return 10;
//	case 'L': return 50;
//	case 'C': return 100;
//	case 'D': return 500;
//	case 'M': return 1000;
//	default: return 0;
//	}
//}

int main()
{
	cout << romanToInt("MCMXC") << endl;
	//cout << romanToInt1("MCMXC") << endl;
    return 0;
}

