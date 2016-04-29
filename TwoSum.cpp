// TwoSum.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"
#include<iostream>

#include<vector>
#include<map>

using namespace std;


//��������������һ���������飬�ҳ�����������������ӵ���ָ��Ŀ������
//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return[0, 1].

//�ⷨһ��˫ѭ���ж��Ƿ���ڶ�Ӧ������������������Ҫ��
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

//�ⷨ��������˫ѭ����ʱ�临�Ӷ�ΪO(n^2)�����Ե���������������ֳ�ʱ�����
//���ǵ��ռ任ʱ��ĸ�������ڲ���������Բ���Hash�����
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

