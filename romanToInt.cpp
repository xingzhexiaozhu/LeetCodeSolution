// romanToInt.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"

#include<iostream>
using namespace std;

//��ǰ�������������֣����ĳ������ǰһ����С������ϸ�����
//��֮����ȥǰһ����������Ȼ����ϸ���

//�ⷨһ��
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

//�ⷨ����
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

