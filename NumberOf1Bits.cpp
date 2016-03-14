// NumberOf1Bits.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

#include<iostream>
using namespace std;


int hammingWeight(uint32_t n) {
	int count = 0;
	while (n != 0) {
		count += n & 1;
		n >>= 1;
	}
	return count;
}

int main()
{
	uint32_t num;
	cin >> num;
	while (num != EOF) {
		cout << hammingWeight(num) << endl;
		cin >> num;
	}
    return 0;
}

