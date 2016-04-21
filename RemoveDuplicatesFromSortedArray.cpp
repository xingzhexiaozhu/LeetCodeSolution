// RemoveDuplicatesFromSortedArray.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

#include<iostream>
#include<vector>
using namespace std;

//题意描述：移除已排序数组内的相同元素，使得每个元素只出现一次，返回新的长度


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

