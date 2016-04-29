// TwoSum.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include<iostream>

#include<vector>
#include<map>

using namespace std;


//题意描述：给定一个整数数组，找出其中两个数满足相加等于指定目标数字
//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return[0, 1].

//解法一：双循环判断是否存在对应的两个数字满足上述要求
//vector<int> twoSum(vector<int>&numbers, int target) {
//	vector<int> result;
//	for (int i = 0; i < numbers.size()-1; i++) {
//		for (int j = i+1; j < numbers.size(); j++) {
//			if (numbers[i] + numbers[j] == target) {
//				result.push_back(i);
//				result.push_back(j);
//				return result;
//			}
//		}
//	}
//	return result;
//}

//解法二：由于双循环的时间复杂度为O(n^2)，所以当输入数组过大会出现超时的情况
//则考虑到空间换时间的概念，而对于查找问题可以采用Hash表完成
vector<int> twoSum(vector<int>&numbers, int target) {
	vector<int> result;
	map<int, int> temp;
	for (int i = 0; i < numbers.size(); i++)
		temp[numbers[i]] = i;

	map<int, int>::iterator it;
	for (int i = 0; i < numbers.size(); i++) {
		if ((it = temp.find(target - numbers[i])) != temp.end()) {
			if (i == it->second)
				continue;
			result.push_back(i);
			result.push_back(it->second);
			return result;
		}
	}

	return result;
}

int main()
{
	vector<int> num = { 2,7,1,15 };
	int target = 9;

	vector<int> a = twoSum(num, target);
	cout << num[a[0]] << "\t" << num[a[1]] << endl;

    return 0;
}

