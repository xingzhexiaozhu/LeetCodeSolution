// takeStones.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"

#include<iostream>
using namespace std;

bool canWinNim(int n) {
	if (n % 4 == 0) return false;
	return true;
}

int main()
{
	int n;
	cin >> n;
	while (n != EOF) {
		if (canWinNim(n))
			cout << "You can win the game!" << endl;
		else cout << "You lost!" << endl;
		cin >> n;
	}

	return 0;
}

