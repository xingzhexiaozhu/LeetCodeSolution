// IntToRoman.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

#include<iostream>
using namespace std;

#include<map>


string intToRoman(int num) {
	if (num > 3999 || num < 1) 
		return string("The num is out of range!");

	const int number[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	const string symbol[] = { "M", "CM", "D", "CD", "C", "XC","L", "XL", "X", "IX", "V", "IV", "I"};

	string roman;
	for (size_t i = 0; num > 0; i++)
	{
		int count = num / number[i];
		num %= number[i];
		for (; count > 0; count--)
			roman += symbol[i];
	}

	return roman;
}

int main()
{
	//cout << intToRoman(1990) << endl;
	printf("%s\n", intToRoman(10));
    return 0;
}

