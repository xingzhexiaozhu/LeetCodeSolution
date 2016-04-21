// RemoveDuplicatesFromSortedArray.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"

#include<iostream>
#include<vector>
using namespace std;

//�����������Ƴ������������ڵ���ͬԪ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������µĳ���


int removeDuplicates(vector<int>& nums) {
	if (nums.empty())
		return 0;

	int index = 0;
	for (int i = 1; i < nums.size(); i++) {
		if (nums[i] != nums[index])
			nums[++index] = nums[i];
	}

	return index + 1;
}

int main()
{
	vector<int> nums = { 1,1,2 };

	cout << removeDuplicates(nums) << endl;

    return 0;
}

